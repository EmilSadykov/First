/**
 * Created by Emil on 13.11.2016.
 */
public class Q<T> extends X {
    private T x;
    private T y;
    private T z;

    public Q(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public <T extends X> int cals2(T x) {
        return x.calc2();
    }

    public <T extends Y> int cals2(T y) {
        return y.calc2();
    }

    public <T extends Z> int cals(T z) {
        return z.calc();
    }

    public int returnCalc(T t) {
        int result = 0;
        if (t.getClass().getName().equals("X")) {
            result = cals2((X) t);
        } else if (t.getClass().getName().equals("Y")) {
            result = cals2((Y) t);
        } else if (t.getClass().getName().equals("Z")) {
            result = cals((Z) t);
        }
        return result;
    }

    public int allCalc() {
        return returnCalc((T) x)+returnCalc((T) y)+returnCalc((T) z);
    }
}