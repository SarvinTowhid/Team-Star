import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

public class Kevin_PUT {

	public void main(String[] args) {
		get();
		post();
		put();
		delete();
	}
		public static void get() {
			baseURI = "http://localhost:3000/";
			given().
				param("name", "Automation").
				get("/subjects").
			then().
				statusCode(200).
				log().all();
		}
		public static void post() {
			JSONObject request = new JSONObject();
			
			request.put("firstName", "Jacob");
			request.put("lastName", "Weaver");
			request.put("subjectId", "1");
			
			baseURI = "http://localhost:3000/";
			
			given().
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				header("Content-Type", "application/Json").
				body(request.toJSONString()).
			when().
				post("/users").
			then().
				statusCode(201).
				log().all();
		}
		public static void put() {
			JSONObject request = new JSONObject();
			
			request.put("lastName", "Sephere");

			baseURI = "http://localhost:3000/";
			
			given().
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				header("Content-Type", "application/Json").
				body(request.toJSONString()).
			when().
				put("/users/4").
			then().
				statusCode(200).
				log().all();
		}
		public static void delete() {
			baseURI = "http://localhost:3000/";
			
			when().
				delete("/users/4").
			then().
				statusCode(200).
				log().all();
		}
	}
	

