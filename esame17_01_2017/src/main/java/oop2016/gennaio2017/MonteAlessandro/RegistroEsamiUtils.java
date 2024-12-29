package oop2016.gennaio2017.MonteAlessandro;

import java.io.*;

public class RegistroEsamiUtils {
    public static RegistroEsami caricaDaFileBinario(String filename) {
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
            return (RegistroEsami) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean salvaSuFileBinario(String filename, RegistroEsami r) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
            oos.writeObject(r);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
