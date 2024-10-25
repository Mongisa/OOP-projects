package distributore;

public abstract class Bibita implements Comparable<Bibita> {
    private final String codice;
    private final String nome;
    private double prezzo;
    private int numero;

    public Bibita(String codice, String nome, double prezzo, int numero) {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
        this.numero = numero;
    }

    public String getCodice() {
        return this.codice;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPrezzo() {
        return this.prezzo;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int compareTo(Bibita b) {
        return b.getClass().toString().compareTo(this.getClass().toString());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(!(obj instanceof Bibita)) return false;

        Bibita b = (Bibita) obj;

        return b.codice.equals(this.codice);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("codice=" + this.codice + "\n");
        sb.append("nome=" + this.nome + "\n");
        sb.append("prezzo=" + this.prezzo + "\n");
        sb.append("numero=" + this.numero + "\n");

        return sb.toString();
    }
}
