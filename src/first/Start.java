package first;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;


public class Start {
	
	
	private static Properties p = new Properties();

	public static void main(String[] args) {

		A a = new A();
		// Verify v1 = new Verify();
		// v1.simpleExample();

		Action act = new Action() {
			public boolean doAction() {
				System.out.println("All done");
				return true;
			}
		};

		a.doSmth(act);

		System.out.println(a.sum(1, 2, 3, 4, 5, 6, 7, 8, 9));

		// System.out.println(a.divide(1,3).toString());

		String s1 = "abc";
		String s2 = "zbc";

		System.out.println(s1.compareTo(s2));
		
		p.put("name", "Alex");
		
		try (FileOutputStream propFile = new FileOutputStream("xyz.properties"))
		{
			p.store(propFile,null);	
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Thread t1=new Thread(new Counter(1));
		Thread t2=new Thread(new Counter(2));
		
		t1.start();
		t2.start();
		

	}

}
