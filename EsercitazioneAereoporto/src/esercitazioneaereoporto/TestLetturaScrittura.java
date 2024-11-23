package esercitazioneaereoporto;

public class TestLetturaScrittura {
    public static void main(String[] args) {
        Aeroporto aeroporto = new Aeroporto(null);

        Aeromobile[] aeromobili = TestAeroporto.inizializzaAeromobili();

        for(Aeromobile aeromobile : aeromobili){
            aeroporto.inserisci(aeromobile);
        }

        //Scrittura su file
        //aeroporto.salvaDOS("aeroporto1.bin");
        //aeroporto.salvaOBJ("aeroporto1.bin");

        //Lettura da file
        //Aeroporto aeroporto2 = Aeroporto.leggiDOS("aeroporto1.bin");
        //Aeroporto aeroporto2 = Aeroporto.leggiOBJ("aeroporto1.bin");

        //System.out.println(aeroporto2);
    }
}
