package parallel;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class Main {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        System.out.println("Normal...");

        IntStream range = IntStream.rangeClosed(1, 2000);
        long start1 = System.currentTimeMillis();
        AtomicInteger i = new AtomicInteger();
        range.forEach(value -> {
            i.set(i.get() + value);
        });

        System.out.println("Total number: " + i);
        System.out.println("Total time: " + (System.currentTimeMillis() -start1));

        System.out.println("\nParallel...");


        long start2 = System.currentTimeMillis();

        IntStream range2 = IntStream.rangeClosed(1, 2000);
        AtomicInteger i2 = new AtomicInteger();
        range2.parallel().forEach(value -> {
            i2.set(i2.get() + value);
        });


        System.out.println("Total number: " + i2);
        System.out.println("Total time: " + (System.currentTimeMillis() - start2));
    }

}