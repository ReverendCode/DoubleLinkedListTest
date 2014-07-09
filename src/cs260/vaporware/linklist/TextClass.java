package cs260.vaporware.linklist;

/**
 * Created by Code on 7/7/14.
 */

public class TextClass extends List {

    public void insert(char l) {//just a wrapper that passes char as int to the underlying Class
        super.insertTail((int)l);
    }
    public boolean removeLetter(char key) {//and vice versa
        return super.deleteKey((int)key);
    }
    public boolean findLetter(char key) {//why are you not setting the insertionpoint properly?
        return super.findKey((int)key);//*Note* Cleaning up the underlying function fixed this^
    }
    public boolean insertLetter(char newLetter) {
        return super.insertKey((int)newLetter);//this can't work if it doesn't have a cursor
    }
    public String showList() {//assumes non-zero dataset, maybe it shouldn't?
        String output = String.valueOf((char)firstLink.getDatum());
        for (Link temp=firstLink.getNext();temp!=null;temp=temp.getNext()) {
            output +=(char)temp.getDatum();
        }
        return output;
    }
    public void joinStrings (TextClass secondList) {
        TextClass temp = secondList;
        secondList.firstLink.setPrevious(lastLink);//may need 'this' here?
        lastLink.setNext(secondList.firstLink);  //It seems to work better without it.
        lastLink=secondList.lastLink; //perhaps it is an implicit 'this'?
        secondList=temp; //this should maintain the second list
    }
}
