package StepDefinitions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.util.Properties;

import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.Json;

public class JSONParser {

		public static String JSON_Object_ByFileName(String jsonFileName) throws FileNotFoundException, IOException
		{
			Properties prop = new Properties();
			String projectPath = System.getProperty("user.dir");
			 System.out.println("here is the paaaaatttttttthhhh: " + projectPath + "\\TestData\\" + jsonFileName);
	
				JSONParser parser = new JSONParser();
				JSONObject jo = new JSONObject();
				Object obj = Json.parse(new FileReader( projectPath + "\\TestData\\" + jsonFileName));
					
					System.out.println(" here is json parser:::::::::::            " + obj.toString());
				
				return obj.toString();
			}

		
	
}
