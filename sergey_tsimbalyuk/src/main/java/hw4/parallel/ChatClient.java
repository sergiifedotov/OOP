package hw4.parallel;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


/**
 * Created by tsv on 05.02.15.
 */

// -- не получать сообщения от себя
// -- fileHandler ++ send / receive
public class ChatClient implements Runnable {

    private Socket clientSocket;
    private PrintWriter outputStream;
    private Scanner inputStream;
    private int port = 30100;
    private String name;

    public ChatClient() throws IOException {
        initialize();
    }

    private void initialize() throws IOException {
        // IP сервера
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введите IP сервера: ");
        String str = keyboard.next();
        // Имя
        System.out.println("Как вы хотите представиться?: ");
        name = keyboard.next();
        // подключение
        InetAddress host = null;
        try {
            host = InetAddress.getByName(str);
        } catch (UnknownHostException e1) {
            System.out.println("Удаленный узел не найден!");
        }
        System.out
                .println("Вы подключены к " + host.getHostAddress());

//        создаем новый сокет
//        setReuseAddress reuse clientSocket if/after(?) it's closed
        clientSocket = null;
        try {
            clientSocket = new Socket(host, port);
            clientSocket.setReuseAddress(true);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("not found");
        }
        inputStream = new Scanner(clientSocket.getInputStream());
        outputStream = new PrintWriter(clientSocket.getOutputStream());

        // новый поток, слушаем сервер
        Thread t = new Thread(this);
        t.start();

        // постоянно ждем ввода текста пользователем
        while (keyboard.hasNextLine()) {
            String msg = keyboard.nextLine();
            outputStream.println(name + ": " + msg);
            outputStream.flush();
        }
    }

    public static void main(String[] args) throws Exception {
        new ChatClient();
    }

    @Override
    public void run() {
        while (true) {
            if (inputStream.hasNextLine())
                System.out.println(inputStream.nextLine());
        }
    }
}