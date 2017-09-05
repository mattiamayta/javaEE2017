package Calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calcServlet
 */
@WebServlet("/calcServlet")
public class calcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valore1 = request.getParameter("first");
		String valore2 = request.getParameter("second");
		double num1=0;
		double num2=0;

		PrintWriter writer = response.getWriter();
		try {
			num1 = Double.parseDouble(valore1);
			num2 = Double.parseDouble(valore2);
		} catch (NumberFormatException e1) {
			writer.println("Numeri scritti male");
			return;
		}
		double ris=0;
		String operazione = request.getParameter("operazione");
		
		try {
		switch(operazione) {
		case "Somma":
			ris=num1+num2;
			break;
		case "Sottrai":
			ris=num1-num2;
			break;
		case "Moltiplica":
			ris=num1*num2;
			break;
		case "Dividi":
			ris=num1/num2;
			break;
		}
		writer.println(ris);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		writer.close();
	}
	

}
