public class Maison {
    private static final String SHOW_INFO = "Maison d'une surface de %,.2fm2 comportant %,.2f pièces.";
    private double surface;
    private double noRoom;
    private boolean isRented;
    private double price;

    public Maison(double surface, double noRoom, boolean isRented, double price) {
        this.surface = surface;
        this.noRoom = noRoom;
        this.isRented = isRented;
        this.price = price;
    }

    public double getSurface() {
        return surface;
    }

    public double getNoRoom() {
        return noRoom;
    }

    public boolean isRented() {
        return isRented;
    }

    public double getPrice() {
        return price;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public void setNoRoom(double noRoom) {
        this.noRoom = noRoom;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(SHOW_INFO, this.surface, this.noRoom));
        if (isRented) {
            builder.append(String.format("Le loyer est de %,.2fCHF mensuel.", this.price));
        } else {
            builder.append(String.format("Le prix est de %,.2fCHF.", this.price));
        }
        return builder.toString();
    }
}
