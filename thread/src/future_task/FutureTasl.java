package future_task;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class FutureTasl {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorService threadpool = Executors.newCachedThreadPool();
        Future<Double> futureTask = threadpool.submit(() -> doubleNumber(22));
        Future<Double> futureTask2 = threadpool.submit(() -> doubleNumber(22));

//        while (!futureTask.isDone()) {
//            System.out.println("Task 1 still running...");
//        }
//
//        while (!futureTask2.isDone()) {
//            System.out.println("Task 2 still running...");
//        }


        Double result = futureTask.get();

//        Double result2 = futureTask2.get();
        System.out.println("result is: " + result);

        threadpool.shutdown();
    }

    public static double doubleNumber(double a) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a*a;
    }
}