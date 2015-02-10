package hw3.sorter;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Config  instance = null;
    private Properties props = null;


    private Config() throws IOException {
        props = new Properties();
        FileInputStream fis = new FileInputStream(new File("Tanya_Gensitskaya/src/main/java/hw3/sorter/conf.properties"));
        props.load(fis);

    }

    public synchronized static Config getInstance() throws IOException {
        if (instance == null)
            instance = new Config();
        return instance;
    }

    // получить значение свойства по имени
    public synchronized String getProperty(String key) {
        String value = null;
        if (props.containsKey(key))
            value = (String) props.get(key);
        else {
            System.out.println("свойство не найдено");
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        String fre = Config.getInstance().getProperty("SOME_INT_FREQUENCY");
        System.out.println(fre);
    }


}