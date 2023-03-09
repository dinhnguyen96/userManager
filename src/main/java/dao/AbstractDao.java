package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDao<T>
{
    private final String URL = "jdbc:mysql://localhost:3306/usermanager";
    private final String USER_NAME = "root";
    private final  String PASSWORD = "Nguyen251096*";


    protected Connection getConnection()
    {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        }
        catch (SQLException e) {
            System.out.println("Error connect !");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Error driver version");
        }
        return connection;
    }
    public abstract List<T> findAll();

    public abstract T get(Long id);

    public abstract int add(T t);

    public abstract int update(T t);

    public abstract int remove(T t);


}
