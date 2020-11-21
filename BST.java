/*
* Binary search tree data structure
* @author : 
*/
import java.util.*;

public class BST<Node> 
{
    /*
    * The root of the BST
    */
    Node<Integer> root;

    /*
    * Node class for a BST
    */
    private static class Node<Integer>
    {
        Integer data;
        Node<Integer> left;
        Node<Integer> right;
        int instance;

        private Node(Integer item)
        {
            this.data = item;
            instance = 1;
        }

    }

    public BST()
    {
        root = null;
    }

    /*
    * Find function that finds an item in the BST
    * @param item to be found
    * @return boolean if the item was found
    */
    public boolean find(Integer item)
    {
        return find(item, root);
    }

    /*
    * Function override of the find function
    * @param item to be found
    * @param node the current node you are at
    * @return boolean if the item was found
    */
    private boolean find(Integer item, Node<Integer> node)
    {
        //TODO FILL IN FUNCITON
        if (item == null) 
        {
           return false;
            
        }
        if (item == node.data) 
        {
            return true;
            
        }
        else if (item.compareTo(node.data)== 1) 
        {
            return find(item, node.left);
            
        }
        else
            return find(item,node.right);
        
    }

    /*
    * Insert an item to the tree
    * @param item to insert
    */
    public void insert(Integer item)
    {
        root = insert(item, root);
    }

    /*
    * Helper function for insert
    * @param item to add
    * @param node you are at
    * @return node you traverse to
    */
    
    private Node<Integer> insert(Integer item, Node<Integer> node)
    {
        if (node == null) 
        {
            return new Node<Integer>(item);
            
        }
        if (node.data.compareTo(item) == -1) 
        {
            node.left = insert(item,node.left);
            
        }
        else
            node.right = insert(item, node.right);

        return node;
        //TODO FILL IN FUNCITON
       // throw new UnsupportedOperationException("Not yet implemented");
    }

    /*
    * Function for deletion of a node
    * @param item to delete
    */
    public void delete(Integer item)
    {
        root = delete(item, root);
    }

    /*
    * Helper function for deletion of a node
    * @param item to delete
    * @param node you are at
    * @return node you traverse to
    */
    private Node<Integer> delete(Integer item, Node<Integer> node)
    {
        //TODO FILL IN FUNCITON
        if (node == null) {
            return null;
            
        }
        if (node.data.compareTo(item)==-1) {
            node.right = delete(item,node.right);
            return node;
            
        }
        else if (node.data.compareTo(item)== 1) 
        {
            node.left = delete(item,node.left);
            return node;
            
        }
        else
        {
            if (node.left == null) {
                return node.right;
                
            }
            else if (node.right == null) 
            {
                return node.left;
                
            }
            else
            {
                node.data = removeSmallest(node.right);
            }
            return node;

        }
       
    }


    public Integer removeSmallest(Node<Integer> node)
    {
        if (node.left.left == null ) 
        {
            Integer smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
            
        }
        else
            return removeSmallest(node.left);


    }

    /*
    * Function to find the range sum of the binary tree
    * @param L the left bound
    * @param R the right bound
    * @return The sum of the range in the binary tree
    */
    public int rangeSum(Integer L, Integer R)
    {
        if (root == null) 
        {
            return 0;
            
        }
        int sum = 0;
        //TODO FILL IN FUNCITON
        if (root.data > L ) 
        {
            sum += rangeSum(root.right.data, R);
            return sum;
            
        }
        else
            sum += rangeSum(root.left.data,L);
        return sum;
    }

    /*
    * Function to print the Binary tree
    */
    public void print()
    {
        print(root);
    }

    /*
    * Helper Function to print the Binary tree
    * @param root the root of the tree
    */
    private void print(Node<Integer> root)
    {
        //TODO FILL IN FUNCITON
        if (root != null) 
        {
            print(root.left);
            System.out.println(root.data);
            print(root.right);
            
        }
        else
            System.out.println(root);
        
    }
}