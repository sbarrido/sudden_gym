package service;

public class UserClassService extends Service {
    private String filePath = "src/main/java/database/UserClassTab.csv";

    public UserClassService() {
        this.setFile(filePath);
    }
}