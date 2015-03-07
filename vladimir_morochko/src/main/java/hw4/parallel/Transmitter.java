package hw4.parallel;

import java.io.*;
import java.util.Scanner;

/**
 * Created by vladimir on 11.02.2015.
 */
public class Transmitter {
    private MessageTransmitter messageTransmitter;

    private Transmitter() {
    }

    public Transmitter(int sendPort) {
        this();
        messageTransmitter = new MessageTransmitter(sendPort);
    }

    public static void main(String[] args) throws IOException {
        Transmitter transmitter = new Transmitter(30000);
        transmitter.messageTransmitter.start();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String text = scanner.nextLine();
            if (text.equals("exit")) {
                break;
            }
            Message message = new Message();
            message.text = text;
            System.out.println("sending message: \"" + message.text + "\"");
            transmitter.messageTransmitter.transmit(message);
        }
        transmitter.messageTransmitter.interrupt();
    }
}
