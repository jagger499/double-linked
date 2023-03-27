public class DoubleLinkedList {
    private Node start;
    private Node end;
    private int size;

    public boolean isNullCase(int index) {
        if (index < 0) {
            System.out.println("Negative index is a invalid parameter");
            return true;
        }

        if (index > size) {
            System.out.println("The index is major than size");
            return true;
        }

        return false;
    }

    public DoubleLinkedList() {
        start = null;
        end = null;
        size = 0;
    }

    // return true if the list is empty
    public boolean isEmpty() {
        return start == null;
    }

    // return the size of the list
    public int getSize() {
        return size;
    }

    // add element in the end of the list is a special case
    public void pushLast(String value) {
        if (!isEmpty()) {
            end = new Node(value, null, end);
            end.prev.next = end;
        } else {
            start = end = new Node(value);
        }
        size++;
    }

    // add element in the start of the list is a special case
    public void pushFirst(String value) {
        if (!isEmpty()) {
            start = new Node(value, start, null);
            start.next.prev = start;
        } else {
            start = end = new Node(value);
        }
        size++;
    }

    // display specific element of the list
    public void displayElement(int index) {
        if (isNullCase(index)) {
            return;
        }
        Node current = getElementByIndex(index);
        System.out.println(current.value);
    }

    // display specific element of the list
    public boolean isInList(String value) {
        Node auxNode = start;
        boolean isInList = false;

        while (auxNode != null) {
            if (auxNode.value == value) {
                isInList = true;
            };
            auxNode = auxNode.next;
        }

        return isInList;
    }

    // show the elements containeds in the list
    public void displayList() {
        if (!isEmpty()) {
            Node auxNode = start;
            while (auxNode != null) {
                System.out.println(auxNode.value);
                auxNode = auxNode.next;
            }
        } else {
            System.out.println("List is empty");
        }
    }

    // obtain specific element of a list for the index
    public Node getElementByIndex(int index) {
        Node current = start;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // replace value in index
    public void replaceValueInIndex(int index, String value) {
        if (isNullCase(index)) {
            return;
        };
        Node current = getElementByIndex(index);
        current.value = value;
    }

    // obtain specific element of a list for the value
    public Node getElementByValue(String value) {
        Node auxNode = start;
        Node current = null;
        while (auxNode != null) {
            if (auxNode.value.contains(value)) {
                current = auxNode;
            }
            auxNode = auxNode.next;
        }
        return current;
    }

    // concatenar dos listas
    public void concatenate(DoubleLinkedList list1, DoubleLinkedList list2) {
        if (list1.isEmpty()) {
            start = list2.start;
            end = list2.end;
        } else if (list2.isEmpty()) {
            start = list1.start;
            end = list1.end;
        } else {
            end.next = list2.start;
            list2.start.prev = end;
            end = list2.end;
        }
    }

    public void deleteElementByValue(String value) {
        if (isEmpty()) {
            return;
        }
       
        Node current = getElementByValue(value);
       
        if (current == null) {
            System.out.println("the current element doesnt exist");
            return;
        }
       
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            start = current.next;
        }
 
 
        if (current.next != null) {
            current.next.prev = current.prev;
        }
       
        current = null;
        size--;
    }
 

    public void deleteElementByIndex(int value) {
        if (isEmpty()) {
            return;
        }
        
        Node current = getElementByIndex(value);
        
        if (current == null) {
            return;
        }
        
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            start = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }
        
        current = null;
        size--;
    }

    // add element in the indicated position
    public void addElement(int index, String value) {
        if (isNullCase(index)) {
            return;
        }

        if (index == 0) {
            pushFirst(value);
            return;
        }

        if (index == size) {
            pushLast(value);
            return;
        }

        Node current = getElementByIndex(index);

        Node newNode = new Node(value, current, current.prev);
        current.prev.next = newNode;
        current.prev = newNode;

        size++;
    }
}
