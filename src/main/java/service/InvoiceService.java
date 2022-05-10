package service;

public class InvoiceService extends Service {
    private String filePath = "src/main/java/database/InvoiceService.csv";

    public InvoiceService() {
        this.setFile(filePath);
    }
}