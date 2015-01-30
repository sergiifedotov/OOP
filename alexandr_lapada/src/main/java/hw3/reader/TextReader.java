package hw3.reader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * Created by sanya on 25.01.2015.
 */
public class TextReader {

    private boolean wait = false;
    public synchronized void setWait(boolean wait) {
        this.wait = wait;
    }

    public synchronized boolean getWait() {
        return wait;
    }

    public void read() throws FileNotFoundException, InterruptedException {
        File file = new File("generateRandomText.txt");
        Scanner in = new Scanner(file);
        while(in.hasNext()){
            if(getWait()) {
                System.out.println(in.nextLine());
                Thread.sleep(400);
            }
        }
    }
}
