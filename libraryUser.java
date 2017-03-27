/*Created by Taha Atakan İpekçi on 22.2.2017*/
/*a class for library user*/
import java.lang.*;
import java.util.*;

public class libraryUser {

	private String name;
	private String password;
	protected ArrayList<book> borrowList = new ArrayList<book>();//contains the books this user has borrowed and not returned yet
	protected static int authority = 0;
	

	libraryUser(){

	}

	/**
	 * creates a user
	 * @param givenName
	 * @param givenPassword
	 */
	libraryUser(String givenName, String givenPassword){
		name = givenName;
		password = givenPassword;
	}


	/**
	 *
	 * @return name
	 */
	public String getName(){

		return name;

	}

	/**
	 *
	 * @return password
	 */
	public String getPassword(){

		return password;

	}

	/**
	 *
	 * @param newName
	 */
	public void setName(String newName){

	int flag = 0;
		for(int i = 0; i<library.userList.size(); i++)
		{
			if(library.userList.get(i).getName().equals(newName))
				flag = 1;

		}
		if(flag!=1)
		name = newName;
		else
		System.out.println("Sorry, This User Name Is Taken");

	}

	/**
	 *
	 * @param newPassword
	 */
	public void setPassword(String newPassword){

		password = newPassword;

	}
/*

 */

	/**
	 *
	 * @return Prints the username,password and the name of the borrowed books.
	 */
	@Override
	public String toString(){

	StringBuffer result = new StringBuffer();

	result.append(getName());
	result.append(" | ");
	result.append(getPassword());
	result.append(" | ");
	result.append("These Are The Books You Borrowed : ");
	result.append("\n");
	for(int i = 0; i<borrowList.size() ; i++){
	
		result.append(borrowList.get(i).getName());
		result.append(",");
	}
	result.append("\n");
	return result.toString();
	}
/*


 */

	/**
	 * Below borrowBook methods are used to borrow  a book from the library. There is more than one way to borrow a book.
	 * It checks for different conditions such as library not having the given book.
	 * @param bookName
	 * @return Returns 1 if successful -1 otherwise.
	 */
	public int borrowBook(String bookName){

	
		
		for(int i = 0; i<library.bookList.size() ; i++){

			if(library.bookList.get(i).getName().equals(bookName)){

				if(library.bookList.get(i).borrow() > 0){
					book newBook = new book(library.bookList.get(i).getName(),library.bookList.get(i).getAuthorName());
					
					borrowList.add(newBook);
					
					return 1;

					}
				else{
					System.out.println("Sorry, this book is out of stock try again later.");
					return -1;
				}
			}

		}
		System.out.println("Sorry, we don't have this book");
		return -1;
		

	}

	/**
	 * Below borrowBook methods are used to borrow  a book from the library. There is more than one way to borrow a book.
	 * @param bookName
	 * @param authorName
	 * @return Returns 1 if successful -1 otherwise.
	 */
	public int borrowBook(String bookName,String authorName){

		for(int i = 0; i<library.bookList.size() ; i++){

			if(library.bookList.get(i).getName().equals(bookName) && 
               library.bookList.get(i).getAuthorName().equals(authorName)){

				if(library.bookList.get(i).borrow() > 0){
					book newBook = new book(library.bookList.get(i).getName(),library.bookList.get(i).getAuthorName());
					
					borrowList.add(newBook);
					
					return 1;
				}
				else{
					System.out.println("Sorry, this book is out of stock try again later.");
					return -1;				
				}
			}

		}
		System.out.println("Sorry, we don't have this book");
		return -1;
	}
/*

 */

	/**
	 * Same logic as borrowing a book. Think of it as library borrowing one from the user.
	 * @param bookName
	 * @return Returns 1 if successful -1 otherwise.
	 */
	public int returnBook(String bookName){

		for(int i = 0; i<borrowList.size() ; i++){

			if(borrowList.get(i).getName().equals(bookName)){

				for(int j = 0; j<library.bookList.size(); j++){

					if(library.bookList.get(j).getName().equals(borrowList.get(i).getName())){
						int valid = library.bookList.get(j).returnOne();
						if(valid <= 0){
							System.out.println("You can't return this book because it is not borrowed from this library.");
							return -1;
						}
						else{
							
							borrowList.remove(i);

							return 1;
						}
					}
				}
				System.out.println("You can't return this book because it is not registered in our library.");
				return -1;
			}
			

			
				
			

		}
		System.out.println("You can't return this book because you don't have it.");
		return -1;
	}

	/**
	 * Same logic as borrowing a book. Think of it as library borrowing one from the user.
	 * @param bookName
	 * @param authorName
	 * @return Returns 1 if successful -1 otherwise.
	 */
	public int returnBook(String bookName,String authorName){

		for(int i = 0; i<borrowList.size() ; i++){

			if(borrowList.get(i).getName().equals(bookName) && borrowList.get(i).getAuthorName().equals(authorName) ){

				for(int j = 0; j<library.bookList.size(); j++){

					if(library.bookList.get(j).getName().equals(borrowList.get(i).getName()) && library.bookList.get(j).getAuthorName().equals(borrowList.get(i).getAuthorName()) ){
						int valid = library.bookList.get(j).returnOne();
						if(valid <= 0){
							System.out.println("You can't return this book because it is not borrowed from this library.");
							return -1;
						}
						else{
							
							borrowList.remove(i);

							return 1;
						}
					}
				}
				System.out.println("You can't return this book because it is not registered in our library.");
				return -1;
			}
			

			
				
			

		}
		System.out.println("You can't return this book because you don't have it.");
				return -1;
	}



}
