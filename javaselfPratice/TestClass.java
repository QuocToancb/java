import java.net.*;
import java.io.*;
public class TestClass {
	public static void main(String[] args) throws Exception {
		try{
			URL url = new URL("http://laptrinh.vn/");
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(url.openStream()));
			String line;
			while ((line = reader.readLine()) != null)
				System.out.println(line);
			reader.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
}