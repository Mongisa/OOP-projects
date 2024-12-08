package gestioneristorante;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Comande implements Serializable {
    private String filename;
    private final Queue<Ordinazione> ordinazioni;

    public Comande(String filename, boolean leggiBackup) {
        this.filename = filename;
        if(leggiBackup) {
            this.ordinazioni = leggiOBJ();
        } else {
            this.ordinazioni = new LinkedList<>();
        }
    }

    public synchronized void aggiungiOrdinazione(Ordinazione ordinazione) {
        this.ordinazioni.add(ordinazione);
        this.notifyAll();
    }

    public synchronized Ordinazione consegnaOrdinazione() throws InterruptedException {
        while(this.ordinazioni.isEmpty())
            this.wait();
        return this.ordinazioni.remove();
    }

    public synchronized void salvaOrdinazioni() throws InterruptedException {
        while(ordinazioni.isEmpty())
            this.wait();

        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
            oos.writeObject(this.ordinazioni);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Ordinazione> leggiOBJ() {
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
            return (LinkedList<Ordinazione>) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
