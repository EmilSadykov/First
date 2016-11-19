package service;

import dao.UsersDao;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import verify.Verifier;

import static dao.UsersDaoArrayListsConst.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UsersDao usersDao;

    @Mock
    private Verifier verifier;

    private UserServiceImpl userService;

    @Before
    public void setUp() throws Exception {
        // создали мок-объект, объект с временной реализацией
        // usersDao = mock(UsersDao.class);
        userService = new UserServiceImpl(usersDao, verifier);

        User user = new User("Vasya", "javaProgrammist", "qwerty007", 1);
        User defaultUser = new User("DEFAULT", "DEFAULT", "DEFAULT", 0);
        when(usersDao.findAll()).thenReturn(TEST_DATA);
        when(usersDao.find(anyInt())).thenReturn(defaultUser);
        when(usersDao.find(2)).thenReturn(user);

        doThrow(IllegalArgumentException.class).when(verifier).userExist(anyInt());
        doNothing().when(verifier).userExist(2);

    }

    @Test
    public void isRegistered() throws Exception {
        boolean actual = userService.isRegistered("Marsel");
        assertTrue(actual);
    }

    @Test
    public void getUser() throws Exception {
        String actualName = userService.getUser(2).getName();
        String expectedName = "Vasya";
        // проверяем, вызвал ли был вообще метод userExist
        verify(verifier).userExist(2);
        assertEquals(actualName, expectedName);
    }

    @Test
    public void addUser() throws Exception {
        userService.addUser(UPDATED_USER);
        verify(usersDao).save(UPDATED_USER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getUserOnIncorrectData() throws Exception {
        userService.getUser(3);
    }

}