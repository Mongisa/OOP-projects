package ParserINGV;

import java.time.LocalDateTime;

public class EQEvent implements Comparable<EQEvent> {
    private String eventID;
    private LocalDateTime time;
    private double latitude;
    private double longitude;
    private double depthKm;
    private String author;
    private String catalog;
    private String contributor;
    private String contributorID;
    private String magType;
    private double magnitude;
    private String magAuthor;
    private String eventLocationName;

    public EQEvent(String eventID, LocalDateTime time, double latitude, double longitude, double depthKm, String author, String catalog, String contributor, String contributorID, String magType, double magnitude, String magAuthor, String eventLocationName) {
        this.eventID = eventID;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.depthKm = depthKm;
        this.author = author;
        this.catalog = catalog;
        this.contributor = contributor;
        this.contributorID = contributorID;
        this.magType = magType;
        this.magnitude = magnitude;
        this.magAuthor = magAuthor;
        this.eventLocationName = eventLocationName;
    }

    public String getEventID() {
        return eventID;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getDepthKm() {
        return depthKm;
    }

    public String getAuthor() {
        return author;
    }

    public String getCatalog() {
        return catalog;
    }

    public String getContributor() {
        return contributor;
    }

    public String getContributorID() {
        return contributorID;
    }

    public String getMagType() {
        return magType;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getMagAuthor() {
        return magAuthor;
    }

    public String getEventLocationName() {
        return eventLocationName;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setDepthKm(double depthKm) {
        this.depthKm = depthKm;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public void setContributorID(String contributorID) {
        this.contributorID = contributorID;
    }

    public void setMagType(String magType) {
        this.magType = magType;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public void setMagAuthor(String magAuthor) {
        this.magAuthor = magAuthor;
    }

    public void setEventLocationName(String eventLocationName) {
        this.eventLocationName = eventLocationName;
    }

    @Override
    public int compareTo(EQEvent o) {
        return this.eventID.compareTo(o.eventID);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("EventID=").append(eventID).append("\n");
        sb.append("Time=").append(time).append("\n");
        sb.append("Latitude=").append(latitude).append("\n");
        sb.append("Longitude=").append(longitude).append("\n");
        sb.append("DepthKm=").append(depthKm).append("\n");
        sb.append("Author=").append(author).append("\n");
        sb.append("Catalog=").append(catalog).append("\n");
        sb.append("Contributor=").append(contributor).append("\n");
        sb.append("ContributorID=").append(contributorID).append("\n");
        sb.append("MagType=").append(magType).append("\n");
        sb.append("Magnitude=").append(magnitude).append("\n");
        sb.append("MagAuthor=").append(contributorID).append("\n");
        sb.append("EventLocationName=").append(eventLocationName).append("\n");
        sb.append("\n");
        return sb.toString();
    }
}