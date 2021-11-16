import java.util.Scanner;

public class WaitAndNotify {
    public static void main(String[] args) {
        Factory factory = new Factory();
        new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        factory.producer();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }).start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        factory.consumer();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }).start();
    }
}


class Factory {
    public void producer() throws InterruptedException {
        synchronized (this) {
            System.out.println("Start producer");
            wait();
            System.out.println("Producer continued");
        }
    }

    public void consumer() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scanner  = new Scanner(System.in);
        synchronized (this){
            System.out.println("Start consumber");
            System.out.println("Waiting for input");
            scanner.nextLine();
            notify();
        }
    }
}