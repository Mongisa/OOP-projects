package esercizio;

import java.time.LocalDate;

public class ProdottoAlimentare extends Prodotto {
    private final LocalDate dataScadenza;

    public ProdottoAlimentare(String codice, String descrizione, double prezzo, LocalDate dataScadenza) {
        /* completare */
        super(codice, descrizione, prezzo);
        this.dataScadenza = dataScadenza;
    }

    /* completare implementando ulteriori metodi se necessario */
    @Override
    public double applicaSconto() {
        LocalDate d = this.dataScadenza.minusDays(10);
        if(d.isBefore(LocalDate.now())) {
            return this.getPrezzo() * 0.8;
        }

        return this.getPrezzo();
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    @Override
    public String toString() {
        return super.toString() + "\ndata scadenza=" + this.dataScadenza;
    }
}
