package expected;

import models.Address;
import models.Company;
import models.Geo;
import models.User;

public class ExpectedUser {

    public User getExpectedUser(){
        User expectedUser = new User();
        Address expectedAddress = new Address();
        Geo expectedGeo = new Geo();

        expectedGeo.setLat("-31.8129");
        expectedGeo.setLng("62.5342");

        expectedAddress.setStreet("Skiles Walks");
        expectedAddress.setSuite("Suite 351");
        expectedAddress.setCity("Roscoeview");
        expectedAddress.setZipcode("33263");
        expectedAddress.setGeo(expectedGeo);

        expectedUser.setID(5);
        expectedUser.setName("Chelsey Dietrich");
        expectedUser.setUsername("Kamren");
        expectedUser.setEmail("Lucio_Hettinger@annie.ca");
        expectedUser.setAddress(expectedAddress);

        expectedUser.setPhone("(254)954-1289");
        expectedUser.setWebsite("demarco.info");

        Company expectedCompany = new Company();
        expectedCompany.setName("Keebler LLC");
        expectedCompany.setCatchPhrase("User-centric fault-tolerant solution");
        expectedCompany.setBs("revolutionize end-to-end systems");

        expectedUser.setCompany(expectedCompany);

        return expectedUser;
    }
}
