package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Korisnik;
import models.URL;

/**
 * Servlet implementation class AutorizacijaKorisnikaServlet
 */
@WebServlet("/AutorizacijaKorisnikaServlet")
public class AutorizacijaKorisnikaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AutorizacijaKorisnikaServlet() {
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
		int sifra = Integer.parseInt(request.getParameter("sifraKorisnika"));
		int uloga = Integer.parseInt(request.getParameter("nivoAutorizacije"));
		Korisnik.autorizujKorisnika(sifra, uloga);
		HttpSession sesija = request.getSession();
		sesija.setAttribute("poruka", "Uspesno ste dodelili autorizaciju");
		response.sendRedirect(URL.baseUrl + "?p=Korisnici");
	}

}
