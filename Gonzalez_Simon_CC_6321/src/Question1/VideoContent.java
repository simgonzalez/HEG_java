package Question1;

public abstract class VideoContent {
    private int id;
    protected String title;
    protected int year;

    public VideoContent(int id, String title, int year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public boolean equals(VideoContent vc) {
        return this.id == vc.id;
    }

    /**
     * This method is used to play the video content
     */
    protected abstract void play();
}
