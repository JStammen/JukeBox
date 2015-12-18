package nl.ica.oose.project.juke.importservice;

import com.sun.jersey.core.header.FormDataContentDisposition;
import nl.ica.oose.project.juke.importservice.persistence.ImportServiceDatabaseMock;
import nl.ica.oose.project.juke.importservice.persistence.ImportServiceSftpMock;
import nl.ica.oose.project.juke.importservice.persistence.ImportServiceSftpMock2;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.io.*;
import java.net.URLDecoder;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class ImportServiceTest {
    private ImportService importService;
    private ImportService importService2;
    private FormDataContentDisposition formdatacontentdisposition;
    private InputStream inputstream;
    private InputStream inputstream2;
    private String artist;
    private String title;
    private String albumtitle;

    @Before
    public void init() throws FileNotFoundException, UnsupportedEncodingException {
        importService = new ImportService(new ImportServiceDatabaseMock(), new ImportServiceSftpMock());
        importService2 = new ImportService(new ImportServiceDatabaseMock(), new ImportServiceSftpMock2());
        formdatacontentdisposition = FormDataContentDisposition.name("File").fileName("idoexist.mp3").build();
        inputstream = new FileInputStream(new File(URLDecoder.decode(this.getClass().getClassLoader().getResource("").getFile() + "/idoexist.mp3", "UTF-8")));
        inputstream2 = new FileInputStream(new File(URLDecoder.decode(this.getClass().getClassLoader().getResource("").getFile() + "/idoexist2.mp3", "UTF-8")));
        artist = "Slayer";
        title = "Temptation";
        albumtitle = "Seasons in the Abyss";
    }

    @Test
    public void normalFlow() throws SQLException, UnsupportedEncodingException {
        Response response = importService.uploadFile(inputstream, formdatacontentdisposition, artist, title, albumtitle);
        assertTrue("Response is not as expected", ("/MusicSystem/Imports/1/1/25.mp3".equals(response.getEntity().toString())));
        File tempfile = new File(URLDecoder.decode(this.getClass().getClassLoader().getResource("").getFile() + "/temp/idoexist.mp3", "UTF-8"));
        tempfile.delete();

    }

    @Test
    public void alterNativeFlow() throws SQLException, UnsupportedEncodingException {
        Response response = importService2.uploadFile(inputstream2, formdatacontentdisposition, artist, title, albumtitle);
        assertTrue("Response is not as expected", ("/MusicSystem/Imports/1/1/25.mp3".equals(response.getEntity().toString())));
        File tempfile = new File(URLDecoder.decode(this.getClass().getClassLoader().getResource("").getFile() + "/temp2/idoexist.mp3", "UTF-8"));
        tempfile.delete();
    }
}
