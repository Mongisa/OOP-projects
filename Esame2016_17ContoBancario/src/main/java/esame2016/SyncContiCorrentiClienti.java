package esame2016;

import java.util.Collection;

public class SyncContiCorrentiClienti extends ContiCorrentiClienti {
    private final ContiCorrentiClienti c;

    public SyncContiCorrentiClienti(ContiCorrentiClienti c) {
        this.c = c;
    }

    @Override
    public synchronized void aggiungiConto(int codice, Utente u) throws ContoCorrenteEsistenteException {
        c.aggiungiConto(codice,u);
    }

    @Override
    public synchronized ContoCorrente rimuoviConto(int codice) throws ContoCorrenteNonEsistenteException {
        return c.rimuoviConto(codice);
    }

    @Override
    public synchronized double operazioneSuConto(int codice, double importo) throws OperazioneNonConsentitaException, ContoCorrenteNonEsistenteException {
        return c.operazioneSuConto(codice,importo);
    }

    @Override
    public synchronized Collection<ContoCorrente> getContiCorrentiUtente(String codiceFiscale) {
        return c.getContiCorrentiUtente(codiceFiscale);
    }

    @Override
    public synchronized String toString() {
        return c.toString();
    }
}
