public class HTWArrayList<E> implements HTWList<E>{

    private int capacity = 10;

    // private E[] data = new E[capacity];
    private E[] data = (E[])(new Object[capacity]);  // work around for line 5

    private int size = 0;

    // add "element" to the end of list
    public void add(E element) {
        if (size == capacity) {
            // array is full, new array needed
            capacity = capacity * 2;
            E[] temp = (E[])(new Object[capacity]);

            // for (int i = 0; i <data.length; i++) {
                // temp[i] = data[i];
            // }

            // equivalent to lines 19--21
            System.arraycopy(data, 0, temp, 0, data.length);

            data = temp;
        }
        data[size] = element;
        size++;
    }

    // remove the element at position idx
    public void remove(int idx) {
        if (idx >= 0 && idx < size){
            for (int i = idx; i < size-1; i++) {
                data[i] = data[i+1];
            }
            size--;
        } else {
            throw new IndexOutOfBoundExcpetion();
        }
    }

    public E get(int idx) {
        if (idx >= 0 && idx < size) {
            return data[idx];
        } else {
            throw new IndexOutOfBoundExcpetion();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        // HTWArrayList<String> htwArrayList = new HTWArrayList<String>();
        HTWArrayList<String> htwArrayList = new HTWArrayList<>(); // equivalent to line 59
        htwArrayList.add("King 0");
        htwArrayList.add("King 1");
        htwArrayList.add("King 2");
        htwArrayList.add("King 3");
        htwArrayList.add("King 4");

        HTWArrayList<Integer> integerHTWArrayList = new HTWArrayList<Integer>();
        integerHTWArrayList.add(42);
        integerHTWArrayList.add(4);
        integerHTWArrayList.add(2);

        for (int i = 0; i < htwArrayList.size(); i++) {
            System.out.println(htwArrayList.get(i));
        }
    }
}
