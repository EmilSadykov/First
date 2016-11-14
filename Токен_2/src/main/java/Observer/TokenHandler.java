package Observer;

import Tokens.Token;

public interface TokenHandler {
    void handleToken(Token token);
    String getName();
}