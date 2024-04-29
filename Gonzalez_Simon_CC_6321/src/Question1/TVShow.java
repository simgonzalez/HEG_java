package Question1;

public class TVShow extends VideoContent {
    private int seasons;

    public TVShow(int id, String title, int year, int seasons) {
        super(id, title, year);
        this.seasons = seasons;
    }

    /**
     * specific implementation to play a TV Show
     */
    @Override
    protected void play() {
        System.out.println("Playing TV Show: " + title + "\nSeasons : " + seasons);
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Seasons: " + seasons;
    }
}
