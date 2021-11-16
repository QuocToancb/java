package A2_Basic_synchronization;

public class M2_JoinThread {
    static int i = 0;

    //If no synchronized keyword, final value can be wrong
    //because when t1 get value, t2 already change the value of count
    static synchronized void increaseValue(){
        i++;
    }
    public static void main(String[] args) {
        doSomething();

        System.out.println("final Value is: " + i);

    }

    private static void doSomething(){
        Thread t1 = new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                increaseValue();
            }
        });


        Thread t2 = new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                increaseValue();
            }
        });




        System.out.println("Start thread");
        t1.start();
        t2.start();

        //Call join to make main thread wait destination thread finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


