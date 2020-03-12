package com.codegym.UserService;

import com.codegym.Model.Img;
import com.codegym.Model.Reader;

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
