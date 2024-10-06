/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.oop.veicoli;

/**
 *
 * @author mongisa
 */
public class Camion extends Veicolo {
    final private int numeroAssi;
    
    public Camion(String numTelaio, String modello, String alimentazione, String targa, int numeroAssi) {
        super(numTelaio, modello, alimentazione, targa);
        this.numeroAssi = numeroAssi;
    }
    
    public int getNumeroAssi() {
        return this.numeroAssi;
    }
    
    @Override
    public boolean controllaTarga() {
        return this.getTarga().toUpperCase().matches("[A-Z]{2}[0-9]{6}");
    }
    
    @Override
    public String toString() {
        return super.toString() + " " + this.numeroAssi;
    }
}
