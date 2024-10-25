package oop2018.itinere1.gruppoXX.dispositivi;

public class AttuatoreRegolabile extends Attuatore {
    private final double livelloMin;
    private final double livelloMax;
    private double livello;

    public AttuatoreRegolabile (int id, double livelloMin, double livelloMax, double livello) throws LivelloNonValidoException {
        super(id);

        if(livello < livelloMin || livello > livelloMax) throw new LivelloNonValidoException("Livello non valido");

        this.livelloMin = livelloMin;
        this.livelloMax = livelloMax;
        this.livello = livello;
    }

    public double getLivelloMin() {
        return this.livelloMin;
    }

    public double getLivelloMax() {
        return this.livelloMax;
    }

    public double getLivello() {
        return this.livello;
    }

    public void setLivello(double livello) throws LivelloNonValidoException {
        if(livello < this.livelloMin || livello > this.livelloMax) throw new LivelloNonValidoException("Livello non valido");

        this.livello = livello;
    }

    @Override
    public String toString() {
        return super.toString() + ", Attuatore regolabile Liv/Min/Max = " + livello + "/" + livelloMin + "/" + livelloMax;
    }
}
