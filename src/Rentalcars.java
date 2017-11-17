import javax.servlet.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

// import java API to read from 
// JavaScriopt Object Notation file
// and parse it into Java
// for this exercise I need an array of objects
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Rentalcars {
	private static String test1 = new String("");
	private static String test2 = new String("");
	private static String test3 = new String("");
	private static String test4 = new String("");
	
	// check Internet connection by for example connecting to google
	private static boolean netIsAvailable() {
	    try {
	        final URL url = new URL("http://www.google.com");
	        final URLConnection conn = url.openConnection();
	        conn.connect();
	        return true;
	    } catch (MalformedURLException e) {
	        throw new RuntimeException(e);
	    } catch (IOException e) {
	        return false;
	    }
	}

	public static void main(String[] args) {	
		// this is my parser from JSON file to the JSON Java API Types
		JSONParser myParser = new JSONParser();
    	
    	// always perform code in a try statement if there is a 
    	// threat of the code that will result in runtime error
		try {      
			// check for Internet connection
            if (!netIsAvailable()) {
            	System.out.print("There is no internet connection.");
            	return;
            }
            
            // firstly, I try to open a URL connection and read from the given file
            URLConnection connectionToVehiclesJSON = new URL("http://www.rentalcars.com/js/vehicles.json").openConnection();
            BufferedReader input = new BufferedReader(new InputStreamReader(connectionToVehiclesJSON.getInputStream()));

            // then I create a JSONObject variable to
            // store the parsed object from the online JSON file
            JSONObject jsonObj = new JSONObject();
            jsonObj = (JSONObject) myParser.parse(input);
            // since the JSON file has 1 object inside called "Search"
            // I try to parse it into a JSONObject type variable
            JSONObject search = new JSONObject();
            search = (JSONObject) jsonObj.get("Search");
            // since the "Search" object has only one array called "VehicleList"
            // I try to parse it into a JSONArray type variable
            JSONArray vehicleList = new JSONArray();
            vehicleList = (JSONArray) search.get("VehicleList");

//_____________________________________________
// PART 1.1
                     System.out.println("____________");
                     System.out.println("__PART 1.1__");
                     System.out.println("____________");            
            
            // I add all of the cars into a new ArrayList of JSONObjects
            ArrayList<JSONObject> sortedVehicleList = new ArrayList<JSONObject>();            
            for (Object o : vehicleList) 
            	sortedVehicleList.add((JSONObject) o);     
   
            // since the ArrayList java type is a built in Java Collection
            // I can use the built in sort method with a custom Comparator 
            // by overriding the compare method to sort the JSONObjects in
            // our freshly made ArrayList in ascending price order
            Collections.sort(sortedVehicleList, new Comparator<JSONObject>() {
            	@Override
				public int compare(JSONObject obj1, JSONObject obj2) {
					
					double price1 = (double) obj1.get("price");					
					double price2 = (double) obj2.get("price");
					
					// from low to high price
					if (price1 > price2) return  1;
					else 				 return -1;
            	}
            });
            
            // I store the output in a variable I use for testing
            int ctr = 1;  
            for (JSONObject o : sortedVehicleList) {  	
            	test1+= ctr + ". " 
            			+ "{" + o.get("name")  + "}" + " - " 
            			+ "{" + o.get("price") + "}" 
            			+ "\n";      	
            	ctr++;
            }
            
            // I print the output on the console 	
        	System.out.println(test1);
            
//_____________________________________________
// PART 1.2
            System.out.println("____________");
            System.out.println("__PART 1.2__");
            System.out.println("____________");

            // I create HasMaps with keys and values for each
    		// of the four letters of the SIPP to be used.
    		// This is the first letter mapping to value
    		HashMap<String, String> carType = new HashMap<String, String>();
            carType.put("M", "Mini");
            carType.put("E", "Economy");
            carType.put("C", "Compact");
            carType.put("I", "Intermediate");
            carType.put("S", "Standard");
        	carType.put("F", "Full size");
        	carType.put("P", "Premium");
        	carType.put("L", "Luxury");
        	carType.put("X", "Special");
            
        	// This is the second letter mapping to value
        	HashMap<String, String> doorsCarType = new HashMap<String, String>();	
        	doorsCarType.put("B", "2 doors");
        	doorsCarType.put("C", "4 doors");
        	doorsCarType.put("D", "5 doors");
        	doorsCarType.put("W", "Estate");
        	doorsCarType.put("T", "Convertible");
        	doorsCarType.put("F", "SUV");
        	doorsCarType.put("P", "Pick up");
        	doorsCarType.put("V", "Passenger Van");
        	doorsCarType.put("X", "Special");
            
        	// This is the third letter mapping to value
        	HashMap<String, String> transmission = new HashMap<String, String>();
        	transmission.put("M", "Manual");
        	transmission.put("A", "Automatic");

        	// This is the fourth letter mapping to value
        	HashMap<String, String> petrolAirConditioer = new HashMap<String, String>();
        	petrolAirConditioer.put("N", "Petrol/no AC");
        	petrolAirConditioer.put("R", "Petrol/AC");

        	// this is where I use the HashMaps for each letter from the SIPP
        	// in order to print the final results
            ctr = 1;
            // for each car object in the vehicleList JSONArray
            for (Object o : vehicleList) {
            	    	
            	// I create a variable to cast the Object into a JSONObject 
            	// so that Java knows I'm not using an ordinary object
            	// this is the car object
				JSONObject myJSONObject = (JSONObject) o;
				// get car name for printing in final result
				String carName = (String) myJSONObject.get("name"); 
				// and for each car object I parse the SIPP value
            	String sipp = (String) myJSONObject.get("sipp");

            	// split all letters into a string array
            	String[] sippLetters = sipp.split("");
            	
            	// extract the current car type value 
            	// by providing the letter as a key to the carType HashMap
            	String currentCarTypeLetter = sippLetters[0]; 
            	String currentCarTypeValue = carType.get(currentCarTypeLetter);
            	// put the car type key in the table
            	myJSONObject.put("carType", currentCarTypeValue);            	
            	
            	// extract the current doors car type value 
            	// by providing the letter as a key to the doorsCarType HashMap
            	String currentDoorsCarTypeLetter = sippLetters[1]; 
            	String currentDoorsCarTypeValue = doorsCarType.get(currentDoorsCarTypeLetter);
            	
            	// extract the current transmission value 
            	// by providing the letter as a key to the transmission HashMap
            	String currentTransmissionLetter = sippLetters[2]; 
            	String currentTransmissionValue = transmission.get(currentTransmissionLetter);
            	
            	// extract the current petrol and Air Conditioer value 
            	// by providing the letter as a key to the petrolAirConditioer HashMap
            	String currentfuelACLetter = sippLetters[3]; 
            	String currentfuelACValue = petrolAirConditioer.get(currentfuelACLetter);
            	// then we split the result into two parts as shown
            	String[] parts = currentfuelACValue.split("/");
            	String myFuel = parts[0];
            	String myAC = parts[1];
            	
            	// I store the output in a variable I use for testing
            	test2+= ctr + ". " 
            			+ "{" + carName					 		 + "}" + " - " 
            			+ "{" + sipp					         + "}" + " - " 
            			+ "{" + currentCarTypeValue			     + "}" + " - " 
            			+ "{" + currentDoorsCarTypeValue		 + "}" + " - "
            			+ "{" + currentTransmissionValue 		 + "}" + " - "
            			+ "{" + myFuel + "}" + " - "
            			+ "{" + myAC + "}"
            			+ "\n";      	
            	ctr++;
            }
            
            // I print the output on the console 
            System.out.println(test2);

//_____________________________________________
// PART 1.3
            System.out.println("____________");
            System.out.println("__PART 1.3__");
            System.out.println("____________");    
            
            // I add all of the cars into a new ArrayList of JSONObjects
            ArrayList<JSONObject> sortedVehicleListPart3 = new ArrayList<JSONObject>();            
            for (Object o : vehicleList) 
            	sortedVehicleListPart3.add((JSONObject) o);     
   
            // by overriding the compare method to sort the JSONObjects in
            // our freshly made ArrayList in descending rating order
            Collections.sort(sortedVehicleListPart3, new Comparator<JSONObject>() {
				@Override
				public int compare(JSONObject car1, JSONObject car2) {
					double currentRating1 = 0;
					double currentRating2 = 0;
					
					// check if rating 1 has a floating point
                    if (!(car1.get("rating") instanceof Double))
                    	currentRating1 = ((Long)car1.get("rating")).doubleValue(); 
                    else
                    	currentRating1 = (Double) car1.get("rating");  
                    
                 // check if rating 2 has a floating point
                    if (!(car2.get("rating") instanceof Double))
                    	currentRating2 = ((Long)car2.get("rating")).doubleValue(); 
                    else
                    	currentRating2 = (Double) car2.get("rating");  

					// descending order
					if (currentRating1 > currentRating2) return -1;					
					else 				 				 return  1;
				}
            });
	               
	        ctr = 1;
	        // I store the output in a variable I use for testing
	        for (JSONObject car : sortedVehicleListPart3) {  
	        	test3+= ctr + ". " 
	        			+ "{" + car.get("name")     + "}" + " - " 
	        			+ "{" + car.get("carType")  + "}" + " - " 
	        			+ "{" + car.get("supplier") + "}" + " - "
	        			+ "{" + car.get("rating")   + "}"
	        			+ "\n";      	
	        	ctr++;
            }
            
	        // I print the output on the console 	
            System.out.println(test3);      
            
//_____________________________________________
// PART 1.4
            System.out.println("____________");
            System.out.println("__PART 1.4__");
            System.out.println("____________");
            
            // create a temporary hash table containing the Supplier and the sum of 
            // vehicle score and supplier rating  
            HashMap<String, Double> calculatedVehicleScoresTable = new HashMap<String, Double>();
            
            // here I add the vehicle score and the supplier rating score into our new table
            for (Object o : vehicleList) {     
            	// I create a variable to cast the Object into a JSONObject 
            	// so that Java knows I'm not using an ordinary object
            	// this is the car object 
            	JSONObject myJSONObject = (JSONObject) o;

            	// add additional breakdown score 
            	double breakdownScore = 0;            	
            	String sipp = (String) myJSONObject.get("sipp");
            	if (Character.toString(sipp.charAt(2)).equals("M"))
            		breakdownScore += 1;
            	if (Character.toString(sipp.charAt(2)).equals("A"))
            		breakdownScore += 5;
            	if (Character.toString(sipp.charAt(3)).equals("R"))
            		breakdownScore += 2;
            	// put a column with the vehicle breakdown score
            	myJSONObject.put("breakdownScore", breakdownScore);
            	
            	// temp var to hold sum of scores
            	double sumOfScores = breakdownScore;
        		// extract currentRating
            	double currentRating = 0;
                if (!(myJSONObject.get("rating") instanceof Double))
                	currentRating = ((Long)myJSONObject.get("rating")).doubleValue();
                else
                	currentRating = (Double) myJSONObject.get("rating");    
        		
                // add both scores together
                sumOfScores += currentRating;
                // put a new column with the scores
        		myJSONObject.put("sumOfScores", sumOfScores);
            } 
            
            // by overriding the compare method to sort the JSONObjects in
            // our freshly made ArrayList in descending order of
            // sum of vehicle score and supplier rating  
            ArrayList<JSONObject> orderedCalculatedVehicleScoresTable = new ArrayList<JSONObject>();           
            for (Object obj : vehicleList) {        
            	JSONObject myObj = (JSONObject) obj;
            	orderedCalculatedVehicleScoresTable.add((JSONObject) myObj);
            }
            
            // sort by total score in descending order
            Collections.sort(orderedCalculatedVehicleScoresTable, new Comparator<JSONObject>() {
				@Override
				public int compare(JSONObject obj1, JSONObject obj2) {
					Double totalScore1 = (Double) obj1.get("sumOfScores");				
					Double totalScore2 = (Double) obj2.get("sumOfScores");
					
					if (totalScore1 > totalScore2) return -1;					
					else 					       return  1;
				}
            });                
            
            ctr = 1;    
	        // I store the output in a variable I use for testing
            for (Object obj : orderedCalculatedVehicleScoresTable) {        
            	JSONObject myObj = (JSONObject) obj;
	        	test4+= "" + ctr + ". " 
	        			+ "{" + myObj.get("name") 		  	+ "}" + " - " 
	        			+ "{" + myObj.get("breakdownScore") + "}" + " - " 
	        			+ "{" + myObj.get("rating")       	+ "}" + " - "
	        			+ "{" + myObj.get("sumOfScores") 	+ "}"
	        			+ "\n";      	
	        	ctr++;
            }

            // I print the output on the console 
            System.out.println(test4);
 
            input.close();            	
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }  	
	}
	
	public String getTest1(){
		return test1;
	}
	
	public String getTest2(){
		return test2;
	}
	
	public String getTest3(){
		return test3;
	}
	
	public String getTest4(){
		return test4;
	}
}