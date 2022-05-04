import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import io.restassured.http.ContentType;

public class DataDriven {

	@DataProvider
public Object[][] dataForPost() {
		
	//	Object[][] data = new Object[2][3];
	//	data[0][0] = "Albert";
	//	data[0][1] = "Stain";
	//	data[0][2] = "2";
		
	//	data[1][0] = "Linda";
	//	data[1][1] = "Nguyen";
	//	data[1][2] = "1";
		
	//	return data;
		
		return new Object[][] {
			{"Milo", "Foell", "1"},
			{"Shoubei", "Liang", "2"}
		};
	}
	
	public static void post(String firstName, String lastName, int subjectId) {
		JSONObject request = new JSONObject();
		
		request.put("firstName", "firstName");
		request.put("lastName", "lastName");
		request.put("subjectId", "subjectId");
		
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
}