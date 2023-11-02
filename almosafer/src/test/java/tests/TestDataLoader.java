package tests;



import com.google.gson.stream.JsonWriter;
import java.io.FileWriter;
import java.io.IOException;


public class TestDataLoader {
	
	// test data driven for drive the data on GET response to testdata.json file after that to send it to POST request

	public static void writeTestData(String jsonFilePath, String responseBody) {
		try (JsonWriter writer = new JsonWriter(new FileWriter(jsonFilePath))) {
			writer.setLenient(true); // Allow lenient writing for multiple JSON objects
			// Assuming responseBody is a JSON array string
			writer.jsonValue(responseBody);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
