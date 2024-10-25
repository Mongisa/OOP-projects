package distributore.eccezioni;

public class CreditoInsufficienteException extends Exception {
    public CreditoInsufficienteException(String message) {
        super(message);
    }
}
