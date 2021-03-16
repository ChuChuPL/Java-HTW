import java.util.LinkedList;
import java.util.List;

/**
 * A simplified implementation of HashSet
 * @author gefei
 */

public class SeparateChainingHashSet<E> {
    // in this implementation, we don't use this attribute
    // using it would make the program slightly more efficient,
    // but also complicate the implementation
    private int currentSize = 0;

    private int m = 11;

    private List<E>[] data;

    public SeparateChainingHashSet() {
        data = new LinkedList[m];
        for (int i = 0; i < m; i++) {
            data[i] = new LinkedList<>();
        }
    }

    /**
     * @return true if <code>e</code> added to <code>data</code>.
     *         false if <code>e</code> already existing in <code>data</code>
     */
    public boolean add(E e) {
        int index = (e.hashCode() & 0x7fffffff) % m;
        List<E> existing = data[index];
        for (E ext : existing) {
            if (ext.equals(e)) {
                return false;
            }
        }
        existing.add(e);
        return true;
    }

    /**
     * @return true if <code>e</code> removed from <code>data</code>.
     *         false if <code>e</code> not found in <code>data</code>
     */
    public boolean remove(Object o) {
        int index = (o.hashCode() & 0x7fffffff) % m;
        List<E> existing = data[index];
        for (E ext : existing) {
            if (ext.equals(o)) {
                existing.remove(ext);
                return true;
            }
        }
        return false;
    }

    public boolean contains(Object o) {
        int index = (o.hashCode() & 0x7fffffff) % m;
        List<E> existing = data[index];
        if (existing.isEmpty()) {
            return false;
        }
        return existing.contains(o);
    }

    public int size() {
        int c=0;
        for (int i=0; i<data.length;i++){
            for (E ext: data[i]){
                c++;
            }
        }
        return c;
    }

    public double getLoadFactor() {
        double size=size();
        double m2=m;
        return size/m2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof SeparateChainingHashSet)) return false;

        SeparateChainingHashSet<E> that = (SeparateChainingHashSet<E>) o;
        if(!(this.size()== that.size())) {
            return false;
        }
        for(int i=0; i<data.length;i++) {
            for (E ext : data[i]) {
                if (that.contains(ext)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        SeparateChainingHashSet<Integer> s= new SeparateChainingHashSet<>();
        SeparateChainingHashSet<Integer> s2= new SeparateChainingHashSet<>();
        s.add(13);
        s.add(24);
        //s2.add(24);
        s2.add(24);
        System.out.println(s.size());
        System.out.println(s.remove(12));
        System.out.println(s.remove(13));
        System.out.println(s.size());
        System.out.println(s.getLoadFactor());
        System.out.println(s.equals(s2));
    }

}