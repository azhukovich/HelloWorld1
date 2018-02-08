package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.JsonObject;

import rest.RestExecutor;

public class App {
	private Client client;
	private ConsoleEventLogger eventLogger;
	private static JsonObject jsonObj = new JsonObject();

	public App(Client client, ConsoleEventLogger eventLogger) {
		this.client=client;
		this.eventLogger=eventLogger;
	};

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("cfg.xml");
		App app = (App) ctx.getBean("app");

		// app.client=new Client ("1","John Smith");
		// app.eventLogger = new ConsoleEventLogger();

		app.logEvent("Bugaga 1");
		app.logEvent("TROLOLO 1");
		app.test1();
				
		jsonObj.addProperty("firstName","[0-9]");
		jsonObj.addProperty("lastName","[A-z]");
		//app.testPost("{\"digit\":[0-9],}");
	}

	private void logEvent(String msg) {
		String message = msg.replaceAll(client.getId(), client.getFullName());
		eventLogger.logEvent(message);

	}

	private final String URL = "http://aztest01.getsandbox.com";

	private RestExecutor executor;
	
	private void test1() {
	
		executor = new RestExecutor(URL);
		
		executor.get("/users")
		.expectCode(200)			// Expected code of 200
		.expectMessage("O1K")		// Expected Message of 'OK'
		.expectHeader("Content-Type", "application/json") // Content-Type header value
		.expectInBody("Eraser");	// Content inside the response body			
	}
	
	private void testPost(json temp) {
		
		executor = new RestExecutor(URL);
		
		executor.post("/users", "{ \"title\": \"new test\", \"author\": \"axatrikx\" }", "application/json")
		.expectCode(400)
		.expectMessage("Created")
		.expectHeader("Content-Type", "application/json; charset=utf-8")
		.expectInBody("\"title\": \"new test\"")
		.expectInBody("axatrikx");	
	}
	
}
