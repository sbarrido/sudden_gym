package components;

import java.util.Date;

//Component class for an Invoice
//static Invoice counter
//Invoice_id denoted by the current count
//Date
public class Invoice {
    private static int count;
    public int id;
    public Date date;

    Invoice(User user, Date target) {
       this.id = Invoice.count++;
       this.date = target;
    }

    public int getID() {
        return this.id;
    }
    public Date getDate() {
        return this.date;
    }
}