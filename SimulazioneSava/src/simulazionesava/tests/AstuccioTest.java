package simulazionesava.tests;

import simulazionesava.enums.MatitaModello;
import simulazionesava.enums.PennaMarchio;
import simulazionesava.classi.Matita;
import simulazionesava.classi.Astuccio;
import simulazionesava.classi.Penna;

public class AstuccioTest {
    public static void main(String[] args) {
        String p1 = "Alessandro";
        String p2 = "Sava";
        
        Astuccio a1 = new Astuccio(p1, 4);
        Astuccio a2 = new Astuccio(p2, 6);
        
        
        /* nessuno strumento inserito */
        System.out.print(a1);
        System.out.println(a2);
        
        System.out.print("(main) inserimento di 4 strumenti\n");
        /* aggiunta normale di strumenti */
        try{
            a1.aggiuntaStrumento(new Penna("ASDF321", p1, 12.6, PennaMarchio.BIC, 0.9));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            a1.aggiuntaStrumento(new Penna("ASDF321", p1, 20.99, PennaMarchio.PILOT, 0.5));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            a1.aggiuntaStrumento(new Matita("ASDF321", p1, 2.99, MatitaModello.HB));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        /* elemento doppione */
        try{
            a1.aggiuntaStrumento(new Penna("ASDF321", p1, 12.6, PennaMarchio.BIC, 0.9));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        System.out.println(a1);
        
        
        System.out.println("(main) inserisco strumento in più\n");
        /* aggiunta con saturazione */        
        try{
            a1.aggiuntaStrumento(new Penna("ASDF321", p1, 12.6, PennaMarchio.BIC, 0.9));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        
        System.out.println("(main) inserimento strumento di un altro proprietario\n");
        /* aggiunta con proprietario diverso */
        try{
            a1.aggiuntaStrumento(new Penna("ASDF321", p2, 12.6, PennaMarchio.BIC, 0.9));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        
        System.out.print("(main) Rimozione di 3 strumenti\n");
        /* rimozione strumenti */
        try{
            a1.rimuoviStrumento(new Penna("ASDF321", p1, 12.6, PennaMarchio.BIC, 0.9));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            a1.rimuoviStrumento(new Penna("ASDF321", p1, 20.99, PennaMarchio.PILOT, 0.5));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            a1.rimuoviStrumento(new Penna("ASDF321", p1, 20.99, PennaMarchio.PILOT, 0.5));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        System.out.println(a1);
    }
}
