public class MinimalistList<E> {
    private SinglyLinkedNode<E> head = null;

    // add element to the start of the list
    public void addFirst(E elem) {
        SinglyLinkedNode<E> node = new SinglyLinkedNode<>();
        node.value = elem;
        node.next = head;
        head = node;
    }

    public MinimalistList<E> tail() {
        if (head == null) {
            throw new EmptyListException();
        }
        MinimalistList<E> list = new MinimalistList<>();
        list.head = head.next;
        return list;
    }

    public E getHeadValue() {
        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
