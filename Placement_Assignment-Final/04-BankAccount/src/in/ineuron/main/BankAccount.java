package in.ineuron.main;

import java.util.Scanner;

public class BankAccount {

	private String accNo;
	private double balance;

	public BankAccount(String accNo, double balance) {
		this.accNo = accNo;
		this.balance = balance;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------------Welcome to the ABC Bank-------------------");
		System.out.print("Enter account number: ");
		String accountNumber = sc.nextLine();
		System.out.print("Enter initial balance: ");
		double balance = sc.nextDouble();
		BankAccount bankAccount = new BankAccount(accountNumber, balance);
		while (true) {
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check balance");
			System.out.println("4. Exit");
			System.out.print("Enter choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter deposit amount: ");
				double depositAmount = sc.nextDouble();
				bankAccount.depositMoney(depositAmount);
				break;
			case 2:
				System.out.print("Enter withdrawal amount: ");
				double withdrawalAmount = sc.nextDouble();
				bankAccount.withdrawMoney(withdrawalAmount);
				break;
			case 3:
				bankAccount.checkBalance();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Invalid choice.");
			}
		}
	}

	public void withdrawMoney(double amount) {
		if (balance < amount) {
			System.out.println( "Insufficient Balance your current Balance is : " + balance);
		} else {
			balance = balance - amount;
			System.out.println(  "Amount Debited successfully from account : " + accNo + " debited amount is : " + amount);
		}
	}

	public void depositMoney(double amount) {
		balance = balance + amount;
		System.out.println( "Amount Credited successfully into your account : " + accNo + " credited amount is : " + amount);
	}

	public void checkBalance() {
		System.out.println( "Balance Amount is : " + balance);
	}
}
