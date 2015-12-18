package nl.ica.oose.project.juke.common.domain;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class UserTest {

    private static final int USERID1 = 1;
    private static final int USERID2 = 2;

    private static final String USERNAME1 = "Harm";
    private static final String USERNAME2 = "Bloeb";

    private User fullUser;
    private User blankUser;

    @Before
    public void init() {
        this.fullUser = new User(USERID1, USERNAME1);
        this.blankUser = new User();
    }

    @Test
    public void getNameFull() {
        assertEquals(fullUser.getName(), USERNAME1);
    }

    @Test
    public void getNameBlank() {
        assertNull(blankUser.getName());
    }

    @Test
    public void getNameChanged() {
        fullUser.setName(USERNAME2);
        assertEquals(fullUser.getName(), USERNAME2);
    }

    @Test
    public void getIdFull() {
        assertEquals(fullUser.getUserID(), USERID1);
    }

    @Test
    public void getIdBlank() {
        assertEquals(blankUser.getUserID(), 0);
    }

    @Test
    public void getIdChanged() {
        fullUser.setUserID(USERID2);
        assertEquals(fullUser.getUserID(), USERID2);
    }
}
