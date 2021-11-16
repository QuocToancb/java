package A7_ReentrainLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void lockThread(){
        System.out.println("Start thread lock and wait");
        lock.lock();
        try {
            condition.await();
//            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish Thread lock");
        lock.unlock();
    }

    public void unLockThread() {
        lock.lock();
        System.out.println("Start Unlock Thread");
        condition.signal();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish unlokc Thread");
    lock.unlock();
    }

    public static void main(String[] args) {
        Main main = new Main();
        new ThreadLock(main).start();
        new ThreadUnLock(main).start();
    }
}

class ThreadLock extends Thread {
    Main main;
    ThreadLock(Main main) {
        this.main = main;
    }
    @Override
    public void run() {
        main.lockThread();
    }
}


class ThreadUnLock extends Thread {
    Main main;
    ThreadUnLock(Main main) {
        this.main = main;
    }
    @Override
    public void run() {
        main.unLockThread();
    }
}
