package esercizio;

import java.util.*;

public class Carrello {
    /* completare con eventuali attributi */
    private List<Prodotto> carrello;

    public Carrello() {
        this.carrello = new LinkedList<>();
    }

    public void addProdotto(Prodotto p) {
        /* completare */
        this.carrello.add(p);
    }

    public double getTotale() {
        double somma = 0;
        Iterator<Prodotto> i = this.carrello.iterator();

        while(i.hasNext()) {
            somma += i.next().getPrezzo();
        }

        return somma;
    }

    public double getTotaleScontato() {
        double somma = 0;

        for(Prodotto p: carrello) {
            somma += p.applicaSconto();
        }

        return somma;
    }

    public void removeProdotto(Prodotto p) {
        this.carrello.remove(p);
    }

    public Prodotto getProdotto(int idx) {
        return this.carrello.get(idx);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        for(Prodotto p: carrello) {
            sb.append(p.toString()+"\n");
        }

        sb.append("\n");
        sb.append("Prezzo Totale=" + this.getTotale() + "€\n");
        sb.append("Prezzo Totale Scontato=" + this.getTotaleScontato() + "€");

        return sb.toString();
    }
}
