package dao;

import com.google.common.collect.Lists;
import model.User;

import java.util.List;

public class UsersDaoArrayListsConst {
    public final static List<User> TEST_DATA = getTestUsers();
    public final static List<User> UPDATE_DATA = getUpdatedUsers();
    public final static User UPDATED_USER = getUpdatedUser();
    public final static String TEST_FILENAME = "text.txt";

    private static List<User> getTestUsers() {
        User marsel = new User("Marsel", "marselLogin", "qwerty007", 1);
        User nastya = new User("Nastya", "nastyaLogin", "qwerty008", 2);
        User ivan = new User("Ivan", "ivanLogin", "qwerty010", 3);
        User ilya = new User("Ilya", "ilyaLogin", "qwerty009", 4);
        User vasya = new User("Vasya", "vasyaLogin", "qwerty011", 5);
        return Lists.newArrayList(marsel, nastya, ilya, ivan, vasya);
    }

    private static List<User> getUpdatedUsers() {
        User marsel = new User("Marsel", "marselLogin", "111", 1);
        User nastya = new User("Nastya", "nastyaLogin", "qwerty008", 2);
        User ivan = new User("Ivan", "ivanLogin", "qwerty010", 3);
        User ilya = new User("Ilya", "ilyaLogin", "qwerty009", 4);
        User vasya = new User("Vasya", "vasyaLogin", "qwerty011", 5);
        return Lists.newArrayList(marsel, nastya, ilya, ivan, vasya);
    }

    private static User getUpdatedUser() {
        User marsel = new User("Marsel", "marselLogin", "111", 1);
        return marsel;
    }
}
