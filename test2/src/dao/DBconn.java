package dao;
import java.sql.*;

public class DBconn {
		String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=ds";
		String account= "sa";
		String psw="lwd1997";
		public Connection conn= null;
	    ResultSet rs =null;
	    public DBconn ()
	    {
	    try
	        {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	        conn=DriverManager.getConnection (url,account,psw);
	        }
	    catch(java.lang.Exception e)
	       {  
	         System.err.println ("DBconn ():"+e.getMessage ());
	       }
	    }
	    public ResultSet executeQuery (String sql)
	    {
	      rs = null;
	      try
	      {  
	        Statement stmt = conn.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        rs =stmt.executeQuery (sql);
	      }
	      catch (SQLException e)
	      {
	        System.err.println ("aq.executeQuery:"+e.getMessage ());
	      }
	     return rs;
	    }
		

}
