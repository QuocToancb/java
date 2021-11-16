package practice.javaStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Java8StreamListy {
	public static void main(String[] args) throws Exception {
		List<Integer> ints = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 5000000; i++) {
			ints.add(random.nextInt());
		}

		long start1 = System.currentTimeMillis();
		int e = ints.size();
		int m = Integer.MIN_VALUE;
		for (Integer anInt : ints) if (anInt > m) m = anInt;

		long fisnih1 = System.currentTimeMillis();

		System.out.println(fisnih1 - start1);

		long start2 = System.currentTimeMillis();
		ints.stream().parallel()
				.reduce(Integer.MIN_VALUE, Math::max);
		long finsi2 = System.currentTimeMillis();

		System.out.println(finsi2 - start2);
	}
}
