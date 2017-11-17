import static org.junit.Assert.*;
import java.util.HashMap;
import org.junit.Test;

public class RentalcarsTest {
	@Test
	public void test1() {
		// create a new class, run main method, get first task output in a var
		Rentalcars rc = new Rentalcars();
		rc.main(null);
		String result = rc.getTest1();

		// 0) test if result is not null
		assertTrue(result!=null);

		// 1) test for formatting: {} - {}
		// split the results into an array for each line
		String[] resultLines = result.split("\\n");
		for (String line: resultLines)
			assertTrue(line.matches("\\d+\\.\\s\\"
					 				+ "{[[a-zA-Z]*[\\d]*\\s*]*\\}\\s\\-\\s\\"	// vehicle name
					 				+ "{\\d*\\.\\d*\\}"));						// price
		
		// 2) test if each vehicle name neither price are null
		// or not empty string and do some additional testing
		double currentPrice = 0;
		double previousPrice = 0;
		for (String line: resultLines)
		{
			// split twice to get the values
			String[] firstSplit = line.split("\\{");
			
			String[] secondSplit1 = firstSplit[1].split("\\}");
			String vehicleName = secondSplit1[0];
			// check if there is a string
			assertTrue(vehicleName!=null);
			// check if that string is not empty
			assertTrue(!vehicleName.isEmpty());

		    String[] secondSplit2 = firstSplit[2].split("\\}");
		    String price = secondSplit2[0];
			// check if there is a string
			assertTrue(price!=null);
			// check if that string is not empty
			assertTrue(!price.isEmpty());
			// check if that string is a number
			assertTrue(price.matches("[[\\d]*[\\.]*]*"));
			
			// 3) test that every next number of price is larger
			currentPrice = Double.parseDouble(price);
			assertTrue(currentPrice >= previousPrice);
			//System.out.println("currentPrice:"+currentPrice+" previousPrice:" +previousPrice);
			previousPrice = currentPrice;
		}//for
		
	}//test1
	
	
	
