package main;

public class Agriturismo {
    
    String comune_azienda;
    String titolare;
    String denominazione_azienda;
    String indirizzo_azienda;
    int posti_letto;
    int posti_macchina;
    int posti_tenda;
    int posti_roulotte;
    String recapiti;
    boolean pernottamento;
    boolean camping;

    public Agriturismo(String comune_azienda, String titolare, String denominazione_azienda, String indirizzo_azienda, int posti_letto, int posti_macchina, int posti_tenda, int posti_roulotte, String recapiti) {
        this.comune_azienda = comune_azienda;
        this.titolare = titolare;
        this.denominazione_azienda = denominazione_azienda;
        this.indirizzo_azienda = indirizzo_azienda;
        this.posti_letto = posti_letto;
        this.posti_macchina = posti_macchina;
        this.posti_tenda = posti_tenda;
        this.posti_roulotte = posti_roulotte;
        this.recapiti = recapiti;

        this.pernottamento = false;
        this.camping = false;

    }

    public String getComune_azienda() {
        return comune_azienda;
    }

    public String getTitolare() {
        return titolare;
    }

    public String getDenominazione_azienda() {
        return denominazione_azienda;
    }

    public String getIndirizzo_azienda() {
        return indirizzo_azienda;
    }

    public int getPosti_letto() {
        return posti_letto;
    }

    public int getPosti_macchina() {
        return posti_macchina;
    }

    public int getPosti_tenda() {
        return posti_tenda;
    }

    public int getPosti_roulotte() {
        return posti_roulotte;
    }

    public String getRecapiti() {
        return recapiti;
    }

    public boolean isPernottamento() {
        return pernottamento;
    }

    public boolean isCamping() {
        return camping;
    }

    public void setComune_azienda(String comune_azienda) {
        this.comune_azienda = comune_azienda;
    }

    public void setTitolare(String titolare) {
        this.titolare = titolare;
    }

    public void setDenominazione_azienda(String denominazione_azienda) {
        this.denominazione_azienda = denominazione_azienda;
    }

    public void setIndirizzo_azienda(String indirizzo_azienda) {
        this.indirizzo_azienda = indirizzo_azienda;
    }

    public void setPosti_letto(int posti_letto) {
        this.posti_letto = posti_letto;
    }

    public void setPosti_macchina(int posti_macchina) {
        this.posti_macchina = posti_macchina;
    }

    public void setPosti_tenda(int posti_tenda) {
        this.posti_tenda = posti_tenda;
    }

    public void setPosti_roulotte(int posti_roulotte) {
        this.posti_roulotte = posti_roulotte;
    }

    public void setRecapiti(String recapiti) {
        this.recapiti = recapiti;
    }

    public void setPernottamento(boolean pernottamento) {
        this.pernottamento = pernottamento;
    }

    public void setCamping(boolean camping) {
        this.camping = camping;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("\n***\n");
        sb.append(denominazione_azienda).append(" di ").append(titolare).append("\n\n");
        sb.append(indirizzo_azienda).append("\n");
        sb.append(comune_azienda).append("\n\n");
        if(pernottamento)
            sb.append("Disponibili camere pernottamento").append("\n\n");
        if (camping)
            sb.append("Disponibili posti camping").append("\n\n");
        sb.append(recapiti).append("\n");
        return sb.toString();
    }

}
