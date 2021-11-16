package A4_countdownlatch;

import java.util.concurrent.CountDownLatch;

//CountDownLatch can be used to make sure that init thread have been run before start do other thing else in the main thread.
//CountDownLatch have same purpose with join but better because it dont need to declare join() for each thread
public class CountDownLatchPractice {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Thread t1 = new Thread(new Thread1(countDownLatch));
        Thread t2 = new Thread(new Thread2(countDownLatch));

        t1.start();
        t2.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish All thread");

        System.out.println("main Run");
        System.out.println("main Finish");
    }
}

class Thread1 implements Runnable {
    CountDownLatch countDownLatch;

    public Thread1 (CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("thread 1 Running");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread 1 Finish");
        countDownLatch.countDown();
    }
}


class Thread2 implements Runnable {
    CountDownLatch countDownLatch;

    public Thread2 (CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("thread 2 Running");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread 2 Finish");
        countDownLatch.countDown();
    }
}

