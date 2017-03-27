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
		try {
			library myLibrary = new library("GTU", "users.csv", "books.csv", "staff.csv");
			System.out.print("************************************************************\n");
			System.out.print("******* WELCOME TO THE GTU LIBRARY MANAGEMENT SYSTEM *******\n");
			System.out.print("************************************************************\n");
			Scanner reader = new Scanner(System.in);
			int flag = 0;
			System.out.println("* Press 1 For User Login ");
			System.out.println("* Press 2 For Staff Login ");
			System.out.println("* Press E To Exit ");
			char n = reader.nextLine().charAt(0);

			while (n != 'E' && n != 'e') {

				if (flag == 1) {
					System.out.println("* Press 1 For User Login ");
					System.out.println("* Press 2 For Staff Login ");
					System.out.println("* Press E To Exit ");
					n = reader.nextLine().charAt(0);
				}
				flag = 1;
				switch (n) {

					case '1':
						System.out.println("Enter Your Username : ");

						String name = reader.nextLine();
						System.out.println("Enter Your Password : ");

						String password = reader.nextLine();

						int i = myLibrary.loginUser(name, password);
						if (i != -1) {
							System.out.println("WELCOME " + name + " ! ");

							System.out.println("* Press 1 To See The Books Our Library Has");
							System.out.println("* Press 2 To Borrow A Book");
							System.out.println("* Press 3 To Return A Book");
							System.out.println("* Press 4 To Change Your User Name");
							System.out.println("* Press 5 To Change Your Password");
							System.out.println("* Press 6 To See Your Account Information");
							System.out.println("* Press E To Exit ");
							n = reader.nextLine().charAt(0);
							int flag2 = 0;
							while (n != 'E' && n != 'e') {
								if (flag2 == 1) {
									System.out.println("* Press 1 To See The Books Our Library Has");
									System.out.println("* Press 2 To Borrow A Book");
									System.out.println("* Press 3 To Return A Book");
									System.out.println("* Press 4 To Change Your User Name");
									System.out.println("* Press 5 To Change Your Password");
									System.out.println("* Press 6 To See Your Account Information");
									System.out.println("* Press E To Exit ");
									n = reader.nextLine().charAt(0);
								}
								flag2 = 1;


								switch (n) {

									case '1':
										System.out.println(myLibrary.toString());
										break;
									case '2':
										System.out.println("* Press 1 If You Only Know The Book's Name");
										System.out.println("* Press 2 If You Know Both The Book's Name And Author's Name");
										System.out.println("* Press E To Exit ");
										n = reader.nextLine().charAt(0);

										if (n == '1') {
											System.out.println("* Enter The Book's Name");
											String bookName = reader.nextLine();
											myLibrary.userList.get(i).borrowBook(bookName);
											myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										}
										if (n == '2') {
											System.out.println("* Enter The Book's Name");
											String bookName = reader.nextLine();
											System.out.println("* Enter The Author's Name");
											String authorName = reader.nextLine();
											myLibrary.userList.get(i).borrowBook(bookName, authorName);
											myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										}
										break;


									case '3':
										System.out.println("* Press 1 If You Only Know The Book's Name Which You Want To Return");
										System.out.println("* Press 2 If You Know Both The Book's Name And Author's Name Which You Want To Return");
										System.out.println("* Press E To Exit ");
										n = reader.nextLine().charAt(0);

										if (n == '1') {
											System.out.println("* Enter The Book's Name");
											String bookName = reader.nextLine();
											myLibrary.userList.get(i).returnBook(bookName);
											myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										}
										if (n == '2') {
											System.out.println("* Enter The Book's Name");
											String bookName = reader.nextLine();
											System.out.println("* Enter The Author's Name");
											String authorName = reader.nextLine();
											myLibrary.userList.get(i).returnBook(bookName, authorName);
											myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										}
										break;
									case '4':
										System.out.println("* Enter Your New User Name: ");
										String newName = reader.nextLine();
										myLibrary.userList.get(i).setName(newName);
										myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										break;

									case '5':
										System.out.println("* Enter Your New Password: ");
										String newPassword = reader.nextLine();
										myLibrary.userList.get(i).setPassword(newPassword);
										myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										break;

									case '6':
										System.out.println(myLibrary.userList.get(i).toString());
										break;
									default:


								}

							}
						}


						break;

					case '2':
						System.out.println("Enter Your Staff Name : ");

						String name2 = reader.nextLine();
						System.out.println("Enter Your Password : ");

						String password2 = reader.nextLine();

						int j = myLibrary.loginStaff(name2, password2);
						if (j != -1) {
							System.out.println("WELCOME " + name2 + " ! ");

							System.out.println("* Press 1 To See The Books Our Library Has");
							System.out.println("* Press 2 To Borrow A Book");
							System.out.println("* Press 3 To Return A Book");
							System.out.println("* Press 4 To Change Your Staff Name");
							System.out.println("* Press 5 To Change Your Password");
							System.out.println("* Press 6 To See Your Account Information");
							System.out.println("* Press 7 To Add A New User");
							System.out.println("* Press 8 To Remove A User");
							System.out.println("* Press 9 To Add A New Staff");
							System.out.println("* Press 0 To Remove Staff");
							System.out.println("* Press A To Add A New Book");
							System.out.println("* Press B To Remove A Book ");
							System.out.println("* Press C To List All Users");


							System.out.println("* Press E To Exit ");
							n = reader.nextLine().charAt(0);
							int flag2 = 0;
							while (n != 'E' && n != 'e') {
								if (flag2 == 1) {
									System.out.println("* Press 1 To See The Books Our Library Has");
									System.out.println("* Press 2 To Borrow A Book");
									System.out.println("* Press 3 To Return A Book");
									System.out.println("* Press 4 To Change Your Staff Name");
									System.out.println("* Press 5 To Change Your Password");
									System.out.println("* Press 6 To See Your Account Information");
									System.out.println("* Press 7 To Add A New User");
									System.out.println("* Press 8 To Remove A User");
									System.out.println("* Press 9 To Add A New Staff");
									System.out.println("* Press 0 To Remove Staff");
									System.out.println("* Press A To Add A New Book");
									System.out.println("* Press B To Remove A Book ");
									System.out.println("* Press C To List All Users");

									System.out.println("* Press E To Exit ");
									n = reader.nextLine().charAt(0);
								}
								flag2 = 1;


								switch (n) {

									case '1':
										System.out.println(myLibrary.toString());
										break;
									case '2':
										System.out.println("* Press 1 If You Only Know The Book's Name");
										System.out.println("* Press 2 If You Know Both The Book's Name And Author's Name");
										System.out.println("* Press E To Exit ");
										n = reader.nextLine().charAt(0);

										if (n == '1') {
											System.out.println("* Enter The Book's Name");
											String bookName = reader.nextLine();
											myLibrary.staffList.get(j).borrowBook(bookName);
											myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										}
										if (n == '2') {
											System.out.println("* Enter The Book's Name");
											String bookName = reader.nextLine();
											System.out.println("* Enter The Author's Name");
											String authorName = reader.nextLine();
											myLibrary.staffList.get(j).borrowBook(bookName, authorName);
											myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										}
										break;


									case '3':
										System.out.println("* Press 1 If You Only Know The Book's Name Which You Want To Return");
										System.out.println("* Press 2 If You Know Both The Book's Name And Author's Name Which You Want To Return");
										System.out.println("* Press E To Exit ");
										n = reader.nextLine().charAt(0);

										if (n == '1') {
											System.out.println("* Enter The Book's Name");
											String bookName = reader.nextLine();
											myLibrary.staffList.get(j).returnBook(bookName);
											myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										}
										if (n == '2') {
											System.out.println("* Enter The Book's Name");
											String bookName = reader.nextLine();
											System.out.println("* Enter The Author's Name");
											String authorName = reader.nextLine();
											myLibrary.staffList.get(j).returnBook(bookName, authorName);
											myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										}
										break;
									case '4':
										System.out.println("* Enter Your New User Name: ");
										String newName2 = reader.nextLine();
										myLibrary.staffList.get(j).setName(newName2);
										myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										break;

									case '5':
										System.out.println("* Enter Your New Password: ");
										String newPassword2 = reader.nextLine();
										myLibrary.staffList.get(j).setPassword(newPassword2);
										myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										break;

									case '6':
										System.out.println(myLibrary.staffList.get(j).toString());
										break;

									case '7':
										System.out.println("* Enter The User Name Of The New User: ");
										String newName3 = reader.nextLine();
										System.out.println("* Enter The Password Of The New User: ");
										String newPassword3 = reader.nextLine();
										myLibrary.staffList.get(j).addUser(newName3, newPassword3);
										myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										break;


									case '8':
										System.out.println("* Enter The User Name Of The User You Want To Remove: ");
										String newName4 = reader.nextLine();
										myLibrary.staffList.get(j).removeUser(newName4);
										myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										break;


									case '9':
										System.out.println("* Enter The Staff Name Of The New Staff: ");
										String newName5 = reader.nextLine();
										System.out.println("* Enter The Password Of The New Staff: ");
										String newPassword5 = reader.nextLine();
										myLibrary.staffList.get(j).addStaff(newName5, newPassword5);

										myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										break;

									case '0':
										System.out.println("* Enter The Staff Name Of The Staff You Want To Remove: ");
										String newName6 = reader.nextLine();
										myLibrary.staffList.get(j).removeStaff(newName6);
										myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										break;
									case 'a':
									case 'A':
										System.out.println("* Press 1 If You Only Know The Book's Name Which You Want To Add");
										System.out.println("* Press 2 If You Know Both The Book's Name And Author's Name Which You Want To Add");

										System.out.println("* Press 3 If You Know The Book's Name And Also The Amount Of The Book Which You Want To Add");

										System.out.println("* Press 4 If You Know Both The Book's Name And Author's Name And Also The Amount Of The Book Which You Want To Add");
										System.out.println("* Press E To Exit ");
										n = reader.nextLine().charAt(0);

										if (n == '1') {
											System.out.println("* Enter The Book's Name");
											String bookName = reader.nextLine();
											myLibrary.staffList.get(j).addBook(bookName);
											myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										}
										if (n == '2') {
											System.out.println("* Enter The Book's Name");
											String bookName = reader.nextLine();
											System.out.println("* Enter The Author's Name");
											String authorName = reader.nextLine();
											myLibrary.staffList.get(j).addBook(bookName, authorName);
											myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										}

										if (n == '3') {
											System.out.println("* Enter The Book's Name");
											String bookName = reader.nextLine();
											System.out.println("* Enter The Amount");
											int amount = Integer.parseInt(reader.nextLine());
											myLibrary.staffList.get(j).addBook(bookName, amount);
											myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										}

										if (n == '4') {
											System.out.println("* Enter The Book's Name");
											String bookName = reader.nextLine();
											System.out.println("* Enter The Author's Name");
											String authorName = reader.nextLine();
											System.out.println("* Enter The Amount");
											int amount = Integer.parseInt(reader.nextLine());
											myLibrary.staffList.get(j).addBook(bookName, authorName, amount);
											myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										}

										break;
									case 'b':
									case 'B':
										System.out.println("* Press 1 If You Only Know The Book's Name Which You Want To Remove");
										System.out.println("* Press 2 If You Know Both The Book's Name And Author's Name Which You Want To Remove");

										System.out.println("* Press 3 If You Know The Book's Name And Also The Amount Of The Book Which You Want To Remove");

										System.out.println("* Press 4 If You Know Both The Book's Name And Author's Name And Also The Amount Of The Book Which You Want To Remove");
										System.out.println("* Press E To Exit ");
										n = reader.nextLine().charAt(0);

										if (n == '1') {
											System.out.println("* Enter The Book's Name");
											String bookName = reader.nextLine();
											myLibrary.staffList.get(j).removeBook(bookName);
											myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										}
										if (n == '2') {
											System.out.println("* Enter The Book's Name");
											String bookName = reader.nextLine();
											System.out.println("* Enter The Author's Name");
											String authorName = reader.nextLine();
											myLibrary.staffList.get(j).removeBook(bookName, authorName);
											myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										}

										if (n == '3') {
											System.out.println("* Enter The Book's Name");
											String bookName = reader.nextLine();
											System.out.println("* Enter The Amount");
											int amount = Integer.parseInt(reader.nextLine());
											myLibrary.staffList.get(j).removeBook(bookName, amount);
											myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										}

										if (n == '4') {
											System.out.println("* Enter The Book's Name");
											String bookName = reader.nextLine();
											System.out.println("* Enter The Author's Name");
											String authorName = reader.nextLine();
											System.out.println("* Enter The Amount");
											int amount = Integer.parseInt(reader.nextLine());
											myLibrary.staffList.get(j).removeBook(bookName, authorName, amount);
											myLibrary.writeAll("users.csv", "staff.csv", "books.csv");
										}

										break;


									case 'c':
									case 'C':
										myLibrary.staffList.get(j).listUsers();
										break;


									default:


								}

							}
						}

					default:

				}

			}
		}catch (FileNotFoundException e) {
			System.out.println("Exception : File Not Found");
		}
		}
	}

