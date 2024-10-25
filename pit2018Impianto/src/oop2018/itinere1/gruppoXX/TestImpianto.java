/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2018.itinere1.gruppoXX;

import oop2018.itinere1.gruppoXX.dispositivi.Condizionatore;
import oop2018.itinere1.gruppoXX.dispositivi.SensoreTemperatura;
import oop2018.itinere1.gruppoXX.dispositivi.LuceRegolabile;
import oop2018.itinere1.gruppoXX.dispositivi.SensoreLuminosita;
import oop2018.itinere1.gruppoXX.dispositivi.Luce;
import oop2018.itinere1.gruppoXX.dispositivi.Sensore;
import oop2018.itinere1.gruppoXX.dispositivi.Dispositivo;
import oop2018.itinere1.gruppoXX.dispositivi.LivelloNonValidoException;
import oop2018.itinere1.gruppoXX.azioni.Azione;
import oop2018.itinere1.gruppoXX.azioni.ImpostaStatoAccensione;
import oop2018.itinere1.gruppoXX.condizioni.Condizione;
import oop2018.itinere1.gruppoXX.condizioni.CondizioneMinoreDi;
import oop2018.itinere1.gruppoXX.condizioni.CondizioneMaggioreDi;


/**
 *
 * @author Gennaro
 */
public class TestImpianto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Impianto impianto = new Impianto("Casa mia");
        Dispositivo retVal = null;
        
        // Aggiungo Condizionatore
        Condizionatore c = null;
        try {
            c= new Condizionatore(1, 18.0, 31.0, 24.0);
            retVal = impianto.add(c);
            if(retVal!=null)
                System.out.println("Sostituzione dispositivo -> " + retVal);
            System.out.println("Nuovo dispositivo aggiunto -> " + c);
        } catch (LivelloNonValidoException ex) {
            System.out.println("Impossibile aggiungere dispositivo: valori non validi");
        }
        
        // Aggiungo sensore temperatura
        SensoreTemperatura st = new SensoreTemperatura(9);
        st.setValore(23.4);
        retVal = impianto.add(st);
            if(retVal!=null)
                System.out.println("Sostituzione dispositivo -> " + retVal);
        System.out.println("Nuovo dispositivo aggiunto -> " + st);

        // Aggiungo Regole di accensione e spegnimento per Condizionatore con sensore di temperatura
        Condizione cond1 =new CondizioneMaggioreDi( (Sensore)impianto.getDispositivo(9) , ((Condizionatore)impianto.getDispositivo(1)).getLivello() + 0.3 );
        System.out.println("\n---- Visualizzo condizione ----\n"+cond1);
        Azione az1 = new ImpostaStatoAccensione((Condizionatore)impianto.getDispositivo(1), true);
        System.out.println("\n---- Visualizzo azione ----\n"+az1);
        Regola r1 = new Regola(cond1, az1);
        System.out.println("\n---- Visualizzo regola ----\n"+r1);
        impianto.add(r1);

        Condizione cond2 =new CondizioneMinoreDi( (Sensore)impianto.getDispositivo(9) , ((Condizionatore)impianto.getDispositivo(1)).getLivello() - 0.3);
        System.out.println("\n---- Visualizzo condizione ----\n"+cond2);
        Azione az2 = new ImpostaStatoAccensione((Condizionatore)impianto.getDispositivo(1), false);
        System.out.println("\n---- Visualizzo azione ----\n"+az2);
        Regola r2 = new Regola(cond2, az2);
        System.out.println("\n---- Visualizzo regola ----\n"+r2);
        impianto.add(r2);
        
        // Aggiungo Luce
        Luce l = new Luce(2);
        retVal=impianto.add(l);
            if(retVal!=null)
                System.out.println("Sostituzione dispositivo -> " + retVal);
        System.out.println("Nuovo dispositivo aggiunto -> " + l);
        
        
        // Aggiungo LuceRegolabile
        LuceRegolabile ld = null;
        try {
            ld= new LuceRegolabile(5, 0.0, 100.0, 43);
            retVal = impianto.add(ld);
            if(retVal!=null)
                System.out.println("Sostituzione dispositivo -> " + retVal);
            System.out.println("Nuovo dispositivo aggiunto -> " + ld);
        } catch (LivelloNonValidoException ex) {
            System.out.println("Impossibile aggiungere dispositivo: valori non validi");
        }

        // Aggiungo LuceRegolabile con valori non validi
        try {
            ld= new LuceRegolabile(2, 0.0, -1.0, 5.0);
            retVal = impianto.add(ld);
            if(retVal!=null)
                System.out.println("Sostituzione dispositivo -> " + retVal);
            System.out.println("Nuovo dispositivo aggiunto -> " + ld);
        } catch (LivelloNonValidoException ex) {
            System.out.println("Impossibile aggiungere dispositivo: valori non validi");
        }
        
        // Sostituisco LuceDimmable
        try {
            ld= new LuceRegolabile(5, 0.0, 100.0, 78.0);
            retVal = impianto.add(ld);
            if(retVal!=null)
                System.out.println("Sostituzione dispositivo -> " + retVal);
            System.out.println("Nuovo dispositivo aggiunto -> " + ld);
        } catch (LivelloNonValidoException ex) {
            System.out.println("Impossibile aggiungere dispositivo: valori non validi");
        }
        
        
        
        SensoreLuminosita sl = new SensoreLuminosita(12);
        sl.setValore(200.0);
        retVal = impianto.add(sl);
            if(retVal!=null)
                System.out.println("Sostituzione dispositivo -> " + retVal);
        System.out.println("Nuovo dispositivo aggiunto -> " + sl);
 
        
        System.out.println(impianto);
        
        
        System.out.println("\n\n\n---- APPLICAZIONE REGOLE ----");
        System.out.println("Imposto la temperatura del sensore a 23.5° -> Il condizionatore si deve spegnere");
        ((SensoreTemperatura)impianto.getDispositivo(9)).setValore(23.5);
        impianto.applicaRegole();
        
        System.out.println(impianto);

        System.out.println("\n\n\n---- APPLICAZIONE REGOLE ----");
        System.out.println("Imposto la temperatura del sensore a 24.5° -> Il condizionatore si deve accendere");
        ((SensoreTemperatura)impianto.getDispositivo(9)).setValore(24.5);
        impianto.applicaRegole();
        
        System.out.println(impianto);
    }
    
}
