package OOP.lesson9;

import java.util.ArrayList;

/**
 * Задана коллекция целых чисел, заполнить случайными значениями от 100 до 120, 20 штук, 
 * удалить элементы, равные 110
 *
 */

public class WrapperDemo {
	public static void main (String[] args) {
		ArrayList <Integer> myCollection = new ArrayList <Integer>();
		for (int i = 0; i < 20; i++) {
			myCollection.add(new Integer((int)(100 + 20 * Math.random())));
			if (i == 11) {
				myCollection.set(i, new Integer(110));
			}
		}
		System.out.println(myCollection.toString());
		new WrapperDemo().filter(myCollection, new Integer(110)); // разрешаем конфликт
		System.out.println(myCollection.toString());
	}

	public void filter (ArrayList <Integer> list, Integer val) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(val)){
				list.remove(i);
				i--; // чтобы не пропустить следующий элемент,
				// т.к. после удаления список перестроится
			}
		}
	}
}
