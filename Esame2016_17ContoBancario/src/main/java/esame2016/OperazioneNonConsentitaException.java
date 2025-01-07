package esame2016;

public class OperazioneNonConsentitaException extends ContoCorrenteException {
    public OperazioneNonConsentitaException(ContoCorrente c) {
        super(c);
    }
}
