import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * Create the Student and Priorities classes here.
 */


class Solution1 {
	private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();

	public static void main(String[] args) {
		int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();

		while (totalEvents-- != 0) {
			String event = scan.nextLine();
			events.add(event);
		}

		List<Student1> student1s = priorities.getStudents(events);

		if (student1s.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			for (Student1 st: student1s) {
				System.out.println(st.getName());
			}
		}
	}
}

class Priorities {
	PriorityQueue<Student1> student1s = new PriorityQueue<>();
	List<Student1> students2 = new ArrayList<>();
	List<Student1> getStudents(List<String> events) {
		for (String event:
		     events) {
			String[] stringTokenizer = event.split(" ");
			if(stringTokenizer[0].compareTo("SERVED") == 0) {
				if(student1s.size() >0) {
					Student1 student1 = student1s.remove();
				}
//				System.out.println("out:"+ student.name );
//				students2.remove(student);
			} else if( stringTokenizer[0].compareTo("ENTER") == 0) {
				Student1 student1 = new Student1(stringTokenizer[1], Double.parseDouble(stringTokenizer[2]),  Integer.parseInt(stringTokenizer[3]));
//				students2.add(student);
				student1s.add(student1);
			}

		}
		int size = student1s.size();
		for (int i = 0; i < size; i++) {
			students2.add(student1s.remove());
		}
		return students2;
	}
}

class Student1 implements Comparable<Student1> {
	int id;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getCgpa() {
		return cgpa;
	}

	String name;
	double cgpa;

	Student1(String name, double cgpa, int id) {
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}


	@Override
	public int compareTo(Student1 o) {
		if(this.id == o.id && this.name.equals(o.name) && this.cgpa == o.cgpa) return 0;
		if(this.cgpa > o.cgpa) {
			return -1;
		}
		else if(this.cgpa == o.cgpa && this.name.compareTo(o.name) < 0){
			return -1;
		}
		else if(this.cgpa == o.cgpa && this.name.compareTo(o.name) == 0 && this.id > o.id){
			return -1;
		}
		return 1;
	}
}