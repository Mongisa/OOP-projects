package esercitazioneaereoporto;

public class CodeCheckEN implements CodeChecker {
    @Override
    public boolean check(String codice) {
        return codice.matches("EN[0-9]{2}[A-Z]{2}");
    }
}
