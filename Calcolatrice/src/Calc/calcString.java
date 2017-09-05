package Calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calcString
 */
@WebServlet("/calcString")
public class calcString extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calcString() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operazione = request.getParameter("stringa");
		String [] split = operazione.split("[-+*/]");
		PrintWriter writer = response.getWriter();
		double val1=0;
		double val2=0;
		try {
			val1 = Double.parseDouble(split[0]);
			val2 = Double.parseDouble(split[1]);
		} catch (NumberFormatException e) {
			writer.println("Stringa scritta male");
			return;
		}
		
		double ris=0;
		if(operazione.contains("+")) 
			ris=val1+val2;
		else if(operazione.contains("-"))
			ris=val1-val2;
		else if(operazione.contains("*"))
			ris=val1*val2;
		else if(operazione.contains("/"))
			ris=val1/val2;
		else {
			writer.println("Stringa scritta male");
			return;
		}
		
		writer.println(ris);
		
		writer.close();
	}

}
