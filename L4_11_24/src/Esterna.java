public class Esterna {
    public int a = 0;
    void stampa() {
        System.out.println("Esterna a: " + a);
    }


    //classe interna - definita nello spazio degli attributi fuori dai metodi
    protected class Interna {
        public int a=1;

        void stampa(int a) {
            System.out.println("parametro stampa a: " + a);
            System.out.println("Interna a: " + this.a);
            System.out.println("Esterna a: " + Esterna.this.a); //Shadowing
        }
    }

    //classe interna statica
    static class Statica {
        int a=10;
        void stampa() {
            System.out.println("Statica a: " + a);
        }
    }

    void provaLocale() {
        int c=2; //variabile locale - non accessibile in scrittura dalla classe locale

        class Locale {
            int l=10;
            int c=1;

            void stampaLoc() {
                c=c*2;
                System.out.println("Locale c:" + c);
            }
        }
        Locale l = new Locale();
        l.stampaLoc();
    }
}
