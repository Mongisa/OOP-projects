package magazzino;

import java.util.*;
import java.time.LocalDate;

public class Magazzino {
    private String id;
    private String nome;
    private Set<Scorta> inventario;

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

    public void setNome() {
        this.nome = nome;
    }

    public void aggiungiScorta(Prodotto p, int quantita, LocalDate dataAggiornamento) {
        Scorta s = new Scorta(p,quantita,dataAggiornamento);
        this.inventario.add(s);
    }

    public void rimuoviScorta(String prodottoId, int quantita, LocalDate dataAggiornamento)  {
        Scorta s = this.getScorta(prodottoId);

        if(s.getQuantitaDisponibile() == quantita) {
            inventario.remove(s);
        } else {
            s.setQuantitaDisponibile(s.getQuantitaDisponibile() - quantita);
            s.setDataUltimoAggiornamento(dataAggiornamento);
        }
    }

    public Scorta getScorta(String prodottoId) {
        Prodotto p = new Prodotto(prodottoId, "", 0);
        Scorta s = new Scorta(p, 0, null);

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
