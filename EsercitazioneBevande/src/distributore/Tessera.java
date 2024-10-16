package distributore;

class Tessera {
    private final int codice;
    private double saldo;

    protected Tessera(int codice) {
        this.codice = codice;
        this.saldo = 0;
    }

    protected int getCodice() {
        return this.codice;
    }

    protected double getSaldo() {
        return this.saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Codice Tessera="+this.codice + " Saldo=" + this.saldo;
    }
}
