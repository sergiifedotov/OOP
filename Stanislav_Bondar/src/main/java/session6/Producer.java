//package session6;
//
///**
// * Created by stan on 25.01.15.
// */
//public class Producer extends Thread {
//    private Holder Polka;
//
//    public Producer(Holder Polka) {
//
//        this.Polka = Polka;
//    }
//
//    public Producer() {
//
//    }
//
//    public void produce() {
//        for (int i = 0; i < 30; i++) {
//            Polka.put(new Integer(i));
//            System.out.println("Producer put: " + i);
//        }
//        Polka.setEnd(true);
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 200; i++) {
//           try {
//               polka.setValue(i);
//           }catch (InterruptedException e){
//               e.printStackTrace();
//           }
//        }
//        Polka.setEnd(true);
//
//    }
//
//
//}
//
//    class Holder {
//
//        private Holder instance = new Holder();
//
//        public Holder() {
//
//        }
//
//
//        private Integer base = null;
//
//        public boolean getEnd() {
//            return end;
//        }
//
//        public void setEnd(boolean end) {
//            this.end = end;
//        }
//
//        private boolean end = false;
//
//        public void put(int i) {
//
//        }
//
//
//        synchronized public void put(Integer valuse) {
//            boolean isPuted = false;
//            while (!isPuted) {
//                if (base == null) {
//                    base = valuse;
//                    isPuted = true;
//                } else {
//                    try {
//                        wait(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//        }
//
//
//        synchronized public int get() {
//            boolean isGeted = false;
//            while (!isGeted) {
//                if (base != null) {
//                    isGeted = true;
//                    Integer returnBase = new Integer(base);
//                    base = null;
//                    return returnBase;
//                } else {
//                    try {
//                        wait(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//            return 0;
//        }
//
//
//        public  Holder getInstance() {
//            return instance;
//        }
//    }
