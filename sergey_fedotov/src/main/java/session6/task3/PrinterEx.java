package session6.task3;

/**
 * Необходимо выводить на экран информацию/сообщение
 Специальный класс printer сделаем метод print.
 В метод print будет передаваться строка.
 Метод должен выводить на экран сообщение в скобках []
 sleep в 1мс выводит строку и далаем паузу в 1мс и выводим
 оставшуюся строку
 Создать 3 потока. Каждый поток по 20 раз выводит свое имя
 используя метод print класса printer
 */
public class PrinterEx extends Thread {

    public static void main(String[] args) {
        PrinterEx th1 = new PrinterEx();
        PrinterEx th2 = new PrinterEx();
        PrinterEx th3 = new PrinterEx();
        th1.start();
        th2.start();
        th3.start();
    }

    @Override
    public void run() {
        Printer printer = Printer.getInstance();
        for (int i=0; i < 20; i++) {
            printer.print(getName());
        }
    }

}

class Printer {

    private static Printer instance = new Printer();

    private Printer(){
    }

    public static Printer getInstance(){
        return instance;
    }

    public synchronized void print(String str) {
        System.out.print("[");
        sleep();
        System.out.print(str);
        sleep();
        System.out.println("]");
    }

    public void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}