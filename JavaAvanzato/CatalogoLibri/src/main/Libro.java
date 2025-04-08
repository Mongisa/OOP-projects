package main;

import java.util.Optional;

public class Libro {
    private final String titolo;
    private final String autore;
    private final int annoPubblicazione;
    private double prezzo;
    private Optional<Double> sconto;

    public Libro(String titolo, String autore, int annoPubblicazione) {
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = 0;
        this.sconto = Optional.empty();
    }

    public Libro(String titolo, String autore, int annoPubblicazione, double prezzo, Optional<Double> sconto) {
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
        this.sconto = sconto;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public Optional<Double> getSconto() {
        return sconto;
    }

    public void setSconto(Optional<Double> sconto) {
        this.sconto = sconto;
    }

    @Override
    public String toString() {
        return "Libro{Titolo=" + titolo + ",Autore=" + autore + ",AnnoPubblicazione=" + annoPubblicazione + ",Prezzo=" + prezzo + ",Sconto=" + sconto + '}';
    }
}
