package esercitazioneaereoporto;

import java.io.Serializable;

public interface CodeChecker extends Serializable {
    public boolean check(String codice);
}
