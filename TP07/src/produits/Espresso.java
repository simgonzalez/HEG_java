package produits;

import java.util.Objects;

public class Espresso extends Cafe {
    private int quantiteCreme;

    public Espresso(String nom, double prix, int taille, String provenance, int force, int quantiteCreme) {
        super(nom, prix, taille, provenance, force);
        this.quantiteCreme = quantiteCreme;
    }

    @Override
    public String allergie() {
        if (quantiteCreme > 0) {
            return "Contient du lactose";
        }
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Espresso espresso)) return false;
        if (!super.equals(o)) return false;
        return quantiteCreme == espresso.quantiteCreme;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(quantiteCreme);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.quantiteCreme + "cl de crème";
    }
}
