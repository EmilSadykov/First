import Observer.TokenHandler;
import Tokens.Letters;
import Tokens.Numbers;
import Tokens.Separator;
import Tokens.Token;

public class TokenHandlerNumbersImpl implements TokenHandler {
    public void handleToken(Token token) {
        // token instanceof Numbers.class
        if (token.getClass().getName().equals(Numbers.class.getName())) {
            System.out.println("from: " + " " + getName() + " I'm on number! " + token);
        }
    }

    public String getName() {
        return "TokenHandlerNumbersImpl";
    }
}
