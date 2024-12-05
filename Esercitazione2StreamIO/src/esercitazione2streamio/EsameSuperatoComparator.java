package esercitazione2streamio;

import java.util.Comparator;

public class EsameSuperatoComparator implements Comparator<EsameSuperato> {
    @Override
    public int compare(EsameSuperato o1, EsameSuperato o2) {
        int i = o1.getMatricolaStudente().compareTo(o2.getMatricolaStudente());

        if(i==0) {
            i = o1.getNomeInsegnamento().compareTo(o2.getNomeInsegnamento());
        }

        return i;
    }
}
