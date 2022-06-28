package by.it._examples_.jd01_07.bean;

import java.io.Serializable;

public class User implements Serializable {

    private final String login; //инкапсуляция
    private String password;    //инкапсуляция

    public User() { //конструктор без параметров
        this.login = "guest";
    }

    public User(String login) {
        this.login = login;
    }

    public String getLogin() { //геттеры
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { //сеттеры
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{login=" + login + ", password=" + password + "}";
    }
}
