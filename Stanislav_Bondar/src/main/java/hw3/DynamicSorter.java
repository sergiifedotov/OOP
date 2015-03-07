package hw3;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

/**
 Created by stan on 17.02.15.
 */
public class DynamicSorter {
    private Thread thread;

    public static void main(String[] args) throws IOException {
        new DynamicSorter().sort();

    }

    public void sort() {
        String fileName = "Stanislav_Bondar/src/main/java/hw3/sorter/adf";
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    writeFileDesc(fileName);
                    try {
                        try {
                            Thread.sleep(Long.parseLong(Config.getInstance().getProperty("FREQUENCY")));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("sorting");
                }
            }
        });
        thread.start();
    }


    private String readfile(String fileName) {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(new File(fileName)));
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }


    private void writeFileDesc(String fileName) {
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
        } finally {
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
