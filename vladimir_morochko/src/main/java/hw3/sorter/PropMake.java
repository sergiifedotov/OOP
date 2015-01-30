package hw3.sorter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by vladimir on 29.01.2015.
 */
public class PropMake {

    public static void main(String[] args) {
        PropMake propMake = new PropMake();
        propMake.makeProperties();
    }

    private Properties properties;
    private FileOutputStream fileOutputStream;
    private String propertiesFileName;

    public PropMake() {
        propertiesFileName = "vladimir_morochko/src/main/java/hw3/sorter/conf.properties";
        properties = new Properties();
    }

    public void makeProperties() {
        try {
            fileOutputStream = new FileOutputStream(propertiesFileName);
            properties.setProperty("SortInterval", "10000");
            properties.setProperty("SortAlgorithm", "Bubble");
            properties.setProperty("SortOrder", "Ascending");

            properties.storeToXML(fileOutputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
