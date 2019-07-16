package net.javaguides.jsonp.examples;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;

import net.javaguides.jsonp.tutorial.Post;

/**
 * The class to demonstrate the usage of JsonArrayBuilder interface.
 * @author Ramesh Fadatare
 *
 */
public class JsonArrayBuilderExample {
	public static void main(String[] args) {

        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

        List<Post> posts = createPosts();

        posts.forEach(post -> {

        	JsonObject json = Json.createObjectBuilder()
    	            .add("id", post.getId())
    	            .add("title", post.getTitle())
    	            .add("description", post.getDescription())
    	            .add("content", post.getContent()).build();

            jsonArrayBuilder.add(json);
        });


        JsonArray jsonArray = jsonArrayBuilder.build();
        
        Map<String, Boolean> config = new HashMap<String, Boolean>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        JsonWriterFactory jwf = Json.createWriterFactory(config);
        StringWriter sw = new StringWriter();

        try (JsonWriter jsonWriter = jwf.createWriter(sw)) {

            jsonWriter.writeArray(jsonArray);

            System.out.println(sw);
        }
	}
	
	public static List<Post> createPosts() {

		List<Post> posts = new ArrayList<>();
		// create a post
        Post post = new Post();
        post.setTitle("JSONP Tutorial");
        post.setId(100);
        post.setDescription("Post about JSONP");
        post.setContent("HTML content here");

        String[] tags = {"Java", "JSON"};
        // create some predefined tags
        post.setTags(tags);

        
     // create a post
        Post post1 = new Post();
        post1.setTitle("Jackson Tutorial");
        post1.setId(100);
        post1.setDescription("Post about Jackson API");
        post1.setContent("HTML content here");
        // create some predefined tags
        post1.setTags(new String[] {"Java", "JSON", "Jackson"});
        
     // create a post
        Post post2 = new Post();
        post2.setTitle("Google Gson Tutorial");
        post2.setId(100);
        post2.setDescription("Post about Google Gson");
        post2.setContent("HTML content here");

        // create some predefined tags
        post2.setTags(new String[] {"Java", "JSON", "Gson"});
        
        posts.add(post);
        posts.add(post1);
        posts.add(post2);
        return posts;
    }
}
