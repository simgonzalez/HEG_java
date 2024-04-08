package produits;

import java.util.Locale;
import java.util.Objects;

public class Chocolat extends Boisson {
    private String typeChocolat;

    public Chocolat(String nom, double prix, int taille, String typeChocolat) {
        super(nom, prix, taille);
        this.typeChocolat = typeChocolat;
    }

    @Override
    public String allergie() {
        if (typeChocolat.toLowerCase() != "chocolat noir") {
            return "Contient du lactose";
        }
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chocolat chocolat)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(typeChocolat, chocolat.typeChocolat);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(typeChocolat);
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.typeChocolat;
    }
}
