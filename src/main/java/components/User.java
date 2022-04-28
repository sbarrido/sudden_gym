package components;

public class User { 
    private static int count = 0;
    public int id;
    public String username, password;

    User(String name, String pass) {
        this.id = User.count++;
        this.username = name;
        this.password = pass;
    }
}