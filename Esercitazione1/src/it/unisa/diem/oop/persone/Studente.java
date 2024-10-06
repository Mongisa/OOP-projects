/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.oop.persone;

/**
 *
 * @author mongisa
 */
public class Studente extends Persona {
    private String matricola;
    
    public Studente(String nome, String cognome, String codiceFiscale, String matricola) {
        super(nome, cognome, codiceFiscale);
        
        this.matricola = matricola;
    }
    
    public String getMatricola() {
        return this.matricola;
    }
    
    public void stampaInfoStudente() {
        System.out.println(this.getNome() + " " + this.getCognome() + " " + this.getCodiceFiscale() + " " + this.getMatricola());
    }
}
