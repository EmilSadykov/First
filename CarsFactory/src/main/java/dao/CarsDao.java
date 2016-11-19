package dao;

import model.Cars;

import java.sql.SQLException;
import java.util.List;

public interface CarsDao {
    //Добавить новое авто
    void addCar(Cars cars) throws SQLException;

    //Изменить авто
    void updateCar(Cars cars) throws SQLException;

    //Удалить авто
    void dellCar(Cars cars) throws SQLException;

    //Вывести список авто
    List<Cars> findAllCars() throws SQLException;
}