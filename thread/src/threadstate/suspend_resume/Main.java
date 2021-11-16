package threadstate.suspend_resume;

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

        threadRunnable.suspend();

        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("MainInterrupted thread wait: " + i);
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadRunnable.resume();
        System.out.println("=============Finish main Thread================");
    }
}
