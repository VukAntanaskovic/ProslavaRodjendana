package controller;

import java.io.IOException;
import java.net.URL;

import org.eclipse.jdt.internal.compiler.classfmt.ExternalAnnotationProvider.IMethodAnnotationWalker;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Korisnik;
import models.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Login.logovanjeKorisnika(email, password);
		if(Login.status == true) {
			HttpSession sesija = request.getSession();
			sesija.setAttribute("korisnik", Login.ime+ " " + Login.prezime);
			sesija.setAttribute("kor_sifra", Login.sifra);
			sesija.setAttribute("kor_uloga", Login.uloga);
			response.sendRedirect(models.URL.baseUrl);
		}
		else {
			HttpSession sesija = request.getSession();
			sesija.setAttribute("poruka", "Uneli ste pogresan email ili password");
			response.sendRedirect(models.URL.baseUrl);
		}
		
	}

}
