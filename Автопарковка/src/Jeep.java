/**
 * Created by Emil on 08.11.2016.
 */
public class Jeep extends Transport {
    public Jeep() {
        deviceType = "Jeep";
    }

    @Override
    public void Crash() {
        System.out.println("My crash is easy!");
    }

    @Override
    public void Move() {
        System.out.println("My speed 50 mph");
    }
}
