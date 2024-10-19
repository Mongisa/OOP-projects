package esercizio;

public class ProdottoNonAlimentare extends Prodotto {
    /* completare con eventuali attributi */
    private final String materiale;

    public ProdottoNonAlimentare(String codice, String descrizione, double prezzo, String materiale) {
        super(codice, descrizione, prezzo);
        this.materiale = materiale;
    }

    public boolean isRiciclabile() {
        if(this.materiale.contentEquals("carta") || this.materiale.contentEquals("vetro") || this.materiale.contentEquals("cotone")) {
            return true;
        } else return false;
    }

    /* completare implementando altri metodi se necessario */
    @Override
    public double applicaSconto() {
        return this.isRiciclabile() ? this.getPrezzo() * 0.9 : this.getPrezzo();
    }

    @Override
    public String toString() {
        return super.toString() + "\nmateriale=" + this.materiale;
    }
}
