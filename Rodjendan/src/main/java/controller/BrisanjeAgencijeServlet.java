package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.AgencijaHelper;
import models.Korisnik;
import models.SveAgencije;

/**
 * Servlet implementation class BrisanjeAgencijeServlet
 */
@WebServlet("/BrisanjeAgencijeServlet")
public class BrisanjeAgencijeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BrisanjeAgencijeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sifraAgencije = Integer.parseInt(request.getParameter("sifraAgencije")); 
		SveAgencije.brisiAgenciju(sifraAgencije);
		HttpSession sesija = request.getSession();
		sesija.setAttribute("poruka", "Uspesno ste obrisali agenciju");
		response.sendRedirect("index.jsp?p=AgencijeAdmin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
