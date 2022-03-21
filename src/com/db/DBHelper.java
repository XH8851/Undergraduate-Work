package com.db;

import java.sql.*;

public class DBHelper {	
//	private String dbClassName = "net.sourceforge.jtds.jdbc.Driver";
//	private String dbUrl="jdbc:jtds:sqlserver://localhost:1433/" + "sushe;SelectMethod = Cursor";
//	private String dbUser="sa";
//	private String dbPassword="123456";
////	private String second=null;
//	
//	//连接数据库
	public Connection getConn(){
//		Connection conn = null;
//		try{
//			Class.forName(dbClassName);
//		}
//		catch(Exception e){}
//		try{
//			conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
//		}
//		catch(SQLException ex){}
//		return conn;		
//	}
	
	 Connection conn = null;
     Statement stmt = null;
     ResultSet rs = null;
     try {
         //1. 注册驱动
         //1.1 获取驱动对象
         Driver driver = new com.mysql.cj.jdbc.Driver();
         //1.2 注册驱动
         DriverManager.registerDriver(driver);
         //2. 获取数据库连接
         String url = "jdbc:mysql://localhost:3306/db_schoolRecru?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
         String user = "root";
         String password = "0721";
         conn = DriverManager.getConnection(url,user,password);

     	}
     catch (Exception e) {
         e.printStackTrace();
     }
	
     return conn;
	}	
	
//    测试
	public static void main(String[] args)
	{
		System.out.println(new DBHelper().getConn());
	}
	
}
