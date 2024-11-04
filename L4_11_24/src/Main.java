public class Main {
    public static void main(String[] args) {

        // istanza della classe esterna
        Esterna e = new Esterna();
        //e.stampa();

        // istanza della classe interna non statica
        Esterna.Interna in = e.new Interna();

        in.stampa(2);
    }
}