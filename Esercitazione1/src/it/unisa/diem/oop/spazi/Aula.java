/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.oop.spazi;

import java.util.Stack;
import it.unisa.diem.oop.persone.Studente;

/**
 *
 * @author mongisa
 */
public class Aula {
    private final int maxPosti;
    private int postiOccupati = 0;
    Stack<Studente> posti;
    Studente studenti[];
    
    public Aula(int maxPosti) {
        this.maxPosti = maxPosti;
        this.posti = new Stack();
        this.postiOccupati = 0;
        this.studenti = new Studente[this.maxPosti];
    }
    
    public void entra(Studente s) {
        if(this.aulaPiena()) {
            System.out.println("Aula piena");
            return;
        }
        
        this.posti.push(s);
        this.studenti[this.postiOccupati++] = s;
    }
    
    public Studente esce() {
        if(this.aulaVuota()) {
            System.out.println("Aula vuota");
            return null;
        }
        
        this.studenti[this.postiOccupati--] = null;
        return this.posti.pop();
    }
    
    public boolean aulaPiena() {
        return this.postiOccupati == this.maxPosti;
    }
    
    public boolean aulaVuota() {
        return this.postiOccupati == 0;
    }
    
    public String getInfoAula() {
        StringBuffer string = new StringBuffer();
        
        for(int i=0; i<this.postiOccupati; i++) {
            Studente s = this.studenti[i];
            string.append(s.getNome());
            string.append(" ");
            string.append(s.getCognome());
            string.append(" ");
            string.append(s.getCodiceFiscale());
            string.append(" ");
            string.append(s.getMatricola());
            string.append("\n");
        }
        
        return string.toString();
    }
    
    public int getMaxPosti() {
        return this.maxPosti;
    }
    
    public int getPostiOccupati() {
        return this.postiOccupati;
    }
    
}
