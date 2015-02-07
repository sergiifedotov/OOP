package hw4.parallel;

import java.util.Scanner;

/*
 * - по существующему пути, 3х существующих файлов на разных уровнях (1,2,3)
 * - по существующему пути, несуществующего файла
 * - по несуществующему пути, несуществующего файла
 * - единственного существующего файла в единственном каталоге
  */

public class FileFinderTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Path to search");
        String path = scanner.next();
        System.out.println("Please enter a Filename");
        String fileName = scanner.next();
        FileFinder finder = new FileFinder();
        finder.parallelFind(path, fileName);
    }
}

/*

import java.io.IOException;

public class FileFinderTest {

    public static void main(String[] args) throws IOException{
        FileFinder ff = new FileFinder();
        // - по существующему пути, 3х существующих файлов на разных уровнях (1,2,3)
        ff.parallelFind("/home/tsv/", "README.txt");
        // - по существующему пути, несуществующего файла
        ff.parallelFind("/home/tsv/", "bashXX.xml");
        // - по несуществующему пути, несуществующего файла
        ff.parallelFind("/home/tsv/tmpBase/", "Some.key");
        // - единственного существующего файла в единственном каталоге
        ff.parallelFind("/home/tsv/apps/apache-maven-3.2.5/", "NOTICE");
    }

}

 */