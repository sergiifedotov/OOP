package hw4.parallel;


/**
 Реализовать в классе MyArrayList метод
 public int parallelIndexOf(E e), выполняющий линейный многопоточный поиск в списке.
 В тестах проверить поиск:
 - существующего элемента
 - не существующего элемента
 - не существующего элемента в пустом массиве
 - не существующего элемента в массиве с одним элементом
 - существующего элемента в массиве с одним элементом
 - элемента со значением null

 Класс задания:
 hw3.parallel.MyArrayList

 Класс теста:
 hw3.parallel.MyArrayListTest
 */
public class MyArrayListTest {
    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<Integer>();

        for(int i = 0; i < 30; i++) {
            list.add(list.size()/2, i + 2);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        System.out.println(list.parallelIndexOf(0));
        System.out.println(list.parallelIndexOf(null));
        System.out.println(list.parallelIndexOf(3));
        System.out.println(list.parallelIndexOf(2));
        System.out.println(list.parallelIndexOf(1));







    }
}
