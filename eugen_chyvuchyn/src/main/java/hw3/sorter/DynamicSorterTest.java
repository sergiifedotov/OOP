package hw3.sorter;

/**
 * Created by Sergey Tsimbalyuk
 * on 26.02.15 // 1:14
 */
public class DynamicSorterTest {

    public static void main(String[] args) {
        SortThread sT = new SortThread();
        sT.start();
        sT.run();
    }
}
