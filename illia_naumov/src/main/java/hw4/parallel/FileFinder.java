package hw4.parallel;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * Created by illia_naumov
 * <p/>
 * Написать многопоточный поиск в файловой системе. Пользователь вводит путь к папке и имя файла.
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
 */
public class FileFinder {
    BufferedReader br;
    String path;
    String filename;

    public FileFinder(String path, String filename) throws IOException {
        this.path = path;
        this.filename = filename;
        //br = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println("Please, type path to folder");
        //path = br.readLine();
        //System.out.println("Type the name of the searching file");
        //filename = br.readLine();
        new Searcher(path, filename);

    }
}

class Searcher implements Runnable {
    Thread t;
    String path;
    String filename;

    public Searcher(String pathname, String filename) {
        path = pathname;
        this.filename = filename;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        try {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isDirectory()) {
                    new Searcher(listOfFiles[i].getPath(), filename);
                } else if (listOfFiles[i].isFile() & listOfFiles[i].getName().equals(filename)) {
                    System.out.println("The path of the searched pass " + listOfFiles[i].getPath());
                }
            }
        } catch (NullPointerException e) {
            System.out.println("No files exist with this name");
        }

    }
}
