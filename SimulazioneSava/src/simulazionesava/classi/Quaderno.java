package simulazionesava.classi;

import simulazionesava.exceptions.*;

public class Quaderno {
    private final int pagine;
    private final String colore;
    private final boolean copertinaRigida;
    private final String proprietario;

    public Quaderno(int pagine, String colore, boolean copertinaRigida, String proprietario) {
        this.pagine = pagine;
        this.colore = colore;
        this.copertinaRigida = copertinaRigida;
        this.proprietario = proprietario;
    }

    public String getProprietario() {
        return this.proprietario;
    }

    public int getPagine() {
        return this.pagine;
    }

    public String getColore() {
        return this.colore;
    }

    //La convenzione vorrebbe che si scriva isCopertinaRigida o hasCopertinaRigida
    public boolean getCopertinaRigida() {
        return this.copertinaRigida;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 79 * hash + this.colore.hashCode();
        hash = 79 * hash + Integer.hashCode(this.pagine);
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;

        Quaderno q = (Quaderno) obj;
        return q.pagine == this.pagine && q.colore.equals(this.colore);
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("---Quaderno---\n");
        sb.append("proprietario: ").append(proprietario).append("\n");
        sb.append("Numero pagine: ").append(pagine).append("\n");
        sb.append("Colore: ").append(colore).append("\n");
        if(copertinaRigida) {
            sb.append("Copertina rigida").append("\n");
        }

        return sb.toString();
    }
}
