import Observer.TokenHandler;
import Tokens.Letters;
import Tokens.Token;

import java.util.ArrayList;
import java.util.List;

public class TokenCollectionHandler implements TokenHandler {

    private ArrayList<Token> tokens;

    public TokenCollectionHandler() {
        tokens = new ArrayList<Token>();
    }

    public void handleToken(Token token) {
        this.tokens.add(token);
        System.out.println("Token count : " + tokens.size());
    }

    public String getName() {
        return "TokenCollectionHandler";
    }
}
