package session7;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by warit on 24.02.2015.
 */
public class Task1 {

    public static void main(String[] args) throws IOException {
        SocketChannel sock = null;
        try {
            sock = SocketChannel.open();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            sock.connect(new InetSocketAddress("127.0.0.1",30000));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ByteBuffer bb = ByteBuffer.allocate(100);
        bb.put("Hello server".getBytes());
        bb.clear();
        try {
            sock.write(bb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        bb.rewind();
        int byteread;
        while((byteread=sock.read(bb))>0){
            System.out.println(new String(bb.array(),0,byteread));
        }

    }

}
