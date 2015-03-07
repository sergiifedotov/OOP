package hw4.parallel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Created by vladimir on 13.02.2015.
 */

public class MessageReceiver implements Runnable {
    private Thread thread;
    private String receiveAddress;
    private int receivePort;
    private MessageHandler messageHandler;

    private MessageReceiver() {
        thread = new Thread(this);
    }

    public MessageReceiver(String receiveAddress, int receivePort, MessageHandler messageHandler) {
        this();
        this.receiveAddress = receiveAddress;
        this.receivePort = receivePort;
        this.messageHandler = messageHandler;
    }

    public void start() {
        thread.start();
    }

    public void interrupt() {
        thread.interrupt();
    }

    @Override
    public void run() {
        Socket receiveSocket = null;
        try {
            receiveSocket = new Socket(receiveAddress, receivePort);
            ObjectInputStream objectInputStream = new ObjectInputStream(receiveSocket.getInputStream());
            System.out.println("receiving data from port " + receivePort + " on " + receiveAddress);
            while (!thread.isInterrupted()) {
                Message message = (Message) objectInputStream.readObject();
                messageHandler.process(message);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("closing receive port " + receivePort);
            if (receiveSocket != null) {
                try {
                    receiveSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}