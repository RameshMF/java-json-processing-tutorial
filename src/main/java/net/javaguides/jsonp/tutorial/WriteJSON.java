package net.javaguides.jsonp.tutorial;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;


/**
 * Class to write json to a posts.json file.
 * @author Ramesh fadatare
 *
 */
public class WriteJSON {
	
	public static void main(String[] args) throws FileNotFoundException {
		Post post = createPost();

		JsonObjectBuilder postBuilder = Json.createObjectBuilder();
		JsonArrayBuilder tagsBuilder = Json.createArrayBuilder();

		for (String tag : post.getTags()) {
			tagsBuilder.add(tag);
		}
		
		postBuilder.add("id", post.getId())
		.add("title", post.getTitle())
		.add("description", post.getDescription())
		.add("content", post.getContent())
		.add("tags", tagsBuilder);
		
		
		JsonObject postJsonObject = postBuilder.build();
		
		System.out.println("Post JSON String -> "+postJsonObject);
		
		//write to file
		OutputStream os = new FileOutputStream("posts.json");
		JsonWriter jsonWriter = Json.createWriter(os);
		
		Map<String, Boolean> config = new HashMap<String, Boolean>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        JsonWriterFactory factory = Json.createWriterFactory(config);
		jsonWriter = factory.createWriter(os);
        
		jsonWriter.writeObject(postJsonObject);
		jsonWriter.close();
	}

	private static Post createPost() {
		// create a post
        Post post = new Post();
        post.setTitle("JSONP Tutorial");
        post.setId(100);
        post.setDescription("Post about JSONP");
        post.setContent("HTML content here");

        String[] tags = {"Java", "JSON"};
        // create some predefined tags
        post.setTags(tags);
        
        // set tags to post
		return post;		
	}
}
