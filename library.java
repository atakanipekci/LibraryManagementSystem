/*Created by Taha Atakan İpekçi on 23.2.2017*/
/*a class for library*/
import java.lang.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class library implements managementSystem {

private String libraryName;
private String userFileName;
private String staffFileName;
private String booksFileName;
/*Static lists are used to make sure that every change made by other classes to this class can be accessed with other
classes. For example when a user borrows a book it changes the book list. Not the book list of a random library object.
 */
protected static ArrayList<book> bookList = new ArrayList<book>();
protected static ArrayList<libraryStaff> staffList = new ArrayList<libraryStaff>();
protected static ArrayList<libraryUser> userList = new ArrayList<libraryUser>();

/*Constructor needs correct files to work*/

	/**
	 * constructor for library, reads all the data from the given files
	 * @param libName
	 * @param userFile
	 * @param booksFile
	 * @param staffFile
	 * @throws FileNotFoundException
	 */
	library(String libName, String userFile, String booksFile, String staffFile)throws FileNotFoundException{

			libraryName = libName;
			userFileName = userFile;
			booksFileName = booksFile;
			staffFileName = staffFile;		

			readUsers(userFile);
			readBooks(booksFile);
			readStaff(staffFile);


	}
/*Set and Get functions to limit data access*/

	/**
	 *
	 * @return library name
	 */
	public String getLibraryName(){

		return libraryName;

	}

	/**
	 *
	 * @return name of the user file
	 */
	public String getUserFileName(){

		return userFileName;

	}

	/**
	 *
	 * @return name of the staff file
	 */
	public String getStaffFileName(){

		return staffFileName;

	}

	/**
	 *
	 * @return name of the books file
	 */
	public String getBooksFileName(){

		return booksFileName;

	}


	/**
	 * sets library name
	 * @param name
	 */
	public void setLibraryName(String name){

		libraryName = name;	

	}

	/**
	 * sets user file name
	 * @param name
	 */
	public void setUserFileName(String name){

		userFileName= name;

	}

	/**
	 *  sets books file name
	 * @param name
	 */
	public void setBooksFileName(String name){

		booksFileName= name;

	}

	/**
	 * sets staff file name
	 * @param name
	 */
	public void setStaffFileName(String name){

		staffFileName= name;

	}



	/**
	 * Checks the given user data, if correct returns the index of the corresponding user
	 * @param name name of the user
	 * @param password password
	 * @return index of the the corresponding user
	 */
	public int loginUser(String name, String password){

	
	
		for(int i = 0; i<userList.size(); i++){
		
		if(userList.get(i).getName().equals(name) && userList.get(i).getPassword().equals(password))
		return i;

		}
	
	System.out.println("Wrong Name Or Password");
	return -1;
	}
/**/

	/**
	 * Checks the given staff data, if correct returns the index of the corresponding staff
	 * @param name name of the staff
	 * @param password password
	 * @return index of the the corresponding staff
	 */
	public int loginStaff(String name, String password){

	
	
		for(int i = 0; i<staffList.size(); i++){
		
		if(staffList.get(i).getName().equals(name) && staffList.get(i).getPassword().equals(password))
		return i;

		}
	
	System.out.println("Wrong Name Or Password");
	return -1;
	}
/*

 */

	/**
	 * Overrided the toString method so that it lists all the books this library has with their names,authornames and amounts.
	 * @return
	 */
	@Override
	public String toString(){

	StringBuffer result = new StringBuffer();

	result.append("These are the available books and their amounts : \n");
	
	for(int i = 0; i<bookList.size() ; i++){
	
		result.append(bookList.get(i).getName());
		result.append(" by ");
		result.append(bookList.get(i).getAuthorName());
		result.append(" | ");
		result.append(bookList.get(i).getAmount());
		result.append("\n");
	}

	return result.toString();
	}

	/**
	 * writes every data to corresponding files
	 * @param user name of the user file
	 * @param staff name of the staff file
	 * @param book name of the books file
	 * @throws FileNotFoundException
	 */
	public void writeAll(String user, String staff, String book)throws FileNotFoundException{

			writeUsers(userFileName);
			writeStaff(staffFileName);
			writeBooks(booksFileName);




	}
/*
 */

	/**
	 * Reads the given file line by line. Slices those lines in to words using , delimeter. Indexes shows
	 the corresponding data fields. index 0 -> name etc.. Same for other read methods. Only difference is indexes and the
	 corresponding datafields.http://www.journaldev.com/2335/read-csv-file-java-scanner
	 * @param fileName name of the user file
	 * @throws FileNotFoundException
	 */
	public void readUsers(String fileName)throws FileNotFoundException 		{

		Scanner scanner = new Scanner(new File(fileName));
		Scanner dataScanner = null;
		int index = 0;
		int flag = 0;
		
		while (scanner.hasNextLine()) {
			dataScanner = new Scanner(scanner.nextLine());
			dataScanner.useDelimiter(",");
			libraryUser newUser = new libraryUser();

			while (dataScanner.hasNext()) {
				String data = dataScanner.next();
				if (index == 0)
					newUser.setName(data);
				else if (index == 1)
					newUser.setPassword(data);
				else if (index >= 2)
					newUser.borrowList.add(new book(data));

				index++;
			}
			index = 0;
			
				
		
				if(userList.size()>0){
					for(int i = 0; i<userList.size(); i++){

						if(userList.get(i).getName().equals(newUser.getName()))
						{
							flag = 1;
						}
					}
				}
			
			if(flag != 1)
			userList.add(newUser);
			else
			flag = 0;
		}

		scanner.close();

	}


	/**
	 * reads the staff data from file and stores in the staff list
	 * @param fileName name of the staff file
	 * @throws FileNotFoundException
	 */
	public void readStaff(String fileName)throws FileNotFoundException 		{

		Scanner scanner = new Scanner(new File(fileName));
		Scanner dataScanner = null;
		int index = 0;
		int flag = 0;
		
		while (scanner.hasNextLine()) {
			dataScanner = new Scanner(scanner.nextLine());
			dataScanner.useDelimiter(",");
			libraryStaff newStaff = new libraryStaff();

			while (dataScanner.hasNext()) {
				String data = dataScanner.next();
				if (index == 0)
					newStaff.setName(data);
				else if (index == 1)
					newStaff.setPassword(data);
				else if (index >= 2)
					newStaff.borrowList.add(new book(data));

				index++;
			}
			index = 0;
			
				
		
			if(staffList.size()>0){
				for(int i = 0; i<staffList.size(); i++){

					if(staffList.get(i).getName().equals(newStaff.getName()))
					{
						flag = 1;
					}
				}
			}
			if(flag != 1)
			staffList.add(newStaff);
			else
			flag = 0;
		}

		scanner.close();

	}

	/**
	 * reads the books data from file and stores in the book list
	 * @param fileName name of the books file
	 * @throws FileNotFoundException
	 */
	public void readBooks(String fileName)throws FileNotFoundException 		{

		Scanner scanner = new Scanner(new File(fileName));
		Scanner dataScanner = null;
		int index = 0;
		int flag = 0;
		
		while (scanner.hasNextLine()) {
			dataScanner = new Scanner(scanner.nextLine());
			dataScanner.useDelimiter(",");
			book newBook = new book();

			while (dataScanner.hasNext()) {
				String data = dataScanner.next();
				if (index == 0)
					newBook.setName(data);
				else if (index == 1)
					newBook.setAuthorName(data);
				else if (index == 2)
					newBook.setAmount(Integer.parseInt(data));
				else if (index == 3)
					newBook.setBorrowed(Integer.parseInt(data));
				index++;
			}
			index = 0;
			
				
		

			for(int i = 0; i<library.bookList.size(); i++){

			if(bookList.get(i).getName().equals(newBook.getName()) && bookList.get(i).getAuthorName().equals(newBook.getAuthorName()) )
			{
				flag = 1;
			}
			}
			if(flag != 1)
			bookList.add(newBook);
			else
			flag = 0;
		}

		scanner.close();

	}

	/*
	 */

	/**
	 * Writes the elements of the Arraylist the library class has. Uses , to slice into words.
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public void writeUsers(String fileName)throws FileNotFoundException {

	  PrintWriter pw = new PrintWriter(new File(fileName));
      StringBuilder sb = new StringBuilder();

		for(int i=0; i<userList.size(); i++){
			sb.append(userList.get(i).getName());
			sb.append(',');
			sb.append(userList.get(i).getPassword());
			
			for(int j = 0; j<userList.get(i).borrowList.size(); j++){
	
			sb.append(',');
			sb.append(userList.get(i).borrowList.get(j).getName());

			}
			sb.append("\n");
		}

		pw.write(sb.toString());
		pw.close();

	}

	/**
	 * Writes the elements of the Arraylist the library class has. Uses , to slice into words.
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public void writeStaff(String fileName)throws FileNotFoundException {

	  PrintWriter pw = new PrintWriter(new File(fileName));
      StringBuilder sb = new StringBuilder();

		for(int i=0; i<staffList.size(); i++){
			sb.append(staffList.get(i).getName());
			sb.append(',');
			sb.append(staffList.get(i).getPassword());
			
			for(int j = 0; j<staffList.get(i).borrowList.size(); j++){
	
			sb.append(',');
			sb.append(staffList.get(i).borrowList.get(j).getName());

			}
			sb.append("\n");
		}

		pw.write(sb.toString());
		pw.close();

	}

	/**
	 * Writes the elements of the Arraylist the library class has. Uses , to slice into words.
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public void writeBooks(String fileName)throws FileNotFoundException {

	  PrintWriter pw = new PrintWriter(new File(fileName));
      StringBuilder sb = new StringBuilder();

		for(int i=0; i<bookList.size(); i++){
			sb.append(bookList.get(i).getName());
			sb.append(',');
			sb.append(bookList.get(i).getAuthorName());
			sb.append(',');
			sb.append(bookList.get(i).getAmount());
			sb.append(',');
			sb.append(bookList.get(i).howManyBorrowed());
			sb.append("\n");

		}

		pw.write(sb.toString());
		pw.close();

	}


}





