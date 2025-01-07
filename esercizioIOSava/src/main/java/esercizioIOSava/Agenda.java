package esercizioIOSava;

import java.util.*;
import java.time.LocalDate;
import java.io.*;

public class Agenda implements Serializable {
    private final String proprietario;
    private final List<Map<LocalDate,Evento>> agenda;

    public Agenda(String proprietario) {
        this.proprietario = proprietario;
        this.agenda = new ArrayList<>();
    }

    public String getProprietario() {
        return proprietario;
    }

    public void aggiungiEvento(Evento e) {
        boolean flag = false;

        for(Map<LocalDate, Evento> subagenda : agenda) {
            if(subagenda.size() < 4) {
                if(subagenda.get(e.getData()) == null) {
                    subagenda.put(e.getData(), e);
                    flag = true;
                    break;
                }
            }
        }

        if(!flag) {
            Map<LocalDate,Evento> m = new TreeMap<>();
            m.put(e.getData(), e);
            agenda.add(agenda.size(),m);
        }
    }

    public void rimuoviEventi(LocalDate data) {
        Iterator<Map<LocalDate, Evento>> iterator = agenda.iterator();

        while(iterator.hasNext()) {
            Map<LocalDate, Evento> subagenda = iterator.next();
            if(subagenda.remove(data) != null && subagenda.isEmpty())
                iterator.remove();
        }
    }

    public Collection<Evento> getEventi(LocalDate data) {
        List<Evento> eventi = new ArrayList<>();

        for(Map<LocalDate, Evento> subagenda : agenda)
            if(subagenda.get(data) != null)
                eventi.add(subagenda.get(data));

        return eventi;
    }

    public int getNumEventi() {
        int totalSize = 0;

        for(Map<LocalDate, Evento> subagenda : agenda)
            totalSize += subagenda.size();

        return totalSize;
    }

    public void saveOBJ(String filename) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
            oos.writeObject(this);
        } catch(IOException e) {
            System.err.println(e);
        }
    }

    public static Agenda readOBJ(String filename) {
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
            return (Agenda) ois.readObject();
        } catch(Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public void saveCSV(String filename) {
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for(Map<LocalDate, Evento> subagenda : agenda) {
                for(Evento e : subagenda.values()) {
                    pw.print(e.getData().toString());
                    pw.print(',');
                    pw.println(e.getDescrizione());
                }
            }
        } catch(IOException e) {
            System.err.println(e);
        }
    }

    public static Agenda readCSV(String filename) {
        try(Scanner r = new Scanner(new BufferedReader(new FileReader(filename)))) {
            r.useLocale(Locale.US);
            r.useDelimiter("[\n,]");

            Agenda a = new Agenda(filename.split("[.]")[0]);

            while(r.hasNext()) {
                LocalDate data = LocalDate.parse(r.next());
                String descrizione = r.next();

                a.aggiungiEvento(new Evento(data, descrizione));
            }

            return a;
        } catch(IOException e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Agenda completa di ")
                .append(proprietario)
                .append(" (").append(agenda.size()).append(" sezioni - ")
                .append(this.getNumEventi()).append(" eventi)\n");

        int i = 0;
        for(Map<LocalDate, Evento> subagenda : agenda) {
            sb.append("***** Sezione ").append(++i).append(" *****\n");
            for(Evento e: subagenda.values())
                sb.append(e.toString()).append("\n");
        }

        return sb.toString();
    }
}
