import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  
 *  @version 09/10/18 11:13:22
 */

/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * 
 * @param <T> This is a type parameter. T is used as a class name in the
 *        definition of this class.
 *
 *        When creating a new DoublyLinkedList, T should be instantiated with an
 *        actual class name that extends the class Comparable. Such classes
 *        include String and Integer.
 *
 *        For example to create a new DoublyLinkedList class containing String
 *        data: DoublyLinkedList<String> myStringList = new
 *        DoublyLinkedList<String>();
 *
 *        The class offers a toString() method which returns a comma-separated
 *        sting of all elements in the data structure.
 * 
 *        This is a bare minimum class you would need to completely implement.
 *        You can add additional methods to support your code. Each method will
 *        need to be tested by your jUnit tests -- for simplicity in jUnit
 *        testing introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>> {

	/**
	 * private class DLLNode: implements a *generic* Doubly Linked List node.
	 */
	private class DLLNode {
		public final T data; // this field should never be updated. It gets its
								// value once from the constructor DLLNode.
		public DLLNode next;
		public DLLNode prev;
		public boolean isMarked;

		/**
		 * Constructor
		 * 
		 * @param theData  : data of type T, to be stored in the node
		 * @param prevNode : the previous Node in the Doubly Linked List
		 * @param nextNode : the next Node in the Doubly Linked List
		 * @return DLLNode
		 */
		public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) {
			data = theData;
			prev = prevNode;
			next = nextNode;
			isMarked = false;
		}
	}

	// Fields head and tail point to the first and last nodes of the list.
	private DLLNode head, tail;

	/**
	 * Constructor of an empty DLL
	 * 
	 * @return DoublyLinkedList
	 */
	public DoublyLinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * Tests if the doubly linked list is empty
	 * 
	 * @return true if list is empty, and false otherwise
	 *
	 *         Worst-case asymptotic running time cost: O(1)
	 *
	 *         Justification: no for loops or anything just checks 2 nodes
	 */
	public boolean isEmpty() {
		if (this.head == null && this.tail == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Inserts an element in the doubly linked list
	 * 
	 * @param pos  : The integer location at which the new data should be inserted
	 *             in the list. We assume that the first position in the list is 0
	 *             (zero). If pos is less than 0 then add to the head of the list.
	 *             If pos is greater or equal to the size of the list then add the
	 *             element at the end of the list.
	 * @param data : The new data of class T that needs to be added to the list
	 * @return none
	 *
	 *         Worst-case asymptotic running time cost: O(N)
	 *
	 *         Justification: only one for loop so worst case it loops through all elements once
	 */
	public void insertBefore(int pos, T data) {
		DLLNode prevNode = null;
		DLLNode nextNode = null;
		DLLNode insertNode = new DLLNode(data, prevNode, nextNode);
		int size = this.size();
		if (pos <= 0) {
			if (this.isEmpty()) {
				insertNode.next = null;
				insertNode.prev = null;
				this.head = insertNode;
				this.tail = insertNode;
			} else {
				insertNode.prev = null;
				insertNode.next = this.head;
				this.head.prev = insertNode;
				this.head = insertNode;
			}
		} else if (pos >= size) {
			if(this.isEmpty()) {
				insertNode.next = null;
				insertNode.prev = null;
				this.head = insertNode;
				this.tail = insertNode;
			}
			else {
				prevNode = this.head;
				for(int count =0;count<size-1;count++) {
					prevNode = prevNode.next;
				}
				if(size == 1) {
					this.head.next = insertNode;
				}
				else {
					prevNode.next = insertNode;
				}
				insertNode.next = null;
				insertNode.prev = prevNode;
				this.tail = insertNode;
			}
		}
		else {
			prevNode = this.head;
			nextNode = this.head.next;
			for(int count =0;count<pos-1;count++) {
				prevNode = prevNode.next;
				nextNode = nextNode.next;
			}
			prevNode.next = insertNode;
			insertNode.prev = prevNode;
			insertNode.next = nextNode;
			if(nextNode != null) {
				nextNode.prev = insertNode;
			}
		}
			return;
	}

	public int size() {
		int size = 0;
		if (!this.isEmpty()) {
			size++;
			DLLNode tmpHead = this.head;
			while(tmpHead != this.tail && tmpHead != null) {
				tmpHead = tmpHead.next;
				size++;
			}
		}
		return size;
	}

	/**
	 * Returns the data stored at a particular position
	 * 
	 * @param pos : the position
	 * @return the data at pos, if pos is within the bounds of the list, and null
	 *         otherwise.
	 *
	 *         Worst-case asymptotic running time cost: 0(N)
	 *
	 *         Justification: one for loop so worst it loops through all nodes
	 *
	 */
	public T get(int pos) {
		DLLNode pushNode;
		if(pos>=0 && pos<=this.size()) {
			pushNode = this.head;
			for(int count =0;count<pos;count++) {
				pushNode = pushNode.next;
			}
			return pushNode.data;
		}
		else {
			return null;
		}
	}

	/**
	 * Deletes the element of the list at position pos. First element in the list
	 * has position 0. If pos points outside the elements of the list then no
	 * modification happens to the list.
	 * 
	 * @param pos : the position to delete in the list.
	 * @return true : on successful deletion, false : list has not been modified.
	 *
	 *         Worst-case asymptotic running time cost: O(N)
	 *
	 *         Justification: One for loop. checks everything once at worst to get delete node
	 */
	public boolean deleteAt(int pos) {
		DLLNode deleteNode;
		if(pos>=0 && pos<=this.size()) {
			deleteNode = this.head;
			if(pos == 0){
				this.head =deleteNode.next;
				this.head.prev = null;
			}
			for(int count =0;count<pos;count++) {
				deleteNode = deleteNode.next;
			}
			DLLNode prev = deleteNode.prev;
			DLLNode next = deleteNode.next;
			if(prev != null) {
				prev.next = next;
			}
			if(next != null){
				next.prev = prev;
			}
			if(pos == this.size()) {
				prev.next = null;
				this.tail = prev;
			}
			return true;
		}
		return false;
	}

	/**
	 * Reverses the list. If the list contains "A", "B", "C", "D" before the method
	 * is called Then it should contain "D", "C", "B", "A" after it returns.
	 *
	 * Worst-case asymptotic running time cost: O(N^2)
	 *
	 * Justification: For loop within a for loop for each start but only does it once.
	 */
	public void reverse() {
		int pos1 = 0;
		int pos2 = this.size();
		int numOfSwaps = 0;
		DLLNode next = null;
		DLLNode prev = null;
		DLLNode tmp1 = null;
		DLLNode swap1 = null;
		DLLNode swap2 = null;
		boolean odd = false;
		if(pos2 % 2 == 0) {
			numOfSwaps = pos2/2;
		}
		else {
			numOfSwaps = pos2-1;
			numOfSwaps = numOfSwaps/2;
			odd = true;
		}
		for(int count =0; count<numOfSwaps ;count++) {
			if(count == 0) {
				swap1 = getNode(pos1);
				swap2 = getNode(pos2);
				next = swap1.next;
				prev = swap2.prev;
			}
			else {
				swap1 = next;
				swap2 = prev;
				next = next.next;
				prev = prev.prev;
			}
			tmp1 = swap1;
			swap1 = swap2;
			swap2 = tmp1;
			if(pos1 == 0) {
				swap2.prev = swap2.next;
				swap2.next = null;
				swap1.next = swap1.prev;
				swap1.prev = null;
				this.head = swap1;
				this.tail = swap2;
			}
			else {
				tmp1 = swap2.prev;
				swap2.prev = swap2.next;
				swap2.next = tmp1;
				tmp1 = swap1.prev;
				swap1.prev = swap1.next;
				swap1.next = tmp1;
			}
			pos1++;
			pos2--;
			if(count == numOfSwaps-1) {
				if(odd) {
					tmp1 = next.prev;
					next.prev = next;
					next.next = tmp1;
				}
			}
		}
		this.head.prev = null;
		this.tail.next = null;
	}
	public DLLNode getNode(int pos) {
		DLLNode returnNode;
		returnNode = this.head;
		for(int count =0; count<pos-1;count++) {
			returnNode = returnNode.next;
		}
		return returnNode;
	}
	/**
	 * Removes all duplicate elements from the list. The method should remove the
	 * _least_number_ of elements to make all elements unique. If the list
	 * contains "A", "B", "C", "B", "D", "A" before the method is called Then it
	 * should contain "A", "B", "C", "D" after it returns. The relative order of
	 * elements in the resulting list should be the same as the starting list.
	 *
	 * Worst-case asymptotic running time cost: O(N^2)
	 *
	 * Justification: for loop in for loop
	 */
	public void makeUnique() {
		if (this.size() > 0) {
			ArrayList<Integer> posList = new ArrayList<Integer>();
			int counter = 0;
			for (DLLNode iter = head; iter.next != null; iter = iter.next) {
				int posToBeAdded = counter + 1;
				for (DLLNode secondIter = iter.next; secondIter != null; secondIter = secondIter.next) {
					if (iter.data == secondIter.data && secondIter.isMarked == false) {
						posList.add(posToBeAdded - posList.size());
						secondIter.isMarked = true;
					}
					posToBeAdded++;
				}
				counter++;
			}
			int i = 0;
			while (i < posList.size()) {
				deleteAt(posList.get(i));
				i++;
			}
		}
	}

	/*----------------------- STACK API 
	 * If only the push and pop methods are called the data structure should behave like a stack.
	 */

	/**
	 * This method adds an element to the data structure. How exactly this will be
	 * represented in the Doubly Linked List is up to the programmer.
	 * 
	 * @param item : the item to push on the stack
	 *
	 *             Worst-case asymptotic running time cost: O(1)
	 *
	 *             Justification: no loops, only deals with first node
	 */
	public void push(T item) {
		DLLNode pushNode;
		pushNode = new DLLNode(item,null,null);
		if (this.isEmpty()) {
			pushNode.next = null;
			pushNode.prev = null;
			this.head = pushNode;
			this.tail = pushNode;
		} else {
			pushNode.prev = null;
			pushNode.next = this.head;
			this.head.prev = pushNode;
			this.head = pushNode;
		}
	}
	/**
	 * This method returns and removes the element that was most recently added by
	 * the push method.
	 * 
	 * @return the last item inserted with a push; or null when the list is empty.
	 *
	 *         Worst-case asymptotic running time cost: O(1)
	 *
	 *         Justification: no loops. Removes head each time
	 */
	public T pop() {
		if(!this.isEmpty()) {
			DLLNode popNode = this.head;
			DLLNode newHead = null;
			if(this.size()>1) {
				newHead = popNode.next;
			}
			T data = popNode.data;
			if(newHead != null) {
				newHead.prev = null;
				this.head = newHead;
			}
			return data;
		}
		return null;
	}

	/*----------------------- QUEUE API
	 * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
	 */

	/**
	 * This method adds an element to the data structure. How exactly this will be
	 * represented in the Doubly Linked List is up to the programmer.
	 * 
	 * @param item : the item to be enqueued to the stack
	 *
	 *             Worst-case asymptotic running time cost: O(1)
	 *
	 *             Justification: deals only with tail of list. no loops 
	 */
	public void enqueue(T item) {
		if(!this.isEmpty()) {
			DLLNode tail = this.tail;
			DLLNode push = new DLLNode(item,tail,null);
			tail.next = push;
			this.tail = push;
		}
		else {
			DLLNode push = new DLLNode(item, null, null);
			this.head = push;
			this.tail = push;
		}
	}

	/**
	 * This method returns and removes the element that was least recently added by
	 * the enqueue method.
	 * 
	 * @return the earliest item inserted with an equeue; or null when the list is
	 *         empty.
	 *
	 *         Worst-case asymptotic running time cost: 0(1)
	 *
	 *         Justification: works in constant time as only removes head each time
	 */
	public T dequeue() {
		DLLNode dequeue = this.head;
		DLLNode prev = null;
		if(!this.isEmpty()) {
			if(this.size()>1) {
				prev = dequeue.next;
				this.head = prev;
				prev.prev = null;
				return dequeue.data;
			}
			else {
				this.head = null;
				this.tail = null;
				return dequeue.data;
			}
		}
		else {
			return null;
		}
	}

	/**
	 * @return a string with the elements of the list as a comma-separated list,
	 *         from beginning to end
	 *
	 *         Worst-case asymptotic running time cost: Theta(n)
	 *
	 *         Justification: We know from the Java documentation that
	 *         StringBuilder's append() method runs in Theta(1) asymptotic time. We
	 *         assume all other method calls here (e.g., the iterator methods above,
	 *         and the toString method) will execute in Theta(1) time. Thus, every
	 *         one iteration of the for-loop will have cost Theta(1). Suppose the
	 *         doubly-linked list has 'n' elements. The for-loop will always iterate
	 *         over all n elements of the list, and therefore the total cost of this
	 *         method will be n*Theta(1) = Theta(n).
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		boolean isFirst = true;

		// iterate over the list, starting from the head
		for (DLLNode iter = head; iter != null; iter = iter.next) {
			if (!isFirst) {
				s.append(",");
			} else {
				isFirst = false;
			}
			s.append(iter.data.toString());
		}
		return s.toString();
	}
}
