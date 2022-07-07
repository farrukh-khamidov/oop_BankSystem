package BankServices;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Account {

	private int id;
	private String ownerName;
	private int date;
	private double balance;

	private  List<Operation> operations = new ArrayList<>();
	private  List<Deposit> deposits = new ArrayList<>();
	private  List<Withdrawal> withdrawals = new ArrayList<>();

	public Account(int id, String ownerName, int date, double balance) {
		this.id = id;
		this.ownerName = ownerName;
		this.date = date;
		this.balance = balance;

		Deposit deposit = new Deposit(date, balance);
		operations.add(deposit);
		deposits.add(deposit);
	}

	@Override
	public String toString() {
		return id + "," + ownerName + "," + date +"," + balance;
	}
		
	public List<Operation> getMovements() {
		operations.sort(new Comparator<Operation>() {
			@Override
			public int compare(Operation o1, Operation o2) {
				return o2.getDate() - o1.getDate();
			}
		});
		return operations;
	}
	
	public List<Deposit> getDeposits() {
		deposits.sort(new Comparator<Deposit>() {
			@Override
			public int compare(Deposit o1, Deposit o2) {
				return (int) (o1.getValue() - o2.getValue());
			}
		});
		return deposits;
	}

	public List<Withdrawal> getWithdrawals() {
		withdrawals.sort(new Comparator<Withdrawal>() {
			@Override
			public int compare(Withdrawal o1, Withdrawal o2) {
				return (int) (o1.getValue() - o2.getValue());
			}
		});
		return withdrawals;
	}



	/* HELPER METHODS */
	public void deposit(int date, double value) {
		balance += value;
		this.date = Math.max(date, this.date);
		Deposit deposit = new Deposit(this.date, value);
		deposits.add(deposit);
		operations.add(deposit);
	}

	public void withdraw(int date, double value) {
		balance -= value;
		this.date = Math.max(date, this.date);
		Withdrawal withdrawal = new Withdrawal(this.date, value);;
		withdrawals.add(withdrawal);
		operations.add(withdrawal);
	}

	public double getBalance() {
		return balance;
	}
}
