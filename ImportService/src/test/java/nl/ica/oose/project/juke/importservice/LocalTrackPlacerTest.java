package nl.ica.oose.project.juke.importservice;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.FileAlreadyExistsException;

import static org.junit.Assert.*;

public class LocalTrackPlacerTest {
    private LocalTrackPlacer tp;

    @Before
    public void init() {
        tp = new LocalTrackPlacer();
    }

    @Test
    public void placeFile() throws IOException {
        File input = new File(URLDecoder.decode(this.getClass().getClassLoader().getResource("").getFile() + "/idoexist.mp3", "UTF-8"));
        File expected = new File(URLDecoder.decode(this.getClass().getClassLoader().getResource("").getFile() + "/musicsystem/imports/1/1/1.mp3", "UTF-8"));
        assertTrue("Test environment corrupted, inputfile should exist but does not", input.exists());
        assertFalse("Test environment corrupted, outputfile should not exist but does", expected.exists());
        String result = tp.placeFile(input, 1, 1, 1);
        File compare = new File(result);
        assertEquals("filepath not as expected", compare, expected);
        assertTrue("Old file falsely removed", input.exists());
        assertTrue("New file falsely not existing", expected.exists());
        compare.delete();
    }

    @Test
    public void placeFileNoAlbum() throws IOException {
        File input = new File(URLDecoder.decode(this.getClass().getClassLoader().getResource("").getFile() + "/idoexist.mp3", "UTF-8"));
        File expected = new File(URLDecoder.decode(this.getClass().getClassLoader().getResource("").getFile() + "/musicsystem/imports/1/1.mp3", "UTF-8"));
        assertTrue("Test environment corrupted, inputfile should exist but does not", input.exists());
        assertFalse("Test environment corrupted, outputfile should not exist but does", expected.exists());
        String result = tp.placeFile(input, 1, 1, 0);
        File compare = new File(result);
        assertEquals("filepath not as expected", compare, expected);
        assertTrue("Old file falsely removed", input.exists());
        assertTrue("New file falsely not existing", expected.exists());
        compare.delete();
    }

    @Test(expected = FileNotFoundException.class)
    public void oldFileDoesntExist() throws IOException {
        File input = new File(URLDecoder.decode(this.getClass().getClassLoader().getResource("").getFile() + "/idonotexist.mp3", "UTF-8"));
        File expected = new File(URLDecoder.decode(this.getClass().getClassLoader().getResource("").getFile() + "/musicsystem/imports/1/1/2.mp3", "UTF-8"));
        assertFalse("Test environment corrupted, inputfile should not exist but does", input.exists());
        assertFalse("Test environment corrupted, outputfile should not exist but does", expected.exists());
        tp.placeFile(input, 2, 1, 1);
    }

    @Test(expected = FileAlreadyExistsException.class)
    public void newFileAlreadyExist() throws IOException {
        File input = new File(URLDecoder.decode(this.getClass().getClassLoader().getResource("").getFile() + "/idoexist.mp3", "UTF-8"));
        File expected = new File(URLDecoder.decode(this.getClass().getClassLoader().getResource("").getFile() + "/musicsystem/imports/1/1/3.mp3", "UTF-8"));
        assertTrue("Test environment corrupted, inputfile should exist but does not", input.exists());
        assertTrue("Test environment corrupted, outputfile should exist but does not", expected.exists());
        tp.placeFile(input, 3, 1, 1);
    }
}
