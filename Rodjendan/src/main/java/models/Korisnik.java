package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Korisnik {
	
	 public static ArrayList<KorisnikHelper> vratiSveKorisnike() {
		 try {
		 Connection connection = DriverManager.getConnection(URL.dbUrl, URL.dbUsername, URL.dbPassword);
		 String upit = "SELECT k.kor_sifra, k.kor_ime, k.kor_prezime, k.kor_email,k.kor_uloga, u.ulg_naziv FROM korisnik k INNER JOIN uloga u on k.kor_uloga = u.ulg_sifra ORDER BY k.kor_sifra ASC";
		 Statement stm = connection.createStatement();
		 ResultSet rsl = stm.executeQuery(upit);
		 ArrayList<KorisnikHelper> listaKorisnika = new ArrayList<KorisnikHelper>();
		 int i = 0;
		 while(rsl.next()) {
			 int sifra = rsl.getInt("kor_sifra");
			 String ime = rsl.getString("kor_ime");
			 String prezime = rsl.getString("kor_prezime");
			 String email = rsl.getString("kor_email");
			 int uloga = rsl.getInt("kor_uloga");
			 String nazivUloga = rsl.getString("ulg_naziv");
			 listaKorisnika.add(new KorisnikHelper(sifra, ime, prezime, email, uloga, nazivUloga));
		 }
		 return listaKorisnika;
		 }
		 catch (Exception e) {
			System.out.println("Neuspesno " + e.getMessage());
			return null;
		}
	 }
	 
	 public static void brisiKoisnika(int Sifra) {
		 try {
			 Connection connection = DriverManager.getConnection(URL.dbUrl, URL.dbUsername, URL.dbPassword);
			 String upit = "DELETE FROM korisnik WHERE kor_sifra = " + Sifra;
			 PreparedStatement pstmt = connection.prepareStatement(upit);
			 pstmt.execute();
		 }
		 catch (Exception e) {
			System.out.println("Neuspesno " + e.getMessage());
		}
	 }
	 
	 public static void autorizujKorisnika(int Sifra, int uloga) {
		 try {
			 Connection connection = DriverManager.getConnection(URL.dbUrl, URL.dbUsername, URL.dbPassword);
			 String upit = "UPDATE korisnik SET kor_uloga = ? WHERE kor_sifra = " +Sifra;
			 PreparedStatement pstmt = connection.prepareStatement(upit);
			 pstmt.setInt(1 , uloga);
			 pstmt.executeUpdate();
		 }
		 catch (Exception e) {
			System.out.println("Neuspesno " + e.getMessage());
		}
	 }
}
