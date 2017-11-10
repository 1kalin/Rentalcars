import static org.junit.Assert.*;
import org.junit.Test;

public class RentalcarsTest {
	@Test
	public void test1() {
		Rentalcars rc = new Rentalcars();
		rc.main(null);
		String result = rc.getTest1();
		String expected = new String(
				"1. {ChevroletSpark} - {120.16}\n"
				+ "2. {Kia Picanto} - {136.57}\n"
				+ "3. {Vauxhall Corsa} - {139.93}\n"
				+ "4. {Citroen C4} - {146.7}\n"
				+ "5. {Ford Focus} - {157.85}\n"
				+ "6. {Ford Focus} - {157.85}\n"
				+ "7. {VW Golf} - {188.97}\n"
				+ "8. {VW Golf} - {209.97}\n"
				+ "9. {VW Golf} - {209.97}\n"
				+ "10. {Skoda Fabia} - {219.71}\n"
				+ "11. {Skoda Fabia} - {219.71}\n"
				+ "12. {Chevrolet Cruze} - {229.45}\n"
				+ "13. {Audi A1} - {234.76}\n"
				+ "14. {Skoda Octavia} - {236.24}\n"
				+ "15. {VW Golf Estate} - {239.56}\n"
				+ "16. {Skoda Fabia} - {240.71}\n"
				+ "17. {Kia Ceed Estate} - {311.03}\n"
				+ "18. {Kia Ceed Estate} - {311.03}\n"
				+ "19. {Vauxhall Zafira} - {319.63}\n"
				+ "20. {Vauxhall Zafira} - {323.63}\n"
				+ "21. {Ford Mondeo} - {339.31}\n"
				+ "22. {Nissan Juke} - {356.28}\n"
				+ "23. {Ford Mondeo} - {365.31}\n"
				+ "24. {Ford Mondeo} - {365.31}\n"
				+ "25. {Nissan Juke} - {463.56}\n"
				+ "26. {VW Passat Estate} - {469.37}\n"
				+ "27. {VW Jetta} - {508.96}\n"
				+ "28. {VW Jetta} - {508.96}\n"
				+ "29. {Ford Galaxy} - {706.89}\n"
				+ "30. {VW Sharan} - {753.75}\n"
				+ "31. {VW Sharan} - {789.75}\n");

		//Check that two objects are equal
	    assertEquals(expected, result);	
	}
	
