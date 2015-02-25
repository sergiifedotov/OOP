package session7;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel sch = ServerSocketChannel.open();
        sch.socket().bind(new InetSocketAddress(30000));

        while (true) {
            SocketChannel cch;
            try {
                cch = sch.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}