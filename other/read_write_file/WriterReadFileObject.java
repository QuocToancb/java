package read_write_file;

import java.io.*;

public class WriterReadFileObject {

    public static void main(String[] args) {

        MyObject p1 = new MyObject("John", 30);
        MyObject p2 = new MyObject("Rachel", 25);

        try {
            FileOutputStream f = new FileOutputStream(new File("./myObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(p1);
            o.writeObject(p2);

            o.close();
            f.close();

            FileInputStream fi = new FileInputStream(new File("./myObjects.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            MyObject pr1 = (MyObject) oi.readObject();
            MyObject pr2 = (MyObject) oi.readObject();

            System.out.println(pr1.toString());
            System.out.println(pr2.toString());

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}

class MyObject implements Serializable {

    private static final long serialVersionUID = 1L;
    private String dataString;
    private int dataInt;

    MyObject() {
    };

    MyObject(String dataString, int dataInt) {
        this.dataString = dataString;
        this.dataInt = dataInt;
    }

    @Override
    public String toString() {
        return "String:" + dataString + "\nInt: " + dataInt;
    }
}