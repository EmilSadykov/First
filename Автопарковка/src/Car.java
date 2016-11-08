/**
 * Created by Emil on 08.11.2016.
 */
public class Car extends Transport {
    public Car() {
        deviceType = "Car";
    }

    @Override
    public void Crash() {
        System.out.println("Help me! I'm crash");
    }

    @Override
    public void Move() {
        System.out.println("My speed 100 mph!");
    }
}
