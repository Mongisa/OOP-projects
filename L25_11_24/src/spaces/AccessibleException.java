package spaces;

/**
 * CONTROLLED EXCEPTION
 * Exception -> controlled exception
 * RuntimeException -> not controlled exception
 */
public class AccessibleException extends Exception {
    public AccessibleException(String message) {
        super(message);
    }
}
