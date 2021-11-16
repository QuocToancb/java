package Ax_thread_pool_advance.executor_service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.*;

public class HowToUseExecuteService {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //Can create unlimited thread, thread can be reused and terminated after 60s
        Executors.newCachedThreadPool();

        Executors.newSingleThreadExecutor();
        //Same as single thread but have delay time between each thread
        Executors.newSingleThreadScheduledExecutor();

        Executors.newScheduledThreadPool(10);


        System.out.println("============================================================================\n");

        //Execute(Runable) execute a thread and return void
        executorService.execute(() -> System.out.println("do something"));


        System.out.println("============================================================================\n");
        //submit(runable) execute and returns a Future
        Future  future = executorService.submit(() -> {
            System.out.println("this is Runable body");
            Thread.sleep(100);
            return "runale result";
        });

        try {
            System.out.println("submit Runable result: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }



        System.out.println("============================================================================\n");
        //submit(Callable) execute and returns a Future
        Future  future2 = executorService.submit((Callable<Object>) () -> {
            System.out.println("this is Callable body");
            Thread.sleep(100);
            return "callAble result";}
            );


        try {
            System.out.println("submit Callable result: " + future2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        System.out.println("============================================================================\n");
        Collection<Callable<String>> callables = new HashSet<>();

        callables.add(() -> "Callable 1");
        callables.add(() -> {
            int b = 3 / 0;
            return "Callable 2";
        });

        callables.add(() -> "Callable 3");
        callables.add(() -> "Callable 4");
        callables.add(() -> "Callable 5");


        //InvokeAny run any thread in collection and return value or exception
        try {
            System.out.println("Start invokeAny");
            System.out.println("callables size: " + callables.size());
           String invokeAnyResult =  executorService.invokeAny(callables);
            System.out.println("invokeAny result: " + invokeAnyResult);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("invokeAny Exception");
            e.printStackTrace();
        }




        System.out.println("============================================================================\n");
        //InvokeAny run any thread in collection and return value or exception
        try {
            System.out.println("Start invokeAll");
            System.out.println("callables size: " + callables.size());
            List<Future<String>> invokeAllResult =  executorService.invokeAll(callables);

            invokeAllResult.forEach(stringFuture -> {
                try {
                    System.out.println("invokeAll result: " + stringFuture.get());
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("invokeAll result Exception");
                    e.printStackTrace();
                }
            });
        } catch (InterruptedException e) {
            System.out.println("invokeAll Exception");
            e.printStackTrace();
        }


        executorService.shutdown();


    }
}
