package distributore;

public class Tessera implements Comparable<Tessera> {
    private final int codice;
    private double saldo;

    public Tessera(int codice, double saldo) {
        this.codice = codice;
        this.saldo = saldo;
    }

    public int getCodice() {
        return this.codice;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(!(obj instanceof Tessera)) return false;

        Tessera t = (Tessera) obj;

        return t.codice == this.codice;
    }

    @Override
    public int compareTo(Tessera t) {
        return this.codice - t.codice;
    }
}
