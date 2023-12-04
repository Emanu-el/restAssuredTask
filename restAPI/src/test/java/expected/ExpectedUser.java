package expected;

import com.google.gson.JsonObject;
import models.Address;
import models.Company;
import models.Geo;
import models.User;
import utilities.ReadJsonUtility;

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

    public User buildExpectedUser(String userKey) {
        User expectedUser = new User();
        Address expectedAddress = new Address();
        Geo expectedGeo = new Geo();
        Company expectedCompany = new Company();
        JsonObject userJsonObject = ReadJsonUtility.getJsonValue(userKey);

        JsonObject addressObject = userJsonObject.getAsJsonObject("address");
        JsonObject geoObject = addressObject.getAsJsonObject("geo");
        JsonObject companyObject = userJsonObject.getAsJsonObject("company");

        expectedGeo.setLat(geoObject.get("lat").getAsString());
        expectedGeo.setLng(geoObject.get("lng").getAsString());
        expectedAddress.setGeo(expectedGeo);

        expectedAddress.setStreet(addressObject.get("street").getAsString());
        expectedAddress.setSuite(addressObject.get("suite").getAsString());
        expectedAddress.setCity(addressObject.get("city").getAsString());
        expectedAddress.setZipcode(addressObject.get("zipcode").getAsString());
        expectedUser.setAddress(expectedAddress);

        expectedUser.setID(userJsonObject.get("id").getAsInt());
        expectedUser.setName(userJsonObject.get("name").getAsString());
        expectedUser.setUsername(userJsonObject.get("username").getAsString());
        expectedUser.setEmail(userJsonObject.get("email").getAsString());

        expectedUser.setPhone(userJsonObject.get("phone").getAsString());
        expectedUser.setWebsite(userJsonObject.get("website").getAsString());

        expectedCompany.setName(companyObject.get("name").getAsString());
        expectedCompany.setCatchPhrase(companyObject.get("catchPhrase").getAsString());
        expectedCompany.setBs(companyObject.get("bs").getAsString());
        expectedUser.setCompany(expectedCompany);

        return expectedUser;
    }
}
