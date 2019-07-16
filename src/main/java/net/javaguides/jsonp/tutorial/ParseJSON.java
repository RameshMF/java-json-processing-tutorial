package net.javaguides.jsonp.tutorial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.json.stream.JsonParserFactory;


/**
 * Class to parse a json using jsonp.
 * @author Ramesh fadatare
 *
 */

public class ParseJSON {
	
	public static void main(String[] args) throws FileNotFoundException {

		InputStream is = new FileInputStream("posts.json");

		JsonParserFactory factory = Json.createParserFactory(null);
        JsonParser parser = factory.createParser(is, StandardCharsets.UTF_8);

        if (!parser.hasNext() && parser.next() != JsonParser.Event.START_ARRAY) {
            return;
        }

        // looping over object attributes
        while (parser.hasNext()) {

            Event event = parser.next();

            // starting object
            if (event == JsonParser.Event.START_OBJECT) {

                while (parser.hasNext()) {

                    event = parser.next();

                    if (event == JsonParser.Event.KEY_NAME) {

                        String key = parser.getString();

                        switch (key) {

                            case "id":
                                parser.next();

                                System.out.printf("id: %s%n", parser.getString());
                                break;

                            case "title":
                                parser.next();

                                System.out.printf("title: %s%n", parser.getString());
                                break;

                            case "description":
                                parser.next();

                                System.out.printf("description: %s%n%n", parser.getString());
                                break;
                                
                            case "content":
                                parser.next();

                                System.out.printf("content: %s%n%n", parser.getString());
                                break;
                        }
                    }
                }
            }
        }
    }
}
