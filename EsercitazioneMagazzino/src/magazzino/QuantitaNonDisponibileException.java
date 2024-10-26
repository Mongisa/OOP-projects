package magazzino;

public class QuantitaNonDisponibileException extends Exception {
    public QuantitaNonDisponibileException(String message) {
        super(message);
    }
}
