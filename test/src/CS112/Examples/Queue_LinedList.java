package CS112.Examples;

/**
 * Implementing Queue with linked list
 * Maintain two pointers: head and tail.
 */
public class Queue_LinedList<Item> {

    private Node head;
    private Node tail;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item i) {
        if (isEmpty() == true) {
            head = new Node();
            head.item = i;
            tail = head;
            N++;
        } else {

            tail.next = new Node();
            tail = tail.next;
            tail.item = i;
            N++;
        }
    }

    public Item dequeue() {
        if (isEmpty()) return null;
        Item i = head.item;
        head = head.next;
        N--;
        return i;
    }


    public static void main(String[] args) {
        Queue_LinedList<String> q = new Queue_LinedList<>();

        //Test
        System.out.println(q.isEmpty());
        System.out.println(q.dequeue());
        q.enqueue("a");
        q.enqueue("b");
        System.out.println(q.size());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.size());
        System.out.println(q.isEmpty());
    }
}
