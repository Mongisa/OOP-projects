package oop2016.gennaio2017.MonteAlessandro;

import java.time.*;
import java.io.Serializable;

public class Esame implements Serializable {
    private final String nome;
    private final LocalDate data;
    private final int voto;
    private final String codice;

    private Esame(String nome, LocalDate data, int voto, String codice) {
        this.nome = nome;
        this.data = data;
        this.voto = voto;
        this.codice = codice;
    }

    public String getCodice() {
        return this.codice;
    }

    @Override
    public int hashCode() {
        return this.codice.toLowerCase().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;

        Esame e = (Esame) obj;

        return this.codice.equalsIgnoreCase(e.codice);
    }

    public String getNome() {
        return this.nome;
    }

    public LocalDate getData() {
        return LocalDate.of(data.getYear(),data.getMonth(),data.getDayOfMonth());
    }

    public int getVoto() {
        return this.voto;
    }

    @Override
    public String toString() {
        return "Esame{nome=" + nome + ", data=" + data.toString() + ", voto=" + voto + ", codice=" + codice + "}";
    }

    public static Esame crea(String nome, int giorno, int mese, int anno, int voto, String codice) {
        try {
            LocalDate.of(anno,mese,giorno);
        } catch(DateTimeException e) {
            throw new DataNonValidaException("Data non valida!");
        }

        if(voto < 18 || voto > 31) throw new VotoNonValidoException("Voto non incluso nell'intervallo 18-31!");

        if(codice == null) throw new CodiceNonValidoException("Il codice passato non può essere null!");

        return new Esame(nome, LocalDate.of(anno,mese,giorno), voto, codice);
    }
}
