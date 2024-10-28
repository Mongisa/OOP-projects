package magazzino;

import java.util.*;
import java.time.LocalDate;

public class Magazzino {
    private final String id;
    private String nome;
    private final Set<Scorta> inventario;

    public Magazzino(String id, String nome) {
        this.id = id;
        this.nome = nome;

        this.inventario = new HashSet<>();
    }

    public String getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void aggiungiScorta(Prodotto p, int quantita, LocalDate dataAggiornamento) throws ScortaGiaPresenteException, QuantitaNegativaException {
        Scorta s = new Scorta(p,quantita,dataAggiornamento);
        if(!this.inventario.add(s)) {
            throw new ScortaGiaPresenteException("Scorta gia presente");
        };
    }

    public void rimuoviScorta(String prodottoId, int quantita, LocalDate dataAggiornamento) throws ScortaNonTrovataException, QuantitaNonDisponibileException, QuantitaNegativaException, PrezzoNegativoException {
        Scorta s = this.getScorta(prodottoId);

        if(quantita < 0) {
            throw new QuantitaNegativaException("Quantita negativa");
        }

        if(quantita > s.getQuantitaDisponibile()) {
            throw new QuantitaNonDisponibileException("Quantità non disponibile");
        }

        if(s.getQuantitaDisponibile() == quantita) {
            inventario.remove(s);
        } else {
            s.setQuantitaDisponibile(s.getQuantitaDisponibile() - quantita);
            s.setDataUltimoAggiornamento(dataAggiornamento);
        }
    }

    public Scorta getScorta(String prodottoId) throws ScortaNonTrovataException, QuantitaNegativaException, PrezzoNegativoException {
        Prodotto p = new Prodotto(prodottoId, "", 0);
        Scorta s = new Scorta(p, 0, null);

        if(!this.inventario.contains(s)) {
            throw new ScortaNonTrovataException("Scorta non trovata");
        }

        for(Scorta si: inventario){
            if(si.getProdotto().getId().equals(prodottoId)) {
                s = si;
            }
        }

        return s;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("—----------------------------------------------------\n");
        sb.append("Magazzino " + this.nome + " " + this.id + " - Elenco scorte\n");
        sb.append("—----------------------------------------------------\n");

        for(Scorta si: this.inventario) {
            sb.append(si.toString() +  "\n");
        }

        return sb.toString();
    }
}
