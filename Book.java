package database;

public class Book
{
    /* at the very beginning we need to create instance variables **/

    public String title;
    
    public String author;
    
    public int year;
    
    public String publisher;
    
    public double cost;
    

    /* once we have it we have to create a constructor that allows a user to input instance variables **/
    
    public Book(String title,String author,int year,String publisher,double cost)
    {   this.title=title;
        this.author=author;
        this.year=year;
        this.publisher=publisher;
        this.cost=cost;
    }
    
    /* then we have to create an accessor method for each of the instance variables created above to retun whatever 
     * has been inputted by the user
     
	 */
      
	 
	  
    public String getTitle()
    {
        return title;
    }
    

	/**
	 * Returns author of this book.
	   * @wi.implements DP-808
	 */ 
    public String getAuthor()
    {
        return author;
    }
		/**
	 * Returns year of this book.
	   * @wi.implements DP-533
	 */ 
    public int getYear()
    {
        return year;
    }
    public String getPublisher()
    {
        return publisher;
    } 
    public double getCost()
    {
        return cost;
    }
    

    /* now we create a mutator method for each of the instance variables created above that allows a user to change
     * the state of the object.
     */

	/**
	 * Returns Title of this book.
	   * @wi.implements DP-802
	 */
    public void setTitle(String title)
    {
        this.title=title; 
    }
	
	/**
	 * Set author of this book.
	   * @wi.implements DP-808
	 */    	 
    public void setAuthor(String author)
    {
       this.author=author;
    }
    public void setYear(int year)
    {
        this.year=year;
    }
    public void setPublisher(String publisher)
    {
        this.publisher=publisher;
    } 
    public void setCost(double cost)
    {
        this.cost=cost;
    }    
    
    
    /* the last part here is to create a toString method that returns all of the details of the book that has been inputted. **/
    
    public String toString()
    {
        return "The details of the book are: " + title + ", " + author + ", " + year + ", " + publisher + ", " + cost;
    }
    
    
    
}
