package thread_arraylist;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread implements Runnable{

    private List<Integer> myList;
    private Object host;
    public MyThread(List<Integer> list){
        this.myList = list;
    }
    private void addToList(int i){
        myList.add(i);
    }

    @Override
    public void run() {
        for( int i = 0; i < 10;i++){
            addToList(i);
        }
        System.out.println("end: " + myList.size());
    }
}
public class Main {

    private ArrayList<Integer> taskList = new ArrayList<>();
    private void launch(){

        ExecutorService executorService= Executors.newFixedThreadPool(5);
        executorService.execute(new MyThread(taskList));
        executorService.execute(new MyThread(taskList));
    }
    public static void main(String[] args) {
        Main test = new Main();
        test.launch();
    }
}
