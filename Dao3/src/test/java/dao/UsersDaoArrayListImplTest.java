package dao;

import model.User;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static dao.UsersDaoArrayListsConst.*;
import static org.junit.Assert.assertEquals;

public class UsersDaoArrayListImplTest {

    private UsersDaoArrayListImpl testingUsersDao;

    @Before
    public void setUp() throws Exception {
        testingUsersDao = new UsersDaoArrayListImpl();
        delete(TEST_FILENAME);
        prepareTestData();
    }

    private void prepareTestData() {
        testingUsersDao.save(TEST_DATA.get(0));
        testingUsersDao.save(TEST_DATA.get(1));
        testingUsersDao.save(TEST_DATA.get(2));
        testingUsersDao.save(TEST_DATA.get(3));
        testingUsersDao.save(TEST_DATA.get(4));
    }

    public static void delete(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void findAll() throws Exception {
        List<User> expected = TEST_DATA;
        List<User> actual = testingUsersDao.findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void update() throws Exception {
        List<User> expected = UPDATE_DATA;
        testingUsersDao.update(UPDATED_USER);
        List<User> actual = testingUsersDao.findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void save() throws Exception {

    }

    @Test
    public void find() throws Exception {

    }

    @Test
    public void delete() throws Exception {
        List<User> expected = TEST_DATA;
        List<User> actual = testingUsersDao.findAll();
        assertEquals(expected, actual);
    }

}