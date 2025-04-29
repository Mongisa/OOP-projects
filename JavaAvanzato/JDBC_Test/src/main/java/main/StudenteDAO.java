package main;

import java.util.List;

public interface StudenteDAO {
    public void inserisci(Studente s) throws Exception;
    public void rimuovi(Studente s) throws Exception;
    public void aggiorna(Studente s) throws Exception;
    public Studente cerca(String matricola) throws Exception;
    public List<Studente> elencaTutti() throws Exception;
}
