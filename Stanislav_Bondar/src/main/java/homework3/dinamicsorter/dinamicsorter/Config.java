package homework3.dinamicsorter.dinamicsorter;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Config  instance = null;
    private Properties props = null;

    public synchronized String getProperty(String key) {
        String value = null;
        if (props.containsKey(key))
            value = (String) props.get(key);
        else {
            System.out.println("indentified property");
        }
        return value;
    }


    private Config() throws IOException {
        props = new Properties();
        FileInputStream fis = new FileInputStream(new File("Stanislav_Bondar/src/main/java/hw3/sorter/conf.properties"));
        props.load(fis);

    }

    public synchronized static Config getInstance() throws IOException {
        if (instance == null)
            instance = new Config();
        return instance;
    }




    public static void main(String[] args) throws IOException {
        String fre = Config.getInstance().getProperty("FREQUENCY");
        long frequency = Long.parseLong(fre);
        System.out.println(frequency);
    }


}