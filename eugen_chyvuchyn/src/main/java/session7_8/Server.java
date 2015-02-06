package session7_8;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

    public class Server {
        public static void main(String[] args) throws IOException {
            Scanner scan = new Scanner(System.in);
            ServerSocket ss = new ServerSocket(30000);

            Socket cs = ss.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));

            String strInput = "";
            String strOutput = "";

            final BufferedReader finalIn = br;

            while (!strOutput.equals("exit")){

                new Thread(() -> {
                    while (true) {
                        try {
                            System.out.println(finalIn.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                strOutput = scan.nextLine();
                pw.println(strOutput);
                pw.flush();
            }

        }
    }

