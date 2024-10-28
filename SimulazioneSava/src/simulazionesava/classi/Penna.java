package simulazionesava.classi;

import simulazionesava.enums.PennaMarchio;
import simulazionesava.exceptions.ConsumatoException;

public class Penna extends StrumentoScrittura {
    private final PennaMarchio marchio;
    private double inchiostro;

    public Penna(String id, String proprietario, double prezzo, PennaMarchio marchio, double inchiostro) {
        super(id,proprietario,prezzo);
        this.marchio = marchio;
        this.inchiostro = inchiostro;
    }

    public double getInchiostro() {
        return this.inchiostro;
    }

    public PennaMarchio getMarchio() {
        return this.marchio;
    }

    public void setInchiostro(double inchiostroConsumato) throws ConsumatoException {
        if(inchiostroConsumato > this.inchiostro) {
            throw new ConsumatoException("Inchiostro consumato");
        }

        this.inchiostro -= inchiostroConsumato;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("-Tipo: Penna ").append(this.marchio).append("\n");
        sb.append("-Inchiostro rimanente: ").append(this.inchiostro).append(" ml\n");

        return sb.toString();
    }
}
