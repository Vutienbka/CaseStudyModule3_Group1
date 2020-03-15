package LibraryManagament.UserService;

import LibraryManagament.Model.Img;
import LibraryManagament.Model.Reader;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public void insertUser(Reader reader) throws SQLException;

    public Reader selectUser(int readerId);

    public List<Reader> selectAllUsers();

    public boolean deleteUser(int readerId) throws SQLException;

    public boolean updateUser(Reader reader) throws SQLException;

    public List<Img> selectAllImgs() throws SQLException;

    public Img selectImg(int imageId);

    public List<Img> selectAllImgsAffection() throws SQLException;

    public List<Img> selectAllImgsEconomy() throws SQLException;

    public List<Img> selectAllImgsHistory() throws SQLException;

    public List<Img> listFind(String bookName) throws SQLException;

    public void insertOrder(Img img) throws SQLException;

    public List<Img> listCart( ) throws SQLException;



}
