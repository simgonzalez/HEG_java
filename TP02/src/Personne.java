public class Personne {
    private static final String SHOW_FIRST_LINE_INFO = "%s %s(%d), %s";
    private String name;
    private String firstname;
    private String address;
    private int age;
    private Voiture voiture;
    private Maison maison;

    public Personne(String name, String firstname, String address, int age) {
        this.name = name;
        this.firstname = firstname;
        this.address = address;
        this.age = age;
        this.voiture = null; // c'est implicite pourquoi on doit le déclarer ??
        this.maison = null;
    }

    public Personne(String name, String firstname, String address, int age, Voiture voiture) {
        this.name = name;
        this.firstname = firstname;
        this.address = address;
        this.age = age;
        this.voiture = voiture;
        this.maison = null; // c'est implicite pourquoi on doit le déclarer ??
    }

    public Personne(String name, String firstname, String address, int age, Maison maison) {
        this.name = name;
        this.firstname = firstname;
        this.address = address;
        this.age = age;
        this.maison = maison;
    }

    public Personne(String name, String firstname, String address, int age, Voiture voiture, Maison maison) {
        this.name = name;
        this.firstname = firstname;
        this.address = address;
        this.age = age;
        this.voiture = voiture; // c'est implicite pourquoi on doit le déclarer ??
        this.maison = maison;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public Maison getMaison() {
        return maison;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public void setMaison(Maison maison) {
        this.maison = maison;
    }

    @Override
    public String toString() {
        StringBuilder possession = new StringBuilder();
        possession.append(String.format(SHOW_FIRST_LINE_INFO, this.name, this.firstname, this.age, this.address));
        possession.append("\nPossession(s) : ");
        boolean hasCar = this.voiture != null;
        boolean hasHouse = this.maison != null;

        if (!(hasHouse && hasCar)) {
            possession.append("Aucunes");
        } else {
            if (hasHouse) {
                possession.append(this.maison);
            }
            if (hasCar) {
                possession.append(this.voiture);

            }
        }

        return  possession.toString();
    }
}
