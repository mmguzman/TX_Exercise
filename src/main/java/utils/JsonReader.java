package utils;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    private Logger log = Logger.getLogger(getClass());
    private JSONObject jsonObjectMain;

    public JsonReader(String filePath) {
        parseJSON(filePath);
    }

    /**
     * Parses the json file into a JSONObject
     * @param filePath
     */
    private void parseJSON (String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            jsonObjectMain = (JSONObject) jsonParser.parse(reader);
        } catch (FileNotFoundException ex) {
            log.error("FileNotFoundException when reading the configuration file ", ex);
        } catch (ParseException ex) {
            log.error("ParseException when reading the configuration file ", ex);
        }  catch (IOException ex) {
            log.error("IOException when reading the configuration file ", ex);
        } catch (NullPointerException ex) {
            log.error("NullPointerException when reading the configuration file ", ex);
        }
    }

    /**
     * Gets the string value given the key from an specific jsonObject
     * @param jsonObject
     * @param key
     * @return
     */
    private String getKeyValueFromJSONObject(JSONObject jsonObject, String key) {
        return (String) jsonObject.get(key);
    }

    /**
     * Gets the jsonObject value given the key from the main json object
     * @param key
     * @return
     */
    private JSONObject getJSONObject(String key) {
        return (JSONObject) jsonObjectMain.get(key);
    }

    /**
     * Gets a JsonObject from the main json and then gets a value given the key
     * @param objectName
     * @param key
     * @return
     */
    public String getKeyValue(String objectName, String key) {
        JSONObject jsonObject = getJSONObject(objectName);
        return getKeyValueFromJSONObject(jsonObject, key);
    }
}
