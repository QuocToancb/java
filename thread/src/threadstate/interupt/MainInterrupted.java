package threadstate.interupt;

public class MainInterrupted {

    public static void main(String[] args) {
        //Create thread by implement Runnable
        CountDownRunnable countDownRunnable = new CountDownRunnable("CountDown");
        Thread threadRunnable = new Thread(countDownRunnable);
        System.out.println("thread start");
        threadRunnable.start();


        System.out.println("Interrupt thread");
        threadRunnable.interrupt();

        System.out.println("=============Finish main Thread================");
    }
}
