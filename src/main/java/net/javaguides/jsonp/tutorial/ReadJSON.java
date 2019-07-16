package net.javaguides.jsonp.tutorial;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

/**
 * Class to read json from a posts.json file.
 * @author Ramesh fadatare
 *
 */
public class ReadJSON {

	public static void main(String[] args) throws IOException {
		InputStream fis = new FileInputStream("posts.json");

		// create JsonReader object
		JsonReader jsonReader = Json.createReader(fis);

		// get JsonObject from JsonReader
		JsonObject jsonObject = jsonReader.readObject();

		// we can close IO resource and JsonReader now
		jsonReader.close();
		fis.close();

		// Retrieve data from JsonObject and create Post bean
		Post post = new Post();
		post.setId(jsonObject.getInt("id"));
		post.setTitle(jsonObject.getString("title"));
		post.setDescription(jsonObject.getString("description"));
		post.setContent(jsonObject.getString("content"));
		
		// reading arrays from json
		JsonArray jsonArray = jsonObject.getJsonArray("tags");
		String[] tags = new String[jsonArray.size()];
		int index = 0;
		for (JsonValue value : jsonArray) {
			tags[index++] =value.toString();
		}
		post.setTags(tags);
		// print post object
		System.out.println(post.toString());
	}
}
