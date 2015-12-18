package nl.ica.oose.project.juke.common.domain;

/**
 * This class is the representation of a trackdetail
 *
 * @author Kayan Meijer
 */
public class TrackDetail {

    private int trackNumber;
    private String genre;
    private int year;

    /**
     * The empty constructor used for mapping ResultSet to a Track.
     */
    public TrackDetail() {

    }

    /**
     * The constructor used to create a new TrackDetail.
     *
     * @param trackNumber The number of the track on the album.
     * @param genre       The genre of the track.
     * @param year        The release year of the track.
     */
    public TrackDetail(int trackNumber, String genre, int year) {
        this.trackNumber = trackNumber;
        this.genre = genre;
        this.year = year;
    }

    /**
     * Gets the track number.
     *
     * @return tracknumber.
     */
    public int getTrackNumber() {
        return trackNumber;
    }

    /**
     * Sets the tracknumber.
     *
     * @param trackNumber tracknumber.
     */
    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    /**
     * Gets the genre.
     *
     * @return genre.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre.
     *
     * @param genre genre.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Gets the release year.
     *
     * @return year.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the release year.
     *
     * @param year year.
     */
    public void setYear(int year) {
        this.year = year;
    }
}
