import java.util.ArrayList;

/**
 * This class represents a Priority Queue (heap) based on the ordering
 * defined by the compareTo method for the element. "Lower" value will
 * mean "higher" priority.
 *
 * @param <E> the type of elements in the queue
 * @author
 */
public class PriorityQueue<E extends Comparable<E>> {

    private ArrayList<E> myHeap; //array representation of the heap

    /**
     * Creates an empty Priority Queue
     */
    public PriorityQueue() {
        myHeap = new ArrayList<E>();
    }

    /**
     * Adds the element to the priority queue
     *
     * @param element the element to be added
     */
    public void add(E element) {
        myHeap.add(element);
        heapify(0);
    }

    /**
     * Swaps two elements in the queue.
     * Pre-condition: 0 <= posOne, posTwo < size of queue
     *
     * @param posOne the first element's position in the queue
     * @param posTwo the second element's position in the queue
     */
    private void swap(int posOne, int posTwo) {
        E first = myHeap.get(posOne);
        E second = myHeap.get(posTwo);
        myHeap.set(posOne, second);
        myHeap.set(posTwo, first);
    }

    /**
     * Returns whether the element is in the heap
     *
     * @param element the element to be searched for
     * @return true if the element is in the queue, false otherwise
     */
    public boolean contains(E element) {
        return myHeap.contains(element);
    }

    /**
     * Returns the element of highest priority, null if queue is empty.
     * Post-condition: the queue is not changed
     *
     * @return the element of highest priority queue
     */
    public E peek() {
        if(myHeap.isEmpty()) {
            return null;
        }
        return myHeap.get(0);
    }

    /**
     * Removes and returns the element of highest priority,
     * returns null if queue is empty.
     *
     * @return the element of highest priority
     */
    public E poll() {
        E val = myHeap.remove(0);
        heapify(0);
        return val;
}

    /**
     * Will "sift down" the element at the given position
     * down to restore the heap property
     *
     * @param pos the starting position for heapify
     */
    private void heapify(int pos) {
        int firstChild  = (2 * pos) + 1;
        int secondChild = (2 * pos) + 2;
        if(firstChild >= myHeap.size()) {
            return;
        }
        int smallestChild = firstChild;
        if(secondChild < myHeap.size()) {
            smallestChild =
                    (myHeap.get(firstChild).compareTo(myHeap.get(secondChild)) <= 0)?
                            firstChild : secondChild;
        }
        if(myHeap.get(smallestChild).compareTo(myHeap.get(pos)) < 0) {
            swap(pos, smallestChild);
        }

        heapify(firstChild);
        heapify(secondChild);
    }

    /**
     * Finds and removes the given element from the queue.
     * Returns true if an element was deleted from the queue,
     * false otherwise.
     *
     * @param element the element to be removed from the queue
     * @return true if an element was removed from the queue, false otherwise
     */
    public boolean remove(E element) {
        if(!contains(element)) {
            return false;
        }
        myHeap.remove(element);
        heapify(0);
        return true;
    }

    /**
     * Returns the number of elements in the queue
     *
     * @return the number of elements in the queue
     */
    public int size() {
        return myHeap.size();
    }

    /**
     * Returns the String representation of the heap
     * (by the order of list, each element separated
     * with a single space)
     *
     * @return the String representation of the heap
     */
    public String toString() {
        String s = "";
        for(E element : myHeap) {
            s += element + " ";
        }
        return s;
    }

}