package BankServices;

public class Deposit extends Operation{

    public Deposit(int date, double value) {
        super(date, value);
    }

    @Override
    public String toString() {
        return getDate() + "," + getValue() + "+";
    }
}
