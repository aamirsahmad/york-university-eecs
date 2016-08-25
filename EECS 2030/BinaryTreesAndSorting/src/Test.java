/**
 * Created by aamir on 2016-07-21.
 */
public class Test
{
    public static void main(String[] args)
    {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(2);
        bst.add(1);
        bst.add(12);
        bst.add(39);
        bst.add(27);
        bst.add(44);
        bst.add(16);
        bst.add(9);
        bst.add(30);

        System.out.println(bst);

        bst.remove(12);
        System.out.println(bst);
    }
}
