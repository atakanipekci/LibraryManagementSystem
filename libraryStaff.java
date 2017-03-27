/*Created by Taha Atakan İpekçi on 22.2.2017*/
/*a class for library staff*/
import java.lang.*;
import java.util.*;
/*
a library staff can do anything a user can. that is way it is extending the user class.
 */
public class libraryStaff extends libraryUser {

private String name;
private String password;
protected ArrayList<book> borrowList = new ArrayList<book>();
private static int authority = 1;

	libraryStaff(){

	}

	/**
	 * creates a library staff
	 * @param givenName
	 * @param givenPassword
	 */
	libraryStaff(String givenName, String givenPassword){
		super(givenName,givenPassword);
	}

/*

 */

	/**
	 * lists the info of every user that are registered.
	 */
	public void listUsers(){
	
	StringBuffer result = new StringBuffer();

		for(int i=0; i<library.userList.size(); i++){

			result.append(library.userList.get(i).getName());
			result.append(" | ");
			result.append(library.userList.get(i).getPassword());
			result.append(" | ");
			result.append("These Are The Books He Borrowed : ");
			result.append("\n");
			for(int j = 0; j<library.userList.get(i).borrowList.size() ; j++){
	
				result.append(library.userList.get(i).borrowList.get(j).getName());
				result.append(",");
			}
			result.append("\n");

		}

		System.out.println(result.toString());

	}

/*

 */

	/**
	 * lists all the info of staff that are registered.
	 */
	public void listStaff(){
	
	StringBuffer result = new StringBuffer();

		for(int i=0; i<library.staffList.size(); i++){

			result.append(library.staffList.get(i).getName());
			result.append(" | ");
			result.append(library.staffList.get(i).getPassword());
			result.append(" | ");
			result.append("These Are The Books He Borrowed : ");
			result.append("\n");
			for(int j = 0; j<library.staffList.get(i).borrowList.size() ; j++){
	
				result.append(library.staffList.get(i).borrowList.get(j).getName());
				result.append(",");
			}
			result.append("\n");

		}

		System.out.println(result.toString());

	}

/*

 */

	/**
	 * adds a book to the library. Different ways to add a book such as only giving name or giving name with amount etc.
	 Everybook should have a name.
	 If the book exists increases the amount. If not adds a new book
	 * @param bookName
	 */
	public void addBook(String bookName){

		int flag = -1;

		for(int i = 0; i<library.bookList.size(); i++){

			if(library.bookList.get(i).getName().equals(bookName))
			{
				
				library.bookList.get(i).setAmount(library.bookList.get(i).getAmount()+1);
				flag=1;
			}
				
		}

		if(flag !=1){
		book newBook = new book(bookName);
		library.bookList.add(newBook);
		}
		
	}

	/**
	 * adds a book to the library. Different ways to add a book such as only giving name or giving name with amount etc.
	 Everybook should have a name.
	 If the book exists increases the amount. If not adds a new book
	 * @param bookName
	 * @param amount
	 */
	public void addBook(String bookName, int amount){

		int flag = -1;

		for(int i = 0; i<library.bookList.size(); i++){

			if(library.bookList.get(i).getName().equals(bookName))
			{
				
				library.bookList.get(i).setAmount(library.bookList.get(i).getAmount()+amount);
				flag=1;
			}
				
		}

		if(flag !=1){
		book newBook = new book(bookName,amount);
		library.bookList.add(newBook);
		}
		
	}

	/**
	 * adds a book to the library. Different ways to add a book such as only giving name or giving name with amount etc.
	 Everybook should have a name.
	 If the book exists increases the amount. If not adds a new book
	 * @param bookName
	 * @param authorName
	 */
	public void addBook(String bookName,String authorName){

		int flag = -1;

		for(int i = 0; i<library.bookList.size(); i++){

			if(library.bookList.get(i).getName().equals(bookName) && library.bookList.get(i).getAuthorName().equals(authorName) )
			{
				
				library.bookList.get(i).setAmount(library.bookList.get(i).getAmount()+1);
				flag=1;
			}
				
		}

		if(flag !=1){
		book newBook = new book(bookName,authorName);
		library.bookList.add(newBook);
		}
		
	}

	/**
	 * adds a book to the library. Different ways to add a book such as only giving name or giving name with amount etc.
	 Everybook should have a name.
	 If the book exists increases the amount. If not adds a new book
	 * @param bookName
	 * @param authorName
	 * @param Amount
	 */
	public void addBook(String bookName,String authorName, int Amount){

		int flag = -1;

		for(int i = 0; i<library.bookList.size(); i++){

			if(library.bookList.get(i).getName().equals(bookName) && library.bookList.get(i).getAuthorName().equals(authorName) )
			{
				
				library.bookList.get(i).setAmount(library.bookList.get(i).getAmount()+Amount);
				flag=1;
			}
				
		}

		if(flag !=1){
		book newBook = new book(bookName,authorName,Amount);
		library.bookList.add(newBook);
		}
		
	}


