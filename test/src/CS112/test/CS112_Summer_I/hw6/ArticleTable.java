package CS112.test.CS112_Summer_I.hw6;

import java.util.Iterator;


public class ArticleTable implements Iterable<Article> {

    private final int N = 2503;                // size of table is prime number close to expected size
    // Next we provide the Hash Table methods which use the previous methods for the buckets

    // This is the table of pointers to LLs

    private Node[] A = new Node[N];     // will be initialized to null

    // The basic hash function used by the String library for hashCode()

    int hash(String s) {
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            h = 31 * h + s.charAt(i);
        }
        return Math.abs(h) % N;
    }

    // insert, delete, and lookup

    public void insert(Article a) {
        A[hash(a.getTitle())] = insertInBucket(a.getTitle(), a, A[hash(a.getTitle())]);
    }

    public void delete(String title) {
        A[hash(title)] = deleteFromList(title, A[hash(title)]);   // delete from bucket
    }

    public Article lookup(String title) {
        return lookup(title, A[hash(title)]);
    }



    // bucket node
    private class Node{
        String key;
        Article datum;
        Node next;       // ptr to next node in bucket

        public Node(String k, Article d, Node n) {
            key = k; datum = d; next = n;
        }
    }

    // standard recursive insert into a LL, takes a LL and returns a new LL with this node in it;
    //  does not insert duplicate keys

    private Node insertInBucket(String key, Article datum, Node n) {
        if(n == null) {
            return new Node(key, datum, null);      // put in this bucket
        }
        else if(key.equals(n.key))              // duplicate, don't insert
            return n;
        else {
            n.next = insertInBucket(key, datum, n.next);
            return n;
        }
    }

    // standard recursive delete in LL

    private Node deleteFromList(String key, Node n) {
        if(n == null)
            return null;
        else if(key.equals(n.key))             // found it
            return n.next;
        else {
            n.next = deleteFromList(key,n.next);
            return n;
        }
    }

    // standard recursive find or lookup method: returns pointer to datum associated with key or null if
    // not found

    private Article lookup(String key, Node n) {
        if(n == null) {
            return null;
        }
        else if(key.equals(n.key)) {              // found it!
            return n.datum;
        } else {
            return lookup(key, n.next);
        }
    }


// Iterator code: to iterate the hash table

    public Iterator<Article> iterator() {
        return new It();
    }


    private class It implements Iterator<Article> {

        private int i = 0;
        private Node p = A[0];

        public It() {
            i = 0;
            p = A[0];
            if(p == null) {      // end of bucket, find next non-empty bucket
                while(i < N && A[i] == null) {
                    ++i;
                }
            }
        }

        // interface methods required by Iterator interface

        public boolean hasNext() {
            return (i != N);
        }

        public Article next() {
            Article tmp = p.datum;
            p = p.next;
            if(p == null) {      // end of bucket, find next non-empty bucket
                ++i;
                while(i < N && A[i] == null) {
                    ++i;
                }
                if(i != N)
                    p = A[i];
            }
            return tmp;
        }

        public void remove() {             // required by interface but we won't implement it
        }
    }



//   // just debug routines
//
//   private void printBucket(Node n) {
//      if( n == null)
//         System.out.println(" -> .");
//      else {
//         System.out.print(" -> [" + n.key + "]");
//         printBucket(n.next);
//      }
//   }
//
//   private void printTable() {
//      for(int i = 0; i < A.length; ++i) {
//         System.out.print("A["+i+"]");
//         printBucket(A[i]);
//      }
//      System.out.println();
//   }

    public static void main(String[] args) {

        DatabaseIterator db = new DatabaseIterator("/Users/davidzhou/Dropbox/BU/Java/Github_Repository/java_code_learning/test/src/CS1" +
                "12/test/CS112_Summer_I/hw6/articles");

        System.out.println("Read " + db.getNumArticles() +
                " articles from disk.");

        ArticleTable Articles = new ArticleTable();

        db.reset();

        while(db.hasNext()) {
            Article a = db.next();
            Articles.insert(a);
        }

        System.out.println("Created in-memory hash table of articles.");

        Iterator<Article> iter = Articles.iterator();
        for(int i = 0; i < 10 && iter.hasNext(); ++i)
            System.out.println(iter.next());


    }
}