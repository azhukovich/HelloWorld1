package first;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;





import static com.jayway.restassured.RestAssured.*;



import static org.hamcrest.Matchers.equalTo;


import com.google.gson.JsonObject;

public class Verify {

	public static void main(String[] args) {
		
		
		
		  Operationable operation;
	        operation = (x,y)->x+y;
	         
	        int result = operation.calculate(10, 20);
	        System.out.println(result); //30
	        
	}

	
	interface Operationable{
	    int calculate(int x, int y);
	}
	@BeforeClass
    static public void initializeRestAssured() {
        RestAssured.baseURI = "http://localhost:8080/REST-Jersey";
        RestAssured.port = 8080;        
    }
	
	@Test
	public void simpleExample(){
		//expect().body("title", equalTo("Hello world!")).when().get("http://my-json-server.typicode.com/typicode/demo/posts");
				
		JsonObject jsonObj = new JsonObject();		
		jsonObj.addProperty("firstName","The length of firstName should be between 1 to 25");
		jsonObj.addProperty("lastName","last");
		jsonObj.addProperty("email","lovetoyogesh@ymail.com");
		jsonObj.addProperty("age","15");		
                
		given()			
			.contentType("application/json")  //another way to specify content type
			.body(jsonObj.toString())
			.log().all()
		.when()
		.post("http://localhost:8080/REST-Jersey/student/register")
		.then()
		.log().all()
		.statusCode(500)
		.body("error", equalTo("The length of firstName should be between 1 to 25"));
		
		}
}