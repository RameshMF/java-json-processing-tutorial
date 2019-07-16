package net.javaguides.jsonp.examples;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;

import net.javaguides.jsonp.tutorial.Post;


public class JsonGeneratorExample {
	public static void main(String[] args) throws FileNotFoundException {
		OutputStream fos = new FileOutputStream("posts.json");
		
		Map<String, Boolean> config = new HashMap<String, Boolean>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        JsonGeneratorFactory factory = Json.createGeneratorFactory(config);
        
        JsonGenerator jsonGenerator = factory.createGenerator(fos);
        
		Post post = createPost();
		jsonGenerator.writeStartObject(); // {
		jsonGenerator.write("id", post.getId()); // "id":123
		jsonGenerator.write("title", post.getTitle());
		jsonGenerator.write("description", post.getDescription());
		jsonGenerator.write("content", post.getContent());
		
		jsonGenerator.writeStartArray("tags");
		for(String tag: post.getTags()) {
			jsonGenerator.write(tag);
		}
		
		jsonGenerator.writeEnd(); // end of phone num array
		jsonGenerator.writeEnd(); // }

		jsonGenerator.close();
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