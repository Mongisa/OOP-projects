package esercitazioneaereoporto;

public class CodeCheckIT implements CodeChecker {
    @Override
    public boolean check(String codice) {
        return codice.matches("IT[A-Za-z]{2}[0-9]{3}");
    }
}
