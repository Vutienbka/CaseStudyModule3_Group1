package LibraryManagement.Service;

import LibraryManagement.Model.Book;
import LibraryManagement.Model.RegisterForm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegisterService {
    SQLConnection connection = new SQLConnection();
    final static String SELECT_ALL_REGISTER = "SELECT * FROM registerDetail";
    private static ArrayList<RegisterForm> registerList;

    public ArrayList<RegisterForm> initRegisterList(){
        ArrayList<RegisterForm> registerList = new ArrayList<>();
        Connection conn = connection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_REGISTER);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int registerId = rs.getInt("registerId");
                int readerId = rs.getInt("readerId");
                int bookTypeId = rs.getInt("bookTypeId");
                int bookTitleId = rs.getInt("bookTitleId");
                int bookId = rs.getInt("bookId");
                String loanDate = rs.getString("loanDate");
                String loanSituation = rs.getString("loanSituation");
                String dueDate = rs.getString("dueDate");
                String returnedDate = rs.getString("returnedDate");
                String receiveSituation = rs.getString("receiveSituation");
                int quantity = rs.getInt("quantity");
                registerList.add(new RegisterForm(registerId,readerId,bookTypeId,bookTitleId,bookId,loanDate,
                        loanSituation,dueDate,returnedDate,receiveSituation,quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registerList;
    }


}

