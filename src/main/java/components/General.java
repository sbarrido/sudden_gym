package components;

public class General extends User{
    public int membership;

    General(String name, String pass) {
        super(name, pass);
        this.membership = 0;
    }
    public int getMembership() {
        return this.membership;
    }
    public void setMembership(int val) {
        this.membership = val;
    }
}