package com.hazex.tofiebackend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reports")
public class Report {

    @Id
    private String id;
    private String report;
    private String adId;
    public boolean closed;

    public Report()
    {

    }

    public Report(String id, String report, String adId, boolean closed) {
        this.id = id;
        this.report = report;
        this.adId = adId;
        this.closed = closed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id='" + id + '\'' +
                ", report='" + report + '\'' +
                ", adId='" + adId + '\'' +
                ", closed=" + closed +
                '}';
    }
}
