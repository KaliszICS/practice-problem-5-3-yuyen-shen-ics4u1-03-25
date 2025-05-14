abstract class BankAccount {

	protected double accountBalance; //stop other coders from using this variable, but allow you to access it.
	protected int accountNumber;

	public boolean withdraw(double money) {
		if (money <= this.accountBalance) {
			this.accountBalance -= money;
			return true; //withdrawl was successful
		}
		return false; // not enough funds for withdrawl
	}

	public void deposit(double money) {
		this.accountBalance += money;
	}

	public double getBalance() {
		return this.accountBalance;
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}
	

	abstract boolean pin(int pin); //abstract method
	//no code body - classes that inherit from it, need to define the body
	
}