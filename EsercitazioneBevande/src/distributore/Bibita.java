package distributore;

public abstract class Bibita implements Comparable {
    private final String codice;
    private String nome;
    private double prezzo;
    private int numero;

    public Bibita(String codice, String nome, double prezzo, int numero) {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
        this.numero = numero;
    }

    protected String getCodice() {
        return this.codice;
    }

    protected String getNome() {
        return this.nome;
    }

    protected double getPrezzo() {
        return this.prezzo;
    }

    protected int getNumero() {
        return this.numero;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    protected void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Id=" + this.codice + " Nome=" + this.nome + " Prezzo=" + this.prezzo + "€ Quantità=" + this.numero;
    }

    @Override
    public abstract boolean equals(Object obj);
}
