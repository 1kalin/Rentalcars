import static org.junit.Assert.*;
import org.mockito.Mockito;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.*;
import org.apache.commons.io.*;
import org.junit.Test;

public class IndexTest extends Mockito{

    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        Index myServlet = new Index();
        myServlet.doPost(request, response);
        
        // create a the tasks and store the outputs
        // check to see if they are the same from the servlet do post request
        Rentalcars rc = new Rentalcars();
		rc.main(null);
		
		String test1 = rc.getTest1();
		String test2 = rc.getTest2();
		String test3 = rc.getTest3();
		String test4 = rc.getTest4();
		
        writer.flush(); // it may not have been flushed yet...
        assertTrue(writer.toString().contains(test1));
        assertTrue(writer.toString().contains(test2));
        assertTrue(writer.toString().contains(test3));
        assertTrue(writer.toString().contains(test4));
    }//testServlet
}