	@Test
	public void test2() {
		// some hash tables for testing letters
		// This is the first letter mapping to value
		HashMap<String, String> carTypeTable = new HashMap<String, String>();
		carTypeTable.put("M", "Mini");
		carTypeTable.put("E", "Economy");
		carTypeTable.put("C", "Compact");
		carTypeTable.put("I", "Intermediate");
		carTypeTable.put("S", "Standard");
        carTypeTable.put("F", "Full size");
        carTypeTable.put("P", "Premium");
        carTypeTable.put("L", "Luxury");
        carTypeTable.put("X", "Special");
        
    	// This is the second letter mapping to value
    	HashMap<String, String> doorsCarTypeTable = new HashMap<String, String>();	
    	doorsCarTypeTable.put("B", "2 doors");
    	doorsCarTypeTable.put("C", "4 doors");
    	doorsCarTypeTable.put("D", "5 doors");
    	doorsCarTypeTable.put("W", "Estate");
    	doorsCarTypeTable.put("T", "Convertible");
    	doorsCarTypeTable.put("F", "SUV");
    	doorsCarTypeTable.put("P", "Pick up");
    	doorsCarTypeTable.put("V", "Passenger Van");
    	doorsCarTypeTable.put("X", "Special");
        
    	// This is the third letter mapping to value
    	HashMap<String, String> transmissionTable = new HashMap<String, String>();
    	transmissionTable.put("M", "Manual");
    	transmissionTable.put("A", "Automatic");

    	// This is the fourth letter mapping to value
    	HashMap<String, String> airConditioerTable = new HashMap<String, String>();
    	airConditioerTable.put("N", "no AC");
    	airConditioerTable.put("R", "AC");

		// create a new class, run main method, get first task output in a var
		Rentalcars rc = new Rentalcars();
		rc.main(null);
		String result = rc.getTest2();

		// 0) test if result is not null
		assertTrue(result!=null);
		
		// 1) test for formatting: {} - {} - {} - {} - {} - {} - {}
		// split the results into an array for each line
		String[] resultLines = result.split("\\n");
		for (String line: resultLines)
			assertTrue(line.matches("\\d+\\.\\s\\"
									+ "{[[a-zA-Z]*[\\d]*\\s*]*\\}\\s\\-\\s\\"		// vehicle name
									+ "{[A-Z][A-Z][A-Z][A-Z]\\}\\s\\-\\s\\"			// sipp
									+ "{[[a-zA-Z]*[\\s]*]*\\}\\s\\-\\s\\"			// car type
									+ "{[[\\d]*[a-zA-Z]*[\\s]*]*\\}\\s\\-\\s\\"		// door car type
									+ "{[a-zA-Z]*\\}\\s\\-\\s\\"					// transmission
									+ "{[a-zA-Z]*\\}\\s\\-\\s\\"					// fuel
									+ "{[[a-zA-Z]*[\\s]*]*\\}"));					// ac
		
		// 2) test if each element is not null
		// or is not an empty string
		// and some additional testing
		double currentPrice = 0;
		double previousPrice = 0;
		for (String line: resultLines)
		{
			// split twice to get the values
			String[] firstSplit = line.split("\\{");
			
			String[] secondSplit1 = firstSplit[1].split("\\}");
			String vehicleName = secondSplit1[0];
			// check if there is a string
			assertTrue(vehicleName!=null);
			// check if that string is not empty
			assertTrue(!vehicleName.isEmpty());

		    String[] secondSplit2 = firstSplit[2].split("\\}");
		    String sipp = secondSplit2[0];
			// check if there is a string
			assertTrue(sipp!=null);
			// check if that string is not empty
			assertTrue(!sipp.isEmpty());
			
		    String[] secondSplit3 = firstSplit[3].split("\\}");
		    String carType = secondSplit3[0];
			// check if there is a string
			assertTrue(carType!=null);
			// check if that string is not empty
			assertTrue(!carType.isEmpty());
			
		    String[] secondSplit4 = firstSplit[4].split("\\}");
		    String carDoorType = secondSplit4[0];
			// check if there is a string
			assertTrue(carDoorType!=null);
			// check if that string is not empty
			assertTrue(!carDoorType.isEmpty());
			
		    String[] secondSplit5 = firstSplit[5].split("\\}");
		    String transmission = secondSplit5[0];
			// check if there is a string
			assertTrue(transmission!=null);
			// check if that string is not empty
			assertTrue(!transmission.isEmpty());
			
		    String[] secondSplit6 = firstSplit[6].split("\\}");
		    String fuel = secondSplit6[0];
			// check if there is a string
			assertTrue(fuel!=null);
			// check if that string is not empty
			assertTrue(!fuel.isEmpty());
			
		    String[] secondSplit7 = firstSplit[7].split("\\}");
		    String ac = secondSplit7[0];
			// check if there is a string
			assertTrue(ac!=null);
			// check if that string is not empty
			assertTrue(!ac.isEmpty());
			
			
			// 3) check if the SIPP value exists and is correct
			char carTypeChar = sipp.charAt(0);
			String carTypeKey = carTypeChar + "";
			assertTrue(carTypeTable.keySet().contains(carTypeKey));
			String carTypeTest = carTypeTable.get(carTypeKey);
			assertEquals(carTypeTest, carType);			
			
			char carDoorTypeChar = sipp.charAt(1);	
			String carDoorTypeKey = carDoorTypeChar + "";
			assertTrue(doorsCarTypeTable.keySet().contains(carDoorTypeKey));
			String doorsCarTypeTest = doorsCarTypeTable.get(carDoorTypeKey);
			assertEquals(doorsCarTypeTest, carDoorType);		
	
			char transmissionChar = sipp.charAt(2);
			String transmissionKey = transmissionChar + "";
			assertTrue(transmissionTable.keySet().contains(transmissionKey));
			String transmissionTest = transmissionTable.get(transmissionKey);
			assertEquals(transmissionTest, transmission);		

			char acChar = sipp.charAt(3);
			String acKey = acChar + "";
			assertTrue(airConditioerTable.keySet().contains(acKey));
			String acTest = airConditioerTable.get(acKey);
			assertEquals(acTest, ac);		

		}//for

	}//test2
	
	
	
