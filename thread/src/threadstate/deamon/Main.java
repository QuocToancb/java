package threadstate.deamon;

public class Main {

    public static void main(String[] args) {
        //Create thread by implement Runnable
        //Deamon thread is a thread that stop when main thread is stopped

        CountDownRunnable countDownRunnable = new CountDownRunnable("CountDown");
        Thread threadRunnable = new Thread(countDownRunnable);
        threadRunnable.setDaemon(true);
        threadRunnable.start();
        try {
            threadRunnable.join(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(threadRunnable.isDaemon());
        for (int i = 0; i < 3; i++) {
            System.out.println("MainInterrupted thread wait: " + i);
        }

        System.out.println("=============Finish main Thread================");
    }
}
