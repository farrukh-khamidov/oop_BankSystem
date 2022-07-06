package BankServices;

import java.util.ArrayList;
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
	}

	@Override
	public String toString() {
		return id + "," + ownerName + "," + date +"," + balance;
	}
		
	public List<Operation> getMovements() {
		return operations;
	}
	
	public List<Deposit> getDeposits() {
		return deposits;
	}

	public List<Withdrawal> getWithdrawals() {
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
