import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * This class encapsulates a binary search tree.
 *
 * @author Steven Castellucci, 2015
 * @author Navid Mohaghegh - Debugged 2016
 */
public class BinarySearchTree<E extends Comparable<? super E>>
// E Ensure the parameterized type can be sorted.
{
    private Node<E> root;

    /**
     * Get the root of the BST
     * @return the root
     */
    public Node<E> getRoot()
    {
        return root;
    }

    /**
     * Initializes an empty binary search tree.
     */
    public BinarySearchTree()
    {
        root = null;
    }

    /**
     * Adds the passed value to the tree.
     * @param value the value to add to the tree
     */
    public void add(E value)
    {
        root = addNode(root, value);
    }

    // Solves 'add' recursively.
    private Node<E> addNode(Node<E> root, E value)
    {
        if (root == null) // Base case, add node here.
        {
            return new Node<E>(value, null, null);
        }
        else if (root.data.compareTo(value) > 0) // Recursive, go left.
        {
            root.leftSubTree = addNode(root.leftSubTree, value);
            return root;
        }
        else // Recursive, go right.
        {
            root.rightSubTree = addNode(root.rightSubTree, value);
            return root;
        }
    }

    /**
     * Removes the passed value from the tree. The tree is not changed if it
     * does not contain the passed value.
     * @param value the value to remove from the tree.
     */
    public void remove(E value)
    {
        root = removeNode(root, value);
    }

    // Solves 'remove' recursively.
    private Node<E> removeNode(Node<E> root, E value)
    {
        if (root != null && root.data.compareTo(value) == 0)
        // Base case, remove this node.
        {
            // Case 1 or 2 (i.e., 0 or 1 child)
            if (root.leftSubTree == null)
            {
                // null if Case 1, not null if Case 2
                return root.rightSubTree;
            }
            // Case 2 (i.e., 1 child on left)
            else if (root.rightSubTree == null)
            {
                return root.leftSubTree;
            }
            else // Case 3 (i.e., 2 children)
            {
                root.data = largestValue(root.leftSubTree).data;
                root.leftSubTree = removeLargestNode(root.leftSubTree);
                return root;
            }
        }
        else if (root.data.compareTo(value) > 0) // Recursive case, go left.
        {
            root.leftSubTree = removeNode(root.leftSubTree, value);
            return root;
        }
        else // Recursive case, go right.
        {
            root.rightSubTree = removeNode(root.rightSubTree, value);
            return root;
        }
    }

    // Returns the largest value in the subtree rooted at 'root'.
    private Node<E> largestValue(Node<E> root)
    {
        if (root.rightSubTree == null) // Base case, this node has largest.
        {
            return root;
        }
        else // Recursive case, keep going right.
        {
            return largestValue(root.rightSubTree);
        }
    }

    // Returns the smallest value in the subtree rooted at 'root'.
    private Node<E> smallestValue(Node<E> root)
    {
        if (root.leftSubTree == null) // Base case, this node has smallest.
        {
            return root;
        }
        else // Recursive case, keep going left.
        {
            return smallestValue(root.leftSubTree);
        }
    }

    // Removes the node with the largest value in the subtree rooted at 'root'.
    private Node<E> removeLargestNode(Node<E> root)
    {
        if (root.rightSubTree == null) // Case 1 or 2 (i.e., 0 or 1 child)
        {
            return root.leftSubTree; // null if Case 1, not null if Case 2
        }
        else
        {
            root.rightSubTree = removeLargestNode(root.rightSubTree);
            return root;
        }
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        infixPrint(root, sb);
        return sb.toString().trim();
    }

    // Prints the elements in infix order.
    private void infixPrint(Node<E> root, StringBuffer sb)
    {
        if (root != null)
        {
            infixPrint(root.leftSubTree, sb);
            sb.append(root.data + " ");
            infixPrint(root.rightSubTree, sb);
        }
    }


    public void bfs()
    {
        Queue<Node> queue = new LinkedList<Node>();
        if (root == null)
            return;
        queue.clear();
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node node = queue.remove();
            System.out.print(node.data + " ");
            if(node.leftSubTree != null) queue.add(node.leftSubTree);
            if(node.rightSubTree != null) queue.add(node.rightSubTree);
        }
    }
    /*
     * This static nested class encapsulates a node in the tree.
     */
    static class Node<E>
    {
        private E data;
        private Node<E> leftSubTree;
        private Node<E> rightSubTree;

        public Node(E data, Node<E> leftSubTree, Node<E> rightSubTree)
        {
            this.data = data;
            this.leftSubTree = leftSubTree;
            this.rightSubTree = rightSubTree;
        }

        public E getData()
        {
            return this.data;
        }
    }

    public static void main(String[] args)
    {
        BinarySearchTree bst = new BinarySearchTree();

        bst.add(25);
        bst.add(17);
        bst.add(8);
        bst.add(44);
        bst.add(83);
        bst.add(68);
        bst.add(99);
        bst.add(57);
        bst.add(39);
        bst.add(77);

        System.out.println(bst);

        bst.remove(25);
        System.out.println(bst);
    }
}

