package oop2018.itinere1.gruppoXX.dispositivi;

public class Dispositivo {
    private final int id;
    private boolean acceso;

    public Dispositivo(int id) {
        this.id = id;
        this.acceso = true;
    }

    @Override
    public String toString() {
        return "ID dispositivo: " + this.id + ", Stato: " + ((this.acceso) ? "Acceso" : "Spento");
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;

        Dispositivo d = (Dispositivo) obj;

        return d.id == this.id;
    }

    public int getId() {
        return this.id;
    }

    public void accendi() {
        this.acceso = true;
    }

    public void spegni() {
        this.acceso = false;
    }

    public boolean isAcceso() {
        return this.acceso;
    }
}