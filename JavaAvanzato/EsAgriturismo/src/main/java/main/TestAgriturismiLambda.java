package main;

public class TestAgriturismiLambda {
    public static void main(String[] args) {
        ElencoAgriturismo elencoAgriturismo = ElencoAgriturismo.caricaCSV("Agriturismi-Napoli.csv");

        System.out.println(
                elencoAgriturismo.esporta(a -> a.getComune_azienda())
        );


        System.out.println(
                elencoAgriturismo.filtra(a -> a.getPosti_letto()>15)
        );


        elencoAgriturismo.ordina(
                (o1, o2) -> o1.denominazione_azienda.compareToIgnoreCase(o2.getDenominazione_azienda())
        );
        System.out.println(elencoAgriturismo);


        elencoAgriturismo.aggiorna(ai ->{
            if(ai.getPosti_letto()>0)
                ai.setPernottamento(true);
        });
        elencoAgriturismo.aggiorna(ai ->{
            if(ai.getPosti_roulotte()>0 || ai.getPosti_tenda()>0)
                ai.setCamping(true);
        });
        System.out.println(elencoAgriturismo);


        Integer sommaPostiLetto =
                elencoAgriturismo.filtra(a -> a.getComune_azienda().equalsIgnoreCase("Gragnano")).somma(a -> a.getPosti_letto());
        System.out.println("Somma dei posti letto: "+sommaPostiLetto);
    }
}
