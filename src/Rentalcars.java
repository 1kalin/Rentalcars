import javax.servlet.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Rentalcars {
	private static String test1 = new String("");
	private static String test2 = new String("");
	private static String test3 = new String("");
	private static String test4 = new String("");
	
	public static void main(String[] args) {	
		JSONParser myParser = new JSONParser();
		
		// vars for PART 1.2
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
        
    	HashMap<String, String> transmission = new HashMap<String, String>();
    	transmission.put("M", "Manual");
    	transmission.put("A", "Automatic");

    	HashMap<String, String> petrolAirConditioer = new HashMap<String, String>();
    	petrolAirConditioer.put("N", "Petrol/no AC");
    	petrolAirConditioer.put("R", "Petrol/AC");
    	
    	ArrayList<HashMap<String, String> > sippTable = new ArrayList<HashMap<String, String> >();
    	sippTable.add(carType);
    	sippTable.add(doorsCarType);
    	sippTable.add(transmission);
    	sippTable.add(petrolAirConditioer);
    	
    	String[] sippTableKeys = {"carType", "doorsCarType", "transmission", "petrolAirConditioer"};
    	
		try {         
//_____________________________________________
// PART 1.1
            System.out.println("____________");
            System.out.println("__PART 1.1__");
            System.out.println("____________");
            
            URLConnection connectionToVehiclesJSON = new URL("http://www.rentalcars.com/js/vehicles.json").openConnection();
            BufferedReader input = new BufferedReader(new InputStreamReader(connectionToVehiclesJSON.getInputStream()));
            
            JSONObject jsonObj = new JSONObject();
            jsonObj = (JSONObject) myParser.parse(input);
            JSONObject search = new JSONObject();
            search = (JSONObject) jsonObj.get("Search");
            JSONArray vehicleList = new JSONArray();
            vehicleList = (JSONArray) search.get("VehicleList");

            // sort
            ArrayList<JSONObject> sortedVehicleList = new ArrayList<JSONObject>();            
            for (Object o : vehicleList) 
            	sortedVehicleList.add((JSONObject) o);     
   
            Collections.sort(sortedVehicleList, new Comparator<JSONObject>() {
            	@Override
				public int compare(JSONObject obj1, JSONObject obj2) {
					
					double price1 = (double) obj1.get("price");					
					double price2 = (double) obj2.get("price");
					
					if (price1 > price2) return  1;
					else 				 return -1;
            	}
            });
             
            int ctr = 1;  
            for (JSONObject o : sortedVehicleList) {  	
            	test1+= ctr + ". " 
            			+ "{" + o.get("name")  + "}" + " - " 
            			+ "{" + o.get("price") + "}" 
            			+ "\n";      	
            	ctr++;
            }
            
        	System.out.println(test1);
            
//_____________________________________________
// PART 1.2
            System.out.println("____________");
            System.out.println("__PART 1.2__");
            System.out.println("____________");

            ctr = 1;
            for (Object o : vehicleList) {
            	    	
				JSONObject myJSONObject = (JSONObject) o;
            	String sipp = (String) myJSONObject.get("sipp");
 
            	for (int i = 0; i < sipp.length(); i++) {
            		String currentKey = sippTableKeys[i];
            		String currentValue = sippTable.get(i).get(Character.toString(sipp.charAt(i)));
            		myJSONObject.put(currentKey, currentValue);
            	}
            	
        		//String currentKey = sippTableKeys[4];
        		//String currentValue = sippTable.get(4).get(Character.toString(sipp.charAt(3)));
        		//myJSONObject.put(currentKey, currentValue);

            	String fuelAC = (String) myJSONObject.get("petrolAirConditioer");
            	String[] parts = fuelAC.split("/");
            	String myFuel = parts[0];
            	String myAC = parts[1];
            	
            	test2+= ctr + ". " 
            			+ "{" + myJSONObject.get("sipp")         + "}" + " - " 
            			+ "{" + myJSONObject.get("carType")      + "}" + " - " 
            			+ "{" + myJSONObject.get("doorsCarType") + "}" + " - "
            			+ "{" + myJSONObject.get("transmission") + "}" + " - "
            			+ "{" + myFuel + "}" + " - "
            			+ "{" + myAC + "}"
            			+ "\n";      	
            	ctr++;
            }
            
            System.out.println(test2);

//_____________________________________________
// PART 1.3
            System.out.println("____________");
            System.out.println("__PART 1.3__");
            System.out.println("____________");    
            
            double carRating;
            HashMap<String, JSONObject> calculatedRatingTable = new HashMap<String, JSONObject>();
            double calculatedRating;
            
            ctr = 1;
            for (Object o : vehicleList) {        
            	JSONObject myJSONObject = (JSONObject) o;

                String type = (String) myJSONObject.get("cartype");
                String doorsType = (String) myJSONObject.get("doorsCarType");
                String fullCarType = type + " " + doorsType; 
                
                if (!(myJSONObject.get("rating") instanceof Double))
                	carRating = ((Long)myJSONObject.get("rating")).doubleValue(); 
                else
                	carRating = (Double) myJSONObject.get("rating");                 	

            	if (calculatedRatingTable.containsKey("cartype")) {
            		JSONObject calculation = (JSONObject) calculatedRatingTable.get(type);

                    if (!(myJSONObject.get("rating") instanceof Double))
                    	calculatedRating = ((Long)myJSONObject.get("rating")).doubleValue(); 
                    else
                    	calculatedRating = (Double) myJSONObject.get("rating");    
            		
            		if (calculatedRating < carRating)
            			calculatedRatingTable.put(fullCarType, myJSONObject);
            		else
        			calculatedRatingTable.put(fullCarType, myJSONObject);
            } 
            
            ArrayList<JSONObject> sortedCalculatedRatingTable = new ArrayList<JSONObject>();
            
            for (String tempType : calculatedRatingTable.keySet()){
            	JSONObject tempObject = (JSONObject) calculatedRatingTable.get(tempType);
            	sortedCalculatedRatingTable.add(tempObject);
            }
            
            Collections.sort(sortedCalculatedRatingTable, new Comparator<JSONObject>() {
				@Override
				public int compare(JSONObject o1, JSONObject o2) {
					double rating1 = (double) o1.get("rating");
					double rating2 = (double) o2.get("rating");

					if (rating1 > rating2) return -1;					
					else 				   return  1;
				}
            });
                
        	test3+= ctr + ". " 
        			+ "{" + myJSONObject.get("name")     + "}" + " - " 
        			+ "{" + myJSONObject.get("carType")  + "}" + " - " 
        			+ "{" + myJSONObject.get("supplier") + "}" + " - "
        			+ "{" + myJSONObject.get("rating")   + "}"
        			+ "\n";      	
        	ctr++;
            }
            
            System.out.println(test3);      
            
//_____________________________________________
// PART 1.4
            System.out.println("____________");
            System.out.println("__PART 1.4__");
            System.out.println("____________");  
            
            Map<String, Double> calculatedVehicleScoresTable = new HashMap<String, Double>();
            
            ctr = 1;
            for (Object o : vehicleList) {        
            	JSONObject myJSONObject = (JSONObject) o;
            	
            	double currentScore = 0;
            	double totalScore = 0;
            	
            	String sipp = (String) myJSONObject.get("sipp");
            	if (Character.toString(sipp.charAt(2)).equals("M"))
            		currentScore += 1;
            	if (Character.toString(sipp.charAt(2)).equals("A"))
            		currentScore += 5;
            	if (Character.toString(sipp.charAt(3)).equals("R"))
            		currentScore += 2;
            	myJSONObject.put("vehicleScore", currentScore);
            	
            	String tempSupplier = "";
            	double tempScore = 0;

        		tempSupplier = (String) myJSONObject.get("supplier");
        		tempScore = (Double) myJSONObject.get("vehicleScore");

                if (!(myJSONObject.get("rating") instanceof Double))
                	calculatedRating = ((Long)myJSONObject.get("rating")).doubleValue(); 
                else
                	calculatedRating = (Double) myJSONObject.get("rating");    
        		
        		tempScore+= calculatedRating;
        		calculatedVehicleScoresTable.put(tempSupplier, tempScore);

        		myJSONObject.put("totalScore", calculatedVehicleScoresTable.get(myJSONObject.get("supplier")));
            } 
            
            ArrayList<JSONObject> orderedCalculatedVehicleScoresTable = new ArrayList<JSONObject>();           
            for (Object obj : vehicleList) {        
            	JSONObject myObj = (JSONObject) obj;
            	orderedCalculatedVehicleScoresTable.add((JSONObject) myObj);
            }
            Collections.sort(orderedCalculatedVehicleScoresTable, new Comparator<JSONObject>() {
				@Override
				public int compare(JSONObject obj1, JSONObject obj2) {
					Double totalScore1 = (Double) obj1.get("totalScore");				
					Double totalScore2 = (Double) obj2.get("totalScore");
					
					if (totalScore1 > totalScore2) return -1;					
					else 					       return  1;
				}
            });                
            
            ctr = 1;    
            for (Object obj : orderedCalculatedVehicleScoresTable) {        
            	JSONObject myObj = (JSONObject) obj;
	        	test4+= "" + ctr + ". " 
	        			+ "{" + myObj.get("name") 		  + "}" + " - " 
	        			+ "{" + myObj.get("vehicleScore") + "}" + " - " 
	        			+ "{" + myObj.get("rating")       + "}" + " - "
	        			+ "{" + myObj.get("totalScore")  + "}"
	        			+ "\n";      	
	        	ctr++;
            }

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