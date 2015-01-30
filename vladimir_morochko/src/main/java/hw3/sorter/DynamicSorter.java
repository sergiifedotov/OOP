package hw3.sorter;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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

public class DynamicSorter extends Application  { //extends Application

//    public static void main(String[] args) {
//        DynamicSorter dynamicSorter = new DynamicSorter();
//        dynamicSorter.loadDataFromFile(dynamicSorter.fileName);
//        dynamicSorter.printArray(dynamicSorter.sortedArray);
//        System.out.println();
//        dynamicSorter.strategy.sort();
//        dynamicSorter.printArray(dynamicSorter.sortedArray);
//        System.out.println();
//        //dynamicSorter.saveDataToFile(dynamicSorter.fileName);
//        System.out.println(dynamicSorter.config.getSortAlgorithm());
//        System.out.println(dynamicSorter.strategy.getSortInterval());
//        System.out.println(dynamicSorter.strategy.isSortOrder());
//        dynamicSorter.sortingThread.start();
//
//    }

    private String fileName = "vladimir_morochko/src/main/java/hw3/sorter/Lorem.txt";
    private String[] sortedArray;
    private Config config = Config.getInstance();
    private Strategy strategy = new Strategy(config);

    private SortingThread sortingThread;

    public void run() {
        launch();
    }


    private void loadDataFromFile(String fileName) {
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream;
        try {
            fileInputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bufferedInputStream = new BufferedInputStream(fileInputStream);
        Scanner scanFile= new Scanner(bufferedInputStream);

        List<String> fileContents = new LinkedList<>();
        while (scanFile.hasNextLine()) {
            fileContents.add(scanFile.nextLine());
        }
        scanFile.close();

        sortedArray = new String[fileContents.size()];
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = fileContents.get(i);
        }
    }

    private void saveDataToFile(String fileName) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bufferedWriter;
        bufferedWriter = new BufferedWriter(fileWriter);

        try {
            for (int i = 0; i < sortedArray.length; i++) {
                bufferedWriter.write(sortedArray[i] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void printArray(String[] sortedArray) {
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }
    }

    private class SortingThread implements Runnable {
        private Thread thread;

        public SortingThread() {
            thread = new Thread(this);
        }

        public void start() {
            System.out.println("SortingThread start");
            thread.start();
        }

        public void interrupt() {
            System.out.println("SortingThread interrupt");
            thread.interrupt();
        }

        public void join() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("SortingThread join");
        }

        @Override
        public void run() {
            while (!thread.isInterrupted()) {
                System.out.println("SortingThread run");
                strategy.initialize(Config.getInstance());
                loadDataFromFile(fileName);
                strategy.sort();
                saveDataToFile(fileName);

                System.out.println(config.getSortAlgorithm());
                System.out.println(strategy.getSortInterval());
                System.out.println(strategy.isSortOrder());
                try {
                    thread.sleep(strategy.getSortInterval());
                } catch (InterruptedException e) {
                    thread.interrupt();
                }
            }
        }
    }

    private class Strategy {
        private SortAlgorithm sortAlgorithm;
        private boolean sortOrder = true; // default value
        private Integer sortInterval = 10000; // default value

        private Strategy() {}

        public Strategy(Config config) {
            this();
            this.initialize(config);
        }

        public void initialize(Config config) {
            String currentSortAlgorithm = config.getSortAlgorithm();
            if (currentSortAlgorithm.equals("Bubble")){
                this.sortAlgorithm = new Bubble();
            } else if (currentSortAlgorithm.equals("Shell")){
                this.sortAlgorithm = new Shell();
            } else if (currentSortAlgorithm.equals("Insert")){
                this.sortAlgorithm = new Insert();
            } else if (currentSortAlgorithm.equals("Quick")){
                this.sortAlgorithm = new Quick();
            } else if (currentSortAlgorithm.equals("Select")){
                this.sortAlgorithm = new Select();
            } else {
                this.sortAlgorithm = new Bubble(); // default value
            }

            String currentSortOrder = config.getSortOrder();
            if (currentSortOrder.equals("Ascending")){
                this.sortOrder = true;
            } else if (currentSortOrder.equals("Descending")){
                this.sortOrder = false;
            }
//            else {
//                this.sortOrder = true; // default value
//            }

            sortInterval = config.getSortInterval();
        }

        public void sort() {
            sortAlgorithm.sort(sortedArray, sortOrder);
        }

        public boolean isSortOrder() {
            return sortOrder;
        }

        public void setSortOrder(boolean sortOrder) {
            this.sortOrder = sortOrder;
        }

        public SortAlgorithm getSortAlgorithm() {
            return sortAlgorithm;
        }

        public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
            this.sortAlgorithm = sortAlgorithm;
        }

        public Integer getSortInterval() {
            return sortInterval;
        }

        public void setSortInterval(Integer sortInterval) {
            this.sortInterval = sortInterval;
        }
    }

    private interface SortAlgorithm {
        public void sort(String[] sortedArray, boolean sortOrder);
    }

