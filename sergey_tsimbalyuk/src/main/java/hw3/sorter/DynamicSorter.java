package hw3.sorter;

interface SortStrategy {
    public void sort();
}

/**
 * Created by Sergey Tsimbalyuk
 * on 24.02.15 // 11:12
 *
 * Написать класс, который  должен  постоянно с заданной частотой считывать
 * и сортировать содержимое файла.
 * public void sort()
 *
 * Частота считывания задается в конфигурационном файле conf.properties.
 * Для считывания конфигурационного файла создать отдельный класс Config,
 * который будет хранить конфигурационные параметры.
 * Класс Config создать по шаблону "Singleton".
 * В процессе работы сортировщика пользователь должен иметь возможность менять
 * алгоритм сортировки (по возрастанию, убыванию)
 *
 * Классы задания:
 * hw3.sorter.DynamicSorter
 * hw3.sorter.Config
 *
 * Класс теста:
 * hw3.sorter.DynamicSorterTest
 *
 */
public class DynamicSorter {

    private String filePath = "gpl-3.0.txt";
    private SortStrategy strategy = new IncreasingSorting();
    private Config config = Config.getInstance(filePath);

    public void setStrategy(SortStrategy strategy){this.strategy = strategy;}

    public void sort(){
        strategy.sort();
    }

}

class SortThread extends Thread {
    private DynamicSorter dynamicSorter = new DynamicSorter();

    @Override
    public void run(){
        while (true) {
            dynamicSorter.setStrategy(new IncreasingSorting());
            dynamicSorter.sort();
        }
    }
}

class IncreasingSorting implements  SortStrategy { //возрастание
    @Override
    public void sort(){
            }
}
class DecreasingSorting implements SortStrategy { //убывание
    @Override
    public void sort(){
    }
}