import dao.CarsDaoPostgreImpl;
import dao.OwnerDaoPostgreImpl;
import factories.CarsFactory;
import model.Cars;
import model.Owner;

import java.io.IOException;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        CarsFactory carsFactory = CarsFactory.getInstance();
        carsFactory.findAllCars();
    }

    public static void update() throws SQLException {
        CarsFactory carsFactory = CarsFactory.getInstance();
        Owner aprivate = new Owner(3, "Sidorov");
        Cars cars = new Cars(3, "Jeep", aprivate);
        carsFactory.updateCar(cars);
    }

    public static void writeToJDBC() throws SQLException, ClassNotFoundException, IOException  {
        Owner aprivate = new Owner(3, "Sidorov");
        OwnerDaoPostgreImpl privateDaoPostgre = new OwnerDaoPostgreImpl();
        privateDaoPostgre.addPrivate(aprivate);
        Cars cars = new Cars(3, "Niva", aprivate);
        CarsDaoPostgreImpl carsDaoPostgre = new CarsDaoPostgreImpl();
        carsDaoPostgre.addCar(cars);
    }

    public static void write() throws SQLException, ClassNotFoundException, IOException  {
        CarsFactory carsFactory = CarsFactory.getInstance();
        Owner aprivate = new Owner(3, "Sidorov");
        Cars cars = new Cars(3, "Niva", aprivate);
        carsFactory.addCar(cars);
    }

}
