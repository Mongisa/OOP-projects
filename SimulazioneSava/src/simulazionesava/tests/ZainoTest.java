package simulazionesava.tests;

import simulazionesava.classi.Matita;
import simulazionesava.classi.Quaderno;
import simulazionesava.classi.Astuccio;
import simulazionesava.classi.Penna;
import simulazionesava.classi.Zaino;
import static simulazionesava.enums.MatitaModello.*;
import static simulazionesava.enums.PennaMarchio.*;

public class ZainoTest {
    public static void main(String[] args) {
        String p1 = "Alessandro";
        String p2 = "Sava";
        
        Astuccio a1 = new Astuccio(p1, 4);
        Astuccio a2 = new Astuccio(p2, 6);
        
        /* creazione astucci di propretari diversi */
        try{
            a1.aggiuntaStrumento(new Penna("ASDF321", p1, 12.6, BIC, 0.9));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            a1.aggiuntaStrumento(new Matita("ASDF321", p1, 1.99, H));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            a2.aggiuntaStrumento(new Penna("ASDF321", p2, 12.6, BIC, 0.9));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            a2.aggiuntaStrumento(new Penna("ASDF321", p2, 5, STAEDTLER, 1.1));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        
        /* aggiungo un astuccio che appartiene a sava e non ad alessandro -> ProprietarioDiversoException */
        System.out.println("(main) inserimento astuccio in zaino di un altro proprietario");
        try{
            Zaino zProva = new Zaino(p1, 4, a2);
        }catch(Exception ex){
            System.out.println(ex.getMessage()); 
        }
        
        
        System.out.println("\n(main) inserimento astuccio e quaderni in zaino dello stesso proprietario");
        Zaino z = null;
        try{
            z = new Zaino(p1, 4, a1);
        }catch(Exception ex){
            System.out.println(ex.getMessage()); 
            return;
        }
        
        try{
            z.aggiungiQuad(new Quaderno(100, "rosso", true, p1));
        }catch(Exception ex){
            System.out.println(ex.getMessage()); 
        }
        
        /* prova di aggiunta doppioni -> non è consentita l'aggiunta */
        try{
            z.aggiungiQuad(new Quaderno(100, "rosso", true, p1));
        }catch(Exception ex){
            System.out.println(ex.getMessage()); 
        }
        
        try{
            z.aggiungiQuad(new Quaderno(100, "rosso", true, p1));
        }catch(Exception ex){
            System.out.println(ex.getMessage()); 
        }
        
        try{
            z.aggiungiQuad(new Quaderno(101, "rosso", true, p1));
        }catch(Exception ex){
            System.out.println(ex.getMessage()); 
        }
        
        System.out.println(z);
        
        
        System.out.println("(main) saturiamo lo zaino e l'astuccio (2 exception aspettate)");
        try{
            z.aggiungiQuad(new Quaderno(102, "rosso", true, p1));
        }catch(Exception ex){
            System.out.println(ex.getMessage()); 
        }
        /* uno quaderno in più */
        try{
            z.aggiungiQuad(new Quaderno(103, "rosso", true, p1));
        }catch(Exception ex){
            System.out.println(ex.getMessage()); 
        }
        try{
            a1.aggiuntaStrumento(new Penna("ASDF321", p1, 12.6, BIC, 0.9));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            a1.aggiuntaStrumento(new Penna("ASDF321", p1, 12.6, BIC, 0.9));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        /* uno strumento in più */
        try{
            a1.aggiuntaStrumento(new Penna("ASDF321", p1, 12.6, BIC, 0.9));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("(main) quaderno di un proprietario diverso rispetto a quello dello zaino (1 exception aspettate)");
        try{
            z.aggiungiQuad(new Quaderno(103, "rosso", true, p2));
        }catch(Exception ex){
            System.out.println(ex.getMessage()); 
        }
        System.out.println(z);
        
        
        
        
        /* rimozione strumenti e quaderni */
        System.out.println("(main) rimozione strumenti e quaderni (lascio solo una penna BIC)");
        try{
            z.rimuoviQuad(new Quaderno(102, "rosso", true, p1));
        }catch(Exception ex){
            System.out.println(ex.getMessage()); 
        }
        try{
            z.rimuoviQuad(new Quaderno(101, "rosso", true, p1));
        }catch(Exception ex){
            System.out.println(ex.getMessage()); 
        }
        try{
            z.rimuoviQuad(new Quaderno(107, "rosso", true, p1));
        }catch(Exception ex){
            System.out.println(ex.getMessage()); 
        }
        try{
            z.rimuoviQuad(new Quaderno(100, "rosso", true, p1));
        }catch(Exception ex){
            System.out.println(ex.getMessage()); 
        }
        try{
            a1.rimuoviStrumento(new Penna("ASDF321", p1, 12.6, BIC, 0.9));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            a1.rimuoviStrumento(new Penna("ASDF321", p1, 12.6, BIC, 0.9));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            a1.rimuoviStrumento(new Penna("ASDF321", p1, 12.6, BIC, 0.9));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }       
        
        System.out.println(z);
        
        
        System.out.println("(main) rimozione strumento dall'astuccio tramite getFromAstuccio()");
        System.out.println("(main) strumento ottenuto dallo zaino, in particolare dall'astuccio: ");
        try{
            System.out.println(z.getFromAstuccio(new Penna("ASDF321", p1, 0, BIC, 0.1)));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        
        System.out.println("\n(main) mi aspetto che lo zaino ora sia ZUOTO (c'è solo l'astuccio): ");
        System.out.println(z);
    }
}
