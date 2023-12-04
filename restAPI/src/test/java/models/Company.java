package models;

import java.util.Objects;

public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getCatchPhrase() { return catchPhrase; }
    public void setCatchPhrase(String value) { this.catchPhrase = value; }

    public String getBs() { return bs; }
    public void setBs(String value) { this.bs = value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) &&
                Objects.equals(catchPhrase, company.catchPhrase) &&
                Objects.equals(bs, company.bs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, catchPhrase, bs);
    }
}
