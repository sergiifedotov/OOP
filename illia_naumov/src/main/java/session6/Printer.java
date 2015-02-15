package main.java.session6;

/**
 * выводить на экран сообщение. Использовать класс
 Printer{
 print(String str){
 }
 }
 Должен выводить на экран сообщение: [ str ]
 sout(“[]”)
 sleep(1);
 sout(str)
 3 потока, каждый поток выводит свое имя по 20 раз

 */
public class Printer {

    public static void main(String[] args) throws InterruptedException {
        MyThread thr1 = new MyThread("thr1");
        MyThread thr2 = new MyThread("thr2");
        MyThread thr3 = new MyThread("thr3");
        thr1.start();
        thr2.start();
        thr3.start();

    }
    public static synchronized void print(String s) throws InterruptedException {
            for(int i = 0; i < 20; i++){
            System.out.print("[ ");
            Thread.sleep(1);
            System.out.print(s);
            Thread.sleep(1);
            System.out.println(" ]");
        }
    }

}
class MyThread implements Runnable{
    String name;
    Thread t;
    public MyThread(String name){
        t = new Thread();
        this.name = name;
    }
    public void run(){

    }
    public void start(){
        try {
            Printer.print(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