	@Test
	public void test2() {
	Rentalcars rc2 = new Rentalcars();
	String result = new String();
	result = rc2.getTest2();
	String expected = new String(
			"1. {CDMR} - {Compact} - {5 doors} - {Manual} - {Petrol} - {AC}\n"
			+ "2. {FVAR} - {Full size} - {Passenger Van} - {Automatic} - {Petrol} - {AC}\n"
			+ "3. {IWMR} - {Intermediate} - {Estate} - {Manual} - {Petrol} - {AC}\n"
			+ "4. {CWMR} - {Compact} - {Estate} - {Manual} - {Petrol} - {AC}\n"
			+ "5. {IDAR} - {Intermediate} - {5 doors} - {Automatic} - {Petrol} - {AC}\n"
			+ "6. {CCAR} - {Compact} - {4 doors} - {Automatic} - {Petrol} - {AC}\n"
			+ "7. {SDMR} - {Standard} - {5 doors} - {Manual} - {Petrol} - {AC}\n"
			+ "8. {IDMR} - {Intermediate} - {5 doors} - {Manual} - {Petrol} - {AC}\n"
			+ "9. {ECMR} - {Economy} - {4 doors} - {Manual} - {Petrol} - {AC}\n"
			+ "10. {MBMN} - {Mini} - {2 doors} - {Manual} - {Petrol} - {no AC}\n"
			+ "11. {ECMR} - {Economy} - {4 doors} - {Manual} - {Petrol} - {AC}\n"
			+ "12. {CCMR} - {Compact} - {4 doors} - {Manual} - {Petrol} - {AC}\n"
			+ "13. {CDMR} - {Compact} - {5 doors} - {Manual} - {Petrol} - {AC}\n"
			+ "14. {CWMR} - {Compact} - {Estate} - {Manual} - {Petrol} - {AC}\n"
			+ "15. {IDMR} - {Intermediate} - {5 doors} - {Manual} - {Petrol} - {AC}\n"
			+ "16. {CDAR} - {Compact} - {5 doors} - {Automatic} - {Petrol} - {AC}\n"
			+ "17. {CXMR} - {Compact} - {Special} - {Manual} - {Petrol} - {AC}\n"
			+ "18. {IVMR} - {Intermediate} - {Passenger Van} - {Manual} - {Petrol} - {AC}\n"
			+ "19. {FVMR} - {Full size} - {Passenger Van} - {Manual} - {Petrol} - {AC}\n"
			+ "20. {CDAR} - {Compact} - {5 doors} - {Automatic} - {Petrol} - {AC}\n"
			+ "21. {CXMR} - {Compact} - {Special} - {Manual} - {Petrol} - {AC}\n"
			+ "22. {IVMR} - {Intermediate} - {Passenger Van} - {Manual} - {Petrol} - {AC}\n"
			+ "23. {FVMR} - {Full size} - {Passenger Van} - {Manual} - {Petrol} - {AC}\n"
			+ "24. {IDAR} - {Intermediate} - {5 doors} - {Automatic} - {Petrol} - {AC}\n"
			+ "25. {CCAR} - {Compact} - {4 doors} - {Automatic} - {Petrol} - {AC}\n"
			+ "26. {SDMR} - {Standard} - {5 doors} - {Manual} - {Petrol} - {AC}\n"
			+ "27. {CDMR} - {Compact} - {5 doors} - {Manual} - {Petrol} - {AC}\n"
			+ "28. {CXMR} - {Compact} - {Special} - {Manual} - {Petrol} - {AC}\n"
			+ "29. {SDMR} - {Standard} - {5 doors} - {Manual} - {Petrol} - {AC}\n"
			+ "30. {CDAR} - {Compact} - {5 doors} - {Automatic} - {Petrol} - {AC}\n"
			+ "31. {CWMR} - {Compact} - {Estate} - {Manual} - {Petrol} - {AC}\n");

	//Check that two objects are equal
    assertEquals(expected, result);	
}	
	
	@Test
	public void test3() {
	Rentalcars rc3 = new Rentalcars();
	String result = new String();
	result = rc3.getTest3();
	String expected = new String(
			"1. {Ford Focus} - {Compact} - {Hertz} - {8.9}\n"
			+ "2. {Ford Galaxy} - {Full size} - {Hertz} - {8.9}\n"
			+ "3. {VW Passat Estate} - {Intermediate} - {Hertz} - {8.9}\n"
			+ "4. {Kia Ceed Estate} - {Compact} - {Hertz} - {8.9}\n"
			+ "5. {VW Jetta} - {Intermediate} - {Hertz} - {8.9}\n"
			+ "6. {Nissan Juke} - {Compact} - {Hertz} - {8.9}\n"
			+ "7. {Ford Mondeo} - {Standard} - {Hertz} - {8.9}\n"
			+ "8. {Skoda Octavia} - {Intermediate} - {Hertz} - {8.9}\n"
			+ "9. {Vauxhall Corsa} - {Economy} - {Hertz} - {8.9}\n"
			+ "10. {Kia Picanto} - {Mini} - {Hertz} - {8.9}\n"
			+ "11. {ChevroletSpark} - {Economy} - {Sixt} - {8.2}\n"
			+ "12. {Audi A1} - {Compact} - {Sixt} - {8.2}\n"
			+ "13. {Citroen C4} - {Compact} - {Sixt} - {8.2}\n"
			+ "14. {VW Golf Estate} - {Compact} - {Sixt} - {8.2}\n"
			+ "15. {Chevrolet Cruze} - {Intermediate} - {Sixt} - {8.2}\n"
			+ "16. {Skoda Fabia} - {Compact} - {Sixt} - {8.2}\n"
			+ "17. {VW Golf} - {Compact} - {Sixt} - {8.2}\n"
			+ "18. {Vauxhall Zafira} - {Intermediate} - {Sixt} - {8.2}\n"
			+ "19. {VW Sharan} - {Full size} - {Sixt} - {8.2}\n"
			+ "20. {Skoda Fabia} - {Compact} - {Europcar} - {8}\n"
			+ "21. {VW Golf} - {Compact} - {Europcar} - {8}\n"
			+ "22. {Vauxhall Zafira} - {Intermediate} - {Europcar} - {8}\n"
			+ "23. {VW Sharan} - {Full size} - {Europcar} - {8}\n"
			+ "24. {VW Jetta} - {Intermediate} - {Europcar} - {8}\n"
			+ "25. {Nissan Juke} - {Compact} - {Europcar} - {8}\n"
			+ "26. {Ford Mondeo} - {Standard} - {Europcar} - {8}\n"
			+ "27. {Ford Focus} - {Compact} - {Alamo} - {7.8}\n"
			+ "28. {VW Golf} - {Compact} - {Alamo} - {7.8}\n"
			+ "29. {Ford Mondeo} - {Standard} - {Alamo} - {7.8}\n"
			+ "30. {Skoda Fabia} - {Compact} - {Alamo} - {7.8}\n"
			+ "31. {Kia Ceed Estate} - {Compact} - {Alamo} - {7.8}\n");

	//Check that two objects are equal
    assertEquals(expected, result);	
	}	
	
