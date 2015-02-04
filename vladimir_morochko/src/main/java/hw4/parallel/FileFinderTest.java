package hw4.parallel;

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

public class FileFinderTest {
    public static void main(String[] args) {
        FileFinder fileFinder = new FileFinder();
        // по существующему пути, 3х существующих файлов на разных уровнях (1,2,3)
        fileFinder.parallelFind("C:\\Program Files\\Java\\sqldeveloper\\ide\\bin", "jdk.conf");
        fileFinder.parallelFind("C:\\Program Files\\Java\\sqldeveloper\\ide", "jdk.conf");
        fileFinder.parallelFind("C:\\Program Files\\Java\\sqldeveloper", "jdk.conf");

        // по существующему пути, несуществующего файла
        fileFinder.parallelFind("C:\\Program Files\\Java\\sqldeveloper\\ide\\bin", "qwerty.asdf");

        // по несуществующему пути, несуществующего файла
        fileFinder.parallelFind("C:\\Program Files\\Java\\sqldeveloper\\ide\\zxcvbn", "qwerty.asdf");

        // единственного существующего файла в единственном каталоге
        fileFinder.parallelFind("C:\\Program Files\\Java\\sqldeveloper\\sqlj\\lib", "runtime12.jar");

    }
}
