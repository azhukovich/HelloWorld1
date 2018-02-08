package spring;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class ConsoleEventLogger {
	
	private static ConsoleEventLogger instance = null;

	private ConsoleEventLogger() {
	      // Exists only to defeat instantiation.
	   }
	
	public static ConsoleEventLogger getInstance() {
	      if(instance == null) {
	         instance = new ConsoleEventLogger();
	      }
	      return instance;
	   }
	
	public void logEvent (String msg) {
		System.out.println(msg);
		try {
		File file=new File("textlog.txt") ;
		FileUtils.writeStringToFile(file, "\n"+msg, true);
		}catch(Exception e) {System.out.println(e.getMessage());}
	}
	
	
}
