package dao;

import model.Owner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class OwnerDaoPostgreImpl implements OwnerDao {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;

    public OwnerDaoPostgreImpl() throws SQLException, ClassNotFoundException, IOException {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("components.properties");
        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("property file not found");
        }
        String url = properties.getProperty("base_url");
        String name = properties.getProperty("user_name");
        String password = properties.getProperty("user_password");

        System.out.println(url + " : " + name + " : " + password);
        Class.forName("org.postgresql.Driver");
        System.out.println("Драйвер подключен");
        connection = DriverManager.getConnection(url, name, password);
        System.out.println("Соединение установлено");
    }

    public void addOwner(Owner owner) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO private(id, name) values(?, ?)");
        preparedStatement.setInt(1, owner.getId());
        preparedStatement.setString(2, owner.getName());
        preparedStatement.executeUpdate();
        System.out.println("INSERT INTO 'private' " +owner.getId() + " : " + owner.getName());
    }

    public void updateOwner(Owner owner) throws SQLException {
        preparedStatement = connection.prepareStatement("UPDATE private SET name = ? where id = ?");
        preparedStatement.setString(1, owner.getName());
        preparedStatement.setInt(2, owner.getId());
        preparedStatement.executeUpdate();
        System.out.println("UPDATE 'owner' " + owner.getId() + " : " + owner.getName());
    }

    public void dellOwner(Owner owner) throws SQLException {
        preparedStatement = connection.prepareStatement("DELETE FROM private where id = ?");
        preparedStatement.setInt(1, owner.getId());
        preparedStatement.executeUpdate();
        System.out.println("DELETE 'cars' " + owner.getId() + " : " + owner.getName());
    }

    public List<Owner> findAllOwners() throws SQLException {
        List<Owner> ownerList = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM private");
        ResultSet result2 = preparedStatement.executeQuery();
        System.out.println("Выводим список владельце");
        while (result2.next()) {
            Owner owner = new Owner(result2.getInt(1), result2.getString(2));
            ownerList.add(owner);
            System.out.println(result2.getInt(1) + " : " + result2.getString(2));
        }
        return ownerList;
    }
}
