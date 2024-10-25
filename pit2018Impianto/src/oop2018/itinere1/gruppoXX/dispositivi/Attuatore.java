/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2018.itinere1.gruppoXX.dispositivi;

import oop2018.itinere1.gruppoXX.dispositivi.Dispositivo;

/**
 *
 * @author Gennaro
 */
public abstract class Attuatore extends Dispositivo {
    
    public Attuatore(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return super.toString() + " Categoria: Attuatore";
    }
    
}