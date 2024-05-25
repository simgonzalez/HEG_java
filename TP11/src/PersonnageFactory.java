public class PersonnageFactory {
    public static Personnage createPersonnage(String type, String nom, int niveau, int pv, int pm, int pa, int pd, int classAttribute) throws UnexpectedCharacterTypeException {
        if (type.equals("G")) {
            return new Guerrier(nom, niveau, pv, pm, pa, pd, classAttribute);
        } else if (type.equals("M")) {
            return new Mage(nom, niveau, pv, pm, pa, pd, classAttribute);
        } else if (type.equals("S")) {
            return new Soigneur(nom, niveau, pv, pm, pa, pd, classAttribute);
        } else {
            throw new UnexpectedCharacterTypeException("Unexpected character type: " + type);
        }
    }
}
