package esercitazioneaereoporto;

import java.io.Serializable;

public abstract class Aeromobile implements Serializable, Cloneable {
    private final String codice;
    private final int numeroSequenziale;
    private static int contatoreIstanze = 1;

    public Aeromobile(String codice) {
        this.codice = codice;
        this.numeroSequenziale = contatoreIstanze++;
    }

    public String getCodice() {
        return this.codice;
    }

    public int getNumeroSequenziale() {
        return this.numeroSequenziale;
    }

    @Override
    public String toString() {
        return "Aeromobile n. " + this.numeroSequenziale + " - Codice = " + this.codice;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
