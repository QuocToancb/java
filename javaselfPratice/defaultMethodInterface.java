public class defaultMethodInterface {
	public static void main(String[] args) {
		Printer printer = new Printer();
		printer.print();
	}
}

interface PrinterInterface {
	default void print() {
		System.out.println("Print Interface");
	}
}

class Printer2 {
	public void print() {
		System.out.println("Printer supper");
	}
}

class Printer  implements PrinterInterface {

	@Override
	public void print() {
		System.out.println("Printer SUB Class");

	}
}
