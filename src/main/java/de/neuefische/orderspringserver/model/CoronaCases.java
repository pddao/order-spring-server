package de.neuefische.orderspringserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class CoronaCases {
@JsonProperty ("Country")
    private String country;
@JsonProperty ("Confirmed")
    private String confirmed;
@JsonProperty ("Date")
    private String date;

    public CoronaCases() {
    }

    public CoronaCases(String country, String confirmed, String date) {
        this.country = country;
        this.confirmed = confirmed;
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoronaCases that = (CoronaCases) o;
        return Objects.equals(country, that.country) && Objects.equals(confirmed, that.confirmed) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, confirmed, date);
    }

    @Override
    public String toString() {
        return "CoronaCases{" +
                "country='" + country + '\'' +
                ", cases='" + confirmed + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
