package A5_Proceduce_Consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//BlockingQUeue is upgrade of normal queue,
// BlokcingQueue will blokc consumer when queue is empty and block producer when queu is full
public class Main {
    static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {

        new Producer().start();
        new Consumer().start();
    }

    static void producer() throws InterruptedException {
        int i = 0;
        while (true){
            Thread.sleep(2000);
            blockingQueue.put(i++);
        }
    }

    static void consumer() throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            System.out.println("Take: " + blockingQueue.take());
            System.out.println("Queue size is: " + blockingQueue.size());
        }
    }


}

class Producer extends Thread{
    @Override
    public void run() {
        try {
            Main.producer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    @Override
    public void run() {
        try {
            Main.consumer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
