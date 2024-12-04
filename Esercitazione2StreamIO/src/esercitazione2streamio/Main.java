package esercitazione2streamio;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LibrettoEsami le = new LibrettoEsami();

        le.addEsameSuperato(new EsameSuperato("061270", LocalDate.of(2024,12,1),"Elettrotecnica",30.0));
        le.addEsameSuperato(new EsameSuperato("061271", LocalDate.of(2024,12,2),"Elettrotecnica",30.0));

        System.out.println(le.getByMatricola("061270").toString());
    }
}
