package CS112.Examples;

/**
 * Implement stack using linked list (Java's generic feature).
 * Always push and pop at the beginning of the linked list
 * Have a pointer "first" pointing the beginning
 */
public class Stack_LinkedList<Item> { //Generic: item

    private Node first;
    private int N;

    private class Node{
        Item s;
        Node next; //Recursive Definition
    }

    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return N;
    }

    public void push(Item s) {
        Node oldFirst = first;
        first = new Node();
        first.s = s;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item s = first.s;
        first = first.next;
        N--;
        return s;
    }

    public static void main(String[] args) {
        Stack_LinkedList<String> s = new Stack_LinkedList<>();
        s.push("a");
        s.push("b");
        System.out.println(s.isEmpty());
        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
