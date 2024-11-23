package esercitazioneaereoporto;

import java.io.Serializable;

public class Aliante extends Aeromobile implements Serializable {
    private final double efficienza;

    public Aliante(String codice, double efficienza) {
        super(codice);
        this.efficienza = efficienza;
    }

    public double getEfficienza() {
        return this.efficienza;
    }

    @Override
    public String toString() {
        return super.toString() + " - Tipo = Aliante - Efficienza = " + String.format("%.2f", efficienza);
    }
}
