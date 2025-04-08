package main;

public class Filtri {
    public static void aggiornaPernottamento(Agriturismo agriturismo){
        if(agriturismo.getPosti_letto()!=0)
            agriturismo.setPernottamento(true);
    }

    public static void aggiornaCamping(Agriturismo agriturismo){
        if(agriturismo.getPosti_roulotte() != 0 || agriturismo.getPosti_tenda() != 0)
            agriturismo.setCamping(true);
    }
}
