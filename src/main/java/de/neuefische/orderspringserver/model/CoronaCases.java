package de.neuefische.orderspringserver.model;

import java.util.Objects;

public class CoronaCases {

    private String country;
    private String cases;
    private String date;

    public CoronaCases(String country, String cases, String date) {
        this.country = country;
        this.cases = cases;
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
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
        return Objects.equals(country, that.country) && Objects.equals(cases, that.cases) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, cases, date);
    }

    @Override
    public String toString() {
        return "CoronaCases{" +
                "country='" + country + '\'' +
                ", cases='" + cases + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
