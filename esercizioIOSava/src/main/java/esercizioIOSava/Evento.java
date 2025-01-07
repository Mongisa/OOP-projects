package esercizioIOSava;

import java.time.LocalDate;
import java.io.Serializable;

public class Evento implements Comparable<Evento>, Serializable{
    private final LocalDate data;
    private final String descrizione;

    public Evento(LocalDate data, String descrizione) {
        this.data = data;
        this.descrizione = descrizione;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;

        Evento e = (Evento) obj;

        return e.data.equals(this.data);
    }

    @Override
    public int compareTo(Evento e) {
        return this.data.compareTo(e.data);
    }

    @Override
    public String toString() {
        return "Evento in Data: " + data.toString() + " - Descrizione: " + descrizione;
    }
}
