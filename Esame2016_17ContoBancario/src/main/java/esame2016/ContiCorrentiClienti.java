package esame2016;

import java.util.*;
import java.io.Serializable;

public class ContiCorrentiClienti implements Serializable {
    private final Map<Integer, ContoCorrente> m;

    public ContiCorrentiClienti() {
        this.m = new HashMap<>();
    }

    public void aggiungiConto(int codice, Utente u) throws ContoCorrenteEsistenteException {
        ContoCorrente c = new ContoCorrente(codice, u);
        if(m.put(codice, c) != null) throw new ContoCorrenteEsistenteException(c);
    }

    public ContoCorrente rimuoviConto(int codice) throws ContoCorrenteNonEsistenteException {
        ContoCorrente c = m.remove(codice);
        if(c == null) throw new ContoCorrenteNonEsistenteException(c);
        else return c;
    }

    public double operazioneSuConto(int codice, double importo) throws ContoCorrenteNonEsistenteException, OperazioneNonConsentitaException {
        ContoCorrente c = m.get(codice);
        if(c == null) throw new ContoCorrenteNonEsistenteException(c);
        c.incrementaSaldo(importo);
        return c.getSaldo();
    }

    public Collection<ContoCorrente> getContiCorrentiUtente(String codiceFiscale) {
        Collection<ContoCorrente> conti = new HashSet<>();

        for(ContoCorrente c: m.values())
            if(c.getUtente().getCodiceFiscale().equals(codiceFiscale))
                conti.add(c);

        return conti;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("CONTI CORRENTI\n");

        for(ContoCorrente c: m.values())
            sb.append(c.toString()).append("\n");

        return sb.toString();
    }
}
