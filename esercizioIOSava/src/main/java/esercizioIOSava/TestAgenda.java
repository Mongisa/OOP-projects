package esercizioIOSava;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public class TestAgenda {
    private static Evento getEventoCasuale(Random n){        
        int anno = n.nextInt(51)+2025;
        int mese = n.nextInt(12)+1;
        int giorno = n.nextInt(LocalDate.of(anno,mese,1).lengthOfMonth())+1;
        
        String[] descrizioni = {
            "BedWars Gis",
            "Esercitazione ASD",
            "Esercitazione OOP",
            "D&D",
            "Teatro Verdi",
            "Riunione con Rocco",
            "Rimpatriata coi bro",
            "Festa Dakunto"
        };
        String descrizioneCasuale = descrizioni[n.nextInt(descrizioni.length)];
        
        return new Evento(LocalDate.of(anno, mese, giorno), descrizioneCasuale);
    }
    
    public static void main(String[] args) throws IOException {
        Agenda a = new Agenda("Gis");
        
        Random n = new Random(300);
        Evento eventi[] = new Evento[20];
        for(int i=0; i<eventi.length; i++){
            eventi[i]=getEventoCasuale(n);
        }
        
        
        System.out.println("------(main)------ Inserimento 10 eventi (metodo aggiungiEvento)");
        for(int i=0; i<=3; i++){
            a.aggiungiEvento(eventi[i]);
        }        
        a.aggiungiEvento(new Evento(eventi[0].getData(),"Riunione Speciale"));        
        for(int i=4; i<=8; i++){
            a.aggiungiEvento(eventi[i]);
        }
        System.out.println(a);
        
        
        System.out.println("------(main)------ Rimozione evento in data "
                +eventi[2].getData()+" (metodo rimuoviEventi)");
        a.rimuoviEventi(eventi[2].getData());        
        System.out.println(a);
        
        
        System.out.println("------(main)------ Inserimento 11 eventi (metodo aggiungiEvento)");
        for(int i=9; i<eventi.length; i++){
            a.aggiungiEvento(eventi[i]);
        }
        System.out.println(a);
        
        
        System.out.println("------(main)------ Ricerca degli eventi in data "
                +eventi[0].getData()+" (metodo getEventi)");
        System.out.println(a.getEventi(eventi[0].getData())+"\n");
        
        
        System.out.println("------(main)------ Rimozione 15 eventi (metodo rimuoviEventi)");
        for(int i=0; i<15; i++){
            a.rimuoviEventi(eventi[i].getData());
        }
        System.out.println(a);
        
        
        System.out.println("------(main)------ Scrittura dell'agenda (metodo saveOBJ)");
        a.saveOBJ(a.getProprietario()+".ser");
        System.out.println("------(main)------ (metodo readOBJ)");
        System.out.println(Agenda.readOBJ(a.getProprietario()+".ser"));
        
        
        System.out.println("------(main)------ Scrittura dell'agenda (metodo saveCSV)");
        a.saveCSV(a.getProprietario()+".csv");
        System.out.println("------(main)------ (metodo readCSV)");
        System.out.println(Agenda.readCSV(a.getProprietario()+".csv"));
    }
}
