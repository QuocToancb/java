package threadstate.join;

public class Main {

    public static void main(String[] args) {
        //Create thread by implement Runnable
        CountDownRunnable countDownRunnable = new CountDownRunnable("CountDown");
        Thread threadRunnable = new Thread(countDownRunnable);
        threadRunnable.start();
        try {
            threadRunnable.join(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

            for (int i = 0; i < 3; i++) {
                System.out.println("MainInterrupted thread wait: " + i);
            }

        System.out.println("=============Finish main Thread================");
    }
}
