/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package it.unisa.diem.oop.spazi;

import it.unisa.diem.oop.persone.Studente;

/**
 *
 * @author mongisa
 */
public class TestAula {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Aula a = new Aula(3);
        
        a.esce();
        
        a.entra(new Studente("Mario","Rossi","MRRSS06A","0612700000"));
        a.entra(new Studente("Roberto","Adinolfi","RBTDN08B","0612700001"));
        
        System.out.println("Elenco studenti in aula: ");
        System.out.println(a.getInfoAula());
        
        a.esce().stampaInfoStudente();
        
        System.out.println();
        
        System.out.println("Elenco studenti in aula: ");
        System.out.println(a.getInfoAula());
        
        a.entra(new Studente("Antonio","De Luca", "NTNDL09C","0612700002"));
        a.entra(new Studente("Giovanni","Esposito", "GVNES10E","0612700003"));
        
        System.out.println("Elenco studenti in aula: ");
        System.out.println(a.getInfoAula());
        
        a.entra(new Studente("Pasquale", "Rossi", "PSQRS11F","0612700004"));
        
    }
    
}
