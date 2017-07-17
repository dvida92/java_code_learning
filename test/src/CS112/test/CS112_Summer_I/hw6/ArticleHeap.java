package CS112.test.CS112_Summer_I.hw6;

/**
 * Created by davidzhou on 6/30/17.
 */
class ArticleHeap {

    private final int SIZE = 1000;       // initial length of array
    private int next = 0;              // limit of elements in array
    private Node[] A = new Node[SIZE];   // implements tree by storing elements in level order


    public static class Node {
        public Article a;
        public Node(Article a, double cs) {
            this.a = a;
            this.a.putCS(cs);
        }
        public String toString() {
            return "[ " + a.getCS() + " ] " + a;
        }
    }

    // standard resize to avoid overflow

    private void resize() {
        Node[] B = new Node[A.length*2];
        for(int i = 0; i < A.length; ++i)
            B[i] = A[i];
        A = B;
    }

    // methods to move up and down tree as array

    private int parent(int i) { return (i-1) / 2; }
    private int lchild(int i) { return 2 * i + 1; }
    private int rchild(int i) { return 2 * i + 2; }

    private boolean isLeaf(int i) { return (lchild(i) >= next); }
    private boolean isRoot(int i) { return i == 0; }

    // standard swap, using indices in array
    private void swap(int i, int j) {
        Node temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // basic data structure methods

    public boolean isEmpty() {
        return (next == 0);
    }

    public int size() {
        return (next);
    }

    // insert an Entry into array at next available location
    //    and fix any violations of heap property on path up to root

    public void insert(Article a, double cs) {
        Node n = new Node(a, cs);
        if(size() == A.length) resize();
        A[next] = n;

        int i = next;
        int p = parent(i);
//        while(!isRoot(i) && A[i].cosineSim > A[p].cosineSim) {
        while(!isRoot(i) && (A[i].a.compareCS(A[p].a) > 0)) {
            swap(i,p);
            i = p;
            p = parent(i);
        }

        ++next;
    }


    // Remove top (maximum) element, and replace with last element in level
    //    order; fix any violations of heap property on a path downwards.
    //    Throws a HeapEmptyException if called when heap is empty

    public Node getMax() throws HeapEmptyException {
        if(isEmpty())
            throw new HeapEmptyException();

        --next;
        swap(0,next);                // swap root with last element
        int i = 0;                   // i is location of new key as it moves down tree

        // while there is a maximum child and element out of order, swap with max child
        int mc = maxChild(i);
        while(!isLeaf(i) && (A[i].a.compareCS(A[mc].a)) < 0) {
            swap(i,mc);
            i = mc;
            mc = maxChild(i);
        }

        return A[next];
    }

    // return index of maximum child of i or -1 if i is a leaf node (no children)

    int maxChild(int i) {
        if(lchild(i) >= next)
            return -1;
        if(rchild(i) >= next)
            return lchild(i);
        else if(A[lchild(i)].a.compareCS(A[rchild(i)].a) > 0)
            return lchild(i);
        else
            return rchild(i);
    }



    // debug method

    private void printHeap() {
        for(int i = 0; i < A.length; ++i)
            System.out.print(A[i].a + " ");
        System.out.println("\t next = " + next);
    }

    private void printHeapAsTree() {
        printHeapTreeHelper(0, "");
        System.out.println();
    }

    private void printHeapTreeHelper(int i, String indent) {
        if(i < next) {

            printHeapTreeHelper(rchild(i), indent + "   ");
            System.out.println(indent + A[i].a.getCS() + "  " + A[i].a.getTitle());
            printHeapTreeHelper(lchild(i), indent + "   ");
        }
    }

    // Unit Test

    public static  void main(String [] args) {

        ArticleHeap H = new ArticleHeap();

        // test basic methods

        H.insert(new Article("4", "a"), .4);
        H.printHeapAsTree();
        H.insert(new Article("3", "b"), .3);
        H.printHeapAsTree();
        H.insert(new Article("5", "b"), .5);
        H.printHeapAsTree();
        H.insert(new Article("8", "b"), .8);
        H.printHeapAsTree();
        H.insert(new Article("4", "b"), .4);
        H.printHeapAsTree();
        H.insert(new Article("1", "b"), .1);
        H.printHeapAsTree();

        for(int i = 0; !H.isEmpty(); ++i) {
            try {
                H.getMax();
                H.printHeapAsTree();
            }
            catch(HeapEmptyException e) {
                System.out.println("Error: Attempt to call getMax on empty heap!");
            }
        }

    }
}

class HeapEmptyException extends Exception {}

