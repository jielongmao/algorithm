package unclassified;

public class ThreadTest extends Thread{
    int num =10 ;

    @Override
    public void run() {
        while (num != 0){
            num --;
            System.out.println(Thread.currentThread().getName()+"  "+num);
        }
    }
    public static void main(String[] args) {
        new ThreadTest().start();
        new ThreadTest().start();
        new ThreadTest().start();

    }
}


class MyRunnable implements Runnable{
    int num =10 ;

    @Override
    public void run() {
        while (num != 0){
            num --;
            System.out.println(Thread.currentThread().getName()+"  "+num);
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
        new Thread(myRunnable).start();
    }
}
