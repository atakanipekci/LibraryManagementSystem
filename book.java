/*Created by Taha Atakan İpekçi on 22.2.2017*/
/*a class for a book*/
import java.lang.*;

public class book{

	private String name;
	private String authorName;
	private int amount;
	private int borrowed;
	book(){}

	/**
	 * creates a book
	 * @param bookName
	 */
	book(String bookName){

		name = bookName;
		authorName = "anonymous";
		borrowed = 0;
		amount = 1;

	}

	/**
	 * creates a book
	 * @param bookName
	 * @param Amount
	 */
	book(String bookName, int Amount){

		name = bookName;
		authorName = "anonymous";
		borrowed = 0;
		amount = Amount;

	}

	/**
	 * creates a book
	 * @param bookName
	 * @param author
	 */
	book(String bookName, String author){

		name = bookName;
		authorName = author;
		borrowed = 0;
		amount = 1;
	}

	/**
	 * creates a book
	 * @param bookName
	 * @param author
	 * @param Amount
	 */
	book(String bookName, String author, int Amount){

		name = bookName;
		authorName = author;
		borrowed = 0;
		amount = Amount;
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
	 * @return author name
	 */
	public String getAuthorName(){

		return authorName;

	}

	/**
	 *
	 * @return how many borrowed
 	 */
	public int howManyBorrowed(){

		return borrowed;

	}

	/**
	 *
	 * @return how many
	 */
	public int getAmount(){

		return amount;		

	}

	/**
	 * sets the name of the book
	 * @param Name
	 */
	public void setName(String Name){

		name = Name;

	}

	/**
	 * sets the name of the book's author
	 * @param Name
	 */
	public void setAuthorName(String Name){

		authorName = Name;

	}

	/**
	 * sets the book's amount
	 * @param newAmount
	 */
	public void setAmount(int newAmount){

		amount = newAmount;

	}

	/**
	 * sets the book's borrow amount
	 * @param newAmount
	 */
	public void setBorrowed(int newAmount){

		borrowed = newAmount;

	}
/*
.
 */

	/**
	 * checks if there is enough books. If so decreases the amount by 1 and increases the borrowed amount by 1
	 * @return
	 */
	public int borrow(){

		if(getAmount() > 0 )
		{

			amount -= 1;
			borrowed +=1;
			return 1;
		}
		return -1;
	}

	/*

	 */

	/**
	 * does the opposite of borrow method
	 * @return 1 if successful -1 otherwise
	 */
	public int returnOne(){

		if(howManyBorrowed() > 0)

		{

			amount +=1;
			borrowed -=1;
			return 1;

		}

		return -1;
	


	}

}