	@Test
	public void test3() {
		// create a new class, run main method, get first task output in a var
		Rentalcars rc = new Rentalcars();
		rc.main(null);
		String result = rc.getTest3();

		// 0) test if result is not null
		assertTrue(result!=null);
		
		// 1) test for formatting: {} - {} - {} - {}
		// split the results into an array for each line
		String[] resultLines = result.split("\\n");
		for (String line: resultLines)
			assertTrue(line.matches("\\d+\\.\\s\\"
									+ "{[[a-zA-Z]*[\\d]*\\s*]*\\}\\s\\-\\s\\"		// vehicle name
									+ "{[[a-zA-Z]*[\\s]*]*\\}\\s\\-\\s\\"			// car type
									+ "{[a-zA-Z]*\\}\\s\\-\\s\\"					// supplier
									+ "{[[\\d]*[\\.]*]*\\}"));						// rating

		// 2) test if each element is not null
		// or not empty string and do some additional testing
		double currentRating = 0;
		double previousRating = Integer.MAX_VALUE;
		for (String line: resultLines)
		{
			// split twice to get the values
			String[] firstSplit = line.split("\\{");
			
			String[] secondSplit1 = firstSplit[1].split("\\}");
			String vehicleName = secondSplit1[0];
			// check if there is a string
			assertTrue(vehicleName!=null);
			// check if that string is not empty
			assertTrue(!vehicleName.isEmpty());

			String[] secondSplit2 = firstSplit[2].split("\\}");
			String carType = secondSplit2[0];
			// check if there is a string
			assertTrue(carType!=null);
			// check if that string is not empty
			assertTrue(!carType.isEmpty());
			
			String[] secondSplit3 = firstSplit[3].split("\\}");
			String supplier = secondSplit3[0];
			// check if there is a string
			assertTrue(supplier!=null);
			// check if that string is not empty
			assertTrue(!supplier.isEmpty());
			
		    String[] secondSplit4 = firstSplit[4].split("\\}");
		    String rating = secondSplit4[0];
			// check if there is a string
			assertTrue(rating!=null);
			// check if that string is not empty
			assertTrue(!rating.isEmpty());
			// check if that string is a number
			assertTrue(rating.matches("[[\\d]*[\\.]*]*"));
			System.out.println("currentRating:"+rating);

			// 3) test that every next number of rating is smaller
			currentRating = Double.parseDouble(rating);
			assertTrue(currentRating <= previousRating);
			previousRating = currentRating;
		}//for
	
	}//test3
	
	@Test
	public void test4() {
		// create a new class, run main method, get first task output in a var
		Rentalcars rc = new Rentalcars();
		rc.main(null);
		String result = rc.getTest4();

		// 0) test if result is not null
		assertTrue(result!=null);
		
		// 1) test for formatting: {} - {} - {} - {} 
		// split the results into an array for each line
		String[] resultLines = result.split("\\n");
		for (String line: resultLines)
			assertTrue(line.matches("\\d+\\.\\s\\"
									+ "{[[a-zA-Z]*[\\d]*\\s*]*\\}\\s\\-\\s\\"		// vehicle name
									+ "{[[\\d]*[\\.]*]*\\}\\s\\-\\s\\"				// breakdown score
									+ "{[[\\d]*[\\.]*]*\\}\\s\\-\\s\\"				// rating
									+ "{[[\\d]*[\\.]*]*\\}"));						// sum of scores
		

		// 2) test if each value is not null
		// or not empty string and do some additional testing
		double currentSumOfScores = 0;
		double previousSumOfScores = Integer.MAX_VALUE;
		for (String line: resultLines)
		{
			// split twice to get the values
			String[] firstSplit = line.split("\\{");
			
			String[] secondSplit1 = firstSplit[1].split("\\}");
			String vehicleName = secondSplit1[0];
			// check if there is a string
			assertTrue(vehicleName!=null);
			// check if that string is not empty
			assertTrue(!vehicleName.isEmpty());
	
			String[] secondSplit2 = firstSplit[2].split("\\}");
			String breakdownScore = secondSplit2[0];
			// check if there is a string
			assertTrue(breakdownScore!=null);
			// check if that string is not empty
			assertTrue(!breakdownScore.isEmpty());			
			// check if that string is a number
			assertTrue(breakdownScore.matches("[[\\d]*[\\.]*]*"));			
			
			String[] secondSplit3 = firstSplit[3].split("\\}");
			String rating = secondSplit3[0];
			// check if there is a string
			assertTrue(rating!=null);
			// check if that string is not empty
			assertTrue(!rating.isEmpty());			
			// check if that string is a number
			assertTrue(rating.matches("[[\\d]*[\\.]*]*"));					

		    String[] secondSplit4 = firstSplit[4].split("\\}");
		    String sumOfScores = secondSplit4[0];
			// check if there is a string
			assertTrue(sumOfScores!=null);
			// check if that string is not empty
			assertTrue(!sumOfScores.isEmpty());
			// check if that string is a number
			assertTrue(sumOfScores.matches("[[\\d]*[\\.]*]*"));
			
			// 3) test if it is actually the sum of scores
			currentSumOfScores = Double.parseDouble(sumOfScores);
			double currentBreakdownScore = Double.parseDouble(breakdownScore);
			double currentRating = Double.parseDouble(rating);
			assertTrue(currentSumOfScores == (currentBreakdownScore+currentRating));
			
			// 4) test that every next number of sum of scores is smaller
			assertTrue(currentSumOfScores <= previousSumOfScores);
			previousSumOfScores = currentSumOfScores;
		}//for
	
	}//test4
	
}
