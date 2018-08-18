import java.sql.*;

import javax.swing.JOptionPane;
public class main {

	public static void main(String[] args) throws SQLException {
		
		int choice = 1;
		do
		{
			System.out.println( "Enter product:" );
			choice = Integer.parseInt( JOptionPane.showInputDialog( 	"1. Add books\n"+
											"2. Update\n"+
											"3. Delete \n"+
											"4. Search\n"+
											"0. Quit program" ) );
								
			switch( choice )
			{
				case 1:  
					 
						int id=Integer.parseInt( JOptionPane.showInputDialog("Enter the ID"));
						String title=JOptionPane.showInputDialog("Enter the title");
						String author=JOptionPane.showInputDialog("Enter the author");
						int qt=Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
				         Connection conn =  DriverManager.getConnection( 
				         "jdbc:mysql://localhost:3306/ebook_store?useSSL=false", "Stefan", "Ameralda");   
						String sql="insert into books"
			    				  +"(ID,Title,Author,Quantity)"+"values(?,?,?,?)";
				         PreparedStatement stmt =conn.prepareStatement(sql); 
						stmt.setInt(1,id);
						stmt.setString(2,title);
						stmt.setString(3,author);
						stmt.setInt(4, qt);
						stmt.executeUpdate();
						stmt.close();
						conn.close();		break;
				case 2: 
					String title1=JOptionPane.showInputDialog("Enter the title");
					String author1=JOptionPane.showInputDialog("Enter the author");
					int qt1=Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					Connection conn2 =  DriverManager.getConnection( 
				         "jdbc:mysql://localhost:3306/ebook_store?useSSL=false", "Stefan", "Ameralda");
					int id2=Integer.parseInt(JOptionPane.showInputDialog("Enter the id of book"));
						String update="update books where id=\'" + id2 + "\' set Title=? and set Author=? and set Quantity=?";
						PreparedStatement prestat=conn2.prepareStatement(update);
						prestat.setString(2, title1);
						prestat.setString(3, author1);
						prestat.setInt(4, qt1);
						prestat.executeQuery();
						prestat.close();
						conn2.close();	 ;break;
				case 3: 
					int delid=Integer.parseInt(JOptionPane.showInputDialog("Insert id to delete record")); 
					Connection conn3 =  DriverManager.getConnection( 
			         "jdbc:mysql://localhost:3306/ebook_store?useSSL=false", "Stefan", "Ameralda");
					String del="delete from books where ID=?";
					PreparedStatement st=conn3.prepareStatement(del);
					st.setInt(1, delid);
					st.executeUpdate();
					st.close();
					conn3.close();		 break;
						
			
				case 4: 
					Connection conn4 =  DriverManager.getConnection( 
					         "jdbc:mysql://localhost:3306/ebook_store?useSSL=false", "Stefan", "Ameralda");
					Statement state=conn4.createStatement();
					int id1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the id of search"));
				String strSelect = "select * from book where id=\'" + id1 + "\'";
				System.out.println("SQL: " + strSelect);
				ResultSet rset = state.executeQuery(strSelect);
				System.out.println("Displaying Results of search: \n");
				while(rset.next()) {
					System.out.println(rset.getInt("id") + ", "
							+ rset.getString("Title") + ", "
							+ rset.getString("Author") + ", "
							+ rset.getInt("Qty \n")
							);
				}
				state.close();
				conn4.close();			break;
				
		
		
			}
			
		}while( choice !=0 );
	

	}

}
