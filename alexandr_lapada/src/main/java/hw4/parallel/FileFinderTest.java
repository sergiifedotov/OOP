package hw4.parallel;

import java.io.File;
import java.util.Scanner;

/**
 Написать многопоточный поиск в файловой системе. Пользователь вводит путь к папке и имя файла. Вывести на экран те пути, где найден файл.
 В тестах проверить поиск:
 - по существующему пути, 3х существующих файлов на разных уровнях (1,2,3)
 - по существующему пути, несуществующего файла
 - по несуществующему пути, несуществующего файла
 - единственного существующего файла в единственном каталоге

 Класс задания:
 hw4.parallel.FileFinder

 Класс теста:
 hw4.parallel.FileFinderTest
 */
public class FileFinderTest {

    public static void main(String[] args) {
        FileFinder finder = new FileFinder();
        finder.start();
    }
}

