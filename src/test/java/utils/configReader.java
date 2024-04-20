package utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    public static Properties prop;
    public static Properties readProperties(String Path) {
        try (FileInputStream fis = new FileInputStream(Path)) {
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error occurred while reading properties file: " + e.getMessage());
        }
        return prop;
    }

    public static String getPropertyValue(String key) {
        if (prop == null) {
            throw new IllegalStateException("Properties object is not initialized.");
        }
        return prop.getProperty(key);
    }
}
