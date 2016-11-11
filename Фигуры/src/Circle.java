/**
 * Created by Emil on 11.11.2016.
 */
public class Circle extends Figure{
    protected double round;

    public Circle(double round) {
        this.round = round;
    }

    @Override
    public double getArea() {
        return 3.14*this.round*this.round;
    }
}
