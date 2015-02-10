package hw3.sorter;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

/**
 * Написать класс, который  должен  постоянно с заданной частотой считывать
 * и сортировать содержимое файла.
 * public void sort()
 * <p/>
 * Частота считывания задается в конфигурационном файле conf.properties.
 * Для считывания конфигурационного файла создать отдельный класс Config, который будет хранить конфигурационные параметры.
 * Класс Config создать по шаблону "Singleton".
 * В процессе работы сортировщика пользователь должен иметь возможность менять алгоритм сортировки (по возрастанию, убыванию)
 * <p/>
 * Классы задания:
 * DynamicSorter
 * Config
 * <p/>
 * Класс теста:
 * DynamicSorterTest
 */
public class DynamicSorter {
    private Thread thread1;

    public static void main(String[] args) throws IOException {
        new DynamicSorter().start("Tanya_Gensitskaya/src/main/java/hw3/sorter/hello");

    }


    public void start(String fileName) {
            thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    writeFileDesc(fileName);
                }
            });
            thread1.start();
    }


    private String readfile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            try (BufferedReader in = new BufferedReader(new FileReader(new File(fileName)))) {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }


    private void writeFileDesc(String fileName){
        String str = readfile(fileName);
        String[] strN = str.split("\\s+");
        Arrays.sort(strN, Collections.reverseOrder());
        String strSort = "";
        for (String i : strN) {
            strSort = strSort + i + " ";
        }
        File flt = new File(fileName);
        FileWriter fw = null;
        try {
            fw = new FileWriter(flt);
            fw.write(strSort);
            fw.flush();
        } catch (IOException e) {
            System.out.println("IOException");
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeFileAsc(String fileName) throws IOException {
        String str = readfile(fileName);
        String[] strN = str.split("\\s+");
        Arrays.sort(strN);
        String strSort = "";
        for (String aStrN : strN) {
            strSort = strSort + aStrN + " ";
        }
        File flt = new File(fileName);
        FileWriter fw = new FileWriter(flt);
        fw.write(strSort);
        fw.flush();
        fw.close();
    }


}
