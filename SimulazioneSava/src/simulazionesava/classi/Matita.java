package simulazionesava.classi;

import simulazionesava.enums.MatitaModello;
import simulazionesava.exceptions.ConsumatoException;

public class Matita extends StrumentoScrittura {
    private MatitaModello modello;
    private double lunghezza;

    public Matita(String id, String proprietario, double prezzo, MatitaModello modello) {
        super(id,proprietario,prezzo);
        this.modello = modello;
        this.lunghezza = 17;
    }

    public double getLunghezza() {
        return this.lunghezza;
    }

    public MatitaModello getModello() {
        return this.modello;
    }

    public void setLunghezza(double lunghezzaConsumata) throws ConsumatoException {
        if(lunghezzaConsumata > lunghezza) {
            throw new ConsumatoException("Lunghezza consumata");
        }

        this.lunghezza -= lunghezzaConsumata;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("-Tipo: Matita ").append(this.modello).append("\n");
        sb.append("-Lunghezza rimanente: ").append(this.lunghezza).append(" cm\n");

        return sb.toString();
    }
}
