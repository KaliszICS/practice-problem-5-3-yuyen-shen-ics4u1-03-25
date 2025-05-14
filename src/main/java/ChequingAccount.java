class ChequingAccount extends BankAccount {

	protected int pinNumber;
	
	public ChequingAccount(double money, int pinNumber) {
		this.accountBalance = money;
		this.pinNumber = pinNumber;
	}
	
	public ChequingAccount(int pinNumber) { //default balance
		this.accountBalance = 0;
		this.pinNumber = pinNumber;
	}

	@Override
	public boolean pin(int pin) { //check if the pin is correct
		if (pinNumber == pin) {
			return true;
		}
		return false;
	}
}