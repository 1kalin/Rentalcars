

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet()");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		System.out.println("doPost()");
		
		Rentalcars rc = new Rentalcars();
		rc.main(null);
		String test1 = rc.getTest1();
		String test2 = rc.getTest2();
		String test3 = rc.getTest3();
		String test4 = rc.getTest4();

		response.getWriter().println("//_____________________________________________");
		response.getWriter().println("// PART 1.1");
		response.getWriter().println(test1);
		
		response.getWriter().println("//_____________________________________________");
		response.getWriter().println("// PART 1.2");
		response.getWriter().println(test2);

		response.getWriter().println("//_____________________________________________");
		response.getWriter().println("// PART 1.3");
		response.getWriter().println(test3);

		response.getWriter().println("//_____________________________________________");
		response.getWriter().println("// PART 1.4");
		response.getWriter().println(test4);
	}

}
