package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudenteDAOPostGres implements StudenteDAO {
    private final String URL="jdbc:postgresql://localhost:5432/ja";
    private final String USER="username";
    private final String PASS="password";

    @Override
    public void inserisci(Studente s) throws Exception {
        try(
                Connection c = DriverManager.getConnection(URL,USER,PASS);
                Statement st = c.createStatement();
        ) {
            String update = String.format("INSERT INTO public.studenti(" +
                    "nome, cognome, matricola) " +
                    "VALUES ('%s', '%s', '%s');", s.getNome(),s.getCognome(),s.getMatricola());

            st.executeUpdate(update);
        }
    }

    @Override
    public void rimuovi(Studente s) throws Exception {
        try(
                Connection c = DriverManager.getConnection(URL,USER,PASS);
                Statement st = c.createStatement();
        ) {
            String update = String.format("DELETE FROM public.studenti " +
                    "WHERE matricola='%s';",s.getMatricola());

            st.executeUpdate(update);
        }
    }

    @Override
    public void aggiorna(Studente s) throws Exception {
        try(
                Connection c = DriverManager.getConnection(URL,USER,PASS);
                Statement st = c.createStatement();
        ) {
            String update = String.format("UPDATE public.studenti " +
                    "SET nome='%s', cognome='%s' " +
                    "WHERE matricola='%s';",s.getNome(),s.getCognome(),s.getMatricola());

            st.executeUpdate(update);
        }
    }

    @Override
    public Studente cerca(String matricola) throws Exception {
        Studente s = null;
        try(
                Connection c = DriverManager.getConnection(URL,USER,PASS);
                Statement st = c.createStatement();
        ) {
            String query = String.format("SELECT * FROM public.studenti" +
                    "WHERE matricola='%s';",matricola);

            ResultSet rs = st.executeQuery(query);

            if(rs.next()) {
                s = new Studente(rs.getString("nome"),rs.getString("cognome"),rs.getString("matricola"));
            }
        }

        return s;
    }

    @Override
    public List<Studente> elencaTutti() throws Exception {
        List<Studente> tutti = new ArrayList<>();
        try(
                Connection c = DriverManager.getConnection(URL,USER,PASS);
                Statement st = c.createStatement();
        ) {
            String query = "SELECT * FROM public.studenti;";

            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                Studente s = new Studente(rs.getString("nome"),rs.getString("cognome"),rs.getString("matricola"));
                tutti.add(s);
            }
        }

        return tutti;
    }
}
