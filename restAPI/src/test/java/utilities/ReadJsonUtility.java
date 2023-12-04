package utilities;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJsonUtility {

    private static final String jsonFilePath = "src/test/resources/testData.json";

    public static int getIntValue(String key) {
        JsonObject jsonObject = getJsonObject();
        return jsonObject.get(key).getAsInt();
    }

    public static String getStringValue(String key) {
        JsonObject jsonObject = getJsonObject();
        return jsonObject.get(key).getAsString();
    }

    public static JsonObject getJsonValue(String key){
        JsonObject jsonObject = getJsonObject();
        return jsonObject.get(key).getAsJsonObject();
    }

    private static JsonObject getJsonObject() {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            return new Gson().fromJson(jsonContent, JsonObject.class);
        } catch (Exception e) {
            throw new RuntimeException("Error reading JSON file", e);
        }
    }

}
