package main;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainStream {
    public static void main(String[] args) {
        /* caricare un elenco agriturismi da file tramite stream API
        mediante uso della classe Files*/
        ElencoAgriturismi ea = ElencoAgriturismi.caricaCSVStream("Agriturismi-Benevento.csv");

        /* aggiornare il valore dell'attributo pernottamento (inizializzato a FALSE
        durante la lettura) sulla base della disponibilità di posti letto*/
        ea.stream().forEach(a -> a.setPernottamento(a.getPostiLetto() > 0));

        /* aggiornare il valore dell'attributo camping (inizializzato a FALSE durante la lettura)
        sulla base dei posti tenda/roulotte*/
        ea.stream().forEach(a -> a.setCamping(a.getPostiRoulotte() > 0 || a.getPostiTenda() > 0));

        /* esportare l'elenco dei comuni che ospitano Agriturismi */
        List<String> elencoComuni = ea.stream()
                .map(Agriturismo::getComuneAzienda)
                .distinct()
                .toList();
        System.out.println(elencoComuni);

        // ordinare l'intero elenco alfabeticamente per denominazione azienda
        List<?> aziendeOrdinate = ea.stream()
                .map(Agriturismo::getDenominazioneAzienda)
                .sorted() /* String::compareTo è di default */
                .toList();
        System.out.println(aziendeOrdinate);

        // indicare il comune con il maggior numero di posti campeggio
        String comuneMaxPosti = ea.stream()
                .max((o1, o2) -> o1.getPostiCamping()-o2.getPostiCamping())
                .map(Agriturismo::getComuneAzienda)
                .orElseGet(() -> "NESSUN COMUNE");
        System.out.println(comuneMaxPosti);

        // ottenere una mappa (Map<K,V>) con il numero di posti letto complessivi disponibili per ogni comune
        Map<String, Integer> comuniPostiLetto = ea.stream()
                .collect(Collectors.groupingBy(
                        Agriturismo::getComuneAzienda,
                        Collectors.summingInt(Agriturismo::getPostiLetto)
                ));
        System.out.println(comuniPostiLetto);

        /* ottenere una mappa con il numero medio di
        posti camping degli agriturismi di ogni comune*/
        Map<String, Double> averageNumber = ea.stream()
                .collect(Collectors.groupingBy(
                        Agriturismo::getComuneAzienda,
                        Collectors.averagingInt(Agriturismo::getPostiLetto)
                ));
        System.out.println(averageNumber);


        /* - definito un record Titolare con attributi (nome, cognome, mail) ottenere un elenco (lista)
           di tutti titolari. Laddove la mail non fosse definita, impostare una mail di
           default ("info@agriturismibenevento.it")*/

        List<Titolare> listaTitolari = ea.stream()
                .map(agriturismo -> {
                    String[] identita = agriturismo.getTitolare().split(" ", 2);
                    String cognome = identita[0];
                    String nome = identita[1];
                    String email = "nd".equals(agriturismo.getRecapiti())
                            ? "info@agriturismibenevento.it"
                            : agriturismo.getRecapiti();
                    return new Titolare(nome, cognome, email);
                })
                .toList();
        System.out.println(listaTitolari);
    }
}
