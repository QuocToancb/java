package threadstate.interupt;

public class MainNormal {

    public static void main(String[] args) {
        //Create thread by implement Runnable
        CountDownRunnableNoSleep countDownRunnable = new CountDownRunnableNoSleep("CountDown");
        Thread threadRunnable = new Thread(countDownRunnable);
        System.out.println("thread start");
        threadRunnable.start();


        System.out.println("Interrupt thread");
        threadRunnable.interrupt();

        System.out.println("=============Finish main Thread================");
    }
}
