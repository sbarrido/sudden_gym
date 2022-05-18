package components;

//Component class for Membership
// includes title
// a type of InvoiceItem
public class Membership extends InvoiceItem{
    public String title;

    Membership() {
        super();

        this.title = "standard";
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String name) {
        this.title = name;
    }
}