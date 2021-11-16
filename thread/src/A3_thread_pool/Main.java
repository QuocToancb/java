package A3_thread_pool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] are) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Runnable runnable = () -> sleep500ms(finalI);

            executor.execute(runnable);
            System.out.println("i = : " + i);
        }

        executor.shutdown();
        System.out.println("Finish: " + (System.currentTimeMillis() - start));

        try {
            System.out.println(executor.awaitTermination(4, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sleep500ms(int s){
        try {
            Thread.sleep(500);
            System.out.println("finish sleep: " + s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
