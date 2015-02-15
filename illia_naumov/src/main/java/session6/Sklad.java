package main.java.session6;

/**
 * ЗАДАНИЕ: Поставщик сгенерировал 200 чисел от 0 до 10,
 * покупатель – должен все числа вывести. Если числа нет – то потребитель не идет их забирать
 */
public class Sklad {
  /**  public static void main(String[] args) {
        Producer prod = new Producer();
        Consumer cons = new Consumer();
        prod.start();
        cons.start();
    }
}
class Producer extends Thread{
    private Holder holder;
    public Producer(Holder holder){
        this.holder = holder;
    }
    @Override
    public void run(){
        for(int i = 0; i < 200; i++){
            holder.setValue(i);
        }
    }
}
class Consumer extends Thread{
    private Holder holder;
    public Consumer(Holder holder){
        this.holder = holder;
    }
    @Override
    public void run(){
        for(int i = 0; i < 200; i++){
            System.out.println(holder.getValue());
        }
    }
}

class Holder{
    private Integer value;

    public synchronized  Integer getValue(){
        if(value == null){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void setValue(Integer value){
        this.value = value;
    }*/
}
