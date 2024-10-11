/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esercitazione11_10_24;

import it.unisa.diem.oop.veicoli.Veicolo;
import it.unisa.diem.oop.veicoli.BoxException;
import it.unisa.diem.oop.veicoli.AutorimessaVuotaException;

public abstract class Box {

    public int maxPosti;
    private String nome;

    public Box(int maxPosti, String nome) {
               this.maxPosti = maxPosti;
               this.nome = nome;
    }

    public int getMaxPosti() {
            return this.maxPosti;
    }

    public void setMaxPosti(int maxPosti) {
               this.maxPosti = maxPosti;
    }

    public String getNome() {
               return this.nome;
    }

    public void setNome(String nome) {
            this.nome = nome;
    }

    public abstract void entra(Veicolo v) throws BoxException;

    public abstract Veicolo esce() throws AutorimessaVuotaException;

    @Override
    public String toString() {
        return "Nome Box="+this.nome+", "+"Capienza= "+this.maxPosti;
    }

}