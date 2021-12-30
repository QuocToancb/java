
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        List<Employee> employees = new ArrayList<Employee>();



//        for(int i = 0; i < 3; i ++) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Enter employee id: " + (i + 1));
//            int id = scanner.nextInt();
//            scanner.nextLine();
//            System.out.println("Enter employee Name: ");
//            String name = scanner.nextLine();
//
//            System.out.println("Enter employee Email: ");
//            String email = scanner.nextLine();
//
//            Employee employee = new Employee(id, name, email);
//            employees.add(employee);
//        }

        // write list to file
//        try {
//            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("C:\\Users\\loctk\\Home\\Aptech\\Term2\\TEST\\src\\com\\company\\employee.txt"));
//            for (Employee employee:employees) {
//                oo.writeObject(employee);
//            }
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//        // display infos:
//        System.out.println("Employees info:");
//        for (Employee employee:employees) {
//            System.out.println(employee.id);
//            System.out.println(employee.name);
//            System.out.println(employee.email);
//        }

        PrintRandomDay pd = new PrintRandomDay();
        Thread thread1 = new Thread(() -> pd.printVNDay());
        Thread thread2 = new Thread(() -> pd.printENDay());
        thread1.start();
        thread2.start();
    }
}

class PrintRandomDay {
    public int randomNum;

    synchronized void printVNDay (){
        try {
            Thread.sleep(2000);
            System.out.println("thread 1");
//            Random random = new Random();
//            int r = random.nextInt(7);
//            randomNum = r;
//            switch (r) {
//                case 0:
//                    System.out.println("Thu hai");
//                    break;
//                case 1:
//                    System.out.println("Thu ba");
//                    break;
//                case 2:
//                    System.out.println("Thu tu");
//                    break;
//                case 3:
//                    System.out.println("Thu nam");
//                    break;
//                case 4:
//                    System.out.println("Thu sau");
//                    break;
//                case 5:
//                    System.out.println("Thu bay");
//                    break;
//                case 6:
//                    System.out.println("CN");
//                    break;
//                default:
//                    System.out.println("No day");
//            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void printENDay (){

        System.out.println("thread 2");
        switch (randomNum) {
            case 0:
                System.out.println("Mon");
                break;
            case 1:
                System.out.println("Thur");
                break;
            case 2:
                System.out.println("Wend");
                break;
            case 3:
                System.out.println("Thurs");
                break;
            case 4:
                System.out.println("Fri");
                break;
            case 5:
                System.out.println("Sat");
                break;
            case 6:
                System.out.println("Sun");
                break;
            default:
                System.out.println("EEEE");
        }

    }
}


