package com.pace.library.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
	
		//new instance of connection
		private static Connection connection=null;
		//opening connection with Mysql database
		public static Connection createConnection()throws ClassNotFoundException,SQLException
{
			String url,userId,passWord;
			url="jdbc:mysql://@localhost:3306/library";
			userId="root";
			passWord="password";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,userId,passWord);
			return connection;
		}
		public static void closeConnection()throws SQLException{
			connection.close();
		
	}
}
