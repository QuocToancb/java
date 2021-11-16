package future_task;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Main2 {
    public static void main(String[] are) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(200);

        List<Future<Integer>> futures = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Future<Integer> futureTask = executor.submit(() -> sleep500ms(finalI));
            futures.add(futureTask);
            System.out.println("i = : " + i);
        }

        System.out.println("Finish: " + (System.currentTimeMillis() - start));
        futures.parallelStream().forEach(integerFuture -> {
            try {
                integerFuture.get(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        });
    }

    private static int sleep500ms(int s){
        try {
            Thread.sleep(500);
            return s + s;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
