package cs260.vaporware.linklist;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.EmptyStackException;

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
        testList.deleteKey(1);
        System.out.print("\nNow the one: "+testList.displayList());
        testList.deleteKey(9);
        try {//this throws an exception. On purpose even.
            System.out.print("\nFinally the 9: " + testList.displayList());
        }catch (EmptyStackException blank){
            System.err.println("Sorry, the stack returned: "+blank.getMessage());
        }
       // testing TextClass
        TextClass testString = new TextClass();
        addSomeLetters("abc",testString);
        System.out.println("\nAdd some letters to the string: " + testString.showList());
        addSomeLetters("defb", testString);
        System.out.println("Show appending: " + testString.showList());
        testString.removeLetter('b');
       System.out.println("remove the first 'b' in the list: "+testString.showList());
        testString.findLetter('e');//should point insertionPoint to the location of 'e'
        testString.insertLetter('X');
        System.out.println("Add an 'X' before the 'e': " + testString.showList());


        TextClass oneList = new TextClass();
        TextClass twoList = new TextClass();
        addSomeLetters("This is a cat",oneList);
        addSomeLetters("That is a dog",twoList);
        System.out.println("First list: "+oneList.showList()+"\nSecond list: "+twoList.showList());
        oneList.joinStrings(twoList);
        System.out.println("\nJoined: "+oneList.showList());
        System.out.print(twoList.showList());

    }

    //helper functions
    public static void addSomeLetters(String letters,TextClass list) {

        for (int i=0;i<letters.length();i++) {
            list.insert(letters.charAt(i));
        }
    }
    public static void insertSomeLetters(String letters,TextClass list, char pre, char post) {
        for (Link temp=list.firstLink.getNext();temp!=null;temp=temp.getNext()){
            if (temp.getDatum()==post && temp.getPrevious().getDatum()==pre) {
                list.insertionPoint=temp;
            }
        }
        for (int i=0;i<letters.length();i++) {
            list.insertLetter(letters.charAt(i));
        }
    }
}
