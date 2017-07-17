package CS112.test.CS112_Summer_I.hw6;

/**
 * Created by davidzhou on 6/30/17.
 */
import java.util.*;

public class TermFrequencyTable {

    private final int N = 7; // 563;

    private final int numDocuments = 2;

    // bucket node
    public class Node{
        String term;
        int[] termFreq = new int[numDocuments];
        Node next;
        public Node(String t, int docNum) {
            term = t;
            termFreq[docNum] = 1;
            next = null;
        }
    }

    // insert

    public void insert(String term, int docNum) {
        A[hash(term)] = insertInBucket(term, docNum, A[hash(term)]);
    }

    // standard recursive insert into a LL, takes a LL and returns a new LL with this node in it;
    //  does not insert duplicate terms

    private  Node insertInBucket(String term, int docNum, Node n) {
        if(n == null)
            return new Node(term, docNum);
        else if(term.equals(n.term))  {            // already exists, just increment freq count
            n.termFreq[docNum]++ ;
            return n;
        }
        else {
            n.next = insertInBucket(term, docNum, n.next);
            return n;
        }
    }

    // Next we provide the Hash Table methods which use the previous methods for the buckets

    // This is the table of pointers to LLs

    private Node[] A = new Node[N];     // will be initialized to null

    // The basic hash function used by the String library for hashCode()

    private int hash(String s) {
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            h = 31 * h + s.charAt(i);
        }
        return Math.abs(h) % N;
    }

    // returns cosine similarity of two documents whose terms are in this table

    public double cosineSimilarity(int docA, int docB) {
        double j = 0.0;
        double k = 0.0;
        double l = 0.0;
        for(int i = 0; i < N; ++i) {

            j += dotProduct(0,1,A[i]);
            k += dotProduct(0,0,A[i]);
            l += dotProduct(1,1,A[i]);
        }
        //     System.out.println(j + " " + k + " " + l + " ");
        return j / (Math.sqrt(k) * Math.sqrt(l));
    }

    public double cosineSimilarity() {
        return cosineSimilarity(0,1);
    }

    // recursive method to find dot product of terms in a single bucket

    private double dotProduct(int docA, int docB, Node p) {
        if(p == null)
            return 0;
        else {
            System.out.println(p.term + " " + p.termFreq[0] + " " + p.termFreq[1]);
            return (p.termFreq[docA] * p.termFreq[docB]) + dotProduct(docA, docB, p.next);
        }
    }

    // just debug routines

    private  void printBucket(Node n) {
        if( n == null)
            System.out.println(" -> .");
        else {
            System.out.print(" -> [" + n.term + ": " + n.termFreq[0] + " " + n.termFreq[1] + "]");
            printBucket(n.next);
        }
    }

    private  void printTable() {
        for(int i = 0; i < A.length; ++i) {
            System.out.print("A["+i+"]");
            printBucket(A[i]);
        }
        System.out.println();
    }

    private static double testTFT(String A, String B) {
        TermFrequencyTable T = new TermFrequencyTable();

        StringTokenizer st = new StringTokenizer(A);
        while (st.hasMoreTokens()) {
            T.insert(st.nextToken(),0);
        }

        st = new StringTokenizer(B);
        while (st.hasMoreTokens()) {
            T.insert(st.nextToken(),1);
        }

        //    T.printTable();

        return(T.cosineSimilarity(0,1));

    }

    public static void main(String[] args) {



        String A = "Z B C D";
        String A1 = "D B Z C";
        String A2 = "Z B C D Z B C D Z B C D Z B C D";
        String B = "B C D";
        String C = "Z B G";
        String D = "Z D D G";

        System.out.println(testTFT(A,A));
        System.out.println(testTFT(A,A1));
        System.out.println(testTFT(A,A2));
        System.out.println(testTFT(A,B));
        System.out.println(testTFT(A,C));
        System.out.println(testTFT(A,D));
        System.out.println(testTFT(B,C));
        System.out.println(testTFT(B,D));
        System.out.println(testTFT(C,D));


    }
}