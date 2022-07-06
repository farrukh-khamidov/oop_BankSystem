package BankServices;

public class Withdrawal extends Operation {
    public Withdrawal(int date, double value) {
        super(date, value);
    }

    @Override
    public String toString() {
        return getDate() + "," + getValue() + "-";
    }
}
