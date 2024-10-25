package oop2018.itinere1.gruppoXX.azioni;

import oop2018.itinere1.gruppoXX.dispositivi.*;

public class ImpostaLivello implements Azione {
    private final AttuatoreRegolabile ar;
    private final double livelloDaImpostare;

    public ImpostaLivello(AttuatoreRegolabile ar, double livelloDaImpostare) {
        this.ar = ar;
        this.livelloDaImpostare = livelloDaImpostare;
    }

    @Override
    public void esegui() throws LivelloNonValidoException {
        this.ar.setLivello(livelloDaImpostare);
    }

    @Override
    public String toString() {
        return "Tipo azione: Imposta livello - attivata per: " + this.ar.toString();
    }
}
