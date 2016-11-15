package dao;

import model.User;
import tokenizer.Tokenizer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoArrayListImpl implements UsersDao {
    private List<User> users;
    final String TEXT_FILE_NAME = "text.txt";

    public UsersDaoArrayListImpl() {
        this.users = new ArrayList<User>();
    }

    public List<User> findAll() {
        try {
            users.clear();
            ArrayList<String> text = read(TEXT_FILE_NAME);
            for (int i = 0; i < text.size(); i++) {
                String[] paramList = Tokenizer.tokenize(text.get(i));
                User newUser = new User(paramList[1], paramList[2], paramList[3], Integer.parseInt(paramList[0]));
                users.add(newUser);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Find " + users.size() + " users");
        return this.users;
    }

    public void update(User user) {
        try {
            ArrayList<String> usersList = read(TEXT_FILE_NAME);
            StringBuilder newUsersList = new StringBuilder();
            for (int i = 0; i < usersList.size(); i++) {
                String[] paramList = Tokenizer.tokenize(usersList.get(i));
                if (Integer.parseInt(paramList[0]) == user.getId()) {
                    newUsersList.append(user.getId() + ";" + user.getName() + ";" + user.getLogin() + ";" + user.getPassword());
                    newUsersList.append("\n");
                } else {
                    newUsersList.append(usersList.get(i));
                    newUsersList.append("\n");
                }
            }
            write(TEXT_FILE_NAME, newUsersList.toString(), true);
            System.out.println("Updated user with ID : "+user.getId());
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(User user) {
        users.add(user);
        write(TEXT_FILE_NAME, user.getId() + ";" + user.getName() + ";" + user.getLogin() + ";" + user.getPassword(), false);
    }

    public User find(int id) {
        User result = new User("", "", "", id);
        try {
            ArrayList<String> text = read(TEXT_FILE_NAME);
            for (int i = 0; i < text.size(); i++) {
                String[] paramList = Tokenizer.tokenize(text.get(i));
                if (Integer.parseInt(paramList[0]) == id) {
                    result.setName(paramList[1]);
                    result.setLogin(paramList[2]);
                    result.setPassword(paramList[3]);
                    for (int j = 0; j < users.size(); j++) {
                        if (users.get(j).equals(result)) {
                            result = users.get(j);
                        }
                    }
                    return result;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public void delete(int id) {
        try {
            ArrayList<String> usersList = read(TEXT_FILE_NAME);
            StringBuilder newUsersList = new StringBuilder();
            for (int i = 0; i < usersList.size(); i++) {
                String[] paramList = Tokenizer.tokenize(usersList.get(i));
                if (!(Integer.parseInt(paramList[0]) == id)) {
                    newUsersList.append(usersList.get(i));
                    newUsersList.append("\n");
                }
            }
            write(TEXT_FILE_NAME, newUsersList.toString(), true);
            System.out.println("Deleted user with ID : "+id);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> read(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        ArrayList<String> sb = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.add(s);
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb;
    }

    public static String readAllFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void write(String fileName, String text, boolean rewrite) {
        File file = new File(fileName);
        try {
            if(!file.exists()){
                file.createNewFile();
            } else {
                StringBuilder sb = new StringBuilder();
                if (!rewrite) {
                    String oldFile = readAllFile(fileName);
                    sb.append(oldFile);
                }
                sb.append(text);
                text = sb.toString();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}