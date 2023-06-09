package database;

import java.sql.*;

public class BookDatabase {

	private String user = "";
	private String password = "";
	static String url = "jdbc:odbc:Books";

	static Connection link;
	static Statement statement;
	static ResultSet results;
	
	private int maxCost, bookStoreSize, bookStoreCost;

	public BookDatabase() {

		getConnection();		//Create Connection 
	}

	public Connection getConnection(){

		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	

		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			link = DriverManager.getConnection(url, user, password);
			statement = link.createStatement();

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

		return link;

	}

	public void displayTable() throws SQLException
	{

		String select = "Select ID, Title, Author, Cost, Publisher, YearOfPublishing from Bookshelf";
		// Step 4
		results = statement.executeQuery(select);
		// Step 5
		while (results.next())
		{
			System.out.println("Book Id:    " + results.getInt("ID"));
			System.out.println("Book Title:    " + results.getString("Title"));
			System.out.println("Book Author: " + results.getString("Author"));
			System.out.println("Publisher: " + results.getString("Publisher") + " " + results.getInt("YearOfPublishing"));
			System.out.println("Cost       " + results.getInt("Cost"));
			System.out.println();
		}
	}

	public int getMaxID() throws SQLException

	{

		try

		{
			String select = "SELECT MAX(ID) FROM BookShelf";
			// Step 4
			results = statement.executeQuery(select);
			results.next();

		}

		catch(Exception e){
			System.out.println(e);
		}	 

		return results.getInt(1);
	}

	public int getMaxPrice() 
	
	{
		try

		{
			String select = "SELECT MAX(Cost) FROM BookShelf";
			// Step 4
			results = statement.executeQuery(select);
			results.next();
			maxCost = results.getInt(1);
		}

		catch(Exception e){
			System.out.println(e);
		}	 
		
		return maxCost;
	}
	
public int getBookStoreSize() 
	
	{
		try

		{
			String select = "Select COUNT(ID) FROM BookShelf";
			// Step 4
			results = statement.executeQuery(select);
			results.next();
			bookStoreSize = results.getInt(1);
		}

		catch(Exception e){
			System.out.println(e);
		}	 
		
		return bookStoreSize;
	}

public int getBookStoreTotalCost() throws SQLException 

{
	try

	{
		String select = "Select SUM(Cost) FROM BookShelf";
		// Step 4
		results = statement.executeQuery(select);
		results.next();
			}

	catch(Exception e){
		System.out.println(e);
	}	 
	
	return results.getInt(1);
}
	
	
	
	public void saveBook(Book newBook){

		try
		{
			int new_id = getMaxID() +1;
			String query = "INSERT INTO BookShelf(ID, Title, Author, Cost, Publisher, YearOfPublishing) VALUES (" 
				+ new_id 
				+ ",'"  + newBook.getTitle()
				+ "','" + newBook.getAuthor() 
				+ "',"  + newBook.getCost()
				+ ",'"  + newBook.getPublisher() + "',"
				+ newBook.getYear() + ")";

			int result = statement.executeUpdate(query);
			if (result == 0){

				System.out.println("Failed to insert the following data: " 
						+ newBook.getTitle() + "," 
						+ newBook.getAuthor() + ","
						+ newBook.getCost() + ","
						+ newBook.getPublisher() + ","
						+ newBook.getYear());
			}
		}
		catch(Exception e){
			System.out.println(e);
		}


		// No further queries, so no step 6

		try{
			// Step 7
			link.close();
		}
		catch(SQLException e){
			System.out.println("Unable to disconnect");
			e.printStackTrace();
			System.exit(1);
		}

	}  //end main
} // end JDBCSelect
