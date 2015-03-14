package hw4.parallel;

import java.util.Scanner;

/*
 Created by stan on 13.02.20.
  */

public class FileFinderTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter way");
        String path = scanner.next();
        System.out.println("Please set the name of the searchable file");
        String fileName = scanner.next();
        FileFinder finder = new FileFinder();
        finder.parallelFind(path, fileName);
    }
}
