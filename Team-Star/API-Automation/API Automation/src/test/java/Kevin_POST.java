import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

public class Kevin_POST {

	public static void main(String[] args) {
//		get();
		post();
		put();
		delete();
	}
		
	public static void get() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Kevin");
		map.put("job", "Associate");
		
		System.out.println(map);
		
		JSONObject request = new JSONObject(map);
		
		request.put("name", "Kevin");
		request.put("job", "Associate");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type", "application/Json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200);
	}
	public static void post() {
	
		JSONObject request = new JSONObject();
		
		request.put("name", "Kevin");
		request.put("job", "Associate");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type", "application/Json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201);
	}
	public static void put() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Kevin");
		request.put("job", "Associate");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type", "application/Json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("https://reqres.in/api/users/2").
		then().
			statusCode(200);
	}
public static void delete() {
		
		
		when().
			put("https://reqres.in/api/users/2").
		then().
			statusCode(200);

}
}