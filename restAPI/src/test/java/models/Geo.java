package models;

import java.util.Objects;

public class Geo {
    private String lat;
    private String lng;

    public String getLat() { return lat; }
    public void setLat(String value) { this.lat = value; }

    public String getLng() { return lng; }
    public void setLng(String value) { this.lng = value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Geo geo = (Geo) o;
        return Objects.equals(lat, geo.lat) &&
                Objects.equals(lng, geo.lng);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lng);
    }
}
