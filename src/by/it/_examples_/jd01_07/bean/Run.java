package by.it._examples_.jd01_07.bean;

public class Run {
    public static void main(String[] args) {
        User user = new User("Demo");
        user.setPassword("qwerty");
        System.out.println(user);
        System.out.printf("login:%s, password:%s\n",
                user.getLogin(),
                user.getPassword()
        );
    }
}
