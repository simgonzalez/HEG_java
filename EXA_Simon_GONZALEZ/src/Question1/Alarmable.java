package Question1;

/**
 * Interface pour la gestion d'objet dont des fonctions d'alarmes doivent être implémentées
 */
public interface Alarmable {
    String infosContact();
    void lancerAlarme() throws NoContactException;
}
