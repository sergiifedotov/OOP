package session5;

/**
 * Created by vladimir on 24.01.2015.
 *
 * Создать класс, от которого можно создать не более трех объектов.
 */
public class Tripleton {
    private static Tripleton instance;
    private static int count = 0;
    private final static int maxCount = 3;

    private Tripleton () {} // как вариант счетчик можно добавить сюда

    public synchronized static Tripleton getInstance() {
    // синхронизированный метод, чтобы только один поток мог зайти
        if (instance == null || count < maxCount) {
            instance = new Tripleton();
            count++;
        }
        // System.out.println(count);
        return instance;
    }

}
