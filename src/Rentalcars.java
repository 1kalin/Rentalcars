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
	}//netIsAvailable()

	
	// return a json array of vehicles from the json file
	private static JSONArray returnVehicleListFromJSONFile() 
			throws FileNotFoundException,IOException, ParseException {  
			// check for Internet connection
            if (!netIsAvailable()) {
            	System.out.print("There is no internet connection.");
            	return null;
            }
            // firstly, I try to open a URL connection and read from the given file
            URLConnection connectionToVehiclesJSON = new URL("http://www.rentalcars.com/js/vehicles.json").openConnection();
            BufferedReader input = new BufferedReader(new InputStreamReader(connectionToVehiclesJSON.getInputStream()));

    		// this is my parser from JSON file to the JSON Java API Types
    		JSONParser myParser = new JSONParser();
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
            JSONArray vehicleList = (JSONArray) search.get("VehicleList");
            input.close();
            return vehicleList;
	}//returnVehicleListFromJSONFile()
	
	
	private static ArrayList<JSONObject> sortJSONArray(JSONArray vehicleList, String key, String order) {
		// I add all of the cars into a new ArrayList of JSONObjects
		ArrayList<JSONObject> sortedVehicleList = new ArrayList<JSONObject>();            
		for (Object o : vehicleList)
			sortedVehicleList.add((JSONObject) o);     
		
		// since the ArrayList java type is a built in Java Collection
		// I can use the built in sort method with a custom Comparator 
		// by overriding the compare method to sort the JSONObjects in
		// our freshly made ArrayList in our order
		Collections.sort(sortedVehicleList, new Comparator<JSONObject>() {
			@Override
			public int compare(JSONObject obj1, JSONObject obj2) {
				double value1 = 0;				
				double value2 = 0;
				
				if (key == "rating") {
					JSONObject[] twoCars = {obj1, obj2};
					double[] twoRatings = new double[2];
					for (int i=0;i<2;i++)
					{
						// check if rating has a floating point
		                if (twoCars[i].get("rating") instanceof Double)
		                	twoRatings[i] = (Double) twoCars[i].get("rating");	
		                else
		                	twoRatings[i] = ((Long)twoCars[i].get("rating")).doubleValue(); 	
					}
					value1 = twoRatings[0];
					value2 = twoRatings[1];
				}//if
				else {
					value1 = (double) obj1.get(key);					
					value2 = (double) obj2.get(key);
				}

				// from low to high price
				if (order == "asc")
				{
					if (value1 > value2) return  1;
					else 				 return -1;
				}
				else { // desc order
					if (value1 > value2) return -1;
					else 				 return  1;
				}
			}
		});		
		
		return sortedVehicleList;
	}//sortJSONArray()
	
	
	// printing system
	private static String formatOutput(ArrayList<JSONObject> sortedArrayList, int taskNum, String[] keys) {
		System.out.println("____________");
        System.out.println("__PART 1."+taskNum+"__");
        System.out.println("____________"); 
		
		int ctr = 1;  
		String output = "";
		for (Object o : sortedArrayList) {  	
			JSONObject myCar = (JSONObject) o;
			output+= ctr + ". ";
			for (String key: keys)
				output += "{" + myCar.get(key)  + "}" + " - ";
			// to get rid of the last dash on the same line
			output = output.substring(0, output.length() - 3);
			output+= "\n";      	
			ctr++;
		}
		return output;	
	}//printFormatedOutput()
	
	
	// task 1 is to print a list of all the cars, 
	// in ascending price order, 
	// in the following format:
	// 1. {Vehicle name} – {Price}
	private static String task1(JSONArray vehicleList) {
		ArrayList<JSONObject> sortedArrayList = sortJSONArray(vehicleList, "price", "asc");
		String[] keys = {"name", "price"};
		return formatOutput(sortedArrayList, 1, keys);
	}//task1()

	
	// task 2 is to map SSIP and to print results in following format
	// 2.	{Vehicle name} – {SIPP} – {Car type} – {Car type/doors} – {Transmission} – {Fuel} – {Air con}
	private static String task2(JSONArray vehicleList) {
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
        // for each car object in the vehicleList JSONArray
        for (Object o : vehicleList) {	
        	// I create a variable to cast the Object into a JSONObject 
        	// so that Java knows I'm not using an ordinary object
        	// this is the car object
			JSONObject myJSONObject = (JSONObject) o;
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
        	myJSONObject.put("doorsCarType", currentDoorsCarTypeValue); 
        	
        	// extract the current transmission value 
        	// by providing the letter as a key to the transmission HashMap
        	String currentTransmissionLetter = sippLetters[2]; 
        	String currentTransmissionValue = transmission.get(currentTransmissionLetter);
        	myJSONObject.put("transmission", currentTransmissionValue); 
        	
        	// extract the current petrol and Air Conditioer value 
        	// by providing the letter as a key to the petrolAirConditioer HashMap
        	String currentfuelACLetter = sippLetters[3]; 
        	String currentfuelACValue = petrolAirConditioer.get(currentfuelACLetter);

        	// then we split the result into two parts as shown
        	String[] parts = currentfuelACValue.split("/");
        	String myFuel = parts[0];
        	myJSONObject.put("fuel", myFuel); 
        	String myAC = parts[1];
        	myJSONObject.put("ac", myAC); 
        }//for
		String[] keys = {"name", "sipp", "carType", "doorsCarType", 
									  "transmission", "fuel", "ac"};
		return formatOutput(vehicleList, 2, keys);
	}//task2()


	// task 3 is to print highest rated supplier in desc order in this format:
	// 3.	{Vehicle name} – {Car type} – {Supplier} – {Rating}
	private static String task3(JSONArray vehicleList) {
		ArrayList<JSONObject> sortedArrayList = sortJSONArray(vehicleList, "rating", "desc");
		String[] keys = {"name", "carType", "supplier", "rating"};
		return formatOutput(sortedArrayList, 3, keys);
    }//task3()

	// task 4 is to combine breakdown and rating scores and print in desc order
	// 4.	{Vehicle name} – {Vehicle score} – {Supplier rating} – {Sum of scores}
	private static String task4(JSONArray vehicleList) {
        // here I add the vehicle score and the supplier rating score 
		// and add a new column to our existing table
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
        }//for
        
		ArrayList<JSONObject> sortedArrayList = sortJSONArray(vehicleList, "sumOfScores", "desc");
		String[] keys = {"name", "breakdownScore", "rating", "sumOfScores"};
		return formatOutput(sortedArrayList, 4, keys);
    }//task4()

	
	public static void main(String[] args) {	  
		// the vehicleList JSONArray object
		JSONArray vehicleList = new JSONArray();
    	// always perform code in a try statement if there is a 
    	// threat of the code that will result in runtime error
		try {      
			vehicleList = returnVehicleListFromJSONFile();
			if (vehicleList==null) return;
			
			// PART 1.1
            String task1Output = task1(vehicleList);
            System.out.println(task1Output);
            test1 = task1Output;
            
            // PART 1.2
            String task2Output = task2(vehicleList);
            System.out.println(task2Output);
            test2 = task2Output;
	
            // PART 1.3
            String task3Output = task3(vehicleList);
            System.out.println(task3Output);
            test3 = task3Output;
            
            // PART 1.4
            String task4Output = task4(vehicleList);
            System.out.println(task4Output);
            test4 = task4Output;	
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }  	
	}//main()
	
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
