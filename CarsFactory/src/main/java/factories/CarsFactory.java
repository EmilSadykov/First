package factories;

import dao.CarsDao;
import model.Cars;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class CarsFactory {
    private static CarsFactory instance;
    private CarsDao carsDao;
    private Properties properties;

    static {
        try {
            instance = new CarsFactory();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private CarsFactory() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("components.properties");
        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("property file not found");
        }
        String carsDaoName = properties.getProperty("cars_dao");
        System.out.println("carsDaoName : " + carsDaoName);
        this.carsDao = (CarsDao)Class.forName(carsDaoName).newInstance();
    }

    public void addCar(Cars cars) throws SQLException {
        carsDao.addCar(cars);
    }

    public void updateCar(Cars cars) throws SQLException {
        carsDao.updateCar(cars);
    }

    public void findAllCars() throws SQLException {
        carsDao.findAllCars();
    }

    public static CarsFactory getInstance() {
        return instance;
    }
}