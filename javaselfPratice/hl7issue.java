//import org.apache.commons.lang3.StringUtils;

public class hl7issue {
	public static void main(String[] args) {
//		++x is called preincrement while x++ is called postincrement.
//		++x increments the value of x and then returns x
//		x++ returns the value of x and then increments

		int x = 0;
		if(x++ > 0) {
			System.out.println("x++");
			System.out.println(x);
		}

		x = 0;
		if(++x > 0) {
			System.out.println("++x");
			System.out.println(x);
		}
	}
}
