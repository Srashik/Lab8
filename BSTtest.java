/*
* Main testing class for BST
* @author: USFCACS 245
*/
public class BSTtest 
{
    public static void main(String[] args)
    {
        //TODO CHANGE CLASS AS NEEDED TO TEST CODE
        BST<Integer> tree = new BST<Integer>();

        Integer L = Integer.valueOf(0);
        Integer R = Integer.valueOf(1);
        /*for(int i=2; i < args.length; i++)
        {
            tree.insert(args[i]);

        }*/
        tree.insert(L);
        tree.insert(R);

        tree.delete(1);
        System.out.println(tree.find(0));
        tree.print();
        
       // System.out.println(tree.rangeSum(L, R));
    }
}
