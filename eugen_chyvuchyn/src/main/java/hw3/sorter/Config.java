package hw3.sorter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Sergey Tsimbalyuk
 * on 26.02.15 // 1:14
 */
public class Config {
    private static Config instance;
    public int time;
    private String filePath = "conf.properties";
    private Config(String file){
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                time = new Integer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public  static  Config getInstance(String file){
        if (instance == null){instance = new Config(file);  }
        return instance;
    }

    public int getTime (){
        return time;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}