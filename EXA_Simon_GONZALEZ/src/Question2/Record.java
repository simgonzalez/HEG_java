package Question2;

import java.util.HashMap;
import java.util.Objects;

public class Record {
    private HashMap<String, String> champs;

    public Record(String nom, String prenom, String poste) {
        champs = new HashMap<>();
        champs.put("nom", nom);
        champs.put("prenom", prenom);
        champs.put("poste", poste);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Record) {
            Record r = (Record) obj;
            return champs.get("nom").equals(r.champs.get("nom")) && champs.get("prenom").equals(r.champs.get("prenom")) && champs.get("poste").equals(r.champs.get("poste"));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(champs.get("nom") + champs.get("prenom") + champs.get("poste"));
    }

    public String getChamp(String champ) {
        return this.champs.get(champ);
    }

    public void setChamp(String champ, String valeur) {
        this.champs.put(champ, valeur);
    }

    public Employe toEmploye() {
        return new Employe(champs.get("nom"), champs.get("prenom"), champs.get("poste"));
    }
}
