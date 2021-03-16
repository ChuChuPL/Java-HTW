public class SinglyLinkedList<E> implements HTWList<E>{
    private SinglyLinkedNode<E> head = null;

    // add element to the start of the list
    public void addFirst(E o) {
        SinglyLinkedNode<E> node = new SinglyLinkedNode<>();
        node.value = o;
        node.next = head;
        head = node;
    }

    public E valueOfHead() {
        return head.value;
    }

    public void add(E o) {
        SinglyLinkedNode<E> node = new SinglyLinkedNode<>();
        node.value = o;
        if (head == null) {
            head = node;
            return;
        }
        SinglyLinkedNode<E> cursor = head;
        while (cursor.next != null) {
            cursor = cursor.next;
        }
        cursor.next = node;
    }

    public int size() {
        int c = 0;
        SinglyLinkedNode<E> cursor = head;
        while (cursor != null) {
            c++;
            cursor = cursor.next;
        }
        return c;
    }

    public E get(int i) {
        SinglyLinkedNode<E> cursor = head;
        int c = 0;
        while (c < i) {
            c++;
            cursor = cursor.next;
        }
        return cursor.value;
    }

    public int indexOf(Object obj) {
        int c = 0;
        SinglyLinkedNode<E> cursor = head;
        while (cursor != null) {
            if (cursor.value.equals(obj)) {
                return c;
            }
            c++;
            cursor = cursor.next;
        }
        return -1;
    }

    public SinglyLinkedList<E> tail() {
        if (head == null) {
            throw new EmptyListException();
        }
        SinglyLinkedList<E> newList = new SinglyLinkedList<>();
        newList.head = head.next;
        return newList;
    }

}
