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

    public static void printArray (String[] arrayToPrint) {
        for (int i = 0; i < arrayToPrint.length; i++) {
            System.out.println(arrayToPrint[i]);
        }
    }

    public static void main(String[] args) {
        FileFinder fileFinder = new FileFinder();
        // по существующему пути, 3х существующих файлов на разных уровнях (1,2,3)

        boolean actual;
        boolean expected;
        String[] testArray;

        System.out.println("по существующему пути, 3х существующих файлов на разных уровнях (1,2,3)");
        System.out.println(1);
        actual = fileFinder.parallelFindString("C:\\Program Files\\Java\\sqldeveloper\\ide\\bin", "jdk.conf").length > 0;
        expected = true;
        if (actual == expected) {System.out.println("test passed");}
        else {System.out.println("test failed");}

        System.out.println(2);
        actual = fileFinder.parallelFindString("C:\\Program Files\\Java\\sqldeveloper\\ide", "jdk.conf").length > 0;
        expected = true;
        if (actual == expected) {System.out.println("test passed");}
        else {System.out.println("test failed");}

        System.out.println(3);
        actual = fileFinder.parallelFindString("C:\\Program Files\\Java\\sqldeveloper", "jdk.conf").length > 0;
        expected = true;
        if (actual == expected) {System.out.println("test passed");}
        else {System.out.println("test failed");}
        System.out.println();

        // по существующему пути, несуществующего файла
        System.out.println("по существующему пути, несуществующего файла");
        actual = fileFinder.parallelFindString("C:\\Program Files\\Java\\sqldeveloper\\ide\\bin", "qwerty.asdf").length == 0;
        expected = true;
        if (actual == expected) {System.out.println("test passed");}
        else {System.out.println("test failed");}
        System.out.println();

        // по несуществующему пути, несуществующего файла
        System.out.println("по несуществующему пути, несуществующего файла");
        actual = fileFinder.parallelFindString("C:\\Program Files\\Java\\sqldeveloper\\ide\\zxcvbn", "qwerty.asdf").length == 0;
        expected = true;
        if (actual == expected) {System.out.println("test passed");}
        else {System.out.println("test failed");}
        System.out.println();

        // единственного существующего файла в единственном каталоге
        System.out.println("единственного существующего файла в единственном каталоге");
        actual = fileFinder.parallelFindString("C:\\Program Files\\Java\\sqldeveloper\\sqlj\\lib", "runtime12.jar").length > 0;
        expected = true;
        if (actual == expected) {System.out.println("test passed");}
        else {System.out.println("test failed");}
        System.out.println();

    }
}
