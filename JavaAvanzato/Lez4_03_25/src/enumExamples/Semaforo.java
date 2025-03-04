package enumExamples;

public class Semaforo {
    Colore c;

    public Semaforo(Colore c) {
        this.c = c;
    }

    public void indicazioni() {
        switch (c) {
            case NERO -> System.out.println("Semaforo spento");
            case ROSSO -> System.out.println("Attenzione. Non attraversare");
            case GIALLO -> System.out.println("Liberare in fretta l'incrocio");
            case VERDE -> System.out.println("E' possibile attraversare");
        }
    }

    public String indicazioniSwitchStatement() {
        var s = switch(c) {
            case NERO -> "Semaforo spento";
            case ROSSO -> "Attenzione non attraversare";
            case GIALLO -> "Liberare in fretta l'incrocio";
            case VERDE -> {
                /*altro codice*/
                yield "E' possibile attraversare";
            }
        };
        return s;
    }
}
