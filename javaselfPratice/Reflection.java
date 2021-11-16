import java.lang.reflect.Field;

public class Reflection {
	public static void main(String[] args) throws IllegalAccessException {
		PrivateClass privateClass = new PrivateClass();

		Class myClass = privateClass.getClass();

		Field[] fields = myClass.getDeclaredFields();
		for (Field field: fields) {
			field.setAccessible(true);
			System.out.println(field.get(privateClass));

		}
	}
}

class PrivateClass {
	private String value1 = "v1";
	private int value2 = 2;
}