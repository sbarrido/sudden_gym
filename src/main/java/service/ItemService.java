package service;

public class ItemService extends Service {
    private String filePath = "src/main/java/database/InvoiceTab.csv";

    public ItemService() {
        this.setFile(filePath);
    }
}