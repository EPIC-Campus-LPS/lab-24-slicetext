import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    @org.junit.jupiter.api.Test
    void add() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(6);
        pq.add(1);
        assertEquals("1 6 5 ", pq.toString());
    }

    @org.junit.jupiter.api.Test
    void contains() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(6);
        pq.add(1);
        assertTrue(pq.contains(6));
    }

    @org.junit.jupiter.api.Test
    void peek() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(6);
        pq.add(1);
        assertEquals(1, pq.peek());
    }

    @org.junit.jupiter.api.Test
    void poll() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(6);
        pq.add(1);
        assertEquals(1, pq.poll());
        assertEquals("5 6 ", pq.toString());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(6);
        pq.add(1);
        assertTrue(pq.remove(5));
        assertTrue(pq.remove(6));
        assertFalse(pq.remove(3));
    }

    @org.junit.jupiter.api.Test
    void size() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(6);
        pq.add(1);
        assertEquals(3, pq.size());
        pq.poll();
        assertEquals(2, pq.size());
        pq.poll();
        pq.poll();
        assertEquals(0, pq.size());
    }
}