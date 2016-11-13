/**
 Создать обощенный класс Q из трех параметров <X, Y, Z>

 Параметр Z должен реализовывать интерфейс D (int calc())

 X и Y должны реализовывать интерфейс B (int calc2()).

 В Q должен быть метод
 int allCalc() {
 // вызывает поля типов X x, Y y, Z z
 // и возвращает результат суммирования их методов calc и calc2
 }
 */
public class Program {
    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        Z z = new Z();
        Q q = new Q(y, z, x);
        System.out.println("Sum result : "+q.allCalc());
    }
}
