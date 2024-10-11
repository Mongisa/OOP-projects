/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.oop.veicoli;

/**
 *
 * @author mongisa
 */
public class Moto extends Veicolo {
    final private boolean guidaLibera;
    
    public Moto(String numTelaio, String modello, String alimentazione, String targa, boolean guidaLibera) {
        super(numTelaio,modello,alimentazione,targa);
        this.guidaLibera = guidaLibera;
    }
    
    public boolean getGuidaLibera() {
        return this.guidaLibera;
    }
    
    @Override
    public boolean controllaTarga() {
        return this.getTarga().toUpperCase().matches("[A-Z]{2}[0-9]{5}");
    }
    
    @Override
    public String toString() {
        return super.toString() + ", GuidaLibera=" + this.guidaLibera;
    }
}
