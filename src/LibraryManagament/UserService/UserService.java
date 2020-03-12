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

    public List<Img> selectAllImgs();
}
