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
 * Servlet implementation class UnosProslaveServlet
 */
@WebServlet("/UnosProslaveServlet")
public class UnosProslaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UnosProslaveServlet() {
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
		HttpSession sesija = request.getSession(); 
		String sifraAgencije = request.getParameter("sifraAgencije");
		int sifraKorisnika = (int)sesija.getAttribute("kor_sifra");
		String brojZvanica = request.getParameter("brojZvanica");
		String vremeOd = request.getParameter("vremeOd");
		String vremeDo = request.getParameter("vremeDo");
		String datum = request.getParameter("datum");
		Proslava.dodajProslavu(Integer.parseInt(sifraAgencije), sifraKorisnika, datum, vremeOd, vremeDo, Integer.parseInt(brojZvanica));
		sesija.setAttribute("poruka", "Uspesno ste uneli zahtev za proslavu");
		response.sendRedirect(models.URL.baseUrl);
	}

}
