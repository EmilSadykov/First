package Tokens;

public class Letters extends Token{
    private String text;
    private boolean isUpperFirst;

    public Letters() {
        super();
    }

    public Letters(int begin, int end, String text, String value, boolean isUpperFirst) {
        super(begin, end, text);
        this.text = value;
        this.isUpperFirst = isUpperFirst;
    }

    public String getValue() {
        return text;
    }

    public void setValue(String value) {
        this.text = value;
    }

    public boolean isUpperFirst() {
        return isUpperFirst;
    }

    public void setUpperFirst(boolean upperFirst) {
        this.isUpperFirst = upperFirst;
    }
}
