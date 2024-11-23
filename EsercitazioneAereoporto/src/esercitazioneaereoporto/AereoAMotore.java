package esercitazioneaereoporto;

import java.io.Serializable;

public class AereoAMotore extends Aeromobile implements Serializable {
    private final int numRotori;

    public AereoAMotore(String codice, int numRotori) {
        super(codice);
        this.numRotori = numRotori;
    }

    public int getNumRotori() {
        return this.numRotori;
    }

    @Override
    public String toString() {
        return super.toString() + " - Tipo = Aereo a motore - Numero rotori = " + this.numRotori;
    }
}
