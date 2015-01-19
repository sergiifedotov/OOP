package OOP.homework4;

import java.util.ArrayList;

/**
Написать класс телефон (hw2.Phone), выполняющий следующие действия:
 - позвонить на указанный телефон (метод void call (String number, int mins))
 - отправить смс на указанный телефон (метод boolean sendSms (String number, String text))
 - пополнить счет на указанную сумму (метод boolean charge (int copeiki))
 - проверять существование номера телефона (метод boolean isNumberExists (String number))
За 1 минуту звонка снимается 10 копеек, за 1 смс 5 копеек. 
Список абонентов сети и баланс счёта храниться в телефоне.
**/

public class Phone {
	private int callRate;
	private int SMSRate;
	private int balance; 
	
	private ArrayList<String> numberList;
	
	public void addNumber(String newNumber) {
		if (!this.isNumberExists(newNumber)) {
			this.numberList.add(newNumber);
		}
	}
	
	public int getCallRate() {
		return callRate;
	}

	public void setCallRate(int callRate) {
		if (callRate > 0) {
			this.callRate = callRate;
		}
	}
	
	public int getSMSRate() {
		return SMSRate;
	}

	public void setSMSRate(int sMSRate) {
		if (sMSRate > 0) {
			this.SMSRate = sMSRate;
		}
	}

	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void call (String number, int mins) {
		if (this.isNumberExists(number)){
			if (this.getBalance() > (mins * this.callRate)) {
				this.setBalance(this.getBalance() - (mins * this.callRate));
				System.out.println("Вы говорили " + mins + " минут.");
				System.out.println("Остаток на счету: " + this.getBalance());
			} else {
				System.out.println("Мало денег на счету.");
			}
		} else {
			System.out.println("Такого номера нет.");
		}
	}
	
	public boolean sendSms (String number, String text) {
		if (this.isNumberExists(number)){
			if (this.getBalance() > this.SMSRate) {
				this.setBalance(this.getBalance() - this.SMSRate);
				System.out.println("СМС \"" + text + "\" отправлено.");
				System.out.println("Остаток на счету: " + this.getBalance());
				return true;
			} else {
				System.out.println("Мало денег на счету.");
				return false;
			}
		} else {
			System.out.println("Такого номера нет.");
			return false;
		}
	}
	
	public boolean charge(int copeiki) {
		if (copeiki > 0) {
			this.balance += copeiki;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isNumberExists (String number) {
		return this.numberList.contains(number);
	}
	
	public Phone () {
		numberList = new ArrayList<String> ();
	}
	
	public Phone (int copeiki) {
		numberList = new ArrayList<String> ();
		this.addNumber("112");
		this.charge(copeiki);
	}
}
