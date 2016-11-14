import Observer.TokenHandler;
import Tokens.Separator;
import Tokens.Token;

public class TokenHandlerSeparatorImpl implements TokenHandler {
    public void handleToken(Token token) {
        // token instanceof Separator.class
        if (token.getClass().getName().equals(Separator.class.getName())) {
            System.out.println("from: " + " " + getName() + " I'm on Separator! " + token);
        }
    }

    public String getName() {
        return "TokenHandlerSeparatorImpl";
    }
}
