import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLock {
    public static void main(String[] args) throws InterruptedException {
        RunFactory runFactory = new RunFactory();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runFactory.thread1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runFactory.thread2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runFactory.finishThread();
    }
}

class RunFactory {
    private int count = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    private void incremernt() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }

    public void thread1() throws InterruptedException {
        System.out.println("Start Thread 1");
        lock.lock();
        System.out.println("thread 1 locked");
//        Thread.sleep(2000);
        System.out.println("thread 1 await");
//        condition.await();
        incremernt();
        System.out.println("thread 1 unlocked");
        lock.unlock();
    }

    public void thread2() throws InterruptedException {
//        Thread.sleep(1000);
        System.out.println("Start Thread 2");
        System.out.println("Start Thread 2 locked");
        lock.lock();
        System.out.println("Waiting for input");
//        (new Scanner(System.in)).nextLine();
//        condition.signal();
        incremernt();
        System.out.println("Start Thread 2 Unlocked");
        lock.unlock();
    }

    public void finishThread(){
        System.out.println("Start finish Thread");
        System.out.println("CountValue: " + count);
    }
}