package threadstate.stop;

public class CountDownRunnable implements Runnable {

    String name;

    public CountDownRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;
            while(true) {
                System.out.println("Runnable Thread "+ name + ": "+ i++);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
