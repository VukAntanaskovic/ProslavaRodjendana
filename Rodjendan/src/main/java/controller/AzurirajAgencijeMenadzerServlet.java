package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.SveAgencije;

/**
 * Servlet implementation class AzurirajAgencijeMenadzerServlet
 */
@WebServlet("/AzurirajAgencijeMenadzerServlet")
public class AzurirajAgencijeMenadzerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AzurirajAgencijeMenadzerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String naziv = request.getParameter("naziv");
		String adresa = request.getParameter("adresa");
		String telefon = request.getParameter("telefon");
		String opis = request.getParameter("opis");
		int sifra =Integer.parseInt(request.getParameter("sifra"));
		SveAgencije.izmeniAgenciju(sifra, naziv, adresa, telefon, opis);
		HttpSession sesija = request.getSession();
		sesija.setAttribute("poruka", "Uspesno ste izmenili agenciju");
		String page = (String) sesija.getAttribute("p");
		response.sendRedirect("index.jsp?p=Agencija");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
