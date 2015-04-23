package omdb;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SqlInsert {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleThinDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@//localhost:1521/XE";
	private static final String DB_USER = "SYSTEM";
	private static final String DB_PASSWORD = "bilge1510";
	private static final DateFormat dateFormat = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");
	
	
	public static void main(String[] argv) {
		 
		try {
 
			insertRecordIntoDbUserTable();
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
			
		}
 
		}
		

		private static <insert> void insertRecordIntoDbUserTable() throws SQLException {
	 
			Connection dbConnection = null;
			Statement statement = null;
	 
			String insertTableSQL = "INSERT INTO DBUSER"
					+ "( USERNAME, CREATED_BY, CREATED_DATE) " + "VALUES"
					+ "('BILGE','SYSTEM', " + "to_date('"
					+ getCurrentTimeStamp() + "', 'yyyy/mm/dd hh24:mi:ss'))";
					
				
	 
			try {
				dbConnection = getDBConnection();
				statement = dbConnection.createStatement();
	 
				System.out.println(insertTableSQL);
				
			 insert FILM; 
			 values ('Forrest Gump',1994,'Drama, Romance','Tom Hanks', 'Rebecca Williams',142 , 'Forrest Gump life');
				
				 
				
				statement.executeUpdate(insertTableSQL);
	 
				System.out.println("Record is inserted into DBUSER table!");
	 
			} catch (SQLException e) {
	 
				System.out.println(e.getMessage());
	 
			} finally {
	 
				if (statement != null) {
					statement.close();
				}
	 
				if (dbConnection != null) {
					dbConnection.close();
				}
	 
			}
	 
		}
	 
		private static Connection getDBConnection() {
	 
			Connection dbConnection = null;
	 
			try {
	 
				Class.forName(DB_DRIVER);
	 
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
	 
		private static String getCurrentTimeStamp() {
	 
			java.util.Date today = new java.util.Date();
			return dateFormat.format(today.getTime());
	 
		
 
	}
	
	
}
