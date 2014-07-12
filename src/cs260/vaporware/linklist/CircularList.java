package cs260.vaporware.linklist;

import java.util.EmptyStackException;

/**
 * Created by Code on 7/9/14.
 */
public class CircularList {//only pick one of these at a time, or bad things might happen
    private static final boolean stack=true;//choose your own adventure.
    private static final boolean queue=false;//these affect deleteItem only

    private Link pointer;//points to the top of the stack
    public CircularList() {
        pointer=null;
    }
    public void insertItem (char letter) {
        Link newItem = new Link((char)letter);
        if (isEmpty()) {
            pointer=newItem;
            pointer.setNext(pointer);
            pointer.setPrevious(pointer);
        }
        else {
            /*  **This is what the assignment says to do, but it does not maintain the stack properly**
            newItem.setNext(pointer.getNext());
            pointer.setNext(newItem);
            newItem.setPrevious(pointer);*/
            newItem.setNext(pointer);//this method maintains the stack order
            newItem.setPrevious(pointer.getPrevious());
            pointer.getPrevious().setNext(newItem);
            pointer.setPrevious(newItem);
            pointer=newItem;
        }
    }
    public char deleteItem() {//since previous is already in the Links, switching the code around allows for a Queue implementation fairly trivially
       char temp;
        if (stack) {//this is the stack implementation, which is the assignment
            if (isEmpty()) throw new EmptyStackException();
            temp = (char) pointer.getDatum();
            if (pointer.getNext() == pointer) {
                pointer = null;
                return temp;
            }
            pointer.getNext().setPrevious(pointer.getPrevious());
            pointer.getPrevious().setNext(pointer.getNext());
            pointer=pointer.getNext();
        }
        if (queue) {//now with bonus optional queue implementation.
            if (isEmpty()) throw new EmptyStackException();
            temp=(char)pointer.getPrevious().getDatum();
            if (pointer.getPrevious()==pointer) {
                pointer=null;
                return temp;
            }
            pointer.setPrevious(pointer.getPrevious().getPrevious());
            pointer.getPrevious().setNext(pointer);
        }
        return temp;
    }
    public void stepLink (int count) {
        for (int i=1;i<count;i++) {
            pointer=pointer.getNext();
        }
    }
    public String displayList() {//**NOTE** this always displays as LIFO
        String output ="";
        Link temp=pointer;
        do {
            output+=(char)temp.getDatum();
            temp=temp.getNext();
        }while(temp!=pointer);
        return output;
    }
    private boolean isEmpty(){
        return (pointer==null);
    }
}
