import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.*;

public class PriorityQueue<Key extends Comparable<Key>> implements Iterable<Integer>{
private int max;
private int n;
private int[] binaryHeap;
private int[] binaryHeapinv;
private Key[] keys;

public PriorityQueue(int vertices){
    if(vertices<0){
        System.out.println("vertices cannot be 0 or less");
    }
    else {
        this.max = vertices;
        this.n=0;
        this.keys = (Key[]) new Comparable[max+1];
        this.binaryHeap = new int[max+1];
        this.binaryHeapinv = new int[max+1];
        for(int i =0;i<= max;i++) this.binaryHeapinv[i] = -1;
    }
}

public boolean isEmpty(){
    if(n == 0){
        return true;
    }
    return false;
}

public boolean contains(int i) {
        if (i < 0 || i >= max) throw new IllegalArgumentException();
        return binaryHeapinv[i] != -1;
}

public int size(){
    return n;
}

public void insert(int i, Key key){
    if (i < 0 || i >= max) throw new IllegalArgumentException();
    if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
    n++;
    binaryHeapinv[i] = n;
    binaryHeap[n] = i;
    keys[i] = key;
    swim(n);
}

public int minIndex(){
    if(n == 0){
        System.out.println("Priority queue underflow");
    }
    else{
        return binaryHeap[1];
    }
    return -1;
}

public Key minKey(){
    if (n == 0) throw new NoSuchElementException("Priority queue underflow");
    return keys[binaryHeap[1]];
}

public int delMin() {
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        int min = binaryHeap[1];
        exch(1, n--);
        sink(1);
        assert min == binaryHeap[n+1];
        binaryHeapinv[min] = -1;
        keys[min] = null;
        binaryHeap[n+1] = -1;
        return min;
}
public Key keyOf(int i) {
        if (i < 0 || i >= max) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        else return keys[i];
}

public void changeKey(int i, Key key) {
        if (i < 0 || i >= max) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        keys[i] = key;
        swim(binaryHeapinv[i]);
        sink(binaryHeapinv[i]);
}

public void decreaseKey(int i, Key key) {
        if (i < 0 || i >= max) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) <= 0)
            throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");
        keys[i] = key;
        swim(binaryHeapinv[i]);
}

public void increaseKey(int i, Key key) {
        if (i < 0 || i >= max) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) >= 0)
            throw new IllegalArgumentException("Calling increaseKey() with given argument would not strictly increase the key");
        keys[i] = key;
        sink(binaryHeapinv[i]);
    }

public void delete(int i) {
        if (i < 0 || i >= max) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        int index = binaryHeapinv[i];
        exch(index, n--);
        swim(index);
        sink(index);
        keys[i] = null;
        binaryHeapinv[i] = -1;
}

    private boolean greater(int i, int j) {
        return keys[binaryHeap[i]].compareTo(keys[binaryHeap[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = binaryHeap[i];
        binaryHeap[i] = binaryHeap[j];
        binaryHeap[j] = swap;
        binaryHeapinv[binaryHeap[i]] = i;
        binaryHeapinv[binaryHeap[j]] = j;
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public Iterator<Integer> iterator() { return new HeapIterator(); }

    private class HeapIterator implements Iterator<Integer> {
        // create a new pq
        private PriorityQueue<Key> copy;

        // add all elements to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            copy = new PriorityQueue<>(binaryHeap.length - 1);
            for (int i = 1; i <= n; i++)
                copy.insert(binaryHeap[i], keys[binaryHeap[i]]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }
}
