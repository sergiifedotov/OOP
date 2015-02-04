package Home.hw4.parallel;

import java.io.IOException;

/**
 * Created by user on 02.02.2015.
 */
public class FileFinderTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Test1");
        String path1 = "D://test";
        String file1 = "textik.txt";
        FileFinder test1 = new FileFinder(path1, file1);

        Thread.sleep(1000);
        System.out.println("Test2");
        String path2 = "D://test";
        String file2 = "textikkkkkk.txt";
        FileFinder test2 = new FileFinder(path2, file2);

        Thread.sleep(1000);
        System.out.println("Test3");
        String path3 = "D://noFolder";
        String file3 = "textikkkkkk.txt";
        FileFinder test3 = new FileFinder(path3, file3);

        Thread.sleep(1000);
        System.out.println("Test4");
        String path4 = "D://oneFolder";
        String file4 = "oneFile.txt";
        FileFinder test4 = new FileFinder(path4, file4);

    }
}
