package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Proslava {
	public static ArrayList<ProslavaHelper> sveProslaveNaCekanju(int sifraKorisnika){
		 try {
			 Connection connection = DriverManager.getConnection(URL.dbUrl, URL.dbUsername, URL.dbPassword);
			 String upit = "SELECT p.pro_sifra, a.agn_naziv, p.agn_sifra, k.kor_ime, k.kor_prezime, k.kor_sifra, p.pro_cena, p.pro_datum, p.pro_broj_zvanica, p.pro_pocetak, p.pro_kraj, p.pro_status FROM proslava p INNER JOIN agencija a ON a.agn_sifra = p.agn_sifra INNER JOIN korisnik k on k.kor_sifra = p.kor_sifra WHERE p.pro_status IS NULL AND k.kor_sifra = " + sifraKorisnika;
			 Statement stm = connection.createStatement();
			 ResultSet rsl = stm.executeQuery(upit);
			 ArrayList<ProslavaHelper> listaProslava = new ArrayList<ProslavaHelper>();
			 int i = 0;
			 while(rsl.next()) {
				 int proslavaSifra = rsl.getInt("pro_sifra");
				 int agencijaSifra = rsl.getInt("agn_sifra");
				 int korisnikSifra = rsl.getInt("kor_sifra");
				 int brojZvanica = rsl.getInt("pro_broj_zvanica");
				 double cena = rsl.getDouble("pro_cena");
				 String statusText = "•";
				 String ime = rsl.getString("kor_ime");
				 String prezime = rsl.getString("kor_prezime");
				 String agencijaNaziv = rsl.getString("agn_naziv");
				 String datum = rsl.getString("pro_datum");
				 String pocetak = rsl.getString("pro_pocetak");
				 String kraj = rsl.getString("pro_kraj");
				 listaProslava.add(new ProslavaHelper(proslavaSifra, agencijaSifra, korisnikSifra, cena, datum, brojZvanica, pocetak, kraj, statusText, agencijaNaziv, ime, prezime));
			 }
			 return listaProslava;
			 }
			 catch (Exception e) {
				System.out.println("Neuspesno " + e.getMessage());
				return null;
			}
	}
	public static ArrayList<ProslavaHelper> sveProslaveOdobrene(int sifraKorisnika){
		 try {
			 Connection connection = DriverManager.getConnection(URL.dbUrl, URL.dbUsername, URL.dbPassword);
			 String upit = "SELECT p.pro_sifra, a.agn_naziv, p.agn_sifra, k.kor_ime, k.kor_prezime, k.kor_sifra, p.pro_cena, p.pro_datum, p.pro_broj_zvanica, p.pro_pocetak, p.pro_kraj, p.pro_status FROM proslava p INNER JOIN agencija a ON a.agn_sifra = p.agn_sifra INNER JOIN korisnik k on k.kor_sifra = p.kor_sifra WHERE p.pro_status = 1 AND k.kor_sifra = " + sifraKorisnika;
			 Statement stm = connection.createStatement();
			 ResultSet rsl = stm.executeQuery(upit);
			 ArrayList<ProslavaHelper> listaProslava = new ArrayList<ProslavaHelper>();
			 int i = 0;
			 while(rsl.next()) {
				 int proslavaSifra = rsl.getInt("pro_sifra");
				 int agencijaSifra = rsl.getInt("agn_sifra");
				 int korisnikSifra = rsl.getInt("kor_sifra");
				 int brojZvanica = rsl.getInt("pro_broj_zvanica");
				 double cena = rsl.getDouble("pro_cena");
				 String statusText = "•";
				 String ime = rsl.getString("kor_ime");
				 String prezime = rsl.getString("kor_prezime");
				 String agencijaNaziv = rsl.getString("agn_naziv");
				 String datum = rsl.getString("pro_datum");
				 String pocetak = rsl.getString("pro_pocetak");
				 String kraj = rsl.getString("pro_kraj");
				 listaProslava.add(new ProslavaHelper(proslavaSifra, agencijaSifra, korisnikSifra, cena, datum, brojZvanica, pocetak, kraj, statusText, agencijaNaziv, ime, prezime));
			 }
			 return listaProslava;
			 }
			 catch (Exception e) {
				System.out.println("Neuspesno " + e.getMessage());
				return null;
			}
	}
	
	public static ArrayList<ProslavaHelper> sveProslaveNaCekanjuMenadzer(int sifraKorisnika){
		 try {
			 Connection connection = DriverManager.getConnection(URL.dbUrl, URL.dbUsername, URL.dbPassword);
			 String upit = "SELECT p.pro_sifra, a.agn_naziv,a.kor_menadzer, p.agn_sifra, k.kor_ime, k.kor_prezime, k.kor_sifra, p.pro_cena, p.pro_datum, p.pro_broj_zvanica, p.pro_pocetak, p.pro_kraj, p.pro_status FROM proslava p INNER JOIN agencija a ON a.agn_sifra = p.agn_sifra INNER JOIN korisnik k on k.kor_sifra = p.kor_sifra WHERE p.pro_status IS NULL AND a.kor_menadzer = " + sifraKorisnika;
			 Statement stm = connection.createStatement();
			 ResultSet rsl = stm.executeQuery(upit);
			 ArrayList<ProslavaHelper> listaProslava = new ArrayList<ProslavaHelper>();
			 int i = 0;
			 while(rsl.next()) {
				 int proslavaSifra = rsl.getInt("pro_sifra");
				 int agencijaSifra = rsl.getInt("agn_sifra");
				 int korisnikSifra = rsl.getInt("kor_sifra");
				 int brojZvanica = rsl.getInt("pro_broj_zvanica");
				 double cena = rsl.getDouble("pro_cena");
				 String statusText = "•";
				 String ime = rsl.getString("kor_ime");
				 String prezime = rsl.getString("kor_prezime");
				 String agencijaNaziv = rsl.getString("agn_naziv");
				 String datum = rsl.getString("pro_datum");
				 String pocetak = rsl.getString("pro_pocetak");
				 String kraj = rsl.getString("pro_kraj");
				 listaProslava.add(new ProslavaHelper(proslavaSifra, agencijaSifra, korisnikSifra, cena, datum, brojZvanica, pocetak, kraj, statusText, agencijaNaziv, ime, prezime));
			 }
			 return listaProslava;
			 }
			 catch (Exception e) {
				System.out.println("Neuspesno " + e.getMessage());
				return null;
			}
	}
	
	public static ArrayList<ProslavaHelper> sveProslaveOdobreneMenadzer(int sifraKorisnika){
		 try {
			 Connection connection = DriverManager.getConnection(URL.dbUrl, URL.dbUsername, URL.dbPassword);
			 String upit = "SELECT p.pro_sifra, a.agn_naziv,a.kor_menadzer, p.agn_sifra, k.kor_ime, k.kor_prezime, k.kor_sifra, p.pro_cena, p.pro_datum, p.pro_broj_zvanica, p.pro_pocetak, p.pro_kraj, p.pro_status FROM proslava p INNER JOIN agencija a ON a.agn_sifra = p.agn_sifra INNER JOIN korisnik k on k.kor_sifra = p.kor_sifra WHERE p.pro_status = 1 AND a.kor_menadzer = " + sifraKorisnika;
			 Statement stm = connection.createStatement();
			 ResultSet rsl = stm.executeQuery(upit);
			 ArrayList<ProslavaHelper> listaProslava = new ArrayList<ProslavaHelper>();
			 int i = 0;
			 while(rsl.next()) {
				 int proslavaSifra = rsl.getInt("pro_sifra");
				 int agencijaSifra = rsl.getInt("agn_sifra");
				 int korisnikSifra = rsl.getInt("kor_sifra");
				 int brojZvanica = rsl.getInt("pro_broj_zvanica");
				 double cena = rsl.getDouble("pro_cena");
				 String statusText = "•";
				 String ime = rsl.getString("kor_ime");
				 String prezime = rsl.getString("kor_prezime");
				 String agencijaNaziv = rsl.getString("agn_naziv");
				 String datum = rsl.getString("pro_datum");
				 String pocetak = rsl.getString("pro_pocetak");
				 String kraj = rsl.getString("pro_kraj");
				 listaProslava.add(new ProslavaHelper(proslavaSifra, agencijaSifra, korisnikSifra, cena, datum, brojZvanica, pocetak, kraj, statusText, agencijaNaziv, ime, prezime));
			 }
			 return listaProslava;
			 }
			 catch (Exception e) {
				System.out.println("Neuspesno " + e.getMessage());
				return null;
			}
	}
	
	public static void odobriProslavu(int sifraProslave, double cena) {
		 try {
			 Connection connection = DriverManager.getConnection(URL.dbUrl, URL.dbUsername, URL.dbPassword);
			 String upit = "UPDATE proslava SET pro_cena = ?, pro_status = True WHERE pro_sifra = " + sifraProslave;
			 PreparedStatement pstmt = connection.prepareStatement(upit);
			 pstmt.setDouble(1 , cena);
			 pstmt.executeUpdate();
		 }
		 catch (Exception e) {
			System.out.println("Neuspesno " + e.getMessage());
		}
	}
	
	public static void dodajProslavu(int sifraAgencije, int sifraKorisnika, String datum, String odVreme, String doVreme, int brojZvanica) {
		 try {
			 Connection connection = DriverManager.getConnection(URL.dbUrl, URL.dbUsername, URL.dbPassword);
			 String upit = "INSERT INTO proslava VALUES (?, ?, NULL, ?, ?, ?, ?, NULL, NULL)";
			 PreparedStatement pstmt = connection.prepareStatement(upit);
			 pstmt.setInt(1 , sifraAgencije);
			 pstmt.setInt(2 , sifraKorisnika);
			 pstmt.setString(3 , datum);
			 pstmt.setInt(4 , brojZvanica);
			 pstmt.setString(5 , odVreme);
			 pstmt.setString(6 , doVreme);
			 pstmt.executeUpdate();
		 }
		 catch (Exception e) {
			System.out.println("Neuspesno " + e.getMessage());
		}
	 }
	
	public static void brisiProslavu(int Sifra) {
		 try {
			 Connection connection = DriverManager.getConnection(URL.dbUrl, URL.dbUsername, URL.dbPassword);
			 String upit = "DELETE FROM proslava WHERE pro_sifra = " + Sifra;
			 PreparedStatement pstmt = connection.prepareStatement(upit);
			 pstmt.execute();
		 }
		 catch (Exception e) {
			System.out.println("Neuspesno " + e.getMessage());
		}
	 }
}
