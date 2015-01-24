package OOP.homework4;

/**
Написать класс число (hw2.Number), выполняющий следующие операции:
 - получение примитива (метод int get())
 - сложение (метод Number add(Number num))
 - вычитание (метод Number sub(Number num))
 - умножение (метод Number mul(Number num))
 - деление (метод Number div(Number num))
 - возведение в степень (метод Number pow(Number exponent))
 - вычисление факториала (метод Number fact())
 - вычисление остатка от деления (метод Number mod(Number num)) 
 **/


public class Task1 {
	public static void main (String [] args) {
//		Number num1 = new Number (10);
//		Number num2 = new Number (20);
//		num1.add(num2);
//		System.out.println(num1.get());

	Phone ph = new Phone(100);
	ph.setCallRate(10);
	ph.setSMSRate(5);
	ph.addNumber("1234567");
	ph.call("123", 2);
	ph.call("1234567", 3);
	ph.addNumber("4567");
	ph.sendSms("4567", "Верни деньги, сука!");
	ph.sendSms("456", "А вот ... тебе!");
	System.out.println(ph.getBalance());
	ph.setBalance(111);
	System.out.println(ph.getBalance());
	}

}