	/**
	 * removes a book with a similar logic to adding one.
	 * @param bookName
	 * @return 1 if successful -1 otherwise.
	 */
	public int removeBook(String bookName){

		

		for(int i = 0; i<library.bookList.size(); i++){

			if(library.bookList.get(i).getName().equals(bookName))
			{
				
				library.bookList.remove(i);
				return 1;
			}
				
		}

		
		System.out.println("There is no book registered with that name.");
		return -1;
		
	}

	/**
	 * removes a book with a similar logic to adding one.
	 * @param bookName
	 * @param authorName
	 * @return 1 if successful -1 otherwise.
	 */
	
	public int removeBook(String bookName, String authorName){

		

		for(int i = 0; i<library.bookList.size(); i++){

			if(library.bookList.get(i).getName().equals(bookName) && library.bookList.get(i).getAuthorName().equals(authorName) )
			{
				
				library.bookList.remove(i);
				return 1;
			}
				
		}

		
		System.out.println("There is no book registered with that name.");
		return -1;
		
	}

	/**
	 * removes a book with a similar logic to adding one.
	 * @param bookName
	 * @param amount
	 * @return 1 if successful -1 otherwise.
	 */
	public int removeBook(String bookName, int amount){

		

		for(int i = 0; i<library.bookList.size(); i++){

			if(library.bookList.get(i).getName().equals(bookName) )
			{
				if(library.bookList.get(i).getAmount()>= amount){
				library.bookList.get(i).setAmount(library.bookList.get(i).getAmount()-amount);
				return 1;
				}
				else{
				System.out.println("We Don't Have That Many.");
				return -1;

				}
			}
				
		}

		
		System.out.println("There is no book registered with that name.");
		return -1;
		
	}

	/**
	 * removes a book with a similar logic to adding one.
	 * @param bookName
	 * @param authorName
	 * @param amount
	 * @return 1 if successful -1 otherwise.
	 */
	public int removeBook(String bookName, String authorName, int amount){

		

		for(int i = 0; i<library.bookList.size(); i++){

			if(library.bookList.get(i).getName().equals(bookName) && library.bookList.get(i).getAuthorName().equals(authorName) )
			{
				if(library.bookList.get(i).getAmount()>= amount){
				library.bookList.get(i).setAmount(library.bookList.get(i).getAmount()-amount);
				return 1;
				}
				else{
				System.out.println("We Don't Have That Many.");
				return -1;

				}
			}
				
		}

		
		System.out.println("There is no book registered with that name.");
		return -1;
		
	}

/*

 */

	/**
	 * registers a new user with the given data. If there is a user registered with the given name, gives an error.
	 * @param userName
	 * @param userPassword
	 * @return 1 if successful -1 otherwise.
	 */
	public int addUser(String userName, String userPassword){

		

		for(int i = 0; i<library.userList.size(); i++){

			if(library.userList.get(i).getName().equals(userName))
			{
				
				System.out.println("This username is already taken. Please pick another one.");
				return -1;
			}
				
		}

		
		libraryUser newUser = new libraryUser(userName,userPassword);
		library.userList.add(newUser);
		return 1;
		
	}
/*

 */

	/**
	 * removes a user with the given name.
	 * @param userName
	 * @return 1 if successful -1 otherwise.
	 */
	public int removeUser(String userName){

		

		for(int i = 0; i<library.userList.size(); i++){

			if(library.userList.get(i).getName().equals(userName))
			{
				
				library.userList.remove(i);
				return 1;
			}
				
		}

		
		System.out.println("There is no user registered with that name.");
		return -1;
		
	}


	/**
	 * does the same thing as addUser. Except it adds a staff member instead.
	 * @param userName
	 * @param userPassword
	 * @return  1 if successful -1 otherwise.
	 */
	public int addStaff(String userName, String userPassword){

		

		for(int i = 0; i<library.staffList.size(); i++){

			if(library.staffList.get(i).getName().equals(userName))
			{
				
				System.out.println("This username is already taken. Please pick another one.");
				return -1;
			}
				
		}

		
		libraryStaff newStaff = new libraryStaff(userName,userPassword);
		library.staffList.add(newStaff);
		return 1;
		
	}

	/**
	 * removes a staff
	 * @param userName
	 * @return 1 if successful -1 otherwise.
	 */
	public int removeStaff(String userName){

		

		for(int i = 0; i<library.staffList.size(); i++){

			if(library.staffList.get(i).getName().equals(userName))
			{
				
				library.staffList.remove(i);
				return 1;
			}
				
		}

		
		System.out.println("There is no staff registered with that name.");
		return -1;
		
	}


}
