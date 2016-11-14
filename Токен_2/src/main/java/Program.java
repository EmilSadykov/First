import Observer.TokenizerObservable;

/**
 1) Создать обработчики:
 Observer.LettersHandler
 NumbersHandler
 SeparatorHander

 2) LetterHandler помимо текста токена заполняет поле isUpperFirst.

 3) NumbersHandler - заполняет поле int value Numbers-токена и выводит на экран

 4) Separator заполняет поле type

 5) TokensCollectionHandler
 handleToken(Token token) {
 this.tokens.add(token);
 }
 */

public class Program {
    public static void main(String[] args) {
        String text = "abb /!123 .abb, 34 a";
        TokenizerObservable tokenizer = new Tokenizer();
        tokenizer.addTokenHandler(new TokenHandlerNumbersImpl());
        tokenizer.addTokenHandler(new TokenHandlerStandardOutputImpl());
        tokenizer.addTokenHandler(new TokenHandlerLettersImpl());
        tokenizer.addTokenHandler(new TokenHandlerSeparatorImpl());
        tokenizer.addTokenHandler(new TokenCollectionHandler());
        tokenizer.tokenize(text);
    }
}