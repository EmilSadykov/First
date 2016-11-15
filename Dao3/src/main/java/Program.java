import dao.UsersDao;
import dao.UsersDaoArrayListImpl;
import model.User;
import service.UserService;
import service.UserServiceImpl;

public class Program {
    public static void main(String[] args) {
        User marsel = new User("Marsel", "marselLogin", "qwerty007", 1);
        User nastya = new User("Nastya", "nastyaLogin", "qwerty008", 2);
        User ivan = new User("Ivan", "ivanLogin", "qwerty010", 3);
        User ilya = new User("Ilya", "ilyaLogin", "qwerty009", 4);
        User vasya = new User("Vasya", "vasyaLogin", "qwerty011", 5);
        UsersDao usersDao = new UsersDaoArrayListImpl();
        usersDao.save(marsel);
        usersDao.save(nastya);
        usersDao.save(ivan);
        usersDao.save(ilya);
        usersDao.save(vasya);
        User user = usersDao.find(2);
        usersDao.delete(4);
        marsel.setPassword("11111");
        usersDao.update(marsel);
        usersDao.findAll();
        System.out.println("Find user : " + user.getId() + " : " + user.getName());
        UserService userService = new UserServiceImpl(usersDao);
        if (userService.isRegistered("Marsel")) {
            System.out.println("Marsel is Registered");
        } else {
            System.out.println("not registered");
        }
    }
}