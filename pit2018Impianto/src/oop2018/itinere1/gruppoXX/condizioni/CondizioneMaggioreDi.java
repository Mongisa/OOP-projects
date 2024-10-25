package oop2018.itinere1.gruppoXX.condizioni;

import oop2018.itinere1.gruppoXX.dispositivi.*;

public class CondizioneMaggioreDi implements Condizione {
    private final Sensore sensore;
    private final double valoreDiConfronto;

    public CondizioneMaggioreDi(Sensore sensore, double valoreDiConfronto) {
        this.sensore = sensore;
        this.valoreDiConfronto = valoreDiConfronto;
    }

    @Override
    public boolean verifica() {
        return this.sensore.getValore() > this.valoreDiConfronto;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();

        s.append("Tipo condizione: Maggiore di " + this.valoreDiConfronto);
        s.append(" - attivata per: " + this.sensore.toString());

        return s.toString();
    }
}
