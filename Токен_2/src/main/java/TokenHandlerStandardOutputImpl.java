import Observer.TokenHandler;
import Tokens.Token;

public class TokenHandlerStandardOutputImpl implements TokenHandler {
    public void handleToken(Token token) {
        System.out.println("from: " + " " + getName() + " " + token);
    }

    public String getName() {
        return "StandardIOHandler";
    }
}
