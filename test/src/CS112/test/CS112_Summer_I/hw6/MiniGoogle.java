package CS112.test.CS112_Summer_I.hw6;

/**
 * Created by davidzhou on 6/30/17.
 */

import java.util.*;

public class MiniGoogle {

    private static final int K = 1579;
    private static final int N = 2503;                 // prime number close to number of entries

    private static final int M = 3;                    // how many matches to print out in phrase search



    public static ArticleTable getArticleTable(DatabaseIterator db) {

        db.reset();

        ArticleTable H = new ArticleTable();

        while(db.hasNext()) {
            Article a = db.next();
            H.insert(a);
        }

        return H;
    }

    private static void addArticle(Scanner s, ArticleTable T) {
        System.out.println();
        System.out.println("Add an article");
        System.out.println("==============");

        System.out.print("Enter article title: ");
        String title = s.nextLine();

        System.out.println("You may now enter the body of the article.");
        System.out.println("Press return twice when you are done.");

        String body = "";
        String line = "";
        do {
            line = s.nextLine();
            body += line + "\n";
        } while (!line.equals(""));

        T.insert(new Article(title, body));
    }


    private static void removeArticle(Scanner s, ArticleTable T) {
        System.out.println();
        System.out.println("Remove an article");
        System.out.println("=================");

        System.out.print("Enter article title: ");
        String title = s.nextLine();


        T.delete(title);
    }


    private static void titleSearch(Scanner s, ArticleTable T) {
        System.out.println();
        System.out.println("Search by article title");
        System.out.println("=======================");

        System.out.print("Enter article title: ");
        String title = s.nextLine();

        Article a = T.lookup(title);
        if(a != null)
            System.out.println(a);
        else {
            System.out.println("Article not found!");
            return;
        }

        System.out.println("Press return when finished reading.");
        s.nextLine();
    }


    public static String phraseSearch(String phrase, ArticleTable T) {


        Iterator<Article> iter = T.iterator();
        ArticleHeap AH = new ArticleHeap();

        while(iter.hasNext()) {
            Article a = iter.next();
            double cs = cosineSimilarity(a.getBody(), phrase);
//            if (cs > 0.001) {
//                System.err.println(a.getTitle() + " " + cs);
//            }
            if(cs > 0.001) {
                //          System.out.println(a.getTitle());
                AH.insert(a,cs);
            }
        }

        String s;
        int M1 = Math.min(M, AH.size());
        if(M1 == 0)
            s = "\nThere are no matching articles.";
        else {
            s = "Top " + M1 + " Matches:\n";

            for(int i = 0; i < M1; ++i) {
                ArticleHeap.Node n = null;
                try {
                    n = AH.getMax();
                }
                catch(HeapEmptyException e ) {
                    System.out.println("Error: Attempt to getMax from empty heap!");
                }
                s += "\nMatch " + (i+1) + " with cosine similarity of ";
                n.a.putCS( (double) Math.round(n.a.getCS()*10000));
                n.a.putCS(n.a.getCS() / 10000.0);
                s += n.a.getCS();
                s += ":\n\n" + n.a;
            }
        }
        return s;
    }

    // Remove anything which is not a lower-case letter or a digit or white space
    private static String preprocess(String s) {
        s = s.toLowerCase();
        String t = "";
        for(int i = 0; i < s.length(); ++i) {
            if(Character.isLetter(s.charAt(i))
                    || Character.isDigit(s.charAt(i))
                    || Character.isWhitespace(s.charAt(i)))
                t = t + s.charAt(i);
        }
        return t;
    }

    private static boolean white(String t) {
        for(int i = 0; i < blackList.length; ++i)
            if(t.equals(blackList[i]))
                return false;
        return true;
    }

    private static String [] blackList = { "the", "of", "and", "a", "to", "in", "is",
            "you", "that", "it", "he", "was", "for", "on", "are", "as", "with",
            "his", "they", "i", "at", "be", "this", "have", "from", "or", "one",
            "had", "by", "word", "but", "not", "what", "all", "were", "we", "when",
            "your", "can", "said", "there", "use", "an", "each", "which", "she",
            "do", "how", "their", "if", "will", "up", "other", "about", "out", "many",
            "then", "them", "these", "so", "some", "her", "would", "make", "like",
            "him", "into", "time", "has", "look", "two", "more", "write", "go", "see",
            "number", "no", "way", "could", "people",  "my", "than", "first", "water",
            "been", "call", "who", "oil", "its", "now", "find", "long", "down", "day",
            "did", "get", "come", "made", "may", "part" };


    public static double cosineSimilarity(String s, String t) {
        TermFrequencyTable TF = new TermFrequencyTable();
        s = preprocess(s);
        t = preprocess(t);

        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            String ter = st.nextToken();
            if(white(ter))
                TF.insert(ter, 0);
        }

        st = new StringTokenizer(t);
        while (st.hasMoreTokens()) {
            String ter = st.nextToken();
            if(white(ter))
                TF.insert(ter, 1);
        }

        return TF.cosineSimilarity(0,1);

    }

    public static void main(String[] args) {

        Scanner user = new Scanner(System.in);

        String dbPath = "/Users/davidzhou/Dropbox/BU/Java/Github_Repository/java_code_learning/test/src/CS1" +
                "12/test/CS112_Summer_I/hw6/articles";

        DatabaseIterator db = new DatabaseIterator(dbPath);

        System.out.println("Read " + db.getNumArticles() +
                " articles from disk.");

        ArticleTable Articles = getArticleTable(db);

        System.out.println("Created in-memory hash table of articles.");

        int choice = -1;
        do {
            System.out.println();
            System.out.println("Welcome to Mini-Google!");
            System.out.println("=======================");
            System.out.println("Make a selection from the " +
                    "following options:");
            System.out.println();
            System.out.println("    1. add a new article");
            System.out.println("    2. remove an article");
            System.out.println("    3. Search by article title");
            System.out.println("    4. Search by phrase (list of keywords)");
            System.out.println();

            System.out.print("Enter a selection (1-4, or 0 to quit): ");

            choice = user.nextInt();
            user.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Bye!");
                    return;

                case 1:
                    addArticle(user, Articles);
                    break;

                case 2:
                    removeArticle(user, Articles);
                    break;

                case 3:
                    titleSearch(user, Articles);
                    break;

                case 4:
                    System.out.println();
                    System.out.println("Search by article content");
                    System.out.println("=========================");

                    System.out.print("Enter search phrase: ");
                    String phrase = user.nextLine();
                    System.out.println(phraseSearch(phrase, Articles));
                    break;

                default:
                    break;
            }

            choice = -1;

        } while (choice < 0 || choice > 5);

//      String A = "Z B C D";
//      String A1 = "D B Z C";
//      String A2 = "Z B C D Z B C D Z B C D Z B C D";
//      String B = "B C D";
//      String C = "Z B G";
//      String D = "Z D D G";
//
//      System.out.println("(A,A):" + " " + cosineSimilarity(A,A));
//      System.out.println("(A,A1):" + " " + cosineSimilarity(A,A1));
//      System.out.println("(A,A2):" + " " + cosineSimilarity(A,A2));
//      System.out.println("(A,B):" + " " + cosineSimilarity(A,B));
//      System.out.println("(A,C):" + " " + cosineSimilarity(A,C));
//      System.out.println("(A,D):" + " " + cosineSimilarity(A,D));
//      System.out.println("(B,C):" + " " + cosineSimilarity(B,C));
//      System.out.println("(B,D):" + " " + cosineSimilarity(B,D));
//      System.out.println("(C,D):" + " " + cosineSimilarity(C,D));

    }

}