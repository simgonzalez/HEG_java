package Question1;

public class Movie extends VideoContent {
    private String director;
    private int duration;

    public Movie(int id, String title, int year, String director, int duration) {
        super(id, title, year);
        this.director = director;
        this.duration = duration;
    }

    /**
     * specific implementation to play a Movie
     */
    @Override
    protected void play() {
        System.out.println("Playing Movie: " + title + "\nDirected by : " + director + "\nDuration : " + duration + " minutes");
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDirector: " + director + "\nDuration: " + duration + " minutes";
    }
}
