package magazzino;

import java.time.LocalDate;

public class Scorta {
    private Prodotto prodotto;
    private int quantitaDisponibile;
    private LocalDate dataUltimoAggiornamento;

    public Scorta(Prodotto prodotto, int quantitaDisponibile, LocalDate dataUltimoAggiornamento) throws QuantitaNegativaException {
        if(quantitaDisponibile < 0) {
            throw new QuantitaNegativaException("Quantità negativa");
        }

        this.prodotto = prodotto;
        this.quantitaDisponibile = quantitaDisponibile;
        this.dataUltimoAggiornamento = dataUltimoAggiornamento;
    }

    public Prodotto getProdotto() {
        return this.prodotto;
    }

    public int getQuantitaDisponibile() {
        return this.quantitaDisponibile;
    }

    public LocalDate getDataUltimoAggiornamento() {
        return this.dataUltimoAggiornamento;
    }

    public void setQuantitaDisponibile(int quantita) {
        this.quantitaDisponibile = quantita;
    }

    public void setDataUltimoAggiornamento(LocalDate data) {
        this.dataUltimoAggiornamento = data;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(this.getClass() != obj.getClass()) return false;

        Scorta s = (Scorta) obj;
        return s.prodotto.equals(this.prodotto);
    }

    @Override
    public String toString() {
        return this.prodotto.toString() + ", Quantità=" + quantitaDisponibile + ", UltimoAggiornamento=" + dataUltimoAggiornamento.toString();
    }

    @Override
    public int hashCode() {
        return this.prodotto.hashCode();
    }
}
