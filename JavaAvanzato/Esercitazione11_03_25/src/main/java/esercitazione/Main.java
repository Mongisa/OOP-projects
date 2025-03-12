package esercitazione;

public class Main {
    public static void main(String[] args) {
        Docente d1 = new Docente("GNLGRG0019","Gianluca Grigi","92441","eng");
        Docente d2 = new Docente("STFGRG003","Stefano Grigi","93541","oop");
        Studente s1 = new Studente("MRRRSS001","Mario Rossi","061270001",CorsoDiStudi.LT,24.8f);
        Studente s2 = new Studente("MRRBNC001","Mario Bianchi","062270001",CorsoDiStudi.LM,27.3f);

        Anagrafica a = new Anagrafica();
        a.inserisciMembroUnisa(d1);
        a.inserisciMembroUnisa(d2);
        a.inserisciMembroUnisa(s1);
        a.inserisciMembroUnisa(s2);

        System.out.println(a);

        a.writeCSV("Anagrafica.csv");

        Anagrafica a2 = Anagrafica.readCSV("Anagrafica.csv");
        System.out.println(a2);
    }
}
