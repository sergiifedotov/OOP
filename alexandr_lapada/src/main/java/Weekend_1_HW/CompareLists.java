package Weekend_1_HW; /**
 * Created by sanya on 14.01.2015.
 */

public class CompareLists
{
    public static void main(String[] args)
    {
        ArrayListInt arrayListInt = new ArrayListInt();
        ArrayListStr arrayListStr = new ArrayListStr();
        LinkedListInt linkedListInt = new LinkedListInt();
        LinkedListStr linkedListStr = new LinkedListStr();

        int in = 1;
        System.out.println("index = size/2");
        arrayListInt.createArrayListInt(in);
        linkedListInt.createLinkedListInt(in);
        arrayListStr.createArrayListStr(in);
        linkedListStr.createLinkedListStr(in);
        System.out.println("----------------------------");

        in = 2;
        System.out.println("index = 0");
        arrayListInt.createArrayListInt(in);
        linkedListInt.createLinkedListInt(in);
        arrayListStr.createArrayListStr(in);
        linkedListStr.createLinkedListStr(in);
        System.out.println("----------------------------");

        in = 3;
        System.out.println("index = size - 1");
        arrayListInt.createArrayListInt(in);
        linkedListInt.createLinkedListInt(in);
        arrayListStr.createArrayListStr(in);
        linkedListStr.createLinkedListStr(in);
        System.out.println("----------------------------");



    }


}
