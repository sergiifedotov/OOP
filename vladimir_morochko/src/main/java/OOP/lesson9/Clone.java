package OOP.lesson9;

import java.io.*;
import java.util.*;

/**
 * Создать класс "человек" с полем "пол". Сделать так, чтобы у него была жена. 
 * Создать метод "клон", сделать глубокое клонирование (т.е. клон обоих). 
 * 
 * Сериализовать объекты
 *
 */

public class Clone {
	public static void main(String[] args) throws CloneNotSupportedException, 
	FileNotFoundException, IOException, ClassNotFoundException {
		Human woman1 = new Human(false);
		Human man1 = new Human(true, woman1);
		man1.setName("Ваня");
		man1.setAge(30);
		man1.getSpouse().setName("Маня");
		man1.getSpouse().setAge(30);
		System.out.println(man1);
		System.out.println(man1.getSpouse());
		

		Human man2 = (Human) man1.clone();
		// Human woman2 = man2.getSpouse();
		
		System.out.println(man2);
		System.out.println(man2.getSpouse());
		
		ObjectOutputStream objOut;
		objOut = new ObjectOutputStream(new FileOutputStream("ObjFile.txt"));
		objOut.writeObject(man1);
		objOut.writeObject(man2); // лучше так не делать: 1 объект = 1 файл
		objOut.close();
		
		ObjectInputStream objIn;
		objIn = new ObjectInputStream(new FileInputStream("ObjFile.txt"));
		man1 = (Human) objIn.readObject();
		man2 = (Human) objIn.readObject();
		objIn.close();
		
		System.out.println(man1);
		System.out.println(man1.getSpouse());
		System.out.println(man2);
		System.out.println(man2.getSpouse());

		Comparator<Integer> comp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return 0;
			}
		}; // это признак конца объекта
		Arrays.sort(new Integer[3], comp);
		
	}
}

class Human implements Cloneable, Serializable {

	private static final long serialVersionUID = -4420991892708736921L;

	@Override
	public Object clone() throws CloneNotSupportedException {
		Human myClone = (Human) super.clone();
		if (isGender()) {
			Human spouse = (Human) myClone.spouse.clone();
			spouse.setSpouse(myClone);
			myClone.setSpouse(spouse);
		}
		return myClone;
	}
	
	@Override
	public String toString() {
		return getName() + " " + getAge();
	}

	private boolean gender;
	private int age;
	private String name;
	private Human spouse;
	
	public Human () {
		
	}
	
	public Human (boolean gender) {
		this();
		setGender(gender);
	}

	public Human (boolean gender, Human spouse) {
		this(gender);
		spouse.setSpouse(this);
		setSpouse(spouse);
	}
	
	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Human getSpouse() {
		return spouse;
	}

	public void setSpouse(Human spouse) {
		this.spouse = spouse;
	}
	
}
