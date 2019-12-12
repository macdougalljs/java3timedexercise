
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class JuiceFactory
 */
@WebServlet("/JuiceFactory")
public class JuiceFactory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Fruit> fruitList;

	/**
	 * Default constructor.
	 */
	public JuiceFactory() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();

		int appleQ = Integer.parseInt(request.getParameter("appleQ"));
		int orangeQ = Integer.parseInt(request.getParameter("orangeQ"));
		int grapeQ = Integer.parseInt(request.getParameter("grapeQ"));

		double applePrice = Double.parseDouble(request.getParameter("Appleprice"));
		double orangePrice = Double.parseDouble(request.getParameter("Orangeprice"));
		double grapePrice = Double.parseDouble(request.getParameter("Grapeprice"));
		double totalCost = 0;

		fruitList = (List<Fruit>) request.getSession().getAttribute("fruitList");
		if (fruitList == null) 
			fruitList = new CopyOnWriteArrayList<Fruit>();

		
		// add a line of apple to array, one per pound
		Fruit apple = new Fruit("apple");
		Fruit orange = new Fruit("orange");
		Fruit grape = new Fruit("grape");
		
		
		for (int x = 0; x < appleQ; x++) {
			fruitList.add(apple);
			totalCost = totalCost + applePrice;
			System.out.println("test loop 1");
		}

		for (int x = 0; x < orangeQ; x++) {
			fruitList.add(orange);
			totalCost = totalCost + orangePrice;
			System.out.println("test loop 2");
		}


		for (int x = 0; x < grapeQ; x++) {
			fruitList.add(grape);
			totalCost = totalCost + grapePrice;
			System.out.println("test loop 3");
		}

		
		System.out.println(appleQ + " " + orangeQ + " " + grapeQ);
		System.out.println("Length of List: " + fruitList.size());
		System.out.println("total cost:" + totalCost);

		request.getSession().setAttribute("fruitList", fruitList);
		request.getSession().setAttribute("totalCost", totalCost);

		// get the DBconnection info from the context
		
		DBConnect conn = new DBConnect("com.mysql.cj.jdbc.Driver",
				"jdbc:mysql://localhost:3306/fruitsdb?useSSL=false",
				"root","root");
				
		
		// create new dataaccess object

		DataAccess dao = new DataAccess();
		
		// send the record to the database
		boolean done = dao.insertRow(conn.getConnect(), appleQ, orangeQ, grapeQ, totalCost);
		System.out.println("Result of insert " + done);

		RequestDispatcher rd = request.getRequestDispatcher("View.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
