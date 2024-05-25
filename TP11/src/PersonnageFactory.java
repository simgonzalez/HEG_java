public class PersonnageFactory {
    public static Personnage createPersonnage(String type, String nom, int niveau, int pv, int pm, int pa, int pd, int classAttribute) throws UnexpectedCharacterTypeException {
        return switch (type) {
            case "G" -> new Guerrier(nom, niveau, pv, pm, pa, pd, classAttribute);
            case "M" -> new Mage(nom, niveau, pv, pm, pa, pd, classAttribute);
            case "S" -> new Soigneur(nom, niveau, pv, pm, pa, pd, classAttribute);
            default -> throw new UnexpectedCharacterTypeException("Unexpected character type: " + type);
        };
    }
}
