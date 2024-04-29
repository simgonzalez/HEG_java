package Question2;

public abstract class Competition {
    private String lieu;
    private String date;

    public Competition(String lieu, String date) {
        this.lieu = lieu;
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public String getDate() {
        return date;
    }
}
