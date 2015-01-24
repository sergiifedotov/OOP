package hw2.frequency;
import java.util.Comparator;

public class WordSorted implements Comparator<Words> {
    private boolean flag; // true по возрастанию false по убыванию

    public WordSorted() {
    }

    public WordSorted(boolean in) {
        this.flag = in;
    }

    public int compare(Words obj1, Words obj2) {
        int rez;
        Integer frequency1 = obj1.getFrequency();
        Integer frequency2 = obj2.getFrequency();
        if (flag) {
            if (frequency1 > frequency2) {
                rez = 1;
            } else if (frequency1 < frequency2) {
                rez = -1;
            } else {
                rez = 0;
            }
        } else {
            if (frequency1 < frequency2) {
                rez = 1;
            } else if (frequency1 > frequency2) {
                rez = -1;
            } else {
                rez = 0;
            }
        }
        return rez;
    }

}
