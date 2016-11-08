/**
 * Created by Emil on 08.11.2016.
 */
public class Transport {
    private String DEFAULT_DEVICE_TYPE = "UNKNOWN";
    private int DEFAULT_INDEX = 0;
    protected String deviceType;
    protected int index;

    public Transport() {
        this.deviceType = DEFAULT_DEVICE_TYPE;
        this.index = DEFAULT_INDEX;
    }

    public void Crash() {
        System.out.println("I'm crashed!");
    }

    public void Move() {
        System.out.println("My speed 10 mph");
    }
}
