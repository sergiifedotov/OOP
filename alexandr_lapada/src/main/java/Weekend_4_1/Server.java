package Weekend_4_1;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * Created by sanya on 31.01.2015.
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(30000);
            while (true) {
                Scanner in = new Scanner(System.in);
                String strIn = "";
                String strOut = "";
                Socket s = ss.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
                strIn = br.readLine();
                System.out.println(strIn);
                if (!strIn.equals("")) {
                    strOut = in.next();
                    pw.println(strOut);
                    pw.flush();
                }
            }
            }catch(IOException e) {
            e.printStackTrace();
        }
        }

    }

