
class Notes {
	public static void main(String[] args) {
		ChequingAccount c = new ChequingAccount(9000, 1234);
		SavingsAccount s = new SavingsAccount(9000, 0.05);

		System.out.println(c.withdraw(1000));
		System.out.println(c.getBalance());

		System.out.println(c.pin(1234));
		System.out.println(s.pin(1234));

		//Abstract classes can not be created into objects
		// BankAccount a = new BankAccount();
	}
}
