package esercitazioneaereoporto;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Aeroporto implements Serializable {
    private final CodeChecker codeChecker;
    private final Map<String, Aeromobile> flotta;

    public Aeroporto(CodeChecker codeChecker) {
        this.codeChecker = codeChecker;
        flotta = new LinkedHashMap<>();
    }

    public boolean inserisci(Aeromobile a) {
        if(this.flotta.containsKey(a.getCodice())) {
            return false;
        } else {
            if(codeChecker != null && !codeChecker.check(a.getCodice())) return false;

            this.flotta.put(a.getCodice(), a);
            return true;
        }
    }

    public Aeromobile cerca(String codice) {
        Aeromobile a = this.flotta.get(codice);
        if(a == null) return null;

        try {
            return (Aeromobile) a.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Aeromobile rimuovi(String codice) {
        return this.flotta.remove(codice);
    }

    public int elementi() {
        return this.flotta.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Aeromobile a : this.flotta.values()) {
            sb.append(a).append("\n");
        }

        return sb.toString();
    }

    /* SCHEMA SALVATAGGIO
     * int [0-infinito] - size
     * int [0,1,2] - CodeChecker. 0-null, 1-IT, 2-EN
     * -----size volte------
     * utf - codice
     * int [0,1] - tipo aeromobile. 0-AereoAMotore, 1-Aliante
     * int/double - numero rotori/efficienza
     * ---------------------
     */

    public void salvaDOS(String nomefile) {
        try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(nomefile)))) {

            dos.writeInt(flotta.size());

            //CodeChecker: 0-null, 1-IT, 2-EN
            if(this.codeChecker == null) {
                dos.writeInt(0);
            } else if(this.codeChecker.getClass() == CodeCheckIT.class) {
                dos.writeInt(1);
            } else if(this.codeChecker.getClass() == CodeCheckEN.class) {
                dos.writeInt(2);
            } else {
                dos.writeInt(0);
            }

            for (Aeromobile a : this.flotta.values()) {
                dos.writeUTF(a.getCodice());
                //0: AereoAMotore, 1: Aliante
                if(a.getClass() == AereoAMotore.class) {
                    dos.writeInt(0);
                    AereoAMotore am = (AereoAMotore) a;
                    dos.writeInt(am.getNumRotori());
                } else if (a.getClass() == Aliante.class) {
                    dos.writeInt(1);
                    Aliante ali = (Aliante) a;
                    dos.writeDouble(ali.getEfficienza());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Aeroporto leggiDOS(String nomefile) {
        Aeroporto aeroporto = null;

        try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(nomefile)))) {
            int length = dis.readInt();
            int codeChecker = dis.readInt();

            if(codeChecker == 1) {
                aeroporto = new Aeroporto(new CodeCheckIT());
            } else if(codeChecker == 2) {
                aeroporto = new Aeroporto(new CodeCheckEN());
            } else {
                aeroporto = new Aeroporto(null);
            }

            for(int i = 0; i < length; i++) {
                String codice = dis.readUTF();
                int tipo = dis.readInt();
                Aeromobile a = null;
                if(tipo == 0) {
                    int numRotori = dis.readInt();
                    a = new AereoAMotore(codice, numRotori);
                } else if(tipo == 1) {
                    double efficienza = dis.readDouble();
                    a = new Aliante(codice, efficienza);
                }

                aeroporto.flotta.put(codice, a);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return aeroporto;
    }

    public void salvaOBJ(String nomefile) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomefile)))) {
            oos.writeObject(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Aeroporto leggiOBJ(String nomefile) {
        Aeroporto aeroporto = null;

        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomefile)))) {
            aeroporto = (Aeroporto) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return aeroporto;
    }
}