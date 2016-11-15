package tokenizer;

import model.User;

public class Tokenizer {
    public static String[] tokenize(String text) {
        String[] paramList = new String[4];
        char[] textAsCharArray = text.toCharArray();
        int begin = 0;
        int paramId = 0;
        for (int i = 1; i < textAsCharArray.length; i++) {
            if (!(typeChar(textAsCharArray, begin).equals(typeChar(textAsCharArray, i)))) {
                if (typeChar(textAsCharArray, i).equals("separator")) {
                    paramList[paramId] = text.substring(begin, i);
                    paramId++;
                }
                begin = i;
            }
        }
        if (begin < textAsCharArray.length) {
            paramList[paramId] = text.substring(begin, textAsCharArray.length);
        }
        System.out.println("tokenize : id: " + paramList[0] + "; name: " + paramList[1] + "; login: " + paramList[2] + "; password: " + paramList[3]);
        return paramList;
    }

    private User addToken(String[] paramList) {
        System.out.println("id: " + paramList[0] + "; name: " + paramList[1] + "; login: " + paramList[2] + "; password: " + paramList[3]);
        User user = new User(paramList[1], paramList[2], paramList[3], Integer.getInteger(paramList[0]));
        return user;
    }

    public static String typeChar(char[] text, int index) {
        if (String.valueOf(text[index]).equals(";")) {
            return "separator";
        } else {
            return "letters";
        }
    }
}
