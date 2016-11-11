
public class NativeTokenizerImpl implements Tokenizer {

    public Token[] tokenize(String textIn) {
        int tokenCount = 1;
        int begin = 0;
        for (int i = 1; i < textIn.length(); i++) {
            if (!(typeChar((int)textIn.charAt(begin)) == typeChar((int)textIn.charAt(i)))) {
                Token[] tokenList = new Token[tokenCount];
                tokenList[tokenCount-1].begin = begin;
                tokenList[tokenCount-1].end = i;
                tokenList[tokenCount-1].text = textIn.substring(begin, i);
                System.out.println(begin + " : " + i + " : " + textIn.substring(begin, i));
                begin = i;
                tokenCount++;
            }
        }
        return new Token[0];
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
