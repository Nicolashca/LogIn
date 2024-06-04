package org.example.Login;

public class Client {

    private String name;
    private String lastName;
    private String login;
    private String eMail;
    private String password;
    private String role;
    private String isBlocked;
    private int id;

    public Client(String name, String lastName, String login, String eMail, String password, String role, String isBlocked, int id) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.eMail = eMail;
        this.password = password;
        this.role = role;
        this.isBlocked = isBlocked;
        this.id = id;
    }

    @Override
    public String toString() {
        return
                 name +
                "|" + lastName +
                "|" + login  +
                "|" + eMail  +
                "|" + password +
                "|" + role +
                "|" + isBlocked +
                "|" + id;
    }
}
