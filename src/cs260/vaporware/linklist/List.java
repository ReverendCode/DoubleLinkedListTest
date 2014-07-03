package cs260.vaporware.linklist;

import java.util.EmptyStackException;

/**
 * Created by Code on 7/2/14.
 */
public class List {
    private Link firstLink;
    private Link lastLink;

    public List() {
        firstLink=null;
        lastLink=null;
    }
    public void insertHead(int number) {
        Link insert = new Link(number);
        if (isEmpty()) lastLink = insert;
        else firstLink.setPrevious(insert);
        insert.setNext(firstLink);
        firstLink=insert;

    }
    public void insertTail(int number) {
        Link insert = new Link(number);
        if (isEmpty()) firstLink = insert;
        else lastLink.setNext(insert);
        insert.setPrevious(lastLink);
        lastLink=insert;

    }
    public int deleteHead() {
        //if (isEmpty()) return 0; //learn how to throw an exception
        int temp = firstLink.getDatum();
        if (firstLink.getNext()==null) lastLink=null;
        else firstLink.getNext().setPrevious(null);//this is much clearer than the public Link method
        firstLink=firstLink.getNext();
        return temp;
    }
    public int deleteTail() {
        int temp=lastLink.getDatum();
        if (lastLink.getPrevious()==null)firstLink=null;
        else lastLink.getPrevious().setNext(null);
        lastLink=lastLink.getPrevious();
        return temp;
    }
    public boolean isEmpty() {
        return false;
    }
    public boolean findKey(int key) {
        return false;
    }
    public boolean insertKey(int number) {
        return false;
    }
    public boolean deleteKey(int key) {
        return false;
    }
    public String displayList() {
        return "";
    }


}
