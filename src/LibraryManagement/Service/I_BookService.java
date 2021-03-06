package LibraryManagement.Service;

import LibraryManagement.Model.Book;

import java.sql.Connection;
import java.util.ArrayList;

public interface I_BookService {

    ArrayList<Book> selectAllBook();
    void saveBook(Book book);
    Book findById(int Id);
    boolean addNewBook(int Id, Book book);
    void removeBook(int Id);
}
