package threadstate.interupt;

public class CountDownRunnable implements Runnable {

    String name;

    public CountDownRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            int i =0;
            while(i<10) {
                System.out.println("Runnable Thread "+ name + ": "+ i++);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
