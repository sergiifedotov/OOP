package Weekend_1_HW;

import java.util.LinkedList;

/**
 * Created by sanya on 14.01.2015.
 */
public class LinkedListStr extends LinkedList
{
    LinkedList<String> linkedListStr = new LinkedList<String>();

    public void createLinkedListStr(int in)
    {
        int index = 0;

        Long timeStartLinkedListStr = System.nanoTime();
        String obj = "aaa";
        for (int i = 0; i < 60000; i++)
        {
            if (in == 1){index = linkedListStr.size()/2;}
            else if (in == 2) {index = 0;}
            else if (in == 3)
            {
                if (linkedListStr.size()!=0){index = linkedListStr.size()-1;}
            }
            linkedListStr.add(index, obj);
        }
        Long timeFinishLinkedListStr = System.nanoTime();
        System.out.println("Time operating LinkedListStr : " + ((timeFinishLinkedListStr - timeStartLinkedListStr) / 1000));
        //System.out.println("---------------------------------");
    }

}
