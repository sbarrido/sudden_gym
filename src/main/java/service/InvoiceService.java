package service;

//Initializes and connects to Invoice Table
public class InvoiceService extends Service {
    private String filePath = "src/main/java/database/InvoiceTab.csv";

    public InvoiceService() {
        this.setFile(filePath);
    }
}