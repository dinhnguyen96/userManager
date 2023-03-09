package dao;

import model.Province;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProvinceDao extends AbstractDao<Province>
{
    private Connection connection;

    public ProvinceDao()
    {
        connection = getConnection();
    }
    @Override
    public List<Province> findAll()
    {
        return null;
    }

    @Override
    public Province get(Long id)
    {
        if (connection != null)
        {
            try
            {
                String sql = "select * from province where id = ?";
                PreparedStatement p = connection.prepareStatement(sql);
                p.setLong(1,id);
                ResultSet rs = p.executeQuery();
                if (rs.next())
                {
                    String name = rs.getString("name");
                    return new Province(id, name);
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
    public int add(Province province) {
        return 0;
    }

    @Override
    public int update(Province province) {
        return 0;
    }

    @Override
    public int remove(Province province) {
        return 0;
    }
}
