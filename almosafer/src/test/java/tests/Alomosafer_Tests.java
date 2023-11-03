package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;

public class Alomosafer_Tests {

	@Test
	public void testGETRequest() {
		// Base URL for the API
		RestAssured.baseURI = "https://ae.almosafer.com";

		// Send a GET request 
		Response response = RestAssured.given()
				.header("Content-Type", "application/json") // add headers
				.when()
				.get("/api/v3/flights/flight/search?query=RUH-JED/2023-11-20/2023-11-30/Economy/2Adult");

		// Assert the response status code
		response.then().statusCode(200)       // smoke test 
		.body("next.nid", notNullValue());    // smoke test 


		// the data changes so i decide to do assert in the API structure and if i have more informations  about the business maybe can do it better
		response.then()
		.body("next.get[0].cid", notNullValue())
		.body("next.get[0].info", notNullValue())
		.body("next.get[0].info.uid", notNullValue())
		.body("next.get[0].info.code", notNullValue())
		.body("next.get[0].info.chnr", notNullValue())
		.body("next.hashedKey", notNullValue())
		.body("request.searchType", notNullValue())
		.body("request.leg[0].originId", notNullValue())
		.body("request.leg[1].destinationId", notNullValue())
		.body("request.pax.adult", notNullValue())
		.body("request.pax.totalSeats", notNullValue())
		.body("request.pax.child", notNullValue())
		.body("request.pax.infant", notNullValue())
		.body("request.query", notNullValue());


		// save JSON response to testdata.json file
		String data = response.jsonPath().getString("key");

		// Serialize the data and save it to a JSON file
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("data", data);
		// Save jsonObject to a JSON file


		String responseBody =response.getBody().asString()  ;
		// Update the JSON data for Test Case 2
		TestDataLoader.writeTestData("testdata.json", responseBody);

	}
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
