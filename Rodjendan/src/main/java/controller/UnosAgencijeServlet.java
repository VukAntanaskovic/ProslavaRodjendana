package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import models.Korisnik;
import models.SveAgencije;

/**
 * Servlet implementation class UnosAgencijeServlet
 */
@WebServlet("/UnosAgencijeServlet")
@MultipartConfig
public class UnosAgencijeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UnosAgencijeServlet() {
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
		String naziv = request.getParameter("naziv");
		int menadzer = Integer.parseInt(request.getParameter("menadzer"));
		String adresa = request.getParameter("adresa");
		String telefon = request.getParameter("telefon");
		String slika = request.getParameter("slika");
		String opis = request.getParameter("opis");
		Part part1 = request.getPart("slika");
		String putFajla = "C:\\Users\\vuk.antanaskovic\\eclipse-workspace\\Rodjendan\\src\\main\\webapp\\assets\\img\\";
		Part filePart = request.getPart("slika");
	    InputStream fileInputStream = filePart.getInputStream();
	    File fileToSave = new File(putFajla + filePart.getSubmittedFileName());
		Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
		slika = "assets/img/" + filePart.getSubmittedFileName();
		SveAgencije.dodajAgenciju(naziv, adresa, telefon, slika, opis, menadzer);
		Korisnik.autorizujKorisnika(menadzer, 2);
		HttpSession sesija = request.getSession();
		sesija.setAttribute("poruka", "Uspesno ste dodali agenciju");
		response.sendRedirect("index.jsp?p=AgencijeAdmin");
		
	}

}
