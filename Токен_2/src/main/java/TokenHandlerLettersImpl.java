import Observer.TokenHandler;
import Tokens.Letters;
import Tokens.Token;

public class TokenHandlerLettersImpl implements TokenHandler {
    public void handleToken(Token token) {
        // token instanceof Letters.class
        if (token.getClass().getName().equals(Letters.class.getName())) {
            System.out.println("from: " + " " + getName() + " I'm on letter! " + token);
        }
    }

    public String getName() {
        return "TokenHandlerLettersImpl";
    }
}
