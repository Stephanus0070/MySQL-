import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

import javax.swing.JOptionPane;

public class add{
	public void add(int in,String Tilt,String name,int qt ){
	 try ( 
				
	         Connection conn =  DriverManager.getConnection( 
	         "jdbc:mysql://localhost:3306/ebook_store?useSSL=false", "Stefan", "Ameralda");   
	       
	         Statement stmt =conn.createStatement();   
	    		  ) {
		 		String input=JOptionPane.showInputDialog("Add the book values");
		 		String ad="insert into books"
	    				  +"values(input)";
	 } catch(SQLException ex) 
     {ex.printStackTrace();
	

}
}
}