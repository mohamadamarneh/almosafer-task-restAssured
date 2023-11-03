package tests;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.notNullValue;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.annotations.Test;

public class POST_TRIP_INFO {

	@Test
	public void testPOSTRequestWithResponseFromBody() throws IOException {
		// Base URL for the API
		RestAssured.baseURI = "https://ae.almosafer.com";

		// Extract the response body
		// JSONObject jsonObject = new JSONObject();

		String jsonRequestBody = new String(Files.readAllBytes(Paths.get("..\\\\almosafer\\\\testdata.json")));
		// System.out.println(jsonRequestBody);

		// Send a POST request using the response body from the previous request
		Response responsePOST = RestAssured.given()
				.header("Content-Type", "application/json")
				.body(jsonRequestBody)
				.when()
				.post("/api/v3/flights/flight/async-search-result");

		responsePOST.then().statusCode(200) //smoke test
		.body("next.nid", notNullValue());

		// You can further assert the POST response if needed.
	}
}









//public class TestCase1 {
//
//    @Test
//    public void testGETRequest() {
//        // Base URL for the API
//        RestAssured.baseURI = "https://ae.almosafer.com";
//
//        // Send a GET request and specify the path
//        Response response = RestAssured.given()
//            .header("Content-Type", "application/json")
//            .when()
//            .get("/api/v3/flights/flight/search?query=RUH-JED/2023-11-20/2023-11-30/Economy/2Adult");
//
//        // Assert the response status code
//        response.then().statusCode(200);
//
//        // You can further assert the data structure of the response using JSONPath or other methods.
//        // For example, to check if a specific element exists:
//        response.then().body("data.someElement", notNullValue());
//    }
//}
//Test Case 2: Send a POST request with the response body from Test Case 1.
//java
//Copy code
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import org.testng.annotations.Test;
