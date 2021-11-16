package A2_Basic_synchronization;

import java.util.Scanner;

//user variable to decide that thread is still running or stop
public class M1_Basic {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("Synchronization");

        myThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        myThread.stopThread();
    }

}

class MyThread extends Thread {
    boolean isRun = true;

    @Override
    public void run() {
        while(isRun) {
            System.out.println("Thread " + getName() + " is running");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThread(){
        isRun = false;
    }
}
