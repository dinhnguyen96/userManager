package dao;

import model.Province;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao<User>
{

    private  AbstractDao<Province> provinceAbstractDao;
    private Connection connection;

    public UserDao()
    {
        connection = getConnection();
        provinceAbstractDao = new ProvinceDao();
    }

    @Override
    public List<User> findAll()
    {
        if (connection != null)
        {
            try
            {
                List<User> userList = new ArrayList<>();
                String sql = "select * from user";
                PreparedStatement p = connection.prepareStatement(sql);
                ResultSet rs = p.executeQuery();
                while (rs.next())
                {
                    Long id = rs.getLong("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String country = rs.getString("country");
                    Long province_id = rs.getLong("province_id");
                    Province province = provinceAbstractDao.get(province_id);
                    User user = new User(id,name,email,country,province);
                    userList.add(user);
                }
                return userList;
            }
            catch (SQLException e)
            {
                System.out.println("Error data query");
            }
        }
        return null;
    }

    @Override
    public User get(Long id)
    {
        if (connection != null)
        {
            try
            {
                String sql = "select * from user where id = ?";
                PreparedStatement p = connection.prepareStatement(sql);
                p.setLong(1,id);
                ResultSet rs = p.executeQuery();
                if (rs.next())
                {
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String country = rs.getString("country");
                    return new User(id,name,email,country);
                }
            }
            catch (SQLException e)
            {
                System.out.println("Error data query");
            }
        }
        return null;
    }

    @Override
    public int add(User user)
    {
        int result = 0;
        if (connection != null)
        {
            try
            {
                String sql = "insert into user(name,email,country) values(?,?,?)";
                PreparedStatement p = connection.prepareStatement(sql);
                p.setString(1,user.getName());
                p.setString(2,user.getEmail());
                p.setString(3, user.getCountry());
                result = p.executeUpdate();
            }
            catch (SQLException e)
            {
                System.out.println("Error data query");
            }
        }
        return result;
    }

    @Override
    public int update(User user)
    {
        int result = 0;
        if (connection != null)
        {
            try
            {
                String sql = "update user set name = ?, email = ?, country = ? where id = ?";
                PreparedStatement p = connection.prepareStatement(sql);
                p.setString(1,user.getName());
                p.setString(2,user.getEmail());
                p.setString(3, user.getCountry());
                p.setLong(4, user.getId());
                result = p.executeUpdate();
            }
            catch (SQLException e)
            {
                System.out.println("Error data query");
            }
        }
        return result;
    }

    @Override
    public int remove(User user)
    {
        int result = 0;
        if (connection != null)
        {
            try
            {
                String sql = "delete from user where id = ?";
                PreparedStatement p = connection.prepareStatement(sql);
                p.setLong(1, user.getId());
                result = p.executeUpdate();
            }
            catch (SQLException e)
            {
                System.out.println("Error data query");
            }
        }
        return result;
    }
}
