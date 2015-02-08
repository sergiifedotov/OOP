//package session06;
//
///**
// * Created by tsv on 25.01.15.
// */
//
//public class ProducerConsumer extends Thread {
//    private int value;
//    private Holder holder;
//
//    public ProducerConsumer(){
//
//    }
//
//    public ProducerConsumer(Holder holder){
//        this.holder = holder;
//    }
//
//    public void produce() {
//        for (int i = 0; i < 200; i++) {
//            value = i;
//            holder.put(value);
//            System.out.println("Put = " + value);
//            synchronized (this){
//                try {
//                    this.wait(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    @Override
//    public void run(){
//        produce();
//    }
//}