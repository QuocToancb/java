package A6_Wait_Notify;

public class Main {
    public static void main(String[] args) {
        long sta = System.currentTimeMillis();
        ProcessorPractice processor = new ProcessorPractice();
        ThreadConsumer threadConsumer = new ThreadConsumer(processor);
        ThreadProduce threadProduce = new ThreadProduce(processor);

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

class Processor {
    Object object = new Object();
    public  void produce(){
        synchronized (object) {
            try {
                System.out.println("Produce Wait");
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Producer done");
        }
    }


    public  void consumer(){
        synchronized (object) {
            try {
                Thread.sleep(1000);
                System.out.println("Notify Produce");
                object.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class ThreadProduce extends Thread {
    ProcessorPractice processor;

    ThreadProduce(ProcessorPractice processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                sleep(1);
                processor.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class ThreadConsumer extends Thread {
    ProcessorPractice processor;

    ThreadConsumer(ProcessorPractice processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                sleep(1);
                processor.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
