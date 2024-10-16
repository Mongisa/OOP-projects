package distributore.eccezioni;

public class CreditoInsufficiente extends Exception {
    public CreditoInsufficiente(String message) {
        super(message);
    }
}
