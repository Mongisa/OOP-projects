package magazzino;

public class Prodotto {
    private final String id;
    private final String nome;
    private final double prezzoUnitario;

    public Prodotto(String id, String nome, double prezzoUnitario) throws PrezzoNegativoException {
        if(prezzoUnitario < 0) {
            throw new PrezzoNegativoException("Prezzo negativo");
        }

        this.id = id;
        this.nome = nome;
        this.prezzoUnitario = prezzoUnitario;
    }

    public String getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPrezzoUnitario() {
        return this.prezzoUnitario;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;

        Prodotto p = (Prodotto) obj;
        return p.id.equals(this.id);
    }

    @Override
    public String toString() {
        return "ID prodotto=" + id + ", Nome=" + nome + ", Prezzo=" + prezzoUnitario + "€";
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
