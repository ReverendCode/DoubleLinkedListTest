package cs260.vaporware.linklist;

/**
 * Created by Code on 7/2/14.
 */
public class Link {

    private int datum;
    private Link next;
    private Link previous;
    private final int DEFAULT_INT=0;

    public Link() {datum=DEFAULT_INT;}
    public Link(int n) {
        datum=n;
    }
    public void setNext(Link nextLink) {
        next=nextLink;
    }
    public Link getNext() {
        return next;
    }
    public void setPrevious(Link prevLink) {
        previous=prevLink;
    }
    public Link getPrevious() {
        return previous;
    }
    public int getDatum() {
        return datum;
    }
}
