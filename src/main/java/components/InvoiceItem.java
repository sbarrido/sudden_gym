package components;

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