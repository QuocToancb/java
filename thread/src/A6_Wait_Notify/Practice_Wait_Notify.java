package A6_Wait_Notify;

import java.util.*;

public class Practice_Wait_Notify {
    public static void main(String[] args) {
        long sta = System.currentTimeMillis();
        ProcessorPractice processor = new ProcessorPractice();
        ThreadConsumerPractice threadConsumer = new ThreadConsumerPractice(processor);
        ThreadProducePractice threadProduce = new ThreadProducePractice(processor);

        threadConsumer.start();
        threadProduce.start();

        try {
            threadConsumer.join();
            threadProduce.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - sta);
    }

}

class ProcessorPractice {
    int value = 0;
    Queue<Integer> queue = new LinkedList<>();
    int LIMIT = 10;

    public  void produce(){
        synchronized (this) {
            if (queue.size() < LIMIT) {
                int value = new Random().nextInt();
                System.out.println("add: " + value);
                queue.add(value);
                notify();
            } else {
                try {
                    System.out.println("list full");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public  void consumer(){
        synchronized (this) {
            if(queue.isEmpty()) {
                try {
                    System.out.println("consumer list empty");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("get: " + queue.poll());
                notify();
            }
        }
    }
}


class ThreadProducePractice extends Thread {
    ProcessorPractice processor;

    ThreadProducePractice(ProcessorPractice processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                sleep(3000);
                processor.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class ThreadConsumerPractice extends Thread {
    ProcessorPractice processor;

    ThreadConsumerPractice(ProcessorPractice processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                sleep(1000);
                processor.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
