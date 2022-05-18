package components;

//Component Class for InvoiceItem
//Parent class to many
//Static count of all invoice Items
//id based off of the static count at time of creation
//includes prices and duration
public class InvoiceItem {
    private static int count;
    public int id;
    public double price;
    public int duration;

    InvoiceItem() {
        this.id = InvoiceItem.count++;
        this.price = 0.0;
        this.duration = 0;
    }
    InvoiceItem(double cost, int time) {
        this.id = InvoiceItem.count++;
        this.price = cost;
        this.duration = time;
    }

    public double getPrice() {
        return this.price;
    }
    public int getDuration() {
        return this.duration;
    }
}