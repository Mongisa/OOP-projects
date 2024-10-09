package people;

/**
 * NOT CONTROLLED EXCEPTION
 */
public class AverageNotPermittedException extends RuntimeException {
    public AverageNotPermittedException(String message) {
        super(message);
    }
}