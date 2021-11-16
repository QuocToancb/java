package threadstate.stop;

public class Main {

    public static void main(String[] args) {
        //Create thread by implement Runnable
        CountDownRunnable countDownRunnable = new CountDownRunnable("CountDown");
        Thread threadRunnable = new Thread(countDownRunnable);

        threadRunnable.start();

        //Suspend could cause deadlock because other thread could be depended on this thread, suspend thread could hold some resource

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("stopping thread");
        threadRunnable.stop();

        System.out.println("=============Finish main Thread================");
    }
}