	@Test
	public void test4() {
	Rentalcars rc4 = new Rentalcars();
	String result = new String();
	result = rc4.getTest4();
	String expected = new String(
			"1. {Ford Galaxy} - {7.0} - {8.9} - {15.9}\n"
			+ "2. {VW Jetta} - {7.0} - {8.9} - {15.9}\n"
			+ "3. {Nissan Juke} - {7.0} - {8.9} - {15.9}\n"
			+ "4. {Skoda Fabia} - {7.0} - {8.2} - {15.2}\n"
			+ "5. {Skoda Fabia} - {7.0} - {8} - {15.0}\n"
			+ "6. {VW Jetta} - {7.0} - {8} - {15.0}\n"
			+ "7. {Nissan Juke} - {7.0} - {8} - {15.0}\n"
			+ "8. {Skoda Fabia} - {7.0} - {7.8} - {14.8}\n"
			+ "9. {Ford Focus} - {3.0} - {8.9} - {11.9}\n"
			+ "10. {VW Passat Estate} - {3.0} - {8.9} - {11.9}\n"
			+ "11. {Kia Ceed Estate} - {3.0} - {8.9} - {11.9}\n"
			+ "12. {Ford Mondeo} - {3.0} - {8.9} - {11.9}\n"
			+ "13. {Skoda Octavia} - {3.0} - {8.9} - {11.9}\n"
			+ "14. {Vauxhall Corsa} - {3.0} - {8.9} - {11.9}\n"
			+ "15. {ChevroletSpark} - {3.0} - {8.2} - {11.2}\n"
			+ "16. {Audi A1} - {3.0} - {8.2} - {11.2}\n"
			+ "17. {Citroen C4} - {3.0} - {8.2} - {11.2}\n"
			+ "18. {VW Golf Estate} - {3.0} - {8.2} - {11.2}\n"
			+ "19. {Chevrolet Cruze} - {3.0} - {8.2} - {11.2}\n"
			+ "20. {VW Golf} - {3.0} - {8.2} - {11.2}\n"
			+ "21. {Vauxhall Zafira} - {3.0} - {8.2} - {11.2}\n"
			+ "22. {VW Sharan} - {3.0} - {8.2} - {11.2}\n"
			+ "23. {VW Golf} - {3.0} - {8} - {11.0}\n"
			+ "24. {Vauxhall Zafira} - {3.0} - {8} - {11.0}\n"
			+ "25. {VW Sharan} - {3.0} - {8} - {11.0}\n"
			+ "26. {Ford Mondeo} - {3.0} - {8} - {11.0}\n"
			+ "27. {Ford Focus} - {3.0} - {7.8} - {10.8}\n"
			+ "28. {VW Golf} - {3.0} - {7.8} - {10.8}\n"
			+ "29. {Ford Mondeo} - {3.0} - {7.8} - {10.8}\n"
			+ "30. {Kia Ceed Estate} - {3.0} - {7.8} - {10.8}\n"
			+ "31. {Kia Picanto} - {1.0} - {8.9} - {9.9}\n");

	//Check that two objects are equal
    assertEquals(expected, result);	
	}	

}
