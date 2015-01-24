package OOP.homework4;

/**
Написать класс дробь (hw2.Fraction), выполняющий следующие действия:
	- сложение дробей (метод Fraction add(Fraction frac))
	- вычитание (метод Fraction sub(Fraction frac))
	- умножение (метод Fraction mul(Fraction frac))
	- деление (метод Fraction div(Fraction frac))
	- приведение к строке(метод String toString())
	- вывод (метод void print())
**/

public class Fraction {
	private int numerator;
	private int denominator;

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		if (denominator != 0) {
			this.denominator = denominator;
		}
	}

	public Fraction add(Fraction frac) {
		// (a/b) + (c/d) = (a*d + c*b) / (b*d)
		this.numerator = this.numerator * frac.getDenominator()
				+ frac.getNumerator() * this.denominator;
		this.denominator *= frac.getDenominator();
		return this;
	}

	public Fraction sub(Fraction frac) {
		// (a/b) - (c/d) = (a*d - c*b) / (b*d)
		this.numerator = this.numerator * frac.getDenominator()
				- frac.getNumerator() * this.denominator;
		this.denominator *= frac.getDenominator();
		return this;
	}

	public Fraction mul(Fraction frac) {
		// (a/b) * (c/d) = (a*c) / (b*d)
		this.numerator *= frac.getNumerator();
		this.denominator *= frac.getDenominator();
		return this;
	}

	public Fraction div(Fraction frac) {
		// (a/b) / (c/d) = (a*d) / (b*c)
		if (frac.getNumerator() == 0) {
			return null;
		} else {
			this.numerator *= frac.getDenominator();
			this.denominator *= frac.getNumerator();
			return this;
		}
	}
	
	public String toString () {
		return (this.numerator + "/" + this.denominator);
	}
	
	public void print () {
		System.out.println(this.toString());
	}

	public Fraction() {
		this.setNumerator(0);
		this.setDenominator(1);
	}

	public Fraction(int numerator) {
		this.setNumerator(numerator);
		this.setDenominator(1);
	}

	public Fraction(int numerator, int denominator) {
		if (denominator != 0) {
			this.setNumerator(numerator);
			this.setDenominator(denominator);
		}
	}
}
