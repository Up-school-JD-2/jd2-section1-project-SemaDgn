package service;

import entity.DomainConstants;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    public static List<User> usersList = new ArrayList<>();

    public static void generateUser() {
        usersList.add(new User("sd", "123", "semasanli34@gmail.com"));
        usersList.add(new User( "ld", "741", "lokmandogan@gmail.com"));

    }

    public static User logInSession(String userName, String password) {
        User user1 = null;
        for (User user : usersList) {
            if (user.getUserName().equalsIgnoreCase(userName) && user.getPassword().equalsIgnoreCase(password)) {
                user1 = user;
                DomainConstants.activeUser = user;
                break;
            }
        }
        return user1;
    }

    public static void logOutSession() {
        DomainConstants.activeUser = null;
    }

    public static boolean addUser(User user) {
        boolean result = false;
        if (user != null)
            result = usersList.add(user);
        return result;
    }
    public static User searchUserByName(String userName) {
        User searchUser = null;
        for (User user : usersList) {
            if (user.getUserName().equalsIgnoreCase(userName)) {
                searchUser = user;
                break;
            }
        }
        return searchUser;
    }
    public static boolean deleteUser(User user) {
        boolean result = false;
        if (user != null)
            result = usersList.remove(user);
        return result;
    }
}

