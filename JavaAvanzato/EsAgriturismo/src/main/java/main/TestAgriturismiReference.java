package main;

import java.util.Comparator;

public class TestAgriturismiReference {
    public static void main(String[] args) {
        ElencoAgriturismo elencoAgriturismo = ElencoAgriturismo.caricaCSV("Agriturismi-Napoli.csv");

        elencoAgriturismo.aggiorna(Filtri::aggiornaPernottamento);

        elencoAgriturismo.aggiorna(Filtri::aggiornaCamping);

        System.out.println(elencoAgriturismo);

        System.out.println(elencoAgriturismo.esporta(Agriturismo::getComune_azienda));

        elencoAgriturismo.ordina(Comparator.comparing(Agriturismo::getDenominazione_azienda));
        System.out.println(elencoAgriturismo);

        System.out.println(elencoAgriturismo.filtra(a -> a.getComune_azienda().equalsIgnoreCase("Gragnano")).somma(Agriturismo::getPosti_letto));
    }
}
