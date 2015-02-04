package hw4.parallel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Created by vladimir on 02.02.2015.
 *
 * Написать многопоточный поиск в файловой системе.
 * Пользователь вводит путь к папке и имя файла.
 * Вывести на экран те пути, где найден файл.
 * В тестах проверить поиск:
 * - по существующему пути, 3х существующих файлов на разных уровнях (1,2,3)
 * - по существующему пути, несуществующего файла
 * - по несуществующему пути, несуществующего файла
 * - единственного существующего файла в единственном каталоге
 *
 * Класс задания:
 * hw4.parallel.FileFinder
 *
 * Класс теста:
 * hw4.parallel.FileFinderTest
 */

public class FileFinder {

    public void parallelFind(String path, String fileName) {
        Finder finder = new Finder();
        finder.find(path, fileName);
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
            try {
                Stream<Path> entries = Files.list(Paths.get(path));

                Iterator<Path> iterator = entries.iterator();
                while (iterator.hasNext()) {
                    Path currentPath = iterator.next();
                    if (Files.isDirectory(currentPath)) {
                        parallelFind(currentPath.toString(), fileName);
                    } else if (currentPath.getFileName().toString().equals(fileName)) {
                        System.out.println(currentPath);
                    }
                }
            } catch (NoSuchFileException e) {
                System.out.println("No such file!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
