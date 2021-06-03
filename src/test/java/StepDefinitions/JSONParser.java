package StepDefinitions;

import java.io.FileReader;
 

public class JSONParser {

		public static String JSON_Object_ByFileName(String json)
		{
	
				JSONParser parser = new JSONParser();
				try {
					//Object obj = parser.parse(new FileReader("C:\\Users\\UmaBolisetty\\eclipse-workspace\\CucumberSeleniumFramework\\TestData\\Address.json"));
					return "test";
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return " ";
			}

		
	
}
