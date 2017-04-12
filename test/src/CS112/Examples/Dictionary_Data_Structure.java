package CS112.Examples;

/**
 * Goal: Implement a Dictionary Structure that is efficient in operations like: lookup, insertion and deletion
 * Using a binary search tree
 * Created by davidzhou on 4/11/17.
 */
public class Dictionary_Data_Structure {

    private class BinarySearchTree<K extends Comparable<? super K>, V> {  //Comparable<? super K>

        class Node{
            K key;
            V value;
            Node left, right;

            /**
             *  Create a node with no children and key and value.
             * @param
             *
             * @param value
             */
            public Node(K key, V value) {
                this.key = key;
                this.value = value;
                left = null;
                right = null;
            }

        }

        private Node root = null;

        /**
         * Continue Searching until find the key
         * @param key
         * @return the value corresponding to the key
         */
        public V lookup(K key) {
            return null;
        }


        /**
         * Insert key-value pair if key not already in the tree;
         * Modifies vluae if key is already int the tree.
         * @param key should not be null
         * @param value
         */
        public void insert(K key, V value) {
            root = insert(root, key, value);
        }

        /**
         *  Recursive Helper function
         * @param root
         * @param key
         * @param value
         * @return the root of the new tree after insertion
         */
        private Node insert(Node root, K key, V value) {
            if (root == null) {
                return new Node(key, value);
            }

            int result = key.compareTo(root.key);
            if (result == 0) {
                root.value = value;
            } else if (result > 0) {
                root.right = insert(root.right, key, value);
            } else {
                root.left = insert(root.right, key, value);
            }
            return root;


        }

        public String toString() {
            return printTreeInPreOrder(root);
        }

        private String printTreeInPreOrder(Node root) {
            return null;
        }


    }


}
