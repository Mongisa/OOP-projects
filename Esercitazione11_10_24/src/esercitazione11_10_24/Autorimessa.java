package esercitazione11_10_24;

import it.unisa.diem.oop.veicoli.Veicolo;
import it.unisa.diem.oop.veicoli.AutorimessaPienaException;
import it.unisa.diem.oop.veicoli.AutorimessaVuotaException;
import it.unisa.diem.oop.veicoli.TargaNonValidaException;

public class Autorimessa extends Box {

    private Veicolo veicoli[];
    private int testa;
    private int coda;
    private int riemp;
  
    public Autorimessa(int maxPosti, String nome) {
        super(maxPosti, nome);
        this.testa = 0;
        this.coda = 0;
        this.riemp = 0;
        this.veicoli = new Veicolo[maxPosti];
    }

    private boolean autorimessaPiena() throws AutorimessaPienaException {
        return this.riemp == maxPosti;
    }

    private boolean autorimessaVuota() throws AutorimessaVuotaException {
        return riemp == 0;
    }

    @Override
    public void entra(Veicolo v) throws AutorimessaPienaException,TargaNonValidaException {
        
        if(v.controllaTarga()) {
            throw new TargaNonValidaException("Targa non valida");
        }
        
        if(autorimessaPiena()) {
            throw new AutorimessaPienaException("Autorimessa Piena");
        }

        veicoli[coda++] = v;
        coda = coda % maxPosti;
        riemp++;
    }

    @Override
    public Veicolo esce() throws AutorimessaVuotaException {
        if(autorimessaVuota()) {
            throw new AutorimessaVuotaException("Autorimessa vuota");
        }

        riemp--;
        Veicolo v = veicoli[testa++];
        testa = testa % maxPosti;
        return v;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer(super.toString());
        s.append("\n");
        for(int i=0;i<riemp;i++) {
            s.append(veicoli[(testa+i)%maxPosti].toString());
            s.append("\n");
        }
        return s.toString();
    }

}