package oop2018.itinere1.gruppoXX;

import oop2018.itinere1.gruppoXX.condizioni.*;
import oop2018.itinere1.gruppoXX.azioni.*;
import oop2018.itinere1.gruppoXX.dispositivi.*;

public class Regola {
    private final Condizione condizione;
    private final Azione azione;

    public Regola(Condizione condizione, Azione azione) {
        this.condizione = condizione;
        this.azione = azione;
    }

    public boolean applica() {
        if(this.condizione.verifica()) {
            try {
                this.azione.esegui();
                return true;
            } catch (Exception e) {
                return false;
            }
        } else return false;
    }

    public Condizione getCondizione() {
        return this.condizione;
    }

    public Azione getAzione() {
        return this.azione;
    }

    @Override
    public String toString() {
        return "Informazioni regola - " + this.condizione.toString() + " - " + this.azione.toString();
    }
}
