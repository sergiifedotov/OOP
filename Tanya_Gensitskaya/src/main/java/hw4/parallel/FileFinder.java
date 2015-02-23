package hw4.parallel;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 Написать многопоточный поиск в файловой системе. Пользователь вводит путь
 к папке и имя файла. Вывести на экран те пути, где найден файл.
 В тестах проверить поиск:
 - по существующему пути, 3х существующих файлов на разных уровнях (1,2,3)
 - по существующему пути, несуществующего файла
 - по несуществующему пути, несуществующего файла
 - единственного существующего файла в единственном каталоге

 //        Класс задания:
 //        hw4.parallel.FileFinder
 //
 //        Класс теста:
 //        hw4.parallel.FileFinderTest
 //        import java.io.File;
 */




public class FileFinder {
//    public String[] parallelFind(File path, String fileName) {
//        // TODO implements
//        return null;
//    }
private static final ConcurrentSkipListSet<Path> result = new ConcurrentSkipListSet<>();

    public static class SearchThread implements Runnable {
        private String path;
        private String fileNamePattern;

        public SearchThread(String path, String fileNamePattern) {
            this.path = path;
            this.fileNamePattern = fileNamePattern;
        }

        @Override
        public void run() {
            Finder finder = new Finder(fileNamePattern);
            try {

                Files.walkFileTree(Paths.get(path), finder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Finder extends SimpleFileVisitor<Path> {

        private final PathMatcher matcher;

        Finder(String pattern) {
            matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
        }

        // Compares the glob pattern against
        // the file or directory name.
        void find(Path file) {
            Path name = file.getFileName();
            if (name != null && matcher.matches(name)) {
                result.add(file);
                System.out.println(file);
            }
        }

        // Invoke the pattern matching
        // method on each file.
        @Override
        public FileVisitResult visitFile(Path file,
                                         BasicFileAttributes attrs) {
            find(file);
            return CONTINUE;
        }

        // Invoke the pattern matching
        // method on each directory.
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            find(dir);
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            exc.printStackTrace();
            return CONTINUE;
        }
    }

    static void parallelFind() {
        for (Path s : result) {
            System.out.println(s.toString());
        }
    }

    public static void main(String[] args) throws IOException {

        String basePath = "f:/";
        String fineName = "t.txt";
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + fineName);

        List<String> directoryName = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(basePath))) {
            for (Path path : directoryStream) {
                if (Files.isDirectory(path)) {
                    directoryName.add(path.toString());
                } else if (matcher.matches(path.getFileName())) {
                    result.add(path);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (String s : directoryName) {
            Runnable worker = new SearchThread(s, fineName);
            executor.execute(worker);
        }
        executor.shutdown();
        while (executor.isTerminated()){
        }
        System.out.println("Finished all threads");
        parallelFind();
    }
}