public class CharStack {

    private CharListNode top = null;

    // push an element into the stack
    public void push(char elem) {
        CharListNode node = new CharListNode();
        node.set(elem, top);
        top = node;
    }

    // pop an element from the stack
    public char pop() {
        char result = top.value();
        top = top.next();
        return result;
    }

    // true iff the stack is empty
    public boolean empty() {
        return top == null;
    }
}
