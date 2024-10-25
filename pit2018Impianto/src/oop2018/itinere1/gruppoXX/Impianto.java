package oop2018.itinere1.gruppoXX;

import oop2018.itinere1.gruppoXX.azioni.*;
import oop2018.itinere1.gruppoXX.dispositivi.*;
import oop2018.itinere1.gruppoXX.condizioni.*;
import java.util.*;

public class Impianto {
    private Set<Dispositivo> dispositivi;
    private List<Regola> regole;
    private final String nome;

    public Impianto(String nome) {
        this.dispositivi = new HashSet<>();
        this.regole = new ArrayList<>();
        this.nome = nome;
    }

    public Dispositivo add(Dispositivo d) {
        if(this.dispositivi.add(d)) {
            return null;
        } else {
            this.dispositivi.remove(d);
            this.dispositivi.add(d);
            return d;
        }
    }

    public Dispositivo getDispositivo(int id) {
        for(Dispositivo d: this.dispositivi) {
            if(d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    public void add(Regola r) {
        this.regole.add(r);
    }

    public void applicaRegole() {
        for(Regola r : this.regole) {
            r.applica();
        }
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();

        s.append("=====================\n");
        s.append("Informazioni impianto\n");
        s.append("=====================\n");
        s.append("\n");
        s.append("Nome: " + this.nome + "\n");
        s.append("\n");
        s.append("---- Elenco dispositivi ----\n");
        for(Dispositivo d : this.dispositivi) {
            s.append(d.toString() + "\n");
        }
        s.append("\n");
        for(Regola r: this.regole) {
            s.append(r.toString() + "\n");
        }

        return s.toString();
    }
}
