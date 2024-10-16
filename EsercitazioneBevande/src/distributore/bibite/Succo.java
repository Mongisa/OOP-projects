package distributore.bibite;

import distributore.Bibita;

public class Succo extends Bibita {
    public Succo(String codice, String nome, double prezzo, int numero) {
        super(codice,nome,prezzo,numero);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;

        if(obj == this) return true;

        if(obj.getClass() != this.getClass()) return false;

        Succo s = (Succo) obj;

        return s.getCodice().equals(this.getCodice());
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
