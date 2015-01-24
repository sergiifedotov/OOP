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

public class Number {
	private int value;

	public int get() {
		return this.value;
	}

	public void set(int inputNumber) {
		this.value = inputNumber;
	}

	public Number add(Number num) {
		this.value += num.get();
		return this;
	}

	public Number sub(Number num) {
		this.value -= num.get();
		return this;
	}

	public Number mul(Number num) {
		this.value *= num.get();
		return this;
	}

	public Number div(Number num) {
		if (num.get() == 0) {
			return null;
		} else {
			this.value /= num.get();
			return this;
		}
	}

	public Number pow(Number exponent) {
		if (this.value == 0 && exponent.get() <= 0) {
			return null;
		} else {
			this.value = (int) Math.pow(this.value, exponent.get());
			return this;
		}
	}

	public Number fact() {
		if (this.value < 0) {
			return null;
			} 
		else {
			int temp = 1;
			for (int i = 1; i <= this.value; i++) {
				temp *= i;
			}
			this.value = temp;
			return this;
		}
	}
	
	public Number mod(Number num) {
		if (num.get() == 0) {
			return null;
		} else {
			this.value %= num.get();
			return this;
		}
	}

	
	public Number() {
		this.set(0);
	}

	public Number(int value) {
		this.set(value);
	}
}