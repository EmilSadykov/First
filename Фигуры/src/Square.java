public class Square extends Figure {
    protected double length;

    public Square(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return this.length*this.length;
    }
}
