package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ElencoAgriturismo {
    private final List<Agriturismo> elenco;

    public ElencoAgriturismo() {
        elenco = new ArrayList<>();
    }

    public void aggiungi(Agriturismo a){
        elenco.add(a);
    }

    public <T> Collection<T> esporta(Function<Agriturismo,T> function){
        Collection<T> out = new HashSet<>();

        elenco.forEach(ai ->{
            T attributeToAdd = function.apply(ai);
            out.add(attributeToAdd);
        });

        return out;
    }
    public ElencoAgriturismo filtra(Predicate<Agriturismo> predicate){
        ElencoAgriturismo out = new ElencoAgriturismo();

        elenco.forEach(ai ->{
            if(predicate.test(ai))
                out.aggiungi(ai);
        });

        return out;
    }

    public void ordina(Comparator<Agriturismo> comparator) {
        elenco.sort(comparator);
    }

    public void aggiorna(Consumer<Agriturismo> consumer){
        elenco.forEach(ai ->{
            consumer.accept(ai);
        });
    }

    public Integer somma(Function<Agriturismo,Integer> function) {
        AtomicInteger sum = new AtomicInteger(0);

        elenco.forEach(ai ->{
             sum.addAndGet(function.apply(ai));
        });

        return sum.get();
    }


    public static ElencoAgriturismo caricaCSV(String filename) {
        try(Scanner s = new Scanner(new BufferedReader(new InputStreamReader(ElencoAgriturismo.class.getClassLoader().getResourceAsStream(filename))))) {
            ElencoAgriturismo ag = new ElencoAgriturismo();
            s.useDelimiter("[;\n]");
            s.nextLine();
            while(s.hasNext()) {
                String comune = s.next();
                String titolare = s.next();
                String denominazione = s.next();
                String indirizzo = s.next();
                int postiLetto = 0;
                if(s.hasNextInt())
                    postiLetto = s.nextInt();
                else
                    s.next();
                int postiMacchina = 0;
                if(s.hasNextInt())
                    postiMacchina = s.nextInt();
                else
                    s.next();
                int postiTenda = 0;
                if(s.hasNextInt())
                    postiTenda = s.nextInt();
                else
                    s.next();
                int postiRoulotte = 0;
                if(s.hasNextInt())
                    postiRoulotte = s.nextInt();
                else
                    s.next();
                String email = s.next();

                ag.aggiungi(new Agriturismo(comune,titolare,denominazione,indirizzo,postiLetto,postiMacchina,postiTenda,postiRoulotte,email));
            }

            return ag;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("***Elenco Agriturismi***\n");

        for(Agriturismo a: elenco)
            sb.append(a);

        return sb.toString();
    }
}
