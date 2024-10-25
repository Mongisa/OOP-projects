package distributore;

import java.util.*;

import distributore.bibite.CocaCola;
import distributore.eccezioni.*;

public class Distributore {
    private List<Bibita> bibite;
    private Set<Tessera> tessere;

    public Distributore() {
        this.bibite = new ArrayList<>();
        this.tessere = new TreeSet<>();
    }

    public void registraTessera(int codice) throws CodiceTesseraPresenteException {
        Tessera t = new Tessera(codice, 0);

        if(!this.tessere.add(t)) {
            throw new CodiceTesseraPresenteException("Codice Tessera già presente");
        }
    }

    public void caricaTessera(int codice, double saldo) throws TesseraNonValidaException {
        Tessera t = new Tessera(codice, 0);

        if(!this.tessere.contains(t)) {
            throw new TesseraNonValidaException("Tessera Non Valida");
        }

        for(Tessera ti: this.tessere) {
            if(ti.getCodice() == codice) {
                t = ti;
            }
        }

        t.setSaldo(t.getSaldo() + saldo);
    }

    public void registraBibita(Bibita b) throws CodiceBibitaPresenteException {
        if(!this.bibite.contains(b)) {
            throw new CodiceBibitaPresenteException("Codice bibita già presente");
        }

        this.bibite.add(b);
    }

    public void caricaBibita(String codice, int numero) throws BibitaNonPresenteException {
        Bibita b = new CocaCola(codice, "a", 0, 0);
        int index = this.bibite.indexOf(b);

        if(index < 0) {
            throw new BibitaNonPresenteException("Bibita non presente");
        }

        this.bibite.get(index).setNumero(numero);
    }

    public void eroga(String codiceBevanda, int codiceTessera) throws TesseraNonValidaException, BibitaNonPresenteException, BibitaEsauritaException, CreditoInsufficienteException {
        Tessera t = new Tessera(codiceTessera, 0);
        Bibita b = new CocaCola(codiceBevanda, "", 0, 0);
        int index = this.bibite.indexOf(b);

        if(!this.tessere.contains(t)) {
            throw new TesseraNonValidaException("Tessera non valida");
        }

        for(Tessera ti: this.tessere) {
            if(ti.getCodice() == codiceTessera)
                t = ti;
        }

        if(index < 0) {
            throw new BibitaNonPresenteException("Bibita non presente");
        }

        b = this.bibite.get(index);

        if(b.getNumero() <= 0) {
            throw new BibitaEsauritaException("Bibita esaurita");
        }

        if(t.getSaldo() < b.getPrezzo()) {
            throw new CreditoInsufficienteException("Credito insufficiente");
        }

        b.setNumero(b.getNumero() - 1);

        System.out.println("Hai acquistato " + b.getClass() + " " + b.getPrezzo() + "€");
    }

    public double visualizzaSaldoTessera(int codice) throws TesseraNonValidaException {
        Tessera t = new Tessera(codice, 0);

        if(!this.tessere.contains(t)) {
            throw new TesseraNonValidaException("Tessera non valida");
        }

        for(Tessera ti: this.tessere) {
            if(ti.getCodice() == codice)
                t = ti;
        }

        return t.getSaldo();
    }

    public int visualizzaBibiteDisponibili(String codice) throws BibitaNonPresenteException {
        Bibita b = new CocaCola(codice, "", 0,0);
        int index = this.bibite.indexOf(b);

        if(index < 0) {
            throw new BibitaNonPresenteException("Bibita non presente");
        }

        for(Bibita bi: this.bibite) {
            if(bi.getCodice() == codice)
                b = bi;
        }

        return b.getNumero();
    }
}