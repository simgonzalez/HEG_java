package Question1;


/**
 * Exception pour les {@link Alarmable} qui n'ont pas de contact
 */
public class NoContactException extends Exception {
    public NoContactException(String message) {
        super(message);
    }
}
