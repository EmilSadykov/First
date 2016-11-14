package Tokens;

public class Numbers extends Token {
    private int value;

    public Numbers() {
        super();
    }

    public Numbers(int begin, int end, String text, int value) {
        super(begin, end, text);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
