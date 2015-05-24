package omdb;

import java.awt.TextField;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ResultSetExp {
	
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@//localhost:1521/XE";
	private static final String DB_USER = "SYSTEM";
	private static final String DB_PASSWORD = "bilge1510";
	
	public static void main(String[] args) {
		try {
	
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			
			}
			
			String connection ="jdbc:oracle:thin:@//localhost:1521/XE;DE_USER=SYSTEM;DB_PASSWORD=bilge1510";
			Connection dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
		
			Statement st = dbConnection.createStatement();
			
			Scanner scan=new Scanner(System.in);
			System.out.println("Bir isim giriniz"); 
            String  filmAdi=scan.nextLine();
        //    String  filmTuru=scan.nextLine();
            ExculatorServices  test = new ExculatorServices(filmAdi,null);
            test.setFilmAdi(filmAdi);
			//test.getFilmAdi();
			//test.setFilmTuru(filmTuru);
			//test.getfilmTuru();
			
			String sql = "SELECT FILMADI, FILMYILI ,FILMTURU ,BASROLOYUNCULAR,FILMSURESI,FILMKONU FROM WHERE FILMADI";
		
			ResultSet sonuc= st.executeQuery("SELECT * FROM FILM WHERE FILMADI =\' filmAdi ==test.getFilmAdi() \' ");
		
		
	//	if(sonuc.getString("FILMADI")==test.getFilmAdi()){
			
				while(sonuc.next()){
					System.out.println("Film adý :"+sonuc.getString("FILMADI")+" , " 
			                      +"Film yýlý :"+sonuc.getInt("FILMYILI")+" , "
						          +"Film türü :"+sonuc.getString("FILMTURU")+" , " 
			                      +"Oyuncular :"+sonuc.getString("BASROLOYUNCULAR")+" , "
			                      +"Filmin süresi :"+sonuc.getInt("FILMSURESI") +" , "
			                      +"Konu :"+sonuc.getString("FILMKONU") );
	              }
	//				} 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}}
   

