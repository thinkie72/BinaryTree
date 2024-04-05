import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 *
 * @author: Tyler Hinkie
 * @version: 04.04.2024
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     *
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size() - 1));
    }

    /**
     * A function that searches for a value in the tree
     *
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    // Parent method that calls recursive method to search the tree for a value
    public boolean search(int val) {
        // TODO: Complete the search function
        return search(root, val);
    }

    // Recursive method to search the binary tree for a value
    public boolean search(BSTNode n, int val) {
        if (n == null) return false;
        // Each recurses to check a child of the given node based on the value of that node
        if (n.getVal() > val) return search(n.getLeft(), val);
        if (n.getVal() < val) return search(n.getRight(), val);
        // If neither run, then the given node must contain the target value, meaning the value is within the tree!
        return true;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    // Creates an ArrayList to be exported and calls the recursive function to add to that ArrayList
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> out = new ArrayList<>();
        inorder(out, root);
        return out;
    }

    // Recursive method to inorder the tree
    public void inorder(ArrayList<BSTNode> out, BSTNode n) {
        if (n == null) return;
        // Recurses and adds element to the ArrayList in the following order: Left, Root, Right
        inorder(out, n.getLeft());
        out.add(n);
        inorder(out, n.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    // Creates an ArrayList to be exported and calls the recursive function to add to that ArrayList
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> out = new ArrayList<>();
        preorder(out, root);
        return out;
    }

    // Recursive method to preorder the tree
    public void preorder(ArrayList<BSTNode> out, BSTNode n) {
        if (n == null) return;
        // Recurses and adds element to the ArrayList in the following order: Root, Left, Right
        out.add(n);
        preorder(out, n.getLeft());
        preorder(out, n.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    // Creates an ArrayList to be exported and calls the recursive function to add to that ArrayList
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> out = new ArrayList<>();
        postorder(out, root);
        return out;
    }

    // Recursive method to postorder the tree
    public void postorder(ArrayList<BSTNode> out, BSTNode n) {
        if (n == null) return;
        // Recurses and adds element to the ArrayList in the following order: Left, Right, Root
        postorder(out, n.getLeft());
        postorder(out, n.getRight());
        out.add(n);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     *
     * @param val The value ot insert
     */
    // Parent method to call the recursive method to insert an element into the tree properly
    public void insert(int val) {
        // TODO: Complete insert
        insert(root, val);
    }

    // Recursive method to insert an element with a given value into the binary tree
    public BSTNode insert(BSTNode n, int val) {
        if (n == null) return new BSTNode(val);
        if (n.getVal() == val) return n;
        if (n.getVal() < val) {
            n.setRight(insert(n.getRight(), val));
            return n;
        }
        n.setLeft(insert(n.getLeft(), val));
        return n;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     *
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
