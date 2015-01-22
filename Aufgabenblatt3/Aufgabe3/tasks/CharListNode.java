public class CharListNode {

    private char elem;
    private CharListNode next;

    // replace the value and next node
    public void set(char newElem, CharListNode newNext) {
        elem = newElem;
        next = newNext;
    }

    // get the value
    public char value() {
        return elem;
    }

    // get the next node
    public CharListNode next() {
        return next;
    }

}
