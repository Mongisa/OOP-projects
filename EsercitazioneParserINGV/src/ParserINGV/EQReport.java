package ParserINGV;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class EQReport {
    private String name;
    private final List<EQEvent> events;

    public EQReport(String name) {
        this.name = name;
        this.events = new ArrayList<>();
    }

    public void addEvent(EQEvent event) {
        this.events.add(event);
    }

    public void sort() {
        this.events.sort(null);
    }

    public void sort(Comparator<EQEvent> c) {
        this.events.sort(c);
    }

    public static EQReport readFromTextFile(String fileName) {
        EQReport report = new EQReport("report");

        try(Scanner s = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            s.useDelimiter("[|\n]");
            s.useLocale(Locale.US);

            while(s.hasNext()) {
                String eventId = s.next();
                LocalDateTime time = LocalDateTime.parse(s.next());
                double latitude = s.nextDouble();
                double longitude = s.nextDouble();
                double depthKm = s.nextDouble();
                String author = s.next();
                String catalog = s.next();
                String contributor = s.next();
                String contributorID = s.next();
                String magType = s.next();
                double magnitude = s.nextDouble();
                String magAuthor = s.next();
                String eventLocationName = s.next();

                EQEvent e = new EQEvent(eventId, time,latitude,longitude,depthKm,author,catalog,contributor,contributorID,magType,magnitude,magAuthor,eventLocationName);

                report.addEvent(e);
            }

            return report;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void printToTextFile(EQReport eqr, String fileName) {
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            eqr.events.forEach(e -> {
                StringBuffer sb = new StringBuffer();
                sb.append(e.getEventID()).append("|");
                sb.append(e.getTime()).append("|");
                sb.append(e.getLatitude()).append("|");
                sb.append(e.getLongitude()).append("|");
                sb.append(e.getDepthKm()).append("|");
                sb.append(e.getAuthor()).append("|");
                sb.append(e.getCatalog()).append("|");
                sb.append(e.getContributor()).append("|");
                sb.append(e.getContributorID()).append("|");
                sb.append(e.getMagType()).append("|");
                sb.append(e.getMagnitude()).append("|");
                sb.append(e.getAuthor()).append("|");
                sb.append(e.getEventLocationName());
                out.println(sb.toString());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return events.toString();
    }
}
