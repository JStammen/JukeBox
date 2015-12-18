package nl.ica.oose.project.juke.importservice;

import com.jcraft.jsch.SftpException;
import nl.ica.oose.project.juke.importservice.persistence.ImportServiceSftpMock;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;

import static org.junit.Assert.*;

public class ServerTrackPlacerTest {
    private ServerTrackPlacer tp;

    @Before
    public void init() {
        tp = new ServerTrackPlacer(new ImportServiceSftpMock());
    }

    @Test
    public void placeFile() throws IOException, SftpException {
        File input = new File(URLDecoder.decode(this.getClass().getClassLoader().getResource("").getFile() + "/idoexist.mp3", "UTF-8"));
        File expected = new File("/MusicSystem/Imports/1/1/1.mp3");
        assertTrue("Test environment corrupted, inputfile should exist but does not", input.exists());
        String result = tp.placeFile(input, 1, 1, 1);
        File compare = new File(result);
        assertEquals("filepath not as expected", compare, expected);
        assertTrue("Old file falsely removed", input.exists());
    }

    @Test(expected = FileNotFoundException.class)
    public void oldFileDoesntExist() throws IOException, SftpException {
        File input = new File(URLDecoder.decode(this.getClass().getClassLoader().getResource("").getFile() + "/idonotexist.mp3", "UTF-8"));
        assertFalse("Test environment corrupted, inputfile should not exist but does", input.exists());
        tp.placeFile(input, 2, 1, 1);
    }

    @Test
    public void placeFileNoAlbum() throws IOException, SftpException {
        File input = new File(URLDecoder.decode(this.getClass().getClassLoader().getResource("").getFile() + "/idoexist.mp3", "UTF-8"));
        File expected = new File("/MusicSystem/Imports/1/1.mp3");
        assertTrue("Test environment corrupted, inputfile should exist but does not", input.exists());
        String result = tp.placeFile(input, 1, 1, 0);
        File compare = new File(result);
        assertEquals("filepath not as expected", compare, expected);
        assertTrue("Old file falsely removed", input.exists());
    }
}
