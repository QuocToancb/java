package A2_Basic_synchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//use synchronize for method wwill block OBJECT, if 2 method have no relation and
// can run dependent, we should use synchronize for block. it only blocks object for that block
//
public class M3_Synchronized_Block {
    public static void main(String[] args) {
        M3_Synchronized_Block m3_synchronized_block = new M3_Synchronized_Block();
        long startTime = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run(){
                m3_synchronized_block.runProcess();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run(){
                m3_synchronized_block.runProcess();
            }
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("totalTime: " + (endTime - startTime));
        System.out.println(m3_synchronized_block.list1.size());
        System.out.println(m3_synchronized_block.list2.size());
    }


    void runProcess() {
        for (int i = 0; i < 1000; i++) {
            stage1();
            stage2();
        }
    }


    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    void stage1() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(new Random().nextInt());
        }
    }

     void stage2() {
         synchronized (lock2){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list2.add(new Random().nextInt());
    }
    }

}


