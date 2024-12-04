package esercitazione2streamio;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class LibrettoEsami {
    private final ObservableList<EsameSuperato> esamiSuperati;


    public LibrettoEsami() {
        this.esamiSuperati = FXCollections.observableArrayList();
    }

    public void addEsameSuperato(EsameSuperato esameSuperato) {
        esamiSuperati.add(esameSuperato);
    }

    public List<EsameSuperato> getByMatricola(String matricola) {
        return esamiSuperati.filtered(e -> {
            return e.getMatricolaStudente().equals(matricola);
        });
    }
}
