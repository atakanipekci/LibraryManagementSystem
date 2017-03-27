/*Created by Taha Atakan İpekçi on 22.2.2017*/
import java.io.*;
import java.util.*;
/*
WORKING FIRST TIME : THERE IS NO USERS REGISTERED AND 1 STAFF REGISTERED IN CSV FILES. STAFF NAME:admin PW:admin.
FILES SHOULD BE IN THE FOLLOWING TYPE TO WORK CORRECTLY:
USER FILE : NAME,PW,NAMEOFTHEBORROWEDBOOKS
STAFF FILE: SAME AS USERFILE
BOOKS FILE: NAMEOFTHEBOOK,AUTHORNAME,AMOUNT,HOWMANYBORROWED
 */
public class mainTester {
/*Includes a menu that connects methods with different options . print commands are explaining the methods*/
	public static void main(String[] args) {
		try{
		library myLibrary = new library("GTU","users.csv","books.csv","staff.csv");
		System.out.println("Adding 5.000 users");
		for(int i=0; i<5000; i++){

		myLibrary.staffList.get(0).addUser("user"+i,"password");	
		myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
		}
		
		System.out.println("Done.");
		System.out.println("Removing 5.000 users");
		for(int i=0; i<5000; i++){

		myLibrary.staffList.get(0).removeUser("user"+i);	
		myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
		}
		
		System.out.println("Done.");

		}catch (FileNotFoundException e) {
			System.out.println("Exception : File Not Found");
		}
	}
}

