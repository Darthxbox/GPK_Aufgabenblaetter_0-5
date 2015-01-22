
public class IntTree {

    private class Node {

        int elem;
        Node left = null;
        Node right = null;

        Node(int elem) {
            this.elem = elem;
        }

        void add(int elem) {
            if (elem < this.elem) {
                if (this.left == null) {
                    this.left = new Node(elem);
                } else {
                    this.left.add(elem);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(elem);
                } else {
                    this.right.add(elem);
                }
            }
        }

        void printUp() {
            if (this.left != null) {
                this.left.printUp();
            }
            System.out.println(this.elem);
            if (this.right != null) {
                this.right.printUp();
            }
        }

        void printDown() {
            if (this.right != null) {
                this.right.printDown();
            }
            System.out.println(this.elem);
            if (this.left != null) {
                this.left.printDown();
            }
        }

    }

    private Node root = null;

    public void add(int elem) {
        if (empty()) {
            this.root = new Node(elem);
        } else {
            this.root.add(elem);
        }
    }

    public boolean empty() {
        return this.root == null;
    }

    public void printUp() {
        if (this.root != null) {
            this.root.printUp();
        }
    }

    public void printDown() {
        if (this.root != null) {
            this.root.printDown();
        }
    }

    public int countNodes() {
      return leafCount(root);
    }

    public int leafCount( Node node ) {
        if ( node == null )
            return 0;
        return 1 + leafCount(node.left) + leafCount(node.right);
    }

    public int height() {
        return rekursionHeight(root);
    }

    int rekursionHeight(Node node)
    {
        if (node == null) {
            return (0);
        } else {
            // Verarbeite Höhen der einzelnen Teilbäume
            int linkeHöhe = rekursionHeight(node.left);
            int rechteHöhe = rekursionHeight(node.right);

            //Vergleiche und nimm die größere Höhe
            if (linkeHöhe > rechteHöhe)
                return (linkeHöhe + 1);
            else
                return (rechteHöhe + 1);
        }
    }

    public static void main(String[] args) {

    }
}

//