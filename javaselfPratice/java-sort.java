import java.util.*;

class Student implements Comparator{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}

	@Override
	public int compare(Object o1, Object o2) {
		Student student1 = (Student) o1;
		Student student2 = (Student) o2;

		if(student1.getId() == student2.getId() && student1.getFname() == student2.getFname() && student1.getCgpa() == student2.getCgpa()) {
			return 0;
		} else if(student1.getCgpa() > student2.getCgpa()) {
			return 1;
		}  else if(student1.getCgpa() == student2.getCgpa() && student1.getFname().compareTo(student2.getFname()) > 0) {
			return 1;
		}  else if(student1.getCgpa() == student2.getCgpa() && student1.getFname().compareTo(student2.getFname()) == 0 && student1.getId() > student2.getId()) {
			return 1;
		}
		return -1;
	}
}

class StuCompare implements Comparator
{
	@Override
	public int compare(Object o1, Object o2) {
		Student student1 = (Student) o1;
		Student student2 = (Student) o2;

		if(student1.getId() == student2.getId() && student1.getFname() == student2.getFname() && student1.getCgpa() == student2.getCgpa()) {
			return 0;
		} else if(student1.getCgpa() > student2.getCgpa()) {
			System.out.println(student1.getFname() + " > " + student2.getFname()) ;
			return 1;
		}  else if(student1.getCgpa() == student2.getCgpa() && student1.getFname().compareTo(student2.getFname()) > 0) {

			System.out.println(student1.getFname() + " > " + student2.getFname()) ;
			return 1;
		}  else if(student1.getCgpa() == student2.getCgpa() && student1.getFname().compareTo(student2.getFname()) == 0 && student1.getId() > student2.getId()) {

			System.out.println(student1.getFname() + " > " + student2.getFname()) ;
			return 1;
		}

		System.out.println(student1.getFname() + " <>> " + student2.getFname()) ;
		return -1;
	}
}
//Complete the code
class Solution3
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			studentList.sort(new StuCompare().reversed());
			System.out.println("in: " + st.getFname());
			testCases--;
		}

		for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}
