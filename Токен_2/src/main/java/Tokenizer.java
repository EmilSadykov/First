import Observer.TokenHandler;
import Observer.TokenizerObservable;
import Tokens.Token;
import Tokens.Numbers;
import Tokens.Letters;
import Tokens.Separator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tokenizer implements TokenizerObservable {
    private Map<String, TokenHandler> handlers;

    public Tokenizer() {
        handlers = new HashMap<String, TokenHandler>();
    }

    public void addTokenHandler(TokenHandler handler) {
        handlers.put(handler.getName(), handler);
    }

    public void removeTokenHandler(String handlerName) {
        handlers.remove(handlerName);
    }

    public void notifyHandlers(Token token) {
        // получаем множество ключей-значений из мапа
        Set<Map.Entry<String, TokenHandler>> entries = handlers.entrySet();

        // на каждой итерации цикла мы в entity кладем значение из entries
        for (Map.Entry<String, TokenHandler> entity : entries) {
            // из текущего entity забираем значение - обработчик
            TokenHandler currentHandler = entity.getValue();
            // оповещаем обработчик
            currentHandler.handleToken(token);
        }
    }

    public void tokenize(String text) {
        char[] textAsCharArray = text.toCharArray();
        int begin = 0;
        for (int i = 1; i < textAsCharArray.length; i++) {
            if (!(typeChar(textAsCharArray, begin).equals(typeChar(textAsCharArray, i))) || (typeChar(textAsCharArray, i).equals("separator"))) {
                addToken(begin, i, text.substring(begin, i), typeChar(textAsCharArray, begin));
                begin = i;
            }
        }
        if (begin < textAsCharArray.length) {
            addToken(begin, text.length()-1, text.substring(begin, text.length()), typeChar(textAsCharArray, begin));
        }
    }

    private void addToken(int begin, int end, String text, String tokenType) {
        if (tokenType.equals("numbers")) {
            System.out.println("Numbers: " + begin + " : " + end + " : " + text);
            Token currentNumber = new Numbers(begin, end, text, Integer.valueOf(text));
            notifyHandlers(currentNumber);
        } else if (tokenType.equals("letters")) {
            System.out.println("Letters: " + begin + " : " + end + " : " + text);
            char[] charArrayText = text.toCharArray();
            boolean isUppercase = false;
            isUppercase = Character.isUpperCase(charArrayText[0]);
            Token currentLetters = new Letters(begin, end, text, text, isUppercase);
            notifyHandlers(currentLetters);
        } else {
            System.out.println("Separator : " + begin + " : " + end + " : " + text);
            Token currentSeparator = new Separator();
            currentSeparator.setText(text);
            currentSeparator.setBegin(begin);
            currentSeparator.setEnd(end);
            notifyHandlers(currentSeparator);
        }
    }

    public String typeChar(char[] text, int index) {
        if (Character.isDigit(text[index])) {
            return "numbers";
        } else if (Character.isLetter(text[index])) {
            return "letters";
        } else {
            return "separator";
        }
    }
}
