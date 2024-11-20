package elencotelefonico;

import java.util.HashMap;
import java.util.Map;

public class ElencoMap {
    public static void main(String[] args) {
        Map<Persona,String> elencoMap;
        elencoMap = new HashMap<>();
        //elencoMap = new TreeMap<>();

        elencoMap.put(new Persona("Luigi","Rossi","tyuio",34), "08965432");
        elencoMap.put(new Persona("Luigia","Verdi","h5reg",20), "081456732");
        elencoMap.put(new Persona("Pasquale","Bianco","lkmnh",20), "063456778");

        String tel = elencoMap.get(new Persona("","","tyuio", 0));
        System.out.println("Telefono: " + tel);

        elencoMap.forEach((k,v) -> {
            System.out.println(k);
        });

        System.out.println();

        elencoMap.forEach((k,v) -> {
            System.out.println(k + " -> " + v);
        });
        /* vabbè dovevi per forza usare sto coso bravos
        * nel chill
        */
    }
}
