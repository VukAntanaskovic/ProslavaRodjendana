package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SveAgencije {
	public static int brojNadjenihAgencija;
	 public static ArrayList<AgencijaHelper> vratiSveAgencije() {
		 try {
		 Connection connection = DriverManager.getConnection(URL.dbUrl, URL.dbUsername, URL.dbPassword);
		 String upit = "SELECT a.agn_sifra, a.agn_naziv, a.agn_adresa, a.agn_telefon, a.agn_slika, a.agn_opis, a.kor_menadzer, k.kor_ime, k.kor_prezime FROM agencija a INNER JOIN Korisnik k ON a.kor_menadzer = k.kor_sifra";
		 Statement stm = connection.createStatement();
		 ResultSet rsl = stm.executeQuery(upit);
		 ArrayList<AgencijaHelper> listaAgencija = new ArrayList<AgencijaHelper>();
		 int i = 0;
		 while(rsl.next()) {
			 int sifra = rsl.getInt("agn_sifra");
			 String naziv = rsl.getString("agn_naziv");
			 String adresa = rsl.getString("agn_adresa");
			 String telefon = rsl.getString("agn_telefon");
			 String slika = rsl.getString("agn_slika");
			 String opis = rsl.getString("agn_opis");
			 int menadzer = rsl.getInt("kor_menadzer");
			 String imeMenadzera = rsl.getString("kor_ime");
			 String prezimeMenadzera = rsl.getString("kor_prezime"); 
			 listaAgencija.add(new AgencijaHelper(sifra, naziv, adresa, telefon, slika, opis, menadzer, imeMenadzera, prezimeMenadzera));
		 }
		 return listaAgencija;
		 }
		 catch (Exception e) {
			System.out.println("Neuspesno " + e.getMessage());
			return null;
		}
	 }
	 public static ArrayList<AgencijaHelper> pretraziAgenciju(String parametar) {
		 try {
		 Connection connection = DriverManager.getConnection(URL.dbUrl, URL.dbUsername, URL.dbPassword);
		 String upit = "SELECT * FROM agencija WHERE agn_naziv LIKE '" +parametar +"%' OR agn_adresa LIKE '" + parametar + "%'";
		 Statement stm = connection.createStatement();
		 ResultSet rsl = stm.executeQuery(upit);
		 ArrayList<AgencijaHelper> listaAgencija = new ArrayList<AgencijaHelper>();
		 int i = 0;
		 while(rsl.next()) {
			 int sifra = rsl.getInt("agn_sifra");
			 String naziv = rsl.getString("agn_naziv");
			 String adresa = rsl.getString("agn_adresa");
			 String telefon = rsl.getString("agn_telefon");
			 String slika = rsl.getString("agn_slika");
			 String opis = rsl.getString("agn_opis");
			 int menadzer = rsl.getInt("kor_menadzer");
			 listaAgencija.add(new AgencijaHelper(sifra, naziv, adresa, telefon, slika, opis, menadzer, "", ""));
		 }
		 brojNadjenihAgencija = listaAgencija.size();
		 System.out.println(brojNadjenihAgencija);
		 return listaAgencija; 
		 }
		 catch (Exception e) {
			System.out.println("Neuspesno " + e.getMessage());
			return null;
		}
	 }
	 
	 public static void dodajAgenciju(String naziv, String adresa, String telefon, String slika, String opis, int menadzer) {
		 try {
			 Connection connection = DriverManager.getConnection(URL.dbUrl, URL.dbUsername, URL.dbPassword);
			 String upit = "INSERT INTO agencija VALUES (NULL, ?, ?, ?, ?, ?, ?)";
			 PreparedStatement pstmt = connection.prepareStatement(upit);
			 pstmt.setString(1 , naziv);
			 pstmt.setString(2 , adresa);
			 pstmt.setString(3 , telefon);
			 pstmt.setString(4 , slika);
			 pstmt.setString(5 , opis);
			 pstmt.setInt(6 , menadzer);
			 pstmt.executeUpdate();
		 }
		 catch (Exception e) {
			System.out.println("Neuspesno " + e.getMessage());
		}
	 }
	 
	 public static void izmeniAgenciju(int sifra, String naziv, String adresa, String telefon, String opis) {
		 try {
			 Connection connection = DriverManager.getConnection(URL.dbUrl, URL.dbUsername, URL.dbPassword);
			 String upit = "UPDATE agencija SET agn_naziv = ?, agn_adresa = ?, agn_telefon=?, agn_opis = ? WHERE agn_sifra = " +sifra;
			 PreparedStatement pstmt = connection.prepareStatement(upit);
			 pstmt.setString(1 , naziv);
			 pstmt.setString(2 , adresa);
			 pstmt.setString(3 , telefon);
			 pstmt.setString(4 , opis);
			 pstmt.executeUpdate();
		 }
		 catch (Exception e) {
			System.out.println("Neuspesno " + e.getMessage());
		}
		 
	 }
	 
	 public static void brisiAgenciju(int sifra) {
		 try {
			 Connection connection = DriverManager.getConnection(URL.dbUrl, URL.dbUsername, URL.dbPassword);
			 String upit = "DELETE FROM agencija WHERE agn_sifra = " +sifra;
			 PreparedStatement pstmt = connection.prepareStatement(upit);
			 pstmt.execute();
		 }
		 catch (Exception e) {
			System.out.println("Neuspesno " + e.getMessage());
		}
		 
	 }
	 
	 public static ArrayList<AgencijaHelper> vratiAgencijeMenadzera(int sifraMenadzera) {
		 try {
		 Connection connection = DriverManager.getConnection(URL.dbUrl, URL.dbUsername, URL.dbPassword);
		 String upit = "SELECT a.agn_sifra, a.agn_naziv, a.agn_adresa, a.agn_telefon, a.agn_slika, a.agn_opis, a.kor_menadzer, k.kor_ime, k.kor_prezime FROM agencija a INNER JOIN Korisnik k ON a.kor_menadzer = k.kor_sifra WHERE a.kor_menadzer = " + sifraMenadzera;
		 Statement stm = connection.createStatement();
		 ResultSet rsl = stm.executeQuery(upit);
		 ArrayList<AgencijaHelper> listaAgencija = new ArrayList<AgencijaHelper>();
		 int i = 0;
		 while(rsl.next()) {
			 int sifra = rsl.getInt("agn_sifra");
			 String naziv = rsl.getString("agn_naziv");
			 String adresa = rsl.getString("agn_adresa");
			 String telefon = rsl.getString("agn_telefon");
			 String slika = rsl.getString("agn_slika");
			 String opis = rsl.getString("agn_opis");
			 int menadzer = rsl.getInt("kor_menadzer");
			 String imeMenadzera = rsl.getString("kor_ime");
			 String prezimeMenadzera = rsl.getString("kor_prezime"); 
			 listaAgencija.add(new AgencijaHelper(sifra, naziv, adresa, telefon, slika, opis, menadzer, imeMenadzera, prezimeMenadzera));
		 }
		 return listaAgencija;
		 }
		 catch (Exception e) {
			System.out.println("Neuspesno " + e.getMessage());
			return null;
		}
	 }
}
