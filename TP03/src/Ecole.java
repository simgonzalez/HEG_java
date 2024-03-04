import java.util.Objects;

public class Ecole {
    public enum EcoleType {
        PUBLIC, PRIVATE
    }

    public enum EcoleDegree {
        PRIMARY, C_O, UNI
    }

    private String name;
    private String address;
    private EcoleType type;
    private int noBuilding;
    private EcoleDegree degree;
    private String domaine;
    private int noStudent;

    public Ecole(String name, String address, EcoleType type, int noBuilding, EcoleDegree degree, String domaine, int noStudent) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.noBuilding = noBuilding;
        this.degree = degree;
        this.domaine = domaine;
        this.noStudent = noStudent;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public EcoleType getType() {
        return type;
    }

    public int getNoBuilding() {
        return noBuilding;
    }

    public EcoleDegree getDegree() {
        return degree;
    }

    public String getDomaine() {
        return domaine;
    }

    public int getNoStudent() {
        return noStudent;
    }

    public void setDegree(EcoleDegree degree) {
        if (this.type.equals(EcoleType.PUBLIC) && (this.degree.equals(EcoleDegree.PRIMARY) || this.degree.equals(EcoleDegree.C_O))) {
            this.degree = degree;
        }
    }

    public void setNoBuilding(int noBuilding) {
        this.noBuilding = noBuilding;
    }

    public void setNoStudent(int noStudent) {
        this.noStudent = noStudent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ecole ecole)) return false;
        if (type.equals(EcoleType.PRIVATE) && Objects.equals(type, ecole.type))
            return Objects.equals(name, ecole.name) && Objects.equals(address, ecole.address) && Objects.equals(domaine, ecole.domaine);
        return Objects.equals(name, ecole.name) && Objects.equals(address, ecole.address);
    }

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append(String.format("%s, %s\nEcole Publique de degré %s dans le domaine %s\nIl y a %d batiments pour %d étudiants", this.name, this.address, this.degree, this.domaine, this.noBuilding, this.noStudent));
        return build.toString();
    }
}
