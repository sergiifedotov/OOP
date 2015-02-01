package session7;

import java.io.*;
import java.net.Socket;

/**
 * Created by vladimir on 31.01.2015.
 *
 * Подключиться к серверу, отправить ему сообщение,
 * получить от него ответ и вывести на экран.
 * адрес 192.168.1.143 порт 30000
 */
public class SocketDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.143", 30000);
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printWriter.println("Hello");
        printWriter.flush();

        System.out.println(bufferedReader.readLine());
    }
}
