package nl.ica.oose.project.juke.common.persistence;

import nl.ica.oose.project.juke.common.domain.Track;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ResultSetMapperTest {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;

    private static final String TRACKID = "trackID";
    private static final String ARTISTID = "artistID";
    private static final String TITLE = "title";
    private static final String DURATION = "duration";

    private static final String TRACKIDVALUE = "trackID";
    private static final String ARTISTIDVALUE = "artistID";
    private static final String TITLEVALUE = "THISISATESTTITLE";
    private static final Time DURATIONVALUE = new Time(123);

    private ResultSetMapper<Track> mapper;
    private ResultSet resultSetMock;

    @Before
    public void startUp() throws SQLException {
        mapper = new ResultSetMapper();
        createResultSetMock();
    }

    @Test
    public void mapResultSetToTrackShouldReturnATrack() {
        List<Track> tracks = mapper.mapResultSetToObject(resultSetMock, Track.class);
        Track track = tracks.get(ZERO);

        assertTrue(track.getTitle().equals(TITLEVALUE));
    }

    private void createResultSetMock() throws SQLException {
        resultSetMock = Mockito.mock(ResultSet.class);

        Mockito.when(resultSetMock.getObject(ONE)).thenReturn(ONE);
        Mockito.when(resultSetMock.getObject(TWO)).thenReturn(TWO);
        Mockito.when(resultSetMock.getObject(THREE)).thenReturn(TITLEVALUE);
        Mockito.when(resultSetMock.getObject(FOUR)).thenReturn(DURATIONVALUE);
        Mockito.when(resultSetMock.next()).thenReturn(true).thenReturn(false);

        createResultSetMetaDataMock();
    }

    private void createResultSetMetaDataMock() throws SQLException {
        ResultSetMetaData metaData = Mockito.mock(ResultSetMetaData.class);
        Mockito.when(metaData.getColumnCount()).thenReturn(FOUR);
        Mockito.when(metaData.getColumnName(ONE)).thenReturn(TRACKID);
        Mockito.when(metaData.getColumnName(TWO)).thenReturn(ARTISTID);
        Mockito.when(metaData.getColumnName(THREE)).thenReturn(TITLE);
        Mockito.when(metaData.getColumnName(FOUR)).thenReturn(DURATION);

        Mockito.when(resultSetMock.getMetaData()).thenReturn(metaData);
    }
}
