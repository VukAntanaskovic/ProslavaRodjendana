package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Proslava;

/**
 * Servlet implementation class BrisanjeProslaveServlet
 */
@WebServlet("/BrisanjeProslaveServlet")
public class BrisanjeProslaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BrisanjeProslaveServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sifraProslave =Integer.parseInt(request.getParameter("sifraProslave"));
		Proslava.brisiProslavu(sifraProslave);
		HttpSession sesija = request.getSession();
		sesija.setAttribute("poruka", "Uspesno ste otkazali proslavu");
		response.sendRedirect(models.URL.baseUrl);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
