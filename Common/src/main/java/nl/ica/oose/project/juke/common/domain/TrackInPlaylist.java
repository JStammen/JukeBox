package nl.ica.oose.project.juke.common.domain;

/**
 * This class represents the entity TrackInPlaylist
 *
 * @author Harm Tacoma
 */
public class TrackInPlaylist {

    private int playlistId;
    private int trackId;

    /**
     * default constructor for TrackInPlaylist
     */
    public TrackInPlaylist() {

    }

    /**
     * constructor for TrackInPlaylist
     *
     * @param playlistId the id of the playlist
     * @param trackId    the id of the track
     */
    public TrackInPlaylist(int playlistId, int trackId) {
        setPlaylistId(playlistId);
        setTrackId(trackId);
    }

    /**
     * Getter for trackId
     *
     * @return the trackId
     */
    public int getTrackId() {
        return trackId;
    }

    /**
     * Setter for trackId
     *
     * @param trackId the trackId
     */
    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    /**
     * Getter for the playlistId
     *
     * @return the playlistId
     */
    public int getPlaylistId() {
        return playlistId;
    }

    /**
     * Setter for the playlistId
     *
     * @param playlistId the playlistId
     */
    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }
}
