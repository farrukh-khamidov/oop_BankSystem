package BankServices;

import java.util.ArrayList;
import java.util.List;

public class Bank {

	private String name;
	private List<Account> accounts = new ArrayList<>();
	
	public Bank(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public int createAccount(String name, int date, double initial) {
		Account account = new Account(accounts.size()+1,name, date, initial);
		accounts.add(account);
		return accounts.size();
	}
	
	public Account deleteAccount(int code, int date) throws InvalidCode {
		if (code < 1 || code > accounts.size()) throw new InvalidCode();
		Account account = accounts.get(code - 1);
		account.withdraw(date, account.getBalance());
		return account;
	}
	
	public Account getAccount(int code) throws InvalidCode {
		if (code < 1 || code > accounts.size()) throw new InvalidCode();
		return accounts.get(code - 1);
	}

	public void deposit(int code, int date, double value) throws InvalidCode {
		if (code < 1 || code > accounts.size()) throw new InvalidCode();
		Account account = accounts.get(code - 1);
		account.deposit(date, value);
	}

	public void withdraw(int code, int date, double value) throws InvalidCode, InvalidValue {
		if (code < 1 || code > accounts.size()) throw new InvalidCode();
		Account account = accounts.get(code - 1);
		if (value > account.getBalance()) throw new InvalidValue();
		account.withdraw(date, value);
	}
	
	public void transfer(int fromCode, int toCode, int date, double value) throws InvalidCode, InvalidValue {
		if (fromCode < 1 || fromCode > accounts.size() || toCode < 1 || toCode > accounts.size()) throw new InvalidCode();
		Account sourceAccount = accounts.get(fromCode - 1);
		Account destinationAccount = accounts.get(toCode - 1);
		if (value > sourceAccount.getBalance()) throw new InvalidValue();

		sourceAccount.withdraw(date, value);
		destinationAccount.deposit(date, value);
	}
	
	public double getTotalDeposit() {
		return 0.0;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	

	public List<Account> getZeroAccounts() {
		return null;
	}

	public List<Account> getAccountsByBalance(double low, double high) {
		return null;
	}
	
	public long getNumberHigher(double min) {
		return 0;
	}
}
