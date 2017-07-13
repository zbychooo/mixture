///**
// * This is leaflet. Good Luck!
// */
//public class Testable {
//
//
//    public static void main(String args[]){
//
//
//        Thread t1 = new Thread(new Test1(), "a");
//        Thread t2 = new Thread(new Test1(), "b");
//        Thread t3 = new Thread(new Test1(), "c");
//        t1.start();
//        t2.start();
//        t3.start();
//
//        try {
//            t1.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//}
//
//
//
//class Test1 implements Runnable {
//
//    public void run() {
//        for(int i=0;i<10;i++){
//            System.out.println(Thread.currentThread().getName() + " hello " + i);
//
//        }
//    }
//}
//
