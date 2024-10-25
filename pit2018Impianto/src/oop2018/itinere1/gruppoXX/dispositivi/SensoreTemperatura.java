package oop2018.itinere1.gruppoXX.dispositivi;

public class SensoreTemperatura extends Sensore {
    public SensoreTemperatura(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return super.toString() + " - Tipo: Sensore di temperatura";
    }
}
