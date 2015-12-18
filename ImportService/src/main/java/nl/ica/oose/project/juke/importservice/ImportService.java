package nl.ica.oose.project.juke.importservice;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import nl.ica.oose.project.juke.importservice.persistence.IImportServicePersistence;
import nl.ica.oose.project.juke.importservice.persistence.IImportServiceSftp;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.net.URLDecoder;
import java.sql.SQLException;

/**
 * The ImportService
 *
 * @author Paul Kamps
 * @author Robbert de Wilde
 */
@Path("/import")
@Produces(MediaType.APPLICATION_JSON)
public class ImportService {

    private IImportServicePersistence database;
    private IImportServiceSftp sftp;

    /**
     * Constructor of ImportService
     *
     * @param database the given database
     * @param sftp     the given sftp
     */
    public ImportService(IImportServicePersistence database, IImportServiceSftp sftp) {
        this.database = database;
        this.sftp = sftp;
    }

    /**
     * method that uploads file
     *
     * @param uploadedInputStream the inputstream of the uploaded file
     * @param fileDetail          the details of the file
     * @param artist              the given artist
     * @param title               the given name
     * @param albumtitle          the given title of the album
     * @return the path where the file is saved to
     * @throws java.sql.SQLException
     */
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@FormDataParam("File") InputStream uploadedInputStream, @FormDataParam("File") FormDataContentDisposition fileDetail, @FormDataParam("Artist") String artist, @FormDataParam("Title") String title, @FormDataParam("Album") String albumtitle) throws SQLException {
        File tempfile;
        try {
            tempfile = writeTempFile(uploadedInputStream, fileDetail.getFileName());
        } catch (IOException e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
        int[] ids = database.importTrack(artist, title, albumtitle);
        AbstractTrackPlacer tp = new ServerTrackPlacer(sftp);
        String savedpath;
        try {
            savedpath = tp.placeFile(tempfile, ids[0], ids[1], ids[2]);
        } catch (IOException e) {
            return Response.status(400).entity(e.getMessage()).build();
        } catch (SftpException e) {
            return Response.status(e.id).entity(e.getMessage()).build();
        } catch (JSchException e) {
            return Response.status(401).entity(e.getMessage()).build();
        }
        database.insertTrackLocation(ids[0], savedpath);
        tempfile.delete();
        return Response.ok(savedpath).build();
    }

    private File writeTempFile(InputStream uploadedInputStream, String filename) throws IOException {
        File result = new File(URLDecoder.decode(sftp.getTempDir() + filename, "UTF-8"));
        if (!result.getParentFile().exists()) result.getParentFile().mkdir();
        OutputStream out = new FileOutputStream(result);
        int read;
        byte[] bytes = new byte[1024];
        while ((read = uploadedInputStream.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        out.flush();
        out.close();
        return result;
    }
}
