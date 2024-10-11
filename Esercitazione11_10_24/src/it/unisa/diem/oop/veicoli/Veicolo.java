/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.oop.veicoli;

/**
 *
 * @author mongisa
 */
public abstract class Veicolo {
    final private String numTelaio;
    final private String modello;
    final private String alimentazione;
    private String targa;
    
    public Veicolo(String numTelaio, String modello, String alimentazione, String targa) {
        this.numTelaio = numTelaio;
        this.modello = modello;
        this.alimentazione = alimentazione;
        this.targa = targa;
    }
    
    public String getNumTelaio() {
        return this.numTelaio;
    }
    
    public String getModello() {
        return this.modello;
    }
    
    public String getAlimentazione() {
        return this.alimentazione;
    }
    
    public String getTarga() {
        return this.targa;
    }
    
    public void setTarga(String targa) {
        this.targa = targa;
    }
    
    public abstract boolean controllaTarga();
    
    @Override
    public String toString() {
        return "Telaio="+this.numTelaio + ", Modello=" + this.modello + ", Alimentazione=" + this.alimentazione + ", Targa=" + this.targa;
    }
}