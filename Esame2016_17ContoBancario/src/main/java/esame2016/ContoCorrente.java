package esame2016;

import java.io.Serializable;

public class ContoCorrente implements Serializable {
    private final Utente utente;
    private double saldo;
    private final int codice;

    public ContoCorrente(int codice, Utente utente) {
        this.utente = utente;
        this.saldo = 0.0;
        this.codice = codice;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getCodice() {
        return codice;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void incrementaSaldo(double incremento) throws OperazioneNonConsentitaException {
        if(saldo + incremento < 0) throw new OperazioneNonConsentitaException(this);
        saldo += incremento;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;

        ContoCorrente c = (ContoCorrente) obj;

        return c.codice == this.codice;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.codice);
    }

    @Override
    public String toString() {
        return codice + ";" + utente.toString() + ";" + saldo;
    }
}
