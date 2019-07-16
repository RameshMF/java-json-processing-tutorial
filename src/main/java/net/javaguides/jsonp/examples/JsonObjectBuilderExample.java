package net.javaguides.jsonp.examples;

import java.io.StringWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;

/**
 * The class demonstrates the usage of JsonObjectBuilder class
 * @author Ramesh Fadatare
 *
 */
public class JsonObjectBuilderExample {
	public static void main(String[] args) {
		String postedDate = LocalDate.of(2019, 7, 15).toString();

		JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder()
	            .add("id", "100")
	            .add("title", "JSON-Processing API Post")
	            .add("description", "JSON-Processing API Post")
	            .add("postedDate", postedDate);
		
		JsonObject jsonObject = jsonObjectBuilder.build();


	    Map<String, Boolean> config = new HashMap<String, Boolean>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        JsonWriterFactory jwf = Json.createWriterFactory(config);
        StringWriter sw = new StringWriter();

        try (JsonWriter jsonWriter = jwf.createWriter(sw)) {
            jsonWriter.writeObject(jsonObject);
            System.out.println(sw);
        }
	}
}
