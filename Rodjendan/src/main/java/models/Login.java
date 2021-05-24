package models;

import java.sql.*;

public class Login {
	public static boolean status;
	public static String ime;
	public static String prezime;
	public static int uloga;
	public static int sifra;
	public static void logovanjeKorisnika(String email, String password) {
		try {
			String dbUrl = "jdbc:mysql://localhost:3306/db_rodj_proslave";
			String dbUsername = "root";
			String dbPassword = "";
			Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			String upit = "SELECT * FROM korisnik where kor_email = '" + email + "' and kor_password='" +password + "'";
			Statement psmt = connection.createStatement();
			ResultSet rSet = psmt.executeQuery(upit);

			while (rSet.next()) {
				ime = rSet.getString("kor_ime");
				prezime = rSet.getString("kor_prezime");
				uloga = rSet.getInt("kor_uloga");
				status = true;
				sifra = rSet.getInt("kor_sifra");
			
			}
			
			}
			catch(SQLException ex){
				System.out.println("neuspesno " + ex.getMessage());
				status = false;
			}
}
}
