package LibraryManagement.Service;

import LibraryManagement.Model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReaderService {
    SQLConnection connection = new SQLConnection();
    RegisterService registerService = new RegisterService();
    BookServices bookServices = new BookServices();
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

    public ArrayList<BorrowedReaders> viewBorrowedReaders(){
        ArrayList<Reader> readerList = selectAllReader();
        ArrayList<BorrowedReaders> borrowedReaderList = new ArrayList<>();
        ArrayList<RegisterForm> registerList = registerService.initRegisterList();
        ArrayList<Book> bookList = bookServices.selectAllBook();

        for(RegisterForm register : registerList) {
                for (Reader reader : readerList) {
                    if (reader.getReaderId() == register.getReaderId()) {
                        for(Book book : bookList){
                            if(book.getBookId() == register.getBookId()){
                                book = new Book(book.getBookId(),book.getBookName(),book.getQuantity());
                                borrowedReaderList.add(new BorrowedReaders(reader.getReaderId(),reader.getReaderName(),reader.getIdentificationId(),
                                reader.getDateOfBirth(),reader.getGender(),reader.getAddress(),reader.getOccupation(),reader.getEmail(),
                                register.getLoanDate(),register.getReturnedDate(), book));
                            }
                        }
                break;
                    }
                }
        }
        System.out.println("Soluong reader: "+ borrowedReaderList.size());
        return borrowedReaderList;
    }
}
