package com.pace.library.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pace.library.entity.Book;
import com.pace.library.helper.DbConnector;
public class BookDAO {

    private Connection connection = null;
    private PreparedStatement pstatement = null;
    private ResultSet resultSet = null;
    //Book book=new Book();
    ArrayList<Book> bookList = null;
    //
    private static String bookQry = "select * from book";

    /**********************Get book data*******************/
    public ArrayList<Book>  getBooks() throws ClassNotFoundException, SQLException {
        //process to get books from table into bookList:
        //1.Get the book data from the table into book list
        //return bookList
        try {
            //open the connection
            connection = DbConnector.createConnection();
            //create pstatement
            pstatement = connection.prepareStatement(bookQry);
            //get the result
            resultSet = pstatement.executeQuery();
            Book book;

            bookList = new ArrayList<Book>();
            while (resultSet.next()) {
                int bookId;
                String bookName;
                String author;
                float price;
                // declare the pojo
                book = new Book();
                //get the row details
                bookId = resultSet.getInt(1);
                bookName = resultSet.getString(2);
                author = resultSet.getString(3);
                price = resultSet.getFloat(4);
                //add this data to book bean
                //set the pojo with retrived values from the row
                book.setBookId(bookId);
                book.setBname(bookName);
                book.setAuthor(author);
                book.setPrice(price);
                //add the book to booklist
                bookList.add(book);
                book = null;   
            } //end the while loop


        } catch (SQLException sqex) {

            //in future if we have any logic we can execute in  catch block
            //clossing the database connection will be in finally

        } finally {
            DbConnector.closeConnection();
        }
       return bookList;
    }
    public void showBookList(ArrayList<Book> bookList2) {
        System.out.println("In DAO layer");
        for (Book book: bookList2) {
            System.out.print(book.getBookId());
            System.out.print("\t" + book.getBname());
            System.out.print("\t" + book.getAuthor());
            System.out.println("\t" + book.getPrice());
        }
    }
    /*********************insert book details**********************/
    public void insertBookDetails(Book book) throws ClassNotFoundException, SQLException {
    	//Book-entity,book-object 
        connection = DbConnector.createConnection();
        String insQry = "Insert into book values(?,?,?,?)";
        pstatement = connection.prepareStatement(insQry);
        pstatement.setInt(1, book.getBookId());
        pstatement.setString(2, book.getBname());
        pstatement.setString(3, book.getAuthor());
        pstatement.setFloat(4, book.getPrice());
        int rows = pstatement.executeUpdate();
        System.out.println(rows + "Rows Inserted!");
        DbConnector.closeConnection();
    }

    /*******************delete book details*******************/
    public boolean deleteBook(int id) throws SQLException, ClassNotFoundException {
        pstatement = null;
       
        connection = DbConnector.createConnection();
        String delQry = "delete from book where id=?";
        pstatement = connection.prepareStatement(delQry);
        pstatement.setInt(1, id);
        int rows = pstatement.executeUpdate();
        boolean isDelete = true;
        if (rows != 0) {
            //if rows is non-zero ,it is deleted
            isDelete = true;
        } else {
            isDelete = false;
        }
        DbConnector.closeConnection();
        return isDelete;

    }
    /********************updating book****************/
    public boolean updateBook(int id) throws SQLException, ClassNotFoundException {
        pstatement = null;
        connection = DbConnector.createConnection();
        String updPriceQry = "update book set price=price*0.10 where id=?";
        pstatement = null;
        pstatement = connection.prepareStatement(updPriceQry);
        pstatement.setInt(1, id);
        int rows = pstatement.executeUpdate();
        boolean isUpdate = true;
        if (rows != 0) {
            //if row available ,it is updated
            isUpdate = true;
        } else {
            isUpdate = false;

        }
        DbConnector.closeConnection();
        return isUpdate;
    }
    //service layer is sed to write the bussiness of the logic

} //end of dao clss