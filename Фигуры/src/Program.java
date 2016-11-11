/**
 * Created by Emil on 11.11.2016.
 */
public class Program {
    public static void main(String[] args) {
        Figure[] figList = new Figure[3];
        Circle circle = new Circle(5);
        figList[0] = circle;
        Rectangle rectangle = new Rectangle(7, 10);
        figList[1] = rectangle;
        Square square = new Square(3);
        figList[2] = square;
        for (int i = 0; i<3; i++) {
            System.out.println(figList[i].getArea());
        }
    }
}