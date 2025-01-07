package esame2016;

import java.util.*;
import java.io.*;

public class SerializableContiCorrentiClienti extends ContiCorrentiClienti implements Serializable {
    private final ContiCorrentiClienti c;

    public SerializableContiCorrentiClienti(ContiCorrentiClienti c) {
        super();
        this.c = c;
    }

    @Override
    public void aggiungiConto(int codice, Utente u) throws ContoCorrenteEsistenteException {
        c.aggiungiConto(codice, u);
    }

    @Override
    public ContoCorrente rimuoviConto(int codice) throws ContoCorrenteNonEsistenteException {
        return c.rimuoviConto(codice);
    }

    @Override
    public double operazioneSuConto(int codice, double importo) throws OperazioneNonConsentitaException, ContoCorrenteNonEsistenteException {
        return c.operazioneSuConto(codice,importo);
    }

    @Override
    public Collection<ContoCorrente> getContiCorrentiUtente(String codiceFiscale) {
        return c.getContiCorrentiUtente(codiceFiscale);
    }

    @Override
    public String toString() {
        return c.toString();
    }

    public void save(String filename) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
            oos.writeObject(this);
        }
    }

    public static SerializableContiCorrentiClienti load(String filename) throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
            return (SerializableContiCorrentiClienti) ois.readObject();
        }
    }
}
