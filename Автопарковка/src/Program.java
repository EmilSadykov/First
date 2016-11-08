/**
 * Created by Emil on 08.11.2016.
 */
public class Program {
    public static void main(String[] args) {
        Parking parking = new Parking();

        Car car = new Car();
        parking.AddDevice(car);
        System.out.println("Device count " + parking.getDeviceListCount() + "; index = "+car.index);

        Jeep jeep = new Jeep();
        parking.AddDevice(jeep);
        System.out.println("Device count " + parking.getDeviceListCount()+ "; index = "+jeep.index);

        car.Crash();
        parking.DellDevice(car);
        System.out.println("Device count " + parking.getDeviceListCount());

        parking.AllDevicesMove();

    }
}
