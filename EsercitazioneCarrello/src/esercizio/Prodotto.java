package esercizio;

import java.time.LocalDate;

public abstract class Prodotto {
    private final String codice;
    private final String descrizione;
    private final double prezzo;

    public Prodotto(String codice, String descrizione, double prezzo) {
        /* completare */
        this.codice = codice;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    /* completare includendo getter per tutti gli attributi */
    public String getCodice() {
        return this.codice;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public double getPrezzo() {
        return this.prezzo;
    }

    /* completare prevedendo il metodo applicaSconto() */
    public abstract double applicaSconto();

    @Override
    public String toString() {
        return "\nProdotto:\n" + "codice=" + codice + "\ndescrizione=" + descrizione + "\nprezzo=" + prezzo;
    }
}
