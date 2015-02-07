package hw4.parallel;

import java.io.*;
import java.net.Socket;


/**
 * Created by tsv on 05.02.15.
 */
public class fileHandler {

    public void send(Socket socket,
                     String filepath) throws IOException {

        File myFile = new File(filepath);
        byte[] bytes = new byte[(int) myFile.length()];
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
        bis.read(bytes, 0, bytes.length);
        OutputStream os = socket.getOutputStream();
        os.write(bytes, 0, bytes.length);
        os.flush();
    }

    public void receive(Socket socket,
                        String filepath) throws IOException {

        byte[] bytes = new byte[1024];
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(filepath);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int bytesRead = is.read(bytes, 0, bytes.length);
        bos.write(bytes, 0, bytesRead);
        bos.close();
    }
}