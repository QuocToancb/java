package A1_Simplethread_StartThread;


//JAVa chỉ cho phép kế thừa 1 class. nếu đã kế thừa Thread rồi thì ko thể kế thừa được nữa,

//Vì thế nên java có cách tạo thread khác thông qua inteface Runable để có thể kế thừa
public class Main {

    public static void main(String[] args) {
        //Create thread by extend thread
        CountDownThread countDownThread = new CountDownThread("CountDown");

        //Create thread by implement Runnable
        CountDownRunnable countDownRunnable = new CountDownRunnable("CountDown");
        Thread threadRunnable = new Thread(countDownRunnable);


        countDownThread.start();
        threadRunnable.start();

        System.out.println("=============Finish main Thread================");
    }
}

class CountDownThread extends Thread {

    public CountDownThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread "+ getName() + ": "+ i);
        }
    }
}

 class CountDownRunnable implements Runnable {

    String name;

    public CountDownRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runnable Thread "+ name + ": "+ i);
        }
    }
}