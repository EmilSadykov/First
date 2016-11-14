package Tokens;

public class Separator extends Token {
    private String type;

    public Separator() {
        super();
    }

    public Separator(int begin, int end, String text, String value) {
        super(begin, end, text);
        this.type = value;
    }

    public String getValue() {
        return type;
    }

    public void setValue(String value) {
        this.type = value;
    }
}
