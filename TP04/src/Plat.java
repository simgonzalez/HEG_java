import java.util.Objects;

public class Plat {
    private String nom;
    private String typePlat;

    public Plat(String nom, String typePlat) {
        this.nom = nom;
        this.typePlat = typePlat;
    }

    public String getNom() {
        return nom;
    }

    public String getTypePlat() {
        return typePlat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plat plat)) return false;
        return Objects.equals(nom, plat.nom) && typePlat == plat.typePlat;
    }

    @Override
    public String toString() {
        return this.nom+' '+this.typePlat;
    }
}
