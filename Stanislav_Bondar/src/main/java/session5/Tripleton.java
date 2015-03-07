//package session5;
//
///**
// * Created by stan on 24.01.15.
// */
//public class Tripleton {
//    public static void main(String[] args) {
//        instanceOne();
//    }
//
//    public static Tripleton instanceOne;
//    public static Tripleton instanceTwo;
//    public static Tripleton instanceThree;
//
//    private Tripleton() {
//
//    }
//
//
//    public synchronized static Tripleton getInstanceOne() {
//
//            if (instanceOne == null) {
//                return new Tripleton();
//            }
//
//        return instanceOne;
//    }
//
//    public synchronized static Tripleton getInstanceTwo() {
//            if (instanceTwo == null) {
//                return new Tripleton();
//            }
//        return instanceTwo;
//    }
//
//    public synchronized static Tripleton getInstanceThree() {
//
//            if (instanceThree == null) {
//                return new Tripleton();
//
//        }
//        return instanceThree;
//    }
//}