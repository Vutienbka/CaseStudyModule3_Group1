package LibraryManagament.UserService;

import LibraryManagament.Model.Img;
import LibraryManagament.Model.Reader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServiceImp implements UserService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/CaseStudy";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Lamlam@95";

    private static final String INSERT_USERS_SQL = "INSERT INTO Reader (readerName, identificationId, dateOfBirth,address,occupation,email) VALUES " +
            " (?, ?, ?, ?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select readerId,readerName,identificationId,dateOfBirth,address,occupation,email from Reader where readerId =?";
    private static final String SELECT_ALL_USERS = "select * from Reader;";
    private static final String DELETE_USERS_SQL = "delete from Reader where readerId = ?;";
    private static final String UPDATE_USERS_SQL = "update Reader set readerName = ?,identificationId= ?, dateOfBirth =?, address =?, occupation =?, email =? where readerId = ?;";
    private static final String SELECT_ALL_IMGS = "select bookId,bookImage,bookName,typeOfBook from bookDetail;";
    private static final String SELECT_IMG_BY_ID = "select bookId,bookImage,bookName,typeOfBook from bookDetail where bookId =?";
    private static final String SELECT_ALL_IMGS_AFFECTION = "select bookId,bookImage,bookName,typeOfBook from bookDetail where typeOfBook = 'Tình Cảm';";
    private static final String SELECT_ALL_IMGS_ECONOMY = "select bookId,bookImage,bookName,typeOfBook from bookDetail where typeOfBook = 'Kinh Tế';";
    private static final String SELECT_ALL_IMGS_HISTORY = "select bookId,bookImage,bookName,typeOfBook from bookDetail where typeOfBook = 'Lịch Sử';";
    private static final String SELECT_ALL_IMGS_NAME = "select bookId,bookImage,bookName,typeOfBook from bookDetail where bookName = ?;";
    private static final String INSERT_ORDER_SQL = "INSERT INTO image (imageId,img,nameBook,imageType) VALUES " +
            " (?, ?, ?, ?);";
    private static final String SELECT_ALL_CART = "select * from image;";
    private static final String SELECT_FIND = "select bookId,bookImage,bookName,typeOfBook from bookDetail where bookName like  ''%' + ? + '%''";

    public UserServiceImp() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public void insertUser(Reader reader) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, reader.getReaderName());
            preparedStatement.setString(2, reader.getIdentificationId());
            preparedStatement.setString(3, reader.getDateOfBirth());
            preparedStatement.setString(4, reader.getAddress());
            preparedStatement.setString(5, reader.getOccupation());
            preparedStatement.setString(6, reader.getEmail());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Reader selectUser(int readerId) {
        Reader reader = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, readerId);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String readerName = rs.getString("readerName");
                String identificationId = rs.getString("identificationId");
                String dateOfBirth = rs.getString("dateOfBirth");
                String address = rs.getString("address");
                String occupation = rs.getString("occupation");
                String email = rs.getString("email");
                reader = new Reader(readerId, readerName, identificationId, dateOfBirth, address, occupation, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reader;
    }

    @Override
    public List<Reader> selectAllUsers() {
        List<Reader> readers = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
                int readerId = rs.getInt("readerId");
                String readerName = rs.getString("readerName");
                String identificationId = rs.getString("identificationId");
                String dateOfBirth = rs.getString("dateOfBirth");
                String address = rs.getString("address");
                String occupation = rs.getString("occupation");
                String email = rs.getString("email");
                readers.add(new Reader(readerId, readerName, identificationId, dateOfBirth, address, occupation, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return readers;
    }

    @Override
    public boolean deleteUser(int readerId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, readerId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(Reader reader) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, reader.getReaderName());
            statement.setString(2, reader.getIdentificationId());
            statement.setString(3, reader.getDateOfBirth());
            statement.setString(4, reader.getAddress());
            statement.setString(5, reader.getOccupation());
            statement.setString(6, reader.getEmail());
            statement.setInt(7, reader.getReaderId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<Img> selectAllImgs() throws SQLException {
        List<Img> imgs = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_IMGS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
                int imageId = rs.getInt("bookId");
                String img = rs.getString("bookImage");
                String nameBook = rs.getString("bookName");
                String imageType = rs.getString("typeOfBook");
                imgs.add(new Img(imageId, img, nameBook, imageType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imgs;
    }

    @Override
    public Img selectImg(int bookId) {
        Img img = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_IMG_BY_ID);) {
            preparedStatement.setInt(1, bookId);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String imgd = rs.getString("bookImage");
                String nameBook = rs.getString("bookName");
                String imageType = rs.getString("typeOfBook");
                img = new Img(bookId, imgd, nameBook, imageType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return img;
    }

    @Override
    public List<Img> selectAllImgsAffection() throws SQLException {
        List<Img> imgs = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_IMGS_AFFECTION);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
                int imageId = rs.getInt("bookId");
                String img = rs.getString("bookImage");
                String nameBook = rs.getString("bookName");
                String imageType = rs.getString("typeOfBook");
                imgs.add(new Img(imageId, img, nameBook, imageType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imgs;
    }

    @Override
    public List<Img> selectAllImgsEconomy() throws SQLException {
        List<Img> imgs = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_IMGS_ECONOMY);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
                int imageId = rs.getInt("bookId");
                String img = rs.getString("bookImage");
                String nameBook = rs.getString("bookName");
                String imageType = rs.getString("typeOfBook");
                imgs.add(new Img(imageId, img, nameBook, imageType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imgs;
    }

    @Override
    public List<Img> selectAllImgsHistory() throws SQLException {
        List<Img> imgs = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_IMGS_HISTORY);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
                int imageId = rs.getInt("bookId");
                String img = rs.getString("bookImage");
                String nameBook = rs.getString("bookName");
                String imageType = rs.getString("typeOfBook");
                imgs.add(new Img(imageId, img, nameBook, imageType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imgs;
    }

//    @Override
//    public List<Img> listFind(String bookName) throws SQLException {
//        List<Img> finds = new ArrayList<>();
//        // Step 1: Establishing a Connection
//        try (Connection connection = getConnection();
//
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_IMGS_NAME);) {
//            preparedStatement.setString(1, bookName);
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
////                int id = rs.getInt("id");
////                String name = rs.getString("name");
////                String email = rs.getString("email");
////                String country = rs.getString("country");
//                int imageId = rs.getInt("bookId");
//                String img = rs.getString("bookImage");
//                String nameBook = rs.getString("bookName");
//                String imageType = rs.getString("typeOfBook");
//                finds.add(new Img(imageId, img, nameBook, imageType));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return finds;
//    }

    @Override
    public void insertOrder(Img img) throws SQLException {
        System.out.println(INSERT_ORDER_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_SQL)) {
            preparedStatement.setInt(1, img.getImageId());
            preparedStatement.setString(2, img.getImg());
            preparedStatement.setString(3, img.getNameBook());
            preparedStatement.setString(4, img.getImageType());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Img> listCart() throws SQLException {
        List<Img> listCarts = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CART);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
                int imageId = rs.getInt("imageId");
                String img = rs.getString("img");
                String nameBook = rs.getString("nameBook");
                String imageType = rs.getString("imageType");
                listCarts.add(new Img(imageId, img, nameBook, imageType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCarts;
    }

    @Override
    public List<Img> listFind(String bookName) throws SQLException {
        List<Img> listFinds = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FIND);) {
            preparedStatement.setString(1, bookName);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String country = rs.getString("country");
                int imageId = rs.getInt("bookId");
                String img = rs.getString("bookImage");
                String nameBook = rs.getString("bookName");
                String imageType = rs.getString("typeOfBook");
                listFinds.add(new Img(imageId, img, nameBook, imageType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listFinds;
    }

}

