package threadstate.destroy;

public class CountDownRunnable implements Runnable {

    String name;

    public CountDownRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;
            while(i<100) {
                System.out.println("Runnable Thread "+ name + ": "+ i++);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
