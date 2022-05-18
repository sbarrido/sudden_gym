package service;

//Initializes and connects to Item table
public class ItemService extends Service {
    private String filePath = "src/main/java/database/ItemTab.csv";

    public ItemService() {
        this.setFile(filePath);
    }
}