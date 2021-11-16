package A1_Simplethread_StartThread;

public class main2 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread(3);

        //Trigger run() will execute method in main thread instead of new thread.
//        user start() instead
        myThread.run();
    }

}

class MyThread extends Thread {
    int count;
    MyThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println("Run thread " + getName() + " : " + count);
    }
}
