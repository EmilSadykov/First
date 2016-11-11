/**
 * Created by Emil on 11.11.2016.
 */
public class Rectangle extends Figure {
    protected double length;
    protected double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return this.length*this.width;
    }
}
