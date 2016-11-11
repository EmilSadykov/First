
public class NativeTokenizerImpl implements Tokenizer {
    private Token[] outList;

    public Token[] tokenize(String textIn) {
        outList = new Token[0];
        int begin = 0;
        for (int i = 1; i < textIn.length(); i++) {
            if (!(typeChar((int)textIn.charAt(begin)) == typeChar((int)textIn.charAt(i)))) {
                AddToken(begin, i, textIn.substring(begin, i), typeChar((int)textIn.charAt(begin)));
                begin = i;
            }
        }
        if (begin < textIn.length()) {
            AddToken(begin, textIn.length()-1, textIn.substring(begin, textIn.length()), typeChar((int)textIn.charAt(begin)));
        }
        return outList;
    }

    private void AddToken(int begin, int end, String text, String tokenType) {
        Token[] tempList = new Token[outList.length+1];
        for (int i = 0; i < outList.length; i++) {
            tempList[i] = outList[i];
        }
        if (tokenType == "cifr") {
            Token tecToken = new Number(begin, end, text);
            tempList[outList.length] = tecToken;
        } else if (tokenType == "word") {
            Token tecToken = new Word(begin, end, text);
            tempList[outList.length] = tecToken;
        } else {
            Token tecToken = new Separator(begin, end, text);
            tempList[outList.length] = tecToken;
        }
        outList = tempList;
    }

    public String typeChar(int symbol) {
        // 48-57 цифры
        // 32-47, 58-64, 91-96, 124-127 - символы
        if ((symbol >= 48) && (symbol <= 57)) {
            return "cifr";
        } else if (((symbol >= 32) && (symbol <= 47)) || ((symbol >= 58) && (symbol <= 64)) || ((symbol >= 91) && (symbol <= 96)) || ((symbol >= 124) && (symbol <= 127))) {
            return "simbol";
        } else {
            return "word";
        }
    }
}
