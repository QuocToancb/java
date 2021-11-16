package threadstate.interupt;

public class CountDownRunnableNoSleep implements Runnable {

    String name;

    public CountDownRunnableNoSleep(String name) {
        this.name = name;
    }

    @Override
    public void run() {
            int i =0;
            while(i<100) {
                System.out.println("Runnable Thread "+ name + ": "+ i++);
            }

    }
}