    private class Bubble implements SortAlgorithm {
        @Override
        public void sort(String[] sortedArray, boolean sortOrder) {
            boolean sortNeeded = true;
            while (sortNeeded) {
                sortNeeded = false;
                for (int i = 0; i < sortedArray.length - 1; i++) {
                    if (sortOrder ?
                            sortedArray[i].compareTo(sortedArray[i + 1]) > 0
                            :
                            sortedArray[i].compareTo(sortedArray[i + 1]) < 0)
                    {
                        String temp = sortedArray[i];
                        sortedArray[i] = sortedArray[i + 1];
                        sortedArray[i + 1] = temp;
                        sortNeeded = true;
                    }
                }
            }
        }
    }

    private class Shell implements SortAlgorithm {
        @Override
        public void sort(String[] sortedArray, boolean sortOrder) {
            for (int step = sortedArray.length / 2; step > 0; step /= 2) {
                for (int i = 0; i < sortedArray.length - step; i++) {
                    int j = i;
                    while (j >= 0 && sortOrder ?
                            sortedArray[j].compareTo(sortedArray[j + step]) > 0
                            :
                            sortedArray[j].compareTo(sortedArray[j + step]) < 0)
                    {
                        String temp = sortedArray[j];
                        sortedArray[j] = sortedArray[j + step];
                        sortedArray[j + step] = temp;
                        j--;
                    }
                }
            }
        }
    }

    private class Quick implements SortAlgorithm {
        @Override
        public void sort(String[] sortedArray, boolean sortOrder) {
            quickSort(sortedArray, 0, sortedArray.length - 1);
        }
    }

    private void quickSort(String[] sortedArray, int left, int right) {
        int l = left;
        int r = right;
        int pivotIndex = (left + right) / 2;
        String pivot = sortedArray[pivotIndex];
        while (l <= r) {
            while (strategy.isSortOrder() ?
                    sortedArray[l].compareTo(pivot) < 0
                    :
                    sortedArray[l].compareTo(pivot) > 0)
            {
                l++;
            }

            while (strategy.isSortOrder() ?
                    sortedArray[l].compareTo(pivot) < 0
                    :
                    sortedArray[l].compareTo(pivot) > 0)
            {
                r--;
            }
            if (l <= r) {
                swap(sortedArray, l++, r--);
            }
        }
        if (left < r) {
            quickSort(sortedArray, left, r);
        }
        if (l < right) {
            quickSort(sortedArray, l, right);
        }
    }

    private void swap(String[] sortedArray, int l, int r) {
        String tmp = sortedArray[l];
        sortedArray[l] = sortedArray[r];
        sortedArray[r] = tmp;
    }


    private class Insert implements SortAlgorithm {
        @Override
        public void sort(String[] sortedArray, boolean sortOrder) {
            for (int i = 1; i < sortedArray.length; i++) {
                if (sortOrder ?
                        sortedArray[i].compareTo(sortedArray[i - 1]) < 0
                        :
                        sortedArray[i].compareTo(sortedArray[i - 1]) > 0)
                {
                    int j = i;
                    while (j > 0 && sortOrder ?
                            sortedArray[j].compareTo(sortedArray[j - 1]) < 0
                            :
                            sortedArray[j].compareTo(sortedArray[j - 1]) > 0)
                    {
                        String temp = sortedArray[j];
                        sortedArray[j] = sortedArray[--j];
                        sortedArray[j] = temp;
                    }
                }
            }
        }
    }

    private class Select implements SortAlgorithm {
        @Override
        public void sort(String[] sortedArray, boolean sortOrder) {
            for (int i = 0; i < sortedArray.length; i++) {
                int minPos = i;
                for (int j = i; j < sortedArray.length; j++) {
                    if (sortOrder ?
                            sortedArray[j].compareTo(sortedArray[minPos]) < 0
                            :
                            sortedArray[j].compareTo(sortedArray[minPos]) > 0)
                    {
                        minPos = j;
                    }
                }
                String temp = sortedArray[i];
                sortedArray[i] = sortedArray[minPos];
                sortedArray[minPos] = temp;
            }
        }
    }

    @Override
    public void start(Stage stage) throws Exception {

        Button btnStart = new Button("Start");
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                sortingThread = new SortingThread();
                sortingThread.start();
            }
        });
        btnStart.setMinWidth(100);

        Button btnStop = new Button("Stop");
        btnStop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                sortingThread.interrupt();
                sortingThread.join();
            }
        });
        btnStop.setMinWidth(100);

        ComboBox<String> sortAlgorithmComboBox = new ComboBox<>();
        sortAlgorithmComboBox.getItems().addAll(
                "Bubble",
                "Shell",
                "Insert",
                "Quick",
                "Select"
        );
        sortAlgorithmComboBox.setValue("Bubble");
        sortAlgorithmComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                config.setSortAlgorithm(t1);
            }
        });

        ComboBox<String> sortOrderComboBox = new ComboBox<>();
        sortOrderComboBox.getItems().addAll(
                "Ascending",
                "Descending"
        );
        sortOrderComboBox.setValue("Ascending");
        sortOrderComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                config.setSortOrder(t1);
            }
        });


        GridPane grid = new GridPane();
        grid.add(btnStart, 0, 0);
        grid.add(btnStop, 0, 1);
        grid.add(sortAlgorithmComboBox, 0, 2);
        grid.add(sortOrderComboBox, 0, 3);
        Scene scene = new Scene(grid, 600, 400);
        stage.setScene(scene);
        stage.show();
// TODO something wrong with the reverse sort order
    }

}
