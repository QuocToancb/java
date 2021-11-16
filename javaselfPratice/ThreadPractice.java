import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPractice {
	public static void main(String[] args) throws InterruptedException {

	}
}


class NonDaemonThreadTest {
	public static void main(String[] args) throws InterruptedException {
		Thread dt = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true){
					System.out.println("running");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "Deamon Thread");

		dt.setDaemon(true);
		dt.start();

		// continue program
		Thread.sleep(3000);
		System.out.println(">><< Finishing main program");
	}
}



class CallableExample {
	public static void main(String[] args) throws InterruptedException {
		// create a listFutureResponse to hold the Future object associated with Callable
		List<Future<Integer>> listFutureResponse = new ArrayList<>();

		// Get ExecutorService from Executors utility class, thread pool size is 5
		ExecutorService executor = Executors.newFixedThreadPool(5);

		Callable<Integer> callable;
		Future<Integer> future;
		for (int i = 1; i <= 10; i++) {
			callable = new CallableWorker(i);

			// submit Callable tasks to be executed by thread pool
			future = executor.submit(callable);

			// add Future to the listFutureResponse, we can get return value using Future
			listFutureResponse.add(future);
		}

		// shut down the executor service now
		executor.shutdown();

		// Wait until all threads are finish
		while (!executor.isTerminated()) {
			System.out.println("Running");
			Thread.sleep(500);
		}

		int sum = 0;
		for (Future<Integer> f : listFutureResponse) {
			try {
				sum += f.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Finished all threads: ");
		System.out.println("Sum all = " + sum);
	}


	static class CallableWorker implements Callable<Integer> {

		private int num;
		private Random ran;

		public CallableWorker(int num) {
			this.num = num;
			this.ran = new Random();
		}

		public Integer call() throws Exception {
			Thread.sleep(ran.nextInt(10) * 1000);
			int result = num * num;
			System.out.println("Complete " + num);
			return result;
		}
	}
}

