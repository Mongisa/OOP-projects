package esercitazione;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagrafica {
    private final Map<String, MembroUnisa> anagrafica = new HashMap<>();

    public void inserisciMembroUnisa(MembroUnisa membro) {
        anagrafica.put(membro.getMatricola(),membro);
    }

    public MembroUnisa getMembroUnisa(String matricola) {
        return anagrafica.get(matricola);
    }

    public MembroUnisa deleteMembroUnisa(String matricola) {
        return anagrafica.remove(matricola);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Anagrafica\n");

        for(MembroUnisa membro : anagrafica.values()) {
            sb.append(membro.toString()).append("\n");
        }

        return sb.toString();
    }

    public void writeCSV(String filename) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for(MembroUnisa membro : anagrafica.values()) {
                pw.print(membro.getCodiceFiscale() + ";");
                pw.print(membro.getNomeCompleto() + ";");
                pw.print(membro.getMatricola() + ";");

                switch (membro) {
                    case Docente d -> {
                        pw.print("docente" + ";");
                        pw.print(d.getInsegnamento());
                    }
                    case Studente s -> {
                        pw.print("studente" + ";");
                        pw.print(s.getVotoMedio() + ";");
                        pw.print(s.getCorsoDiStudi());
                    }
                    default -> pw.print("membro");
                }
                pw.println();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static Anagrafica readCSV(String filename) {
        try(Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)))) {
            Anagrafica anagrafica = new Anagrafica();

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                var data = line.split(";");

                switch (data.length) {
                    case 5 -> {
                        Docente d = new Docente(data[0], data[1], data[2], data[4]);
                        anagrafica.inserisciMembroUnisa(d);
                    }
                    case 6 -> {
                        Studente s = new Studente(data[0],data[1],data[2],CorsoDiStudi.valueOf(data[5]),Float.parseFloat(data[4]));
                        anagrafica.inserisciMembroUnisa(s);
                    }
                }
            }

            return anagrafica;
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
