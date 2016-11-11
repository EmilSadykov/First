/**
 * Created by Emil on 11.11.2016.
 */
public class Program {
    public static void main(String[] args) {
        NativeTokenizerImpl nativeTokenizer = new NativeTokenizerImpl();
        Token[] token = new Token[0];
        token = nativeTokenizer.tokenize("123 - number, 9, 11, 123");
        for (int i = 0; i < token.length; i++) {
            System.out.println(token[i].begin + " : " + token[i].end + " : " + token[i].text);
        }
    }
}
