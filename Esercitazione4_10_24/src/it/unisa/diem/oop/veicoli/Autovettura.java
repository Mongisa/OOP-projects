/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.oop.veicoli;

/**
 *
 * @author mongisa
 */
public class Autovettura extends Veicolo {
    
    final private int numeroPosti;
    
    public Autovettura(String numTelaio, String modello, String alimentazione, String targa, int numeroPosti) {
        super(numTelaio,modello,alimentazione,targa);
        this.numeroPosti = numeroPosti;
    }
    
    public int getNumeroPosti() {
        return this.numeroPosti;
    }
    
    @Override
    public boolean controllaTarga() {
        return this.getTarga().toUpperCase().matches("[A-Z]{2}[0-9]{3}[A-Z]{2}");
    }
    
    @Override
    public String toString() {
        return super.toString() + " " + this.numeroPosti;
    }
}
