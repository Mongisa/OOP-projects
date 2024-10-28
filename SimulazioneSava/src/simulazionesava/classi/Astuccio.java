package simulazionesava.classi;

import java.util.*;
import simulazionesava.exceptions.*;

public class Astuccio {
    private final String proprietario;
    private final int capienzaMassimaOggetti;
    private final List<StrumentoScrittura> astuccio;

    public Astuccio(String proprietario, int capienzaMassimaOggetti) {
        this.proprietario = proprietario;
        this.capienzaMassimaOggetti = capienzaMassimaOggetti;

        this.astuccio = new ArrayList<>();
    }

    public String getProprietario() {
        return this.proprietario;
    }
    
    public int getCapienzaMassima(){
        return this.capienzaMassimaOggetti;
    }
    
    public List<StrumentoScrittura> getAstuccio(){
        return this.astuccio;
    }

    public void aggiuntaStrumento(StrumentoScrittura s) throws ProprietarioDiversoException, SpazioSaturatoException {
        if(this.astuccio.size() == this.capienzaMassimaOggetti) {
            throw new SpazioSaturatoException("Spazio saturato");
        }

        if(!s.getProprietario().equals(this.proprietario)) {
            throw new ProprietarioDiversoException("Proprietario diverso");
        }

        this.astuccio.add(s);
    }

    public void rimuoviStrumento(StrumentoScrittura s) {
        this.astuccio.remove(s);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("------Astuccio di ").append(this.proprietario).append("------\n");
        sb.append("Numero strumenti: ").append(this.astuccio.size()).append("/").append(this.capienzaMassimaOggetti).append("\n");

        for(StrumentoScrittura s: this.astuccio) {
            sb.append(s.toString());
        }

        sb.append("------Fine elenco strumenti astuccio------\n");
        return sb.toString();
    }
}
