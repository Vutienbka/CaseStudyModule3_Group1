package LibraryManagement.Service;

import LibraryManagement.Model.Reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReaderService {
    SQLConnection connection = new SQLConnection();
    final static String SELECT_ALL_READER = "SELECT * FROM Reader";

    public ArrayList<Reader> selectAllReader(){
        ArrayList<Reader> readerList = new ArrayList<>();
        Connection conn = connection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_READER);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int readerId = rs.getInt("readerId");
                String readerName = rs.getString("readerName");
                String identificationId = rs.getString("identificationId");
                String dateOfBirth = rs.getString("dateOfBirth");
                String gender = rs.getString("gender");
                String address = rs.getString("address");
                String occupation = rs.getString("occupation");
                String email = rs.getString("email");
                readerList.add(new Reader(readerId,readerName,identificationId,dateOfBirth,gender,address,occupation,email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readerList;
    }
    public int viewReaderQuantity(){
        ArrayList<Reader> readerList =selectAllReader();
        return readerList.size();
    }
}
