public class Node {
    public String value;
    Node next, prev;

    // null nodes constructor
    public Node (String vAlue) {
        this(vAlue, null, null);
    }

    // existing nodes constructor
    public Node(String vAlue, Node nExt, Node pRev) {
        value = vAlue;
        next = nExt;
        prev = pRev;
    }
}