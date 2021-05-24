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
 * Servlet implementation class OdobravanjeProslaveServlet
 */
@WebServlet("/OdobravanjeProslaveServlet")
public class OdobravanjeProslaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public OdobravanjeProslaveServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sifraProslave =Integer.parseInt(request.getParameter("sifraProslave"));
		String cena = request.getParameter("cena");
		Proslava.odobriProslavu(sifraProslave, Double.parseDouble(cena));
		HttpSession sesija = request.getSession();
		sesija.setAttribute("poruka", "Uspesno ste odobrili proslavu pod brojem: " +sifraProslave);
		response.sendRedirect(models.URL.baseUrl + "?p=PregledZahtevaZaProslavu");
		
	}

}
