package future_task;


import java.util.concurrent.*;

class CompletableFutureTask {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorService threadpool = Executors.newCachedThreadPool();
        CompletableFuture<Double> futureTask = new CompletableFuture<>();
        System.out.println("call complêt future");
        futureTask.complete(doubleNumber(2));


        System.out.println("get result");
        System.out.println("réult: " + futureTask.get());

        System.out.println("finishj");
    }

    public static double doubleNumber(double a) {
        try {
            System.out.println("startTask");
            Thread.sleep(5000);
            System.out.println("finishTask");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a*a;
    }
}