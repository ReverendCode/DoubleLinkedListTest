package cs260.vaporware.linklist;

import java.util.EmptyStackException;

/**
 * Created by Code on 7/2/14.
 */
public class List {
    private Link firstLink;
    private Link lastLink;
    private Link insertionPoint=null;

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
    public void insertTail(int number) {//assumes valid inputs
        Link insert = new Link(number);
        if (isEmpty()) firstLink = insert;
        else lastLink.setNext(insert);
        insert.setPrevious(lastLink);
        lastLink=insert;

    }
    public int deleteHead() {//assumes valid inputs
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
        return (firstLink==null && lastLink==null);
    }
    public boolean findKey(int key) {
        if (firstLink.getDatum()==key) {
            insertionPoint=firstLink;
            return true;
        }
        for (Link temp = firstLink.getNext();temp!=null;temp=temp.getNext()) {
            if (temp.getDatum()==key) insertionPoint = temp;
            return true;
        }
        return false;
    }
    public boolean insertKey(int number) {
        if (insertionPoint==null) return false;
    Link newLink = new Link(number);//**This might not make any sense**
        newLink.setNext(insertionPoint);//**Don't forget to check this part**
        newLink.setPrevious(insertionPoint.getPrevious());
        insertionPoint.getPrevious().setNext(newLink);
        insertionPoint.setPrevious(newLink);
        return true;
    }
    public boolean deleteKey(int key) {
        if (firstLink.getDatum()==key) {
            firstLink.getNext().setPrevious(null);
            firstLink=firstLink.getNext();
            return true;
        }  
        if (lastLink.getDatum()==key) {
            lastLink.getPrevious().setNext(null);
            lastLink = lastLink.getPrevious();
            return true;
        }

        for (Link temp=firstLink.getNext();temp!=null;temp = temp.getNext()) {
            if (temp.getDatum()==key) {
                temp.getNext().setPrevious(temp.getPrevious());
                temp.getPrevious().setNext(temp.getNext());
                return true;
            }
        }
        return false;
    }
    public String displayList() {
        if (isEmpty()) return "\nNothing to display\n";
        String output = String.valueOf(firstLink.getDatum());
            for (Link temp = firstLink.getNext();temp!=null;temp=temp.getNext()) {
                 output += " "+temp.getDatum();
            }


        return output;
    }


}
