package models;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public int getID() { return id; }
    public void setID(int value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getUsername() { return username; }
    public void setUsername(String value) { this.username = value; }

    public String getEmail() { return email; }
    public void setEmail(String value) { this.email = value; }

    public Address getAddress() { return address; }
    public void setAddress(Address value) { this.address = value; }

    public String getPhone() { return phone; }
    public void setPhone(String value) { this.phone = value; }

    public String getWebsite() { return website; }
    public void setWebsite(String value) { this.website = value; }

    public Company getCompany() { return company; }
    public void setCompany(Company value) { this.company = value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(address, user.address) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(website, user.website) &&
                Objects.equals(company, user.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, email, address, phone, website, company);
    }
}
