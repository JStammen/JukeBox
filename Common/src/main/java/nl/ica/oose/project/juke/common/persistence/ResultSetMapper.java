package nl.ica.oose.project.juke.common.persistence;

import nl.ica.oose.project.juke.common.persistence.annotations.Column;
import nl.ica.oose.project.juke.common.persistence.annotations.Entity;
import nl.ica.oose.project.juke.common.persistence.exceptions.EntityAnnotationNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the results returned by an sql query
 * Documentatie: http://oprsteny.com/?p=900
 *
 * @param <T>
 * @author Kayan Meijer
 */
public class ResultSetMapper<T> {

    private static final int ONE = 1;

    private static final String SETPROPERTYEXCEPTIONMESSAGE = "Exception has been triggered in ResultSetMapper --> setProperty!";
    private static final String ILLEGALACCESEXCEPTIONMESSAGE = "IllegalAccessException has been triggered in ResultSetMapper --> mapResultSetToObject!";
    private static final String SQLEXCEPTIONMESSAGE = "SQLException has been triggered in ResultSetMapper --> mapResultSetToObject!";
    private static final String INSTANTIATIONEXCEPTIONMESSAGE = "InstantiationException has been triggered in ResultSetMapper --> mapResultSetToObject!";
    private static final String ENTITYANNOTATIONNOTFOUNDMESSAGE = "EntityAnnotationNotFoundException has been triggered in ResultSetMapper --> mapResultSetToObject!";

    private Logger logger;

    /**
     * The constructor to create a ResultSetMapper.
     */
    public ResultSetMapper() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    /**
     * Maps the ResultSet to an Object.
     *
     * @param resultSet   The resultset
     * @param objectClass An Object class.
     * @return A list of objects.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<T> mapResultSetToObject(ResultSet resultSet, Class objectClass) {
        List<T> outputList = null;
        try {
            if (resultSet != null) {
                outputList = fillObjectWhenEntityAnnotationIsPresent(resultSet, objectClass);
            } else {
                return new ArrayList();
            }
        } catch (IllegalAccessException ex) {
            logger.error(ILLEGALACCESEXCEPTIONMESSAGE, ex);
        } catch (SQLException ex) {
            logger.error(SQLEXCEPTIONMESSAGE, ex);
        } catch (InstantiationException ex) {
            logger.error(INSTANTIATIONEXCEPTIONMESSAGE, ex);
        } catch (EntityAnnotationNotFoundException ex) {
            logger.error(ENTITYANNOTATIONNOTFOUNDMESSAGE, ex);
        }

        return outputList;
    }

    private List<T> fillObjectWhenEntityAnnotationIsPresent(ResultSet resultSet, Class objectClass) throws SQLException, InstantiationException, IllegalAccessException, EntityAnnotationNotFoundException {
        List<T> outputList = null;

        if (objectClass.isAnnotationPresent(Entity.class)) {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            Field[] fields = objectClass.getDeclaredFields();

            outputList = parseResultSetToClass(resultSet, objectClass, outputList, resultSetMetaData, fields);
        } else {
            throw new EntityAnnotationNotFoundException();
        }
        return outputList;
    }

    private List<T> parseResultSetToClass(ResultSet resultSet, Class objectClass, List<T> outputList, ResultSetMetaData resultSetMetaData, Field[] fields) throws SQLException, InstantiationException, IllegalAccessException {
        while (resultSet.next()) {
            T bean = (T) objectClass.newInstance();
            analyzeColumns(resultSet, resultSetMetaData, fields, bean);

            if (outputList == null) {
                outputList = new ArrayList();
            }
            outputList.add(bean);
        }
        return outputList;
    }

    private void analyzeColumns(ResultSet resultSet, ResultSetMetaData resultSetMetaData, Field[] fields, T bean) throws SQLException {
        for (int iterator = 0; iterator < resultSetMetaData.getColumnCount(); iterator++) {
            String columnName = resultSetMetaData.getColumnName(iterator + ONE);
            Object columnValue = resultSet.getObject(iterator + ONE);

            setPropertyForFields(fields, bean, columnName, columnValue);
        }
    }

    private void setPropertyForFields(Field[] fields, T bean, String columnName, Object columnValue) {
        for (Field field : fields) {
            if (setPropertyIfAnnotationIsPresent(bean, columnName, columnValue, field))
                break;
        }
    }

    private boolean setPropertyIfAnnotationIsPresent(T bean, String columnName, Object columnValue, Field field) {
        if (field.isAnnotationPresent(Column.class)) {
            Column column = field.getAnnotation(Column.class);
            if (column.name().equalsIgnoreCase(columnName)
                    && columnValue != null) {
                this.setProperty(bean, field.getName(), columnValue);
                return true;
            }
        }
        return false;
    }

    private void setProperty(Object objClass, String fieldName, Object columnValue) {
        try {
            Field field = objClass.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(objClass, columnValue);
        } catch (Exception ex) {
            logger.error(SETPROPERTYEXCEPTIONMESSAGE, ex);
        }
    }
}
