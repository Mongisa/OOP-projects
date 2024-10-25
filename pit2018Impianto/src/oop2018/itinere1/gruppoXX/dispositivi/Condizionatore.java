package oop2018.itinere1.gruppoXX.dispositivi;

public class Condizionatore extends AttuatoreRegolabile {
    public Condizionatore(int id, double livelloMin, double livelloMax, double livello) throws LivelloNonValidoException {
        super(id, livelloMin, livelloMax, livello);
    }

    @Override
    public String toString() {
        return super.toString() + " - Tipo: Condizionatore";
    }
}
