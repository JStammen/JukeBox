package nl.ica.oose.project.juke.playlistcontentmanagementservice.persistence;

import nl.ica.oose.project.juke.common.domain.Playlist;
import nl.ica.oose.project.juke.common.domain.Track;
import nl.ica.oose.project.juke.common.domain.TrackInPlaylist;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class PlayListContentManagementServicePersistenceMock implements IPlayListContentManagementServicePersistence {

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    private static final int NINE = 9;
    private static final int TEN = 10;

    private List<Playlist> playlists = new ArrayList();
    private List<Track> tracks = new ArrayList();
    private List<TrackInPlaylist> trackInPlaylists = new ArrayList<>();

    public PlayListContentManagementServicePersistenceMock() {
        generateData();
    }

    @Override
    public boolean deleteTrackOnPlaylist(int playlistID, int trackID) throws SQLException {
        try {
            trackInPlaylists.remove(new TrackInPlaylist(playlistID, trackID));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void addTrackOnPlaylist(int playlistID, int trackID) throws SQLException {
        trackInPlaylists.add(new TrackInPlaylist(playlistID, trackID));
    }


    @Override
    public boolean isValid() throws SQLException {
        return !playlists.isEmpty();
    }

    @Override
    public Connection getConnection() {
        throw new NotImplementedException();
    }


    private void generateData() {
        tracks.add(new Track(ONE, 1, "Song1", new Time(123)));
        tracks.add(new Track(TWO, 1, "Song2", new Time(123)));
        tracks.add(new Track(THREE, 1, "Song3", new Time(123)));
        tracks.add(new Track(FOUR, 1, "Song4", new Time(123)));
        tracks.add(new Track(FIVE, 1, "Song5", new Time(123)));
        tracks.add(new Track(SIX, 1, "Song6", new Time(123)));
        tracks.add(new Track(EIGHT, 1, "Song7", new Time(123)));
        tracks.add(new Track(SEVEN, 1, "Song8", new Time(123)));
        tracks.add(new Track(NINE, 1, "Song9", new Time(123)));
        tracks.add(new Track(TEN, 1, "Song10", new Time(123)));

        playlists.add(new Playlist(ONE, "NAAM PLAYLIST 1", ONE));
        playlists.add(new Playlist(TWO, "NAAM PLAYLIST 1", TWO));
        playlists.add(new Playlist(THREE, "NAAM PLAYLIST 1", THREE));
        playlists.add(new Playlist(FOUR, "NAAM PLAYLIST 1", FOUR));
        playlists.add(new Playlist(FIVE, "NAAM PLAYLIST 1", FIVE));
        playlists.add(new Playlist(SIX, "NAAM PLAYLIST 1", SIX));
        playlists.add(new Playlist(SEVEN, "NAAM PLAYLIST 1", SEVEN));
        playlists.add(new Playlist(EIGHT, "NAAM PLAYLIST 1", EIGHT));
        playlists.add(new Playlist(NINE, "NAAM PLAYLIST 1", NINE));
        playlists.add(new Playlist(TEN, "NAAM PLAYLIST 1", TEN));
    }


}
