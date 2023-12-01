package models;

import java.util.Objects;

public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    public String getStreet() { return street; }
    public void setStreet(String value) { this.street = value; }

    public String getSuite() { return suite; }
    public void setSuite(String value) { this.suite = value; }

    public String getCity() { return city; }
    public void setCity(String value) { this.city = value; }

    public String getZipcode() { return zipcode; }
    public void setZipcode(String value) { this.zipcode = value; }

    public Geo getGeo() { return geo; }
    public void setGeo(Geo value) { this.geo = value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) &&
                Objects.equals(suite, address.suite) &&
                Objects.equals(city, address.city) &&
                Objects.equals(zipcode, address.zipcode) &&
                Objects.equals(geo, address.geo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, suite, city, zipcode, geo);
    }
}
