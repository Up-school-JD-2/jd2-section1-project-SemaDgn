package entity;

import java.util.UUID;

public class User {
    private final String id;
    private String userName;
    private String password;
    private String email;
    public User(String userName, String password, String email) {
        this.id = UUID.randomUUID().toString();
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    //region Set-Get
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //endregion

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
