package oop2018.itinere1.gruppoXX.azioni;

import oop2018.itinere1.gruppoXX.dispositivi.*;

public class ImpostaStatoAccensione implements Azione {
    private final Attuatore attuatore;
    private final boolean setOn;

    public ImpostaStatoAccensione(Attuatore attuatore, boolean setOn) {
        this.attuatore = attuatore;
        this.setOn = setOn;
    }

    @Override
    public void esegui() {
        if(this.setOn) {
            this.attuatore.accendi();
        } else {
            this.attuatore.spegni();
        }
    }

    @Override
    public String toString() {
        return "Tipo azione: " + ((this.setOn) ? "Accendi" : "Spegni") + " - attivata per: " + this.attuatore.toString();
    }
}
