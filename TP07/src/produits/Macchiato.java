package produits;

import java.util.Objects;

public class Macchiato extends Cafe {
    private int quantiteLait;

    public Macchiato(String nom, double prix, int taille, String provenance, int force, int quantiteLait) {
        super(nom, prix, taille,  provenance, force);
        this.quantiteLait = quantiteLait;
    }

    @Override
    public String allergie() {
        if (quantiteLait > 0) {
            return "Contient du lactose";
        }
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Macchiato macchiato)) return false;
        if (!super.equals(o)) return false;
        return quantiteLait == macchiato.quantiteLait;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(quantiteLait);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.quantiteLait + "cl de lait";
    }
}
