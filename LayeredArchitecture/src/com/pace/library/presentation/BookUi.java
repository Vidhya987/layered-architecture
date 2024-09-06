package com.pace.library.presentation;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.pace.library.entity.Book;
import com.pace.library.service.BookServiceProvider;
public class BookUi {

	public static void main(String[] args)throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		Book book = new Book();
		ArrayList<Book>bookList = new ArrayList<Book>();
		
		BookServiceProvider bookServiceProvider = new BookServiceProvider();
		Scanner sc = new Scanner(System.in);
		int choice;
		
		
		while(true) {
			System.out.println("1.add Book Details 2.Show Book Details" +
					"3.Delete Book 4.Update Book 5.Exit\n");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				book = null;
				book = new Book();
				System.out.println("Enter book id,book name,author,price");
				book.setBookId(sc.nextInt());
				sc.nextLine();
				book.setBname(sc.next());
				book.setAuthor(sc.next());
				book.setPrice(sc.nextFloat());
				sc.nextLine();
				bookServiceProvider.insertBookService(book);
				break;
			case 2:
				//1.get books
				bookList = bookServiceProvider.getBookService();
				System.out.println("No of rows in the table ="+ bookList);
				 bookServiceProvider.showBooksServices(bookList);

				break;
			case 3:
				System.out.println("Enter the book id:");
				int id=sc.nextInt();
				bookServiceProvider.deleteBookService(id);
				break;
			case 4:
				System.out.println("Enter the book id:");
				int bid=sc.nextInt();
				bookServiceProvider.updateBookService(bid);
				break;
				//System class has static  method called exit.
			case 5:
				System.out.println("Thanks for using our application!");
				System.exit(0);//termination of loop
				break;
			}
		}
	}

}