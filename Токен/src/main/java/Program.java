/**
 * Created by Emil on 11.11.2016.
 */
public class Program {
    public static void main(String[] args) {
        NativeTokenizerImpl nativeTokenizer = new NativeTokenizerImpl();
        Token[] token = new Token[0];
        token = nativeTokenizer.tokenize("Привет - word, 0, 6, Привет");
        for (int i = 0; i < token.length; i++) {
            System.out.println(token[i].text + " : " + token[i].text + " : " + token[i].text);
        }
    }
}
