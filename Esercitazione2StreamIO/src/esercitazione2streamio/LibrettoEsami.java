package esercitazione2streamio;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class LibrettoEsami implements Serializable {
    private final ObservableList<EsameSuperato> esamiSuperati;


    public LibrettoEsami() {
        this.esamiSuperati = FXCollections.observableArrayList();
    }

    public LibrettoEsami(List<EsameSuperato> esamiSuperati) {
        this.esamiSuperati = FXCollections.observableArrayList(esamiSuperati);
    }

    public void addEsameSuperato(EsameSuperato esameSuperato) {
        esamiSuperati.add(esameSuperato);
    }

    public List<EsameSuperato> getByMatricola(String matricola) {
        return esamiSuperati.filtered(e -> {
            return e.getMatricolaStudente().equals(matricola);
        });
    }

    public List<EsameSuperato> getByNomeInsegnamento(String nomeInsegnamento) {
        return esamiSuperati.filtered(e -> {
            return e.getNomeInsegnamento().equals(nomeInsegnamento);
        });
    }

    public static LibrettoEsami read(String filename) {
        try(Scanner s = new Scanner(new BufferedReader(new FileReader(LibrettoEsami.class.getResource(filename).getPath())))) {
            s.useDelimiter("\n");
            s.useLocale(Locale.ITALY);

            LibrettoEsami esami = new LibrettoEsami();

            while(s.hasNext()) {
                String[] line = s.nextLine().split(",");

                String matricola = line[0];
                LocalDate dataEsame = LocalDate.parse(line[1]);
                String nomeInsegnamento = line[2];
                int voto = Integer.parseInt(line[3]);

                EsameSuperato es = new EsameSuperato(matricola, dataEsame, nomeInsegnamento, voto);
                esami.addEsameSuperato(es);
            }

            return esami;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void saveObj(String filename) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
            oos.writeObject(new ArrayList<>(esamiSuperati));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static LibrettoEsami readObj(String filename) {
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
            List<EsameSuperato> le =(List<EsameSuperato>) ois.readObject();
            return new LibrettoEsami(le);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<EsameSuperato> getLibrettoOrdinato() {
        this.esamiSuperati.sort(new EsameSuperatoComparator());
        return this.esamiSuperati;
    }

    @Override
    public String toString() {
        return esamiSuperati.toString();
    }
}
