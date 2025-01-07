package esame2016;

public class ContoCorrenteNonEsistenteException extends ContoCorrenteException {
    public ContoCorrenteNonEsistenteException(ContoCorrente c) {
        super(c);
    }
}
