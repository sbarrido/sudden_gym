package components;

public class Class extends InvoiceItem {
    String title;
    String description;

    Class() {
        super();

        this.title = "default";
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String name) {
        this.title = name;
    }
}