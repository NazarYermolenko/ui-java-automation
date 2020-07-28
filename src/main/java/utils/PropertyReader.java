package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static final String PATH_TO_PROPERTY_FILE = "config.properties";

    public static String getProperty(String property) {
        Properties properties = new Properties();

        try (InputStream inputStream = new FileInputStream(PATH_TO_PROPERTY_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return properties.getProperty(property);
    }
}
