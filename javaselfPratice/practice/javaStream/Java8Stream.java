package practice.javaStream;

import java.util.Arrays;
import java.util.Random;

public class Java8Stream {
	public static void main(String[] args) throws Exception {
		int[] ints = new int[500000];
		Random random = new Random();
		for (int i = 0; i < ints.length; i++) {
			ints[i] = random.nextInt();
		}

		int[] ints2 = new int[500000];
		for (int i = 0; i < ints2.length; i++) {
			ints2[i] = random.nextInt();
		}

		long start1 = System.currentTimeMillis();


		Arrays.stream(ints2)
				.reduce(Integer.MIN_VALUE, Math::max);

		System.out.println(System.currentTimeMillis() - start1);

//		long start2 = System.currentTimeMillis();
//		Arrays.stream(ints).parallel()
//				.reduce(Integer.MIN_VALUE, Math::max);
//
//		System.out.println(System.currentTimeMillis() - start2);
	}
}
