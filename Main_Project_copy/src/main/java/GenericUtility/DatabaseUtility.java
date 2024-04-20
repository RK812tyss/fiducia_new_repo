package GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility 
{
	
	Connection con=null;
	public void connectionToDB() throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		
		
	 con = DriverManager.getConnection(IpathConstant.DBURL,IpathConstant.DBUsername,IpathConstant.DbPassword);
		
	}
	
	
	public void executeAndGetData(String query,int colIndex,String expdata) throws SQLException
	{
		Statement state = con.createStatement();
		
		 		 
		 ResultSet result = state.executeQuery(query);
		 
		 boolean flag=false;
		 
		 while(result.next())
			{
			 
			 String actual=result.getString(colIndex);
			 if(actual.contains(expdata))
			 {
				 flag=true;
				 break;
			 }
				
			 }
		 
		 if(flag==true)
		 {
			 System.out.println("data is present");
		 }
		 else
		 {
			 System.out.println("data is not present");
		 }
	} 
	
	
		public void closeDataBase() throws SQLException
		{
			con.close();
		}
		 
		 
	}
	


