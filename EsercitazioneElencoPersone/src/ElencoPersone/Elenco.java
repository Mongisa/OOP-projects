package ElencoPersone;

import java.util.*;

public class Elenco {
    private final Set<Persona> elenco;

    public Elenco(){
        this.elenco = new HashSet<>();
    }

    public void aggiungi(Persona p) {
        elenco.add(p);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("L'elenco è formato da:");

        for(Persona p: elenco) {
            sb.append("\n***");
            sb.append("\n" + p.toString());
        }

        return sb.toString();
    }

}
