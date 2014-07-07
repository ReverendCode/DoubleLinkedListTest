package cs260.vaporware.linklist;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Main {

    public static void main(String[] args) {
	List testList = new List();
        //Testing FIFO
        testList.insertHead(1);
        testList.insertHead(2);
        testList.insertHead(3);
        System.out.print(testList.deleteTail());
        System.out.print(testList.deleteTail());
        System.out.print(testList.deleteTail());

        testList.insertTail(7);
        testList.insertTail(8);
        testList.insertTail(9);
        System.out.print("\n"+testList.deleteHead());
        System.out.print(testList.deleteHead());
        System.out.print(testList.deleteHead());
        //Testing LIFO
        testList.insertHead(1);
        testList.insertHead(2);
        testList.insertHead(3);
        System.out.print("\n"+testList.deleteHead());
        System.out.print(testList.deleteHead());
        System.out.print(testList.deleteHead());

        testList.insertTail(7);
        testList.insertTail(8);
        testList.insertTail(9);
        System.out.print("\n"+testList.deleteTail());
        System.out.print(testList.deleteTail());
        System.out.print(testList.deleteTail());
        //testing insertion
        testList.insertHead(1);
        testList.insertHead(2);
        testList.insertHead(3);
        System.out.print("\nCurrent array: " + testList.displayList());
        testList.findKey(2);
        testList.insertKey(9);
        System.out.print("\nArray with '9' inserted: " + testList.displayList());
        testList.deleteKey(3);//delete from the end
        System.out.print("\nDelete the three: "+testList.displayList());
        testList.deleteKey(2);//delete from the middle
        System.out.print("\nAnd the two: "+testList.displayList());


    }
}
