
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Example {
    public static void main(String[] args) throws IOException {
        BufferedReader2();
    }

    public void BufferedReader1() throws IOException {
        InputStreamReader inStream = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(inStream);

        int num , num2;
        String str[]=new String[2];

        System.out.print("Please Enter Your First Number:");
        str[0] = stdin.readLine();
        System.out.print("Please Enter Your Second Number:");
        str[1] = stdin.readLine();

        num = Integer.parseInt(str[0]);
        num2 = Integer.parseInt(str[1]);
    }

    public static void BufferedReader2() throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = r.readLine()) != null) {
            System.out.println(line);
        }
    }

}

class ThreadPrintValueFromOtherThread {

    public static void main(String args[]) throws Exception {
        Map<String, String> dateMap = new HashMap();
        dateMap.put("1", "mot");
        dateMap.put("2", "hai");
        dateMap.put("3", "ba");
        dateMap.put("4", "bon");
        dateMap.put("5", "nam");
        dateMap.put("6", "sau");
        dateMap.put("7", "bay");

        ExecutorService service = Executors.newFixedThreadPool(1);

        Future<String> randomDateKey = service.submit(new RandomDateKey(dateMap));

         System.out.println(randomDateKey.get());
        Future<String> valueOfRandomKey = service.submit(new RandomValue(dateMap, randomDateKey.get()));

        System.out.println(randomDateKey.get());

        System.out.println(valueOfRandomKey.get());

        service.shutdown();

    }
}

class RandomDateKey implements Callable<String> {
    Map<String, String> stringStringMap;
    RandomDateKey(Map<String, String> stringStringMap) {
        this.stringStringMap = stringStringMap;
    }

    public synchronized String call() throws InterruptedException {
        //get Random value
        List<String> keysAsArray = new ArrayList<String>(stringStringMap.keySet());
        Random r = new Random();

        stringStringMap.get(keysAsArray.get(r.nextInt(keysAsArray.size())));

        String result =  keysAsArray.get(r.nextInt(keysAsArray.size()));
        System.out.println("key is: " + result);
        Thread.sleep(3000);
        return result;
    }
}

class RandomValue implements Callable<String> {
    Map<String, String> stringStringMap;
    String key;
    RandomValue(Map<String, String> stringStringMap, String key) {
        this.stringStringMap = stringStringMap;
        this.key = key;
    }
    public synchronized String call() {
        System.out.println("value is: " +  stringStringMap.get(key));
        return stringStringMap.get(key);
    }
}

