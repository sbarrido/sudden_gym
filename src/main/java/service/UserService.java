package service;

public class UserService extends Service {
    private String filePath = "src/main/java/database/UserTab.csv";

    public UserService() {
        this.setFile(filePath);
    }
}