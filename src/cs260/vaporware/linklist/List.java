package cs260.vaporware.linklist;

import java.util.EmptyStackException;

/**
 * Created by Code on 7/2/14.
 */
public class List {
    protected Link firstLink;
    protected Link lastLink;
    protected Link insertionPoint=null;

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
    public int deleteHead() {//**assumes non-zero dataset**
        int temp = firstLink.getDatum();
        if (firstLink.getNext()==null) lastLink=null;
        else firstLink.getNext().setPrevious(null);//this is much clearer than the public Link method
        firstLink=firstLink.getNext();
        return temp;
    }
    public int deleteTail() {//**assumes non-zero dataset**
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
/*         **Old and busted**
       if (isEmpty())return false;
        if (firstLink.getDatum()==key) {
            insertionPoint=firstLink;
            return true;
        }
        for (Link temp = firstLink.getNext();temp!=null;temp=temp.getNext()) {
            if (temp.getDatum()==key) insertionPoint = temp;
            return true;
        }
        return false;*/

        //   **New Hotness**
        if (isEmpty()) return false;
        for (Link temp=firstLink;temp!=null;temp=temp.getNext()) {
            if (temp.getDatum()==key) {
                insertionPoint = temp;
                return true;
            }
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
        if (firstLink==lastLink) {
            firstLink=lastLink=null;
        return true;
        }
        if (firstLink.getDatum()==key) {
            firstLink.getNext().setPrevious(null);
            firstLink=firstLink.getNext();
            return true;
        }

        for (Link temp=firstLink.getNext();temp!=lastLink;temp = temp.getNext()) {
            if (temp.getDatum()==key) {
                temp.getNext().setPrevious(temp.getPrevious());
                temp.getPrevious().setNext(temp.getNext());
                return true;
            }
        }
        if (lastLink.getDatum()==key) {
            lastLink.getPrevious().setNext(null);
            lastLink = lastLink.getPrevious();
            return true;
        }
        return false;
    }
    public boolean deleteInsertion() {
        if (insertionPoint==null) return false;
        insertionPoint.getNext().setPrevious(insertionPoint.getPrevious());
        insertionPoint.getPrevious().setNext(insertionPoint.getNext());
        insertionPoint=insertionPoint.getNext();//this moves the cursor to the next spot
        return true;
    }
    public String displayList() {
        if (isEmpty()) throw new EmptyStackException();
        String output = String.valueOf(firstLink.getDatum());
            for (Link temp = firstLink.getNext();temp!=null;temp=temp.getNext()) {
                 output += " "+temp.getDatum();
            }


        return output;
    }
    
    public boolean reFind(Link ptr, int v) {
        if (ptr==null) return false;
        if (ptr.getDatum()==v) return true;
        else return reFind(ptr.getNext(),v);
    }
}
