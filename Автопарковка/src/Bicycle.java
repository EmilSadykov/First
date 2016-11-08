/**
 * Created by Emil on 08.11.2016.
 */
public class Bicycle extends Transport {
    public Bicycle() {
        deviceType = "Bicycle";
    }

    @Override
    public void Move() {
        System.out.println("My speed 5 mph");
    }

    @Override
    public void Crash() {
        System.out.println("I'm never crash");
    }
}
