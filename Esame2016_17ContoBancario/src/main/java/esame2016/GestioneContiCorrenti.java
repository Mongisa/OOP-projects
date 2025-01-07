/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esame2016;

import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;


/**
 *
 * @author Gennaro
 */
public class GestioneContiCorrenti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        SerializableContiCorrentiClienti conti = null;
        String filename, risposta;
        int scelta;

        do {
            System.out.println("Vuoi caricare conti correnti da file? (S/N): ");
            risposta = s.next().toLowerCase();
        } while ((!risposta.equals("s")) && (!risposta.equals("n")));

        if (risposta.equals("s")) {
            System.out.println("Digitare nome file: ");
            filename = s.next();
            try {
                conti = SerializableContiCorrentiClienti.load(filename);
            } catch (ClassNotFoundException ex) {
                System.out.println("Errore caricamento dati. Il programma sara' terminato");
                ex.printStackTrace();
                System.exit(-1);
            } catch (IOException ex) {
                System.out.println("Errore caricamento dati. Il programma sara' terminato");
                ex.printStackTrace();
                System.exit(-1);
            }
        } else {
            System.out.println("Digitare nome per salvataggio automatico: ");
            filename = s.next();
            conti = new SerializableContiCorrentiClienti(new ContiCorrentiClienti());
        }
        System.out.println("Digitare periodo di salvataggio automatico in secondi");
        int period = s.nextInt();

        SyncContiCorrentiClienti syncConti = new SyncContiCorrentiClienti(conti);

        // TODO: DA COMPLETARE istanziare ed avviare il thread di salvataggio automatico
        new Thread(new ThreadSalvataggioAutomatico(syncConti,filename,period)).start();


        while ((scelta = menu(s)) != 0) {
            switch (scelta) {
                case 1: {
                    ContoCorrente c = leggiConto(s);

                    // ToDo: Completare
                    try {
                        conti.aggiungiConto(c.getCodice(), c.getUtente());
                    } catch (ContoCorrenteEsistenteException e) {
                        System.err.println("ERRORE: conto " + e.getC().getCodice() + " già esistente");
                    }

                    break;
                }
                case 2: {
                    System.out.println("Digitare il codice del conto corrente da eliminare: ");
                    int codice = s.nextInt();

                    // ToDo: Completare
                    try {
                        conti.rimuoviConto(codice);
                    } catch (ContoCorrenteNonEsistenteException e) {
                        System.err.println("ERRORE: conto con codice " + codice + " inesistente");
                    }

                    break;
                }
                case 3: {
                    System.out.println("Digitare il codice del conto corrente su cui operare: ");
                    int codice = s.nextInt();
                    System.out.println("Digitare importo operazione (valore positivo per versamento, negativo per prelievo: ");
                    double importo = s.nextDouble();

                    // ToDo: Completare
                    try {
                        conti.operazioneSuConto(codice, importo);
                    } catch (OperazioneNonConsentitaException e) {
                        System.err.println("ERRORE: Il saldo non può essere negativo");
                    } catch (ContoCorrenteNonEsistenteException e) {
                        System.err.println("ERRORE: conto con codice " + codice + " inesistente");
                    }

                    break;
                }
                case 4: {
                    System.out.println("Digitare il codice fiscale dell'utente: ");
                    String codiceFiscale = s.next();

                    // ToDo: Completare
                    Collection<ContoCorrente> data = conti.getContiCorrentiUtente(codiceFiscale);

                    if(data.isEmpty())
                        System.out.println("Nessun conto presente per " + codiceFiscale);
                    else
                        for(ContoCorrente c: data)
                            System.out.println(c);

                    break;
                }
                case 5: {

                    // ToDo: Completare
                    System.out.println(conti.toString());

                    break;
                }
                default: {
                    System.out.println("Scelta non consentita");
                }
            }
        }
        System.exit(0);
    }

    private static int menu(Scanner s) {
        int risposta;
        String msg = "1. Aggiungi conto\n"
                + "2. Rimuovi conto\n"
                + "3. Operazione su conto\n"
                + "4. Visualizza conti correnti di un utente\n"
                + "5. Visualizza tutti i conti correnti\n"
                + "0. Termina applicazione\nSelezionare operazione: ";
        do {
            System.out.println(msg);
            risposta = s.nextInt();
        } while ((risposta < 0) && (risposta > 5));
        return risposta;
    }

    private static ContoCorrente leggiConto(Scanner s) {
        System.out.print("Digitare codice conto corrente: ");
        int codice = s.nextInt();
        System.out.print("Digitare nome utente: ");
        String nome = s.next();
        System.out.print("Digitare cognome utente: ");
        String cognome = s.next();
        System.out.print("Digitare codice fiscale utente: ");
        String codFis = s.next();
        return new ContoCorrente(codice, new Utente(cognome, nome, codFis));

    }

}
