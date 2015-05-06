package omdb;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


 

public class PreparedStatementInsert {
	
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@//localhost:1521/XE";
	private static final String DB_USER = "SYSTEM";
	private static final String DB_PASSWORD = "bilge1510";
	

	public static void main(String[] argv) {
		 
		try {
 
			insertRecordIntoTable();
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
	}
 
	private static void insertRecordIntoTable() throws SQLException  {
 
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
	

		String insertTableSQL = "INSERT INTO FILM "
				+"(FILMADI,FILMYILI,FILMTURU,BASROLOYUNCULAR,FILMSURESI,FILMKONU) "
				+ "VALUES"
				+ "(?,?,?,?,?,?)";
 
 
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
		
			
		    preparedStatement.setString(1, "FILMADI");
			preparedStatement.setString(2, "FILMYILI");
		    preparedStatement.setString(3, "FILMTURU");
			preparedStatement.setString(4, "BASROLOYUNCULAR");
			preparedStatement.setString(5, "FILMSURESI");
			preparedStatement.setString(6, "FILMKONU");
			
			
			String insertTableSQL1 = "INSERT INTO FILM "
					+"(FILMADI,FILMYILI,FILMTURU,BASROLOYUNCULAR,FILMSURESI,FILMKONU) "
					+ "VALUES"
				    + "('Batman',1989,'Action, Adventure','Michael Keaton, Jack Nicholson, Kim Basinger',126,'The Dark Knight of Gotham City begins his war on crime with his first major enemy being the clownishly homicidal Joker')";
		      
			String insertTableSQL2 = "INSERT INTO FILM"
		    	+ "(FILMADI,FILMYILI,FILMTURU,BASROLOYUNCULAR,FILMSURESI,FILMKONU)"
			    + "VALUES"
			    +"('Iron Man',2008,'Action, Adventure','Robert Downey Jr.,Terrence Howard',126,'After being held captive in an Afghan cave, an industrialist creates a unique weaponized suit of armor to fight against evil. This leads him to conflict within his own company')";
				

			preparedStatement.executeUpdate(insertTableSQL1);
			preparedStatement.executeUpdate(insertTableSQL2);
 
			System.out.println(insertTableSQL1);
			System.out.println(insertTableSQL2);
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		} finally {
 
			if (preparedStatement != null) {
				preparedStatement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
 	}
 
	private static Connection getDBConnection() {
 
		Connection dbConnection = null;
 
		try {
 
			Class.forName("oracle.jdbc.driver.OracleDriver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		try {
 
			dbConnection = DriverManager.getConnection(
                            DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
		return dbConnection;
 
	}
 
	private static java.sql.Timestamp getCurrentTimeStamp() {
 
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
 
	}
 
}
		