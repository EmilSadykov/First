package dao;

import model.Cars;
import model.Owner;

import java.sql.*;
import java.util.List;

public class CarsDaoPostgreImpl implements CarsDao {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;

    public CarsDaoPostgreImpl() throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
        String name = "postgres";
        String password = "gfhjkzytn";
        Class.forName("org.postgresql.Driver");
        System.out.println("Драйвер подключен");
        connection = DriverManager.getConnection(url, name, password);
        System.out.println("Соединение установлено");
    }

    public void addCar(Cars cars) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO cars(id, name, private) values(?, ?, ?)");
        preparedStatement.setInt(1, cars.getId());
        preparedStatement.setString(2, cars.getName());
        preparedStatement.setInt(3, cars.getaOwner().getId());
        preparedStatement.executeUpdate();
        System.out.println("INSERT INTO 'cars' " + cars.getId() + " : " + cars.getName());
    }

    public void updateCar(Cars cars) throws SQLException {
        preparedStatement = connection.prepareStatement("UPDATE cars SET name = ? where id = ?");
        preparedStatement.setString(1, cars.getName());
        preparedStatement.setInt(2, cars.getId());
        preparedStatement.executeUpdate();
        System.out.println("UPDATE 'cars' " + cars.getId() + " : " + cars.getName());
    }

    public void dellCar(Cars cars) throws SQLException {
        preparedStatement = connection.prepareStatement("DELETE FROM cars where id = ?");
        preparedStatement.setInt(1, cars.getId());
        preparedStatement.executeUpdate();
        System.out.println("DELETE 'cars' " + cars.getId() + " : " + cars.getName());
    }

    public List<Cars> findAllCars() throws SQLException {
        List<Cars> carsList = null;
        preparedStatement = connection.prepareStatement("SELECT * FROM cars RIGHT JOIN private ON cars.private=private.id");
        ResultSet result2 = preparedStatement.executeQuery();
        System.out.println("Выводим список cars");
        while (result2.next()) {
            Owner owner = new Owner(result2.getInt(4), result2.getString(5));
            Cars cars = new Cars(result2.getInt(1), result2.getString(2), owner);
            carsList.add(cars);
            System.out.println(result2.getInt(1) + " : " + result2.getString(2) + " : " + result2.getString(5));
        }
        return carsList;
    }

}
