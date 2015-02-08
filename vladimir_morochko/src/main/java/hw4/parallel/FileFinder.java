package hw4.parallel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Created by vladimir on 02.02.2015.
 * <p/>
 * Написать многопоточный поиск в файловой системе.
 * Пользователь вводит путь к папке и имя файла.
 * Вывести на экран те пути, где найден файл.
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
 * как вариант джойнить каждый вновь созданный поток в головном потоке
 */

public class FileFinder {
    public int finderCount = 0;
    LinkedList<String> results;

    public void parallelFind (String path, String fileName) {
        printArray(parallelFindString(path, fileName));
    }

    public static void printArray (String[] arrayToPrint) {
        for (int i = 0; i < arrayToPrint.length; i++) {
            System.out.println(arrayToPrint[i]);
        }
    }

    public String[] parallelFindString(String path, String fileName) {
        results = new LinkedList<>();
        Finder finder = new Finder();
        finder.find(path, fileName);

        do {
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (finderCount != 0);

        String[] arrayToReturn = new String[results.size()];
        for (int i = 0; i < arrayToReturn.length; i++) {
            arrayToReturn[i] = results.get(i);
        }
        return arrayToReturn;
    }

    private class Finder implements Runnable {
        private Thread thread;
        private String fileName;
        private String path;

        public Finder() {
            thread = new Thread(this);
        }

        public void find(String path, String fileName) {
            this.fileName = fileName;
            this.path = path;
            thread.start();
        }

        @Override
        public void run() {
            finderCount++;
            if (Files.exists(Paths.get(path))) {
                try {
                    Stream<Path> stream = Files.list(Paths.get(path));
                    Iterator<Path> iterator = stream.iterator();
                    while (iterator.hasNext()) {
                        Path currentPath = iterator.next();
                        if (Files.isDirectory(currentPath)) {
                            Finder finder = new Finder();
                            finder.find(currentPath.toString(), fileName);
                        } else if (currentPath.getFileName().toString().equals(fileName)) {
                            results.add(currentPath.toString());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            finderCount--;
        }
    }
}
