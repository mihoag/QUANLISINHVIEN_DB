package JDBCconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLconnection {
	public static Connection c = null;
	public static Connection getConnection()
	{
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String url = "jdbc:sqlserver://MSI:1433;databaseName=QUANLISINHVIEN;integratedSecurity=true;";
		    c =  DriverManager.getConnection(url);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return c;
	}
	public void close()
	{
		try {
			if(c != null)
			{
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
