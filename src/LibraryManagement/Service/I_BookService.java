package LibraryManagement.Service;

import LibraryManagement.Model.Book;

import java.sql.Connection;
import java.util.ArrayList;

public interface I_BookService {

    ArrayList<Book> selectAllBook();
    boolean saveBook(Book book);
    Book findById(int Id);
    boolean addNewBook(Book book);
    void removeBook(int Id);
}
