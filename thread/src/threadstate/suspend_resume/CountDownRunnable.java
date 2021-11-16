package threadstate.suspend_resume;

public class CountDownRunnable implements Runnable {

    String name;

    public CountDownRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            int i =0;
            while(true) {
                System.out.println("Runnable Thread "+ name + ": "+ i++);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
