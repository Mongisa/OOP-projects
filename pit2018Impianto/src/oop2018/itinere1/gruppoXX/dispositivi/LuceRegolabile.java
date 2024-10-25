package oop2018.itinere1.gruppoXX.dispositivi;

public class LuceRegolabile extends AttuatoreRegolabile {
    public LuceRegolabile(int id, double livelloMin, double livelloMax, double livello) throws LivelloNonValidoException {
        super(id, livelloMin, livelloMax, livello);
    }

    @Override
    public String toString() {
        return super.toString() + " - Tipo: Luce regolabile";
    }
}
