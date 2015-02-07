package hw3.chat;



import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by CAT_Caterpiller on 03.02.2015.
 */

public class AsyncChat {
    public static void main(String args[]) throws InterruptedException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


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

        // frame.setFont(new Font("Tahoma", Font.BOLD, 30));

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


        frame.add(windows, BorderLayout.CENTER);


        /*try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            System.out.println(e);
        }
        frame.setState(JFrame.ICONIFIED);*/


        frame.setVisible(true);



/*
        class ButtonActionListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                String textMessage = field.getText();
                System.out.println(textMessage);
            }

        }



*/

        ServerSocket serverSocket = new ServerSocket(30000);
        Socket socket = serverSocket.accept();

        PrintWriter serverWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner serverScanner = new Scanner(System.in);


    }



}
