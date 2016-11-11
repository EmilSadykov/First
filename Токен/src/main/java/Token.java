/**
 * Created by Emil on 11.11.2016.
 */
public class Token {
    protected int begin;
    protected int end;
    protected String text;

    public Token(int begin, int end, String text) {
        this.begin = begin;
        this.end = end;
        this.text = text;
    }

}
