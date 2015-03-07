package hw4.parallel;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by vladimir on 13.02.2015.
 */
public class MessageTransmitter implements Runnable{
    private Thread thread;
    private int sendPort;
    private ObjectOutputStream objectOutputStream;

    private MessageTransmitter() {
        thread = new Thread(this);
    }

    public MessageTransmitter(int sendPort) {
        this();
        this.sendPort = sendPort;
    }

    public void start() {
        thread.start();
    }

    public void interrupt() {
        thread.interrupt();
    }

    public void transmit(Message message) {
        try {
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Socket sendSocket = null;
        try {
            System.out.println("waiting for connections on port " + sendPort);
            sendSocket = new ServerSocket(sendPort).accept();
            objectOutputStream = new ObjectOutputStream(sendSocket.getOutputStream());
            System.out.println("opened port " + sendPort);
            while(!thread.isInterrupted()) {
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("closing send port " + sendPort);
            if (sendSocket != null) {
                try {
                    sendSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
