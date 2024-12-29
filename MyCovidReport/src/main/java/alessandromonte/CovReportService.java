package alessandromonte;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

public class CovReportService extends Service<ObservableList<CovReportEntry>> {
    private final String partialUrl = "https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-province/dpc-covid19-ita-province-";
    private String url;
    private String denominazioneRegione;

    public void setDateInUrl(LocalDate date) {
        this.url = partialUrl + date.toString().replace("-","") + ".csv";
    }

    public String getUrl() {
        return this.url;
    }

    public void setDenominazioneRegione(String denominazioneRegione) {
        this.denominazioneRegione = denominazioneRegione;
    }

    public String getDenominazioneRegione() {
        return this.denominazioneRegione;
    }

    @Override
    protected Task<ObservableList<CovReportEntry>> createTask() {
        return new Task<ObservableList<CovReportEntry>>() {
            @Override
            protected ObservableList<CovReportEntry> call() throws FileNotFoundException, MalformedURLException {
                String url = getUrl();
                try(Scanner scanner = new Scanner(new BufferedInputStream((new URL(url)).openStream()))) {
                    scanner.useDelimiter("[\n,]");
                    scanner.useLocale(Locale.US);

                    if(scanner.nextLine() == null) return null;

                    ObservableList<CovReportEntry> l = FXCollections.observableArrayList();

                    while(scanner.hasNext()) {
                        LocalDateTime dateTime = LocalDateTime.parse(scanner.next());
                        String stato = scanner.next();
                        String codiceRegione = scanner.next();
                        String denominazioneRegione = scanner.next();
                        String codiceProvincia = scanner.next();
                        String denominazioneProvincia = scanner.next();
                        String siglaProvincia = scanner.next();
                        double latitudine = 0.0;
                        if(scanner.hasNextFloat()) {
                            latitudine =  scanner.nextFloat();
                        } else {
                            scanner.next();
                        }
                        double longitudine = 0.0;
                        if(scanner.hasNextFloat()) {
                            longitudine =  scanner.nextFloat();
                        } else {
                            scanner.next();
                        }
                        int totaleCasi = 0;
                        if(scanner.hasNextInt()) {
                            totaleCasi = scanner.nextInt();
                        } else {
                            scanner.next();
                        }

                        StringBuffer sb = new StringBuffer();

                        for(int i=0; i<4;i++)
                            sb.append(scanner.next());

                        String note = sb.toString();

                        CovReportEntry cre = new CovReportEntry(dateTime, stato,codiceRegione,denominazioneRegione,codiceProvincia,denominazioneProvincia,siglaProvincia,latitudine,longitudine,totaleCasi,note);

                        if(getDenominazioneRegione() != null && !getDenominazioneRegione().isEmpty()) {
                            if(denominazioneRegione.contains(getDenominazioneRegione())) {
                                l.add(cre);
                            }
                        } else {
                            l.add(cre);
                        }
                    }
                    updateProgress(1, 1);
                    return l;
                } catch(IOException e) {
                    updateProgress(1, 1);
                    return null;
                }
            };
        };
    }
}
