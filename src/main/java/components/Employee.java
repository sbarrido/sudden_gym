package components;

public class Employee extends User {
    public double rate = 0.0;
    public double hours = 0.0;

    Employee(String name, String pass) {
        super(name, pass);
    }
    public double getRate() {
        return this.rate;
    }
    public double getHours() {
        return this.hours;
    }
    public void setRate(double val) {
        this.rate = val;
    }
    public void setHours(double val) {
        this.hours = val;
    }
}