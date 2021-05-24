package models;

import java.sql.*;
public class Registracija {
	public static boolean status;
	public static void registracijaKorisnika(String ime, String prezime, String email, String password) {
		try {
			String dbUrl = "jdbc:mysql://localhost:3306/db_rodj_proslave";
			String dbUsername = "root";
			String dbPassword = "";
			Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			String upit = "INSERT INTO korisnik VALUES (NULL, '"+ime+"', '"+prezime+"', '"+email+"', '"+password+"', 1)";
			PreparedStatement psmt = connection.prepareStatement(upit);
			psmt.executeUpdate();
			psmt.close();
			status = true;
			
			}
			catch(SQLException ex){
				System.out.println("neuspesno " + ex.getMessage());
				status = false;
			}
	}

}
