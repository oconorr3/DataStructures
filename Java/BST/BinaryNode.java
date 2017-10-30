

/**
 * 
 * @author Conor
 *
 * @param <T> Generic holder for data in a binary node
 */
public class BinaryNode<T extends Comparable<T>> {

		private T data;
		private BinaryNode<T> left;
		private BinaryNode<T> right;
		
		/**
		 * Constructor 
		 * @param data the data for the BinaryNode to hold
		 */
		public BinaryNode(T data) {
			this.data = data;;
			this.left = null;
			this.right = null;
		}
		
		/**
		 * Constructor
		 * @param data the data for the BinaryNode to hold
		 * @param left the left child
		 * @param right the right child
		 */
		public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		/**
		 * @return the data
		 */
		public T getData() {
			return data;
		}

		/**
		 * @param data the data to set
		 */
		public void setData(T data) {
			this.data = data;
		}
		

		/**
		 * left getter
		 * @return the left
		 */
		public BinaryNode<T> getLeft() {
			return left;
		}

		/**
		 * left setter
		 * @param leftChild the left child to set
		 */
		public void setLeft(BinaryNode<T> left) {
			this.left = left;
		}
		
		/**
		 * right getter
		 * @return the right
		 */
		public BinaryNode<T> getRight() {
			return right;
		}

		/**
		 * right setter
		 * @param right the right child to set
		 */
		public void setRight(BinaryNode<T> right) {
			this.right = right;
		}

		
}
