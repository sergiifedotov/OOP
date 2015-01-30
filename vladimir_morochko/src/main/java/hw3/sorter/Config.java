package hw3.sorter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by vladimir on 27.01.2015.
 *
 * Написать класс, который  должен  постоянно с заданной
 * частотой считывать и сортировать содержимое файла.
 * public void sort()
 *
 * Частота считывания задается в конфигурационном файле
 * conf.properties.
 * Для считывания конфигурационного файла создать отдельный
 * класс Config, который будет хранить конфигурационные параметры.
 * Класс Config создать по шаблону "Singleton".
 * В процессе работы сортировщика пользователь должен иметь
 * возможность менять алгоритм сортировки (по возрастанию, убыванию)
 *
 * Классы задания:
 * hw3.sorter.DynamicSorter
 * hw3.sorter.Config
 *
 * Класс теста:
 * hw3.sorter.DynamicSorterTest
 */

public class Config {

    private static Config instance;
    private Properties properties;
    private FileOutputStream fileOutputStream;
    private FileInputStream fileInputStream;
    private String propertiesFileName;

    private Config() {
        propertiesFileName = "vladimir_morochko/src/main/java/hw3/sorter/conf.properties";
        properties = new Properties();
        this.loadProperties();
    }

    public synchronized static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public void loadProperties() {
        try {
            fileInputStream = new FileInputStream(propertiesFileName);
            properties.loadFromXML(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveProperties() {
        try {
            fileOutputStream = new FileOutputStream(propertiesFileName);
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

    public Integer getSortInterval() {
        return Integer.parseInt(properties.getProperty("SortInterval"));
    }

    public void setSortInterval(Integer interval) {
        properties.setProperty("SortInterval", interval.toString());
    }

    public String getSortAlgorithm() {
        return properties.getProperty("SortAlgorithm");
    }

    public void setSortAlgorithm(String algorithm) {
        properties.setProperty("SortAlgorithm", algorithm);
    }

    public String getSortOrder() {
        return properties.getProperty("SortOrder");
    }

    public void setSortOrder(String order) {
        properties.setProperty("SortOrder", order);
    }


}
