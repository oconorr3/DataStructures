import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> {

	private BinaryNode<T> root;
	
	/**
	 * Constructor
	 * @param root the root of the BST
	 */
	public BinarySearchTree(BinaryNode<T> root) {
		this.root = root;
	}
	

	/**
	 * @return the root
	 */
	public BinaryNode<T> getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(BinaryNode<T> root) {
		this.root = root;
	}
	
	
	/**
	 * Inserts a given value T into the BST
	 * @param data
	 */
	public void insert(T data) {
		this.root = this.insert(this.root, data);
	}
	
	/**
	 * Recursive Helper for insert
	 * Inserts a given value T into the BST
	 * @param root the root pointer of a BST
	 * @param data the data to be inserted
	 * @return the new root pointer of the BST
	 */
	private BinaryNode<T> insert(BinaryNode<T> root, T data) {
		//if the tree is empty
		if (root == null) {
			root = new BinaryNode<T>(data);
			return root;
		}
		
		//otherwise we need to recursively insert down the BST
		if (data.compareTo(root.getData()) < 0) {
			root.setLeft(this.insert(root.getLeft(), data));
		} 
		else if (data.compareTo(root.getData()) > 0) {
			root.setRight(this.insert(root.getRight(), data));
		}
		
		//return the unchanged root pointer for the BST
		return root;
	}
	
	/**
	 * @ param data
	 */
	public void delete(T data) {
		root = this.delete(this.root, data);
	}
	
	/**
	 * helper function for delete
	 * @param root
	 * @param data
	 * @return
	 */
	private BinaryNode<T> delete(BinaryNode<T> root, T data) {
		//base case if the tree is empty
		if (root == null) {
			return root;
		}
		
		//recursiely search the tree for the value
		if (data.compareTo(root.getData()) < 0) {
			root.setLeft(this.delete(root.getLeft(), data));
		} 
		else if (data.compareTo(root.getData()) > 0) {
			root.setRight(this.delete(root.getRight(), data));
		} 
		else {
			//if the data is the same as the roots data, this is the node to be deleted
			
			//if the node has no child
			if (root.getLeft() == null) {
				return root.getRight();
			}
			else if (root.getRight() == null) {	//if the node has 1 child
				return root.getLeft();
			}
			
			//if the node has 2 children get the smallest node in the right subtree (in order successor)
			root.setData(minValue(root.getRight()));
			
			//delete the inorder successor
			root.setRight(this.delete(root.getRight(), root.getData()));
		}
		
		return root;
	}
	
	/**
	 * Count the number of nodes in a Binary tree
	 * @param root
	 * @return
	 */
    public int countNodes(BinaryNode<T> root) 
    {
        if (root == null)
            return 0;
        return (1 + countNodes(root.getLeft()) + countNodes(root.getRight()));
    }
	

    /**
     * Compute the "height" of a tree -- the number of
     * nodes along the longest path from the root node
     * down to the farthest leaf node
     * @param root
     * @return
     */
    public int height(BinaryNode<T> root)
    {
        if (root == null)
           return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.getLeft());
            int rheight = height(root.getRight());
             
            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1); 
        }
    }
    
	
	/**
	 * Flips all the children of a binary tree
	 * move all the small (left) elements to the right subtree and all the large(right) elements to the left
	 * @param root
	 */
	public void reverseTree(BinaryNode<T> root) {
		if (root == null) {
	        return;
	    }

		//swap the children of root
	    BinaryNode<T> temp = root.getRight();
	    root.setRight(root.getLeft());
	    root.setLeft(temp);

	    //recursively flip the subtrees of the left and right child respectively
	    reverseTree(root.getLeft());

	    reverseTree(root.getRight());
	}
	
	/**
	 * Helper for validating a BST
	 * find min by traversing left pointers until we reach leftmost node. 
	 * But in Binary Tree, we must visit every node to figure out min. 
	 * So the idea is to traverse the given tree and for every node return min of 3 values.
	 * @param root
	 * @return
	 */
	public T minValue(BinaryNode<T> root) {

		if (root == null)
            return null;
		
	    T result = root.getData();
	    T left = minValue(root.getLeft());
	    T right = minValue(root.getRight());
	 
	    if (left.compareTo(result) < 0)
	    	result = left;
	    if (right.compareTo(result) < 0)
	    	result = right;
	    
	    return result;
	}
	

	/**
	 * Helper for validating a BST
	 * we can find maximum by traversing right pointers until we reach rightmost node. 
	 * But in Binary Tree, we must visit every node to figure out maximum. 
	 * So the idea is to traverse the given tree and for every node return maximum of 3 values.
	 * @param root
	 * @return
	 */
	public T maxValue(BinaryNode<T> root) {
		
		if (root == null)
            return null;
		
		T result = root.getData();
		T left = maxValue(root.getLeft());
		T right = maxValue(root.getRight());
		
		if (left.compareTo(result) > 0) {
		      result = left;
		}
	    if (right.compareTo(result) > 0) {
	    	 result = right;
	    }
		     
	    return result;
		
		
	}
	
	/**
	 * Validates a BST
	 * @param root
	 * @return true if the given root is a BST, false otherwise
	 */
	private boolean validateBST(TreeNode root, long min, long max) {
		if (root == null) {
		    return true;
		}

		if (root.val >= max || root.val <= min) {
		    return false;
		}

		return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    	}
	
	/**
	 * Given a Binary Search Tree and a target number, return true if 
	 * there exist two elements in the BST such that their sum is equal to the given target.
	 * @param root
	 * @param k
	 * @return
	 */
	public boolean findTarget(BinaryNode<T> root, int k) {
		ArrayList<Integer> set = new ArrayList<>();
        return findTargetHelper(root, set, k);
	}
	
	//Recursively search the tree, check if the value of the current node + any of the previously visited nodes in the set is equal to the target
	private boolean findTargetHelper(BinaryNode<T> root, ArrayList<Integer> set, int k) {
	       
        if (root == null) {
            return false;
        }
       
        for (int num : set) {
            if (num + (Integer)root.getData() == k) {
                return true;
            }
        }
        
        set.add((Integer) root.getData());
        
        return findTargetHelper(root.getLeft(), set, k) || findTargetHelper(root.getRight(), set, k);
    }

	
	/**
	 * Flatten left and right subtree and paste each sublist 
	 * to the right child of the root. 
	 * @param root
	 */
	public void flatten(BinaryNode<T> root) {
        if (root == null) return;
        
        BinaryNode<T> left = root.getLeft();
        BinaryNode<T> right = root.getRight();
        
        root.setLeft(null);
        
        flatten(left);
        flatten(right);
        
        root.setRight(left);
        BinaryNode<T> cur = root;
        
        while (cur.getRight() != null) {
        	cur = cur.getRight();
        }
        
        cur.setRight(right);
    }
	
	/**
	 * 
	 */
	public void breadthFirstSearch() {
		
	}
	
	/**
	 * 
	 */
	public void depthFirstSearch() {
		
	}

	
	/**
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBalanced(BinaryNode<T> root) {
		if (root == null) {	//an empty tree is balanced
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isFull() {
		return false;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isComplete() {
		return false;
		
	}
	
	
	/**
	 * conduct a preOrder traversal of the Binary tree
	 * @param root
	 */
	public void preOrderTraversal(BinaryNode<T> root) {
		if (root == null)
            return;
 
        /* first print data of node */
        System.out.print(root.getData() + " ");
 
        /* then recur on left sutree */
        preOrderTraversal(root.getLeft());
 
        /* now recur on right subtree */
        preOrderTraversal(root.getRight());
	}
	
	/**
	 * conduct an in order traversal of the Binary tree
	 * @param root
	 */
	public void inOrderTraversal(BinaryNode<T> root) {
		if (root == null) {
			return;
		}
		/* first recur on left child */
		inOrderTraversal(root.getLeft());
 
        /* then print the data of node */
        System.out.print(root.getData() + " ");
 
        /* now recur on right child */
        inOrderTraversal(root.getRight());
	}

	/**
	 * conduct a post traversal of the Binary tree
	 * @param root
	 */
	public void postOrderTraversal(BinaryNode<T> root) {
		if (root == null)
            return;
 
        // first recur on left subtree
		postOrderTraversal(root.getLeft());
 
        // then recur on right subtree
		postOrderTraversal(root.getRight());
 
        // now deal with the node
        System.out.print(root.getData() + " ");
	}

		
}
