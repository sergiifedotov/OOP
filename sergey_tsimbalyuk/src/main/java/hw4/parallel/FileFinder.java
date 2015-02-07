package hw4.parallel;

import java.io.File;

/**
 * Created by Tsimbalyuk Sergey
 * 2/3/2015.
 * <p/>
 * Написать многопоточный поиск в файловой системе.
 * Пользователь вводит путь к папке и имя файла. Вывести на экран те пути, где найден файл.
 * В тестах проверить поиск:
 * - по существующему пути, 3х существующих файлов на разных уровнях (1,2,3)
 * - по существующему пути, несуществующего файла
 * - по несуществующему пути, несуществующего файла
 * - единственного существующего файла в единственном каталоге
 * <p/>
 * Класс задания:
 * hw4.parallel.FileFinder
 * <p/>
 * Класс теста:
 * hw4.parallel.FileFinderTest
 */
public class FileFinder implements Runnable {
    private String path = null;
    private String fileName = null;

    public FileFinder() {}

    private FileFinder(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
    }

    public void parallelFind(String path, String fileName) {
        Thread thread = new Thread(new FileFinder(path, fileName));
        thread.start();
    }

    @Override
    public void run() {
        File startPath = new File(path);
        if (startPath.isDirectory()) {
            for (File file : startPath.listFiles()) {
                if (file.isDirectory()) {
                    Thread thread = new Thread(new FileFinder(file.getAbsolutePath(), fileName));
                    thread.start();
                } else if (file.getName().equals(fileName)){
                    System.out.println(file.getAbsolutePath());
                }
            }
        }

    }
}