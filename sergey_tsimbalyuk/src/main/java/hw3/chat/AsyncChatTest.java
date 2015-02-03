package hw3.chat;

import java.io.*;
import java.net.Socket;

/**
 * Created by Tsimbalyuk Sergey
 * 2/3/2015.
 */
public class AsyncChatTest {
    public static void main(String[] args) throws IOException {
        AsyncChat asyncChat = new AsyncChat();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Socket socket = new Socket("127.0.0.1", 30000);
    }
}