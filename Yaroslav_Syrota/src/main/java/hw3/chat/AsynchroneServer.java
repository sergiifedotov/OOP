package hw3.chat;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by @CAT_Caterpiller on 05.02.2015.
 */

public class AsynchroneServer {
    public static void main(String[] args) throws IOException {
        String[] listMessage = new String[10];


        JFrame frame = new JFrame("cheerful chat");
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel textIn = new JPanel();
        textIn.setLayout(new FlowLayout());
        textIn.setBackground(Color.ORANGE);
        textIn.setSize(790, 13);

        JTextField field = new JTextField(60);
        field.setFont(new Font("Calipso", Font.BOLD, 14));
        field.setForeground(Color.RED);

        JButton ok = new JButton("ok!");
        ok.setFont(new Font("Baltica", Font.BOLD, 18));
        ok.setBackground(Color.GREEN);
        ok.setForeground(Color.WHITE);
        // ok.addActionListener(new );


        textIn.add(field);
        textIn.add(ok);

        String local = "";
        try {
            local = InetAddress.getLocalHost().getHostAddress();
        } catch(UnknownHostException e) {
            System.out.println(e);
        }
        JPanel adress = new JPanel();
        adress.setLayout(new FlowLayout());
        adress.setBackground(Color.ORANGE);
        JLabel localHost = new JLabel(local);
        localHost.setFont(new Font("Tahoma", Font.BOLD, 25));
        adress.add(localHost);

        frame.add(textIn, BorderLayout.SOUTH);
        frame.add(adress, BorderLayout.NORTH);



        JPanel windows = new JPanel();
        windows.setLayout(new GridLayout());
        windows.setBackground(Color.CYAN);
        windows.setSize(800, 450);



        String[] m = new String[10];

        JList list = new JList(m);
        list.setSize(780, 430);
        list.setBackground(Color.WHITE);
        list.setFont(new Font("Tahoma", Font.ITALIC, 12));
        list.setForeground(Color.RED);
        list.add(new JLabel("test"));


        frame.add(windows, BorderLayout.CENTER);


        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            System.out.println(e);
        }
        frame.setState(JFrame.ICONIFIED);


        frame.setVisible(true);



        ServerSocket serverSocket = new ServerSocket(30000);
        Socket socket = serverSocket.accept();

        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        MessageReaderThread readerThread = new MessageReaderThread(bufferedReader);
        readerThread.setListener(new MessageReaderThread.Listener() {
            @Override
            public void newMessage(String message) {
                //System.out.println(message);
                list.add(new JLabel(message));
            }
        });
        readerThread.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            //System.out.println(bufferedReader.readLine());
            printWriter.println(scanner.nextLine());
            printWriter.flush();
        }


    }
}

class MessageReaderThread extends Thread {
    public interface Listener {
        void newMessage(String message);
    }
    private BufferedReader reader;
    private Listener listener;

    public MessageReaderThread(BufferedReader reader) {
        this.reader = reader;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        while (true) {
            String line;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                break;
            }
            if (listener != null) {
                listener.newMessage(line);
            }
        }
    }
}
