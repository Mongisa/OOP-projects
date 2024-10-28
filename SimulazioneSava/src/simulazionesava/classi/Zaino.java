package simulazionesava.classi;

import java.util.*;
import simulazionesava.exceptions.*;

public class Zaino {
    private final String proprietario;
    private final Astuccio astuccio;
    private final int capienzaMassimaOggetti;
    private final Set<Quaderno> quaderni;

    public Zaino(String proprietario, int capienzaMassimaOggetti, Astuccio astuccio) throws ProprietarioDiversoException {
        if(!proprietario.equals(astuccio.getProprietario())) {
            throw new ProprietarioDiversoException("Proprietario diverso");
        }

        this.proprietario = proprietario;
        this.astuccio = astuccio;
        this.capienzaMassimaOggetti = capienzaMassimaOggetti;

        this.quaderni = new HashSet<>();
    }

    public String getProprietario() {
        return this.proprietario;
    }

    public int getCapienzaMassimaOggetti() {
        return this.capienzaMassimaOggetti;
    }

    public void aggiungiQuad(Quaderno q) throws ProprietarioDiversoException, SpazioSaturatoException {
        if(this.quaderni.size()+1 == this.capienzaMassimaOggetti) {
            throw new SpazioSaturatoException("Spazio saturato");
        }

        if(!q.getProprietario().equals(this.proprietario)) {
            throw new ProprietarioDiversoException("Proprietario diverso");
        }

        this.quaderni.add(q);
    }

    public void rimuoviQuad(Quaderno q) {
        this.quaderni.remove(q);
    }

    //Secondo me andava inserito in Astuccio e non in Zaino, il metodo è un po' controverso.
    public StrumentoScrittura getFromAstuccio(StrumentoScrittura s) {
        List<StrumentoScrittura> a = astuccio.getAstuccio();

        if(!a.contains(s)) return null;

        astuccio.rimuoviStrumento(s);
        return s;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("------------Zaino di Alessandro------------------\n");
        sb.append("Numero oggetti: ").append(this.quaderni.size()+1).append("/").append(this.capienzaMassimaOggetti).append("\n\n");
        sb.append(this.astuccio.toString()).append("\n");
        Iterator<Quaderno> i = this.quaderni.iterator();

        while(i.hasNext()) {
            Quaderno q = i.next();
            sb.append(q.toString());
        }

        sb.append("------------Fine elenco oggetti zaino------------\n");

        return sb.toString();
    }
}
