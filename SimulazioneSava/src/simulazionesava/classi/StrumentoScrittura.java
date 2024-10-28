package simulazionesava.classi;

public abstract class StrumentoScrittura {
    private final String proprietario;
    private final double prezzo;
    private final String id;

    public StrumentoScrittura(String id, String proprietario, double prezzo) {
        this.id = id;
        this.proprietario = proprietario;
        this.prezzo = prezzo;
    }

    public String getId(){
        return this.id;
    }
    
    public double getPrezzo() {
        return this.prezzo;
    }

    public String getProprietario() {
        return this.proprietario;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("---Strumento scrittura---\n");
        sb.append("-id: ").append(id).append("\n");
        sb.append("-proprietario: ").append(proprietario).append("\n");
        sb.append("-prezzo: ").append(prezzo).append(" €\n");

        return sb.toString();
    }

    //SAVA non lo voleva
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(!(obj instanceof StrumentoScrittura)) return false;

        StrumentoScrittura s = (StrumentoScrittura) obj;

        return s.id.equals(this.id);
    }
}
