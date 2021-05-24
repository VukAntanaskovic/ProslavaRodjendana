package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Korisnik;

/**
 * Servlet implementation class BrisanjeKorisnika
 */
@WebServlet("/BrisanjeKorisnika")
public class BrisanjeKorisnika extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrisanjeKorisnika() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sifraKorisnika = Integer.parseInt(request.getParameter("sifraKorisnika")); 
		Korisnik.brisiKoisnika(sifraKorisnika);
		HttpSession sesija = request.getSession();
		sesija.setAttribute("poruka", "Uspesno ste obrisali korisnika");
		response.sendRedirect("index.jsp?p=Korisnici");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
