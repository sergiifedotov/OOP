package session5;

/**
 * Created by vladimir on 25.01.2015.
 *
 * Необходимо выводить на экран информацию, просто сообщение.
 * Для этого будет использоваться специальный класс Printer,
 * у него будет метод print(String str). Он должен выводить
 * на экран сообщение в виде: [str]. Между скобкой и выводом
 * строки делается пауза в 1 миллисекунду (т.е. в начале и в конце).
 * Создать три потока, чтобы каждый вывел свое имя 20 раз, используя Printer.
 */

class Printer extends Thread {
    private static Printer instance;

    public Printer() {}

    public synchronized static Printer getInstance() {
        if (instance == null) {
            instance = new Printer();
        }
        return instance;
    }

    public synchronized void print(String string) {

        synchronized (this) { // синхронизируемся на синглтоне
            System.out.print("[");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(string);
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("]");
        }
    }
}
