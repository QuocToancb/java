package Ax_thread_pool_advance.executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class newSingleThread {
    public static void main(String[] args) {

        System.out.println("========================================\n");
        System.out.println("Rubn newSingleThread");
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 10; i++) {
            executor.execute(() -> {
                System.out.println("Start " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("            Finish " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();

    }

}

class newFixedThreadPool {
    public static void main(String[] args) {

        System.out.println("========================================\n");
        System.out.println("Rubn newFixedThreadPool 3");
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 10; i++) {
            executor.execute(() -> {
                System.out.println("Start " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("            Finish " + Thread.currentThread().getName());
            });
        }


        executor.shutdown();
    }
}

class newCachedThreadPool {
    public static void main(String[] args) {

        System.out.println("========================================\n");
        System.out.println("Rubn newCachedThreadPool 3");
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 1; i <= 100; i++) {
            executor.execute(() -> {
                System.out.println("Start " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("            Finish " + Thread.currentThread().getName());
            });
        }


        executor.shutdown();
    }
}

class newScheduledThreadPool {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("========================================\n");
        System.out.println("Rubn newScheduledThreadPool 2");
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        for (int i = 1; i <= 10; i++) {
            executor.scheduleWithFixedDelay(() -> {
                System.out.println("Start " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("            Finish " + Thread.currentThread().getName());
            },
                    1, 2, TimeUnit.SECONDS);
        }

        executor.awaitTermination(10, TimeUnit.SECONDS);
        executor.shutdown();
        while (!executor.isTerminated()) {

        }

        System.out.println("Finished all threads");
    }
}