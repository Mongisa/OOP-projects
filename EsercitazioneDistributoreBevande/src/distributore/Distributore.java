package distributore;

import java.util.*;

import distributore.bibite.CocaCola;
import distributore.eccezioni.*;

public class Distributore {
    private final List<Bibita> bibite;
    private final Set<Tessera> tessere;

    public Distributore() {
        this.bibite = new ArrayList<>();
        this.tessere = new TreeSet<>();
    }

    public void registraTessera(int codice) throws CodiceTesseraPresenteException {
        Tessera t = new Tessera(codice, 0);

        if(!this.tessere.add(t)) {
            throw new CodiceTesseraPresenteException("Codice Tessera " + codice + " già presente");
        }
    }

    public void caricaTessera(int codice, double saldo) throws TesseraNonValidaException {
        Tessera t = new Tessera(codice, 0);

        if(!this.tessere.contains(t)) {
            throw new TesseraNonValidaException("Tessera " + codice + " Non Valida");
        }

        for(Tessera ti: this.tessere) {
            if(ti.getCodice() == codice) {
                t = ti;
            }
        }

        t.setSaldo(t.getSaldo() + saldo);
    }

    public void registraBibita(Bibita b) throws CodiceBibitaPresenteException {
        if(this.bibite.contains(b)) {
            throw new CodiceBibitaPresenteException("Bibita con codice "+ b.getCodice() + " già presente");
        }

        this.bibite.add(b);
    }

    public void caricaBibita(String codice, int numero) throws BibitaNonPresenteException {
        Bibita b = new CocaCola(codice, "a", 0, 0);
        int index = this.bibite.indexOf(b);

        if(index < 0) {
            throw new BibitaNonPresenteException("Bibita " + codice + " non presente");
        }

        b= this.bibite.get(index);

        b.setNumero(b.getNumero() + numero);
    }

    public void eroga(String codiceBevanda, int codiceTessera) throws TesseraNonValidaException, BibitaNonPresenteException, BibitaEsauritaException, CreditoInsufficienteException {
        Tessera t = new Tessera(codiceTessera, 0);
        Bibita b = new CocaCola(codiceBevanda, "", 0, 0);
        int index = this.bibite.indexOf(b);

        if(!this.tessere.contains(t)) {
            throw new TesseraNonValidaException("Tessera " + codiceTessera + " non valida");
        }

        for(Tessera ti: this.tessere) {
            if(ti.getCodice() == codiceTessera)
                t = ti;
        }

        if(index < 0) {
            throw new BibitaNonPresenteException("Bibita " + codiceBevanda + " non presente");
        }

        b = this.bibite.get(index);

        if(b.getNumero() <= 0) {
            throw new BibitaEsauritaException("Bibita" + b.getNome() + " esaurita");
        }

        if(t.getSaldo() < b.getPrezzo()) {
            throw new CreditoInsufficienteException("Credito insufficiente (" + t.getSaldo() + ")");
        }

        b.setNumero(b.getNumero() - 1);
        t.setSaldo(t.getSaldo() - b.getPrezzo());

        System.out.println("Hai acquistato " + b.getNome() + " " + b.getPrezzo() + "€");
    }

    public double visualizzaSaldoTessera(int codice) throws TesseraNonValidaException {
        Tessera t = new Tessera(codice, 0);

        if(!this.tessere.contains(t)) {
            throw new TesseraNonValidaException("Tessera " + codice + " non valida");
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
            throw new BibitaNonPresenteException("Bibita " + codice + " non presente");
        }

        for(Bibita bi: this.bibite) {
            if(bi.getCodice().equals(codice))
                b = bi;
        }

        return b.getNumero();
    }

    //Non richiesto, implementato per debugging
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("---Info Distributore---\n");
        sb.append("---Lista tessere---\n");
        for(Tessera t: this.tessere) {
            sb.append(t.toString()).append("\n");
        }

        sb.append("\n");
        sb.append("---Lista bibite---\n");
        for(Bibita b: this.bibite) {
            sb.append(b.toString()).append("\n");
        }

        return sb.toString();
    }
}