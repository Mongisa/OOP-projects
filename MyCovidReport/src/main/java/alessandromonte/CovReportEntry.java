package alessandromonte;

import java.time.LocalDateTime;

public class CovReportEntry implements Comparable<CovReportEntry> {
    private LocalDateTime date;
    private String stato;
    private String codice_regione;
    private String denominazioneRegione;
    private String codice_provincia;
    private String denominazioneProvincia;
    private String sigla_provincia;
    private double latitudine;
    private double longitudine;
    private int totaleCasi;
    private String note;

    public CovReportEntry(LocalDateTime date, String stato, String codice_regione, String denominazione_regione, String codice_provincia, String denominazione_provincia, String sigla_provincia, double latitudine, double longitudine, int totale_casi, String note) {
        this.date = date;
        this.stato = stato;
        this.codice_regione = codice_regione;
        this.denominazioneRegione = denominazione_regione;
        this.codice_provincia = codice_provincia;
        this.denominazioneProvincia = denominazione_provincia;
        this.sigla_provincia = sigla_provincia;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        this.totaleCasi = totale_casi;
        this.note = note;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getCodice_regione() {
        return codice_regione;
    }

    public void setCodice_regione(String codice_regione) {
        this.codice_regione = codice_regione;
    }

    public String getDenominazioneRegione() {
        return denominazioneRegione;
    }

    public void setDenominazioneRegione(String denominazione_regione) {
        this.denominazioneRegione = denominazione_regione;
    }

    public String getCodice_provincia() {
        return codice_provincia;
    }

    public void setCodice_provincia(String codice_provincia) {
        this.codice_provincia = codice_provincia;
    }

    public String getDenominazioneProvincia() {
        return denominazioneProvincia;
    }

    public void setDenominazione_provincia(String denominazione_provincia) {
        this.denominazioneProvincia = denominazione_provincia;
    }

    public String getSigla_provincia() {
        return sigla_provincia;
    }

    public void setSigla_provincia(String sigla_provincia) {
        this.sigla_provincia = sigla_provincia;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }

    public int getTotaleCasi() {
        return totaleCasi;
    }

    public void setTotaleCasi(int totale_casi) {
        this.totaleCasi = totale_casi;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(this.getClass() != obj.getClass()) return false;
        CovReportEntry other = (CovReportEntry) obj;

        return other.getDate().equals(this.getDate()) || this.getCodice_provincia().equals(other.getCodice_provincia());
    }

    @Override
    public int compareTo(CovReportEntry o) {
        int r = date.compareTo(o.getDate());

        if (r == 0) {
            return codice_provincia.compareTo(o.getCodice_provincia());
        }

        return r;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("CovReportEntry{");
        sb.append("date=").append(date);
        sb.append(", stato=").append(stato);
        sb.append(", codice_regione=").append(codice_regione);
        sb.append(", denominazioneRegione=").append(denominazioneRegione);
        sb.append(", codice_provincia=").append(codice_provincia);
        sb.append(", denominazioneProvincia=").append(denominazioneProvincia);
        sb.append(", sigla_provincia=").append(sigla_provincia);
        sb.append(", latitudine=").append(latitudine);
        sb.append(", longitudine=").append(longitudine);
        sb.append(", totaleCasi=").append(totaleCasi);
        sb.append(", note=").append(note);

        return sb.append("}").toString();
    }
}
