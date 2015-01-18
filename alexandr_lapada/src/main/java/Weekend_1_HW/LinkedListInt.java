package Weekend_1_HW;

import java.util.LinkedList;

/**
 * Created by sanya on 14.01.2015.
 */
public class LinkedListInt extends LinkedList
{
    LinkedList<Integer> linkedListInt = new LinkedList<Integer>();

    public void createLinkedListInt(int in)
    {
        int index = 0;

        Long timeStartLinkedListInt = System.nanoTime();
        for (int i = 0; i < 60000; i++)
        {
            if (in == 1){index = linkedListInt.size()/2;}
            else if (in == 2) {index = 0;}
            else if (in == 3)
            {
                if (linkedListInt.size()!=0){index = linkedListInt.size()-1;}
            }
            int obj = (int)(Math.random() * 10);
            linkedListInt.add(index, obj);
        }
        Long timeFinishLinkedListInt = System.nanoTime();
        System.out.println("Time operating LinkedListInt : " + ((timeFinishLinkedListInt - timeStartLinkedListInt) / 1000));
        //System.out.println("---------------------------------");
    }
}

