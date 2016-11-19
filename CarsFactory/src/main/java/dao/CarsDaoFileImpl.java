package dao;

import model.Cars;

import java.sql.SQLException;

public class CarsDaoFileImpl implements CarsDao {
    public CarsDaoFileImpl() {
    }

    public void addCar(Cars cars) throws SQLException {
        System.out.println("Cars save to file " + cars.getName() + " : " + cars.getId());
    }

    public void updateCar(Cars cars) {

    }

    public void dellCar(Cars cars) {

    }

    public void findAllCars() {

    }
}
