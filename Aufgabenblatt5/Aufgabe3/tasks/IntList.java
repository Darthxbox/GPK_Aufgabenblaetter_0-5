public class IntList {

    private class ListNode {
        int elem;
        ListNode next = null;

        ListNode(int elem, ListNode next) {
            this.elem = elem;
            this.next = next;
        }

        int getElem() {
            return this.elem;
        }

        ListNode getNext() {
            return this.next;
        }

        void add(int elem) {
            if (this.next == null) {
                this.next = new ListNode(elem, null);
            } else {
                this.next.add(elem);
            }
        }

        public String toString() {
            return this.elem + ((this.next == null) ? "-|" : "->" + this.next);
        }

        public void reverseInt()
        {
            if (head == null || head.next == null)
                return; //Falls die Liste leer ist, muss nichts umgedreht werden.

            //Dreieckstausch
            ListNode Second = head.next; //neuer Nachfolger von head
            ListNode Third = Second.next; //neuer Nachfolger vom Element nach head
            Second.next = head; //head und neuer Nachfolger werden vertauscht

            head.next = null; //alter Nachfolger wird auf null gesetzt

            if (Third == null) //Falls die Liste nur 2 Knoten besitzt, wurden sie bereits vertauscht.
                    return;    // Da es keinen dritten gibt, sind wir fertig.

            ListNode cur = Third; //Aktueller Knoten ist nun unser neuer dritter Nachfolger
            ListNode prev = Second; //Vorheriger Knoten ist nun unser neuer Nachfolger

            while (cur != null) //Bis letzter Knoten erreicht wird (null) werden die Knoten vertauscht
            {
                ListNode NextNode = cur.next;
                cur.next = prev;
                prev = cur;
                cur = NextNode;
            }

            head  = prev; //schlussendlich wird der Knoten vor null als neuer head festgelegt.
        }

        public void reverseRec(ListNode cur)
        {

            if(cur == null) //Falls die Liste leer ist, muss nichts umgedreht werden.
                return;

            if(cur.next == null)
            {
                //head wird als neuer End-Knoten definiert.
                head = cur;
                return;
            }

            reverseRec(cur.next);
            cur.next.next = cur;
            cur.next = null; //setzt den alten next pointer auf null
        }
    }

    private ListNode head = null;

    public boolean empty() {
        return this.head == null;
    }

    public void add(int elem) {
        if (this.empty()) {
            this.head = new ListNode(elem, null);
        } else {
            this.head.add(elem);
        }
    }

    public boolean search(int value) {
        String elements[] = toString().split("->");
        ListNode elem = head;
        for(int i = 1; i<= elements.length; i++)
        {
            if(elem.elem == value)
            {
                return true;
            }
            elem = elem.next;
        }
        return false;
    }

    public int first() {
        return head.elem;
    }

    public void reverse() {
      head.reverseInt();
    }

    public void reverseRecursive() {
        head.reverseRec(head);
    }

    public String toString() {
        return "[" + this.head + "]";
    }

    public static void main(String[] args) {
     IntList n = new IntList();
        n.add(5);
        n.add(8);
        n.search(8);
    }

}

// Die Elemente werden durch die überschriebene toString-Methode ausgegeben.
// Dabei wird zuerst der head ausgegeben: 1
// Im zweiten Schritt wird der Pointer head.next abgefragt, welche wiederum 2 als Element hat
// Beim dritten Element kommt head.next.next zum tragen -> 3
// Im letzten Schritt bekommen wir das Element "null"
