package hw4.parallel;

/**
 * Created by vladimir on 11.02.2015.
 */
public class Receiver {

    private MessageReceiver messageReceiver;
    private MessageHandler messageHandler = new MessageHandler() {
        @Override
        public void process(Message message) {
            System.out.println("incoming message: " + message.text);
        }
    };

    private Receiver() {
    }

    public Receiver(String receiveAddress, int receivePort) {
        this();
        messageReceiver = new MessageReceiver(receiveAddress, receivePort, messageHandler);
    }

    public static void main(String[] args) {
        Receiver receiver = new Receiver("localhost", 30000);
        receiver.messageReceiver.start();
    }
}
