package LinkedList;

import java.util.NoSuchElementException;

/* Name: Frank Omullo
 * Netid:foo6
 * What I thought about this assignment:Initially appeared really easy, but once you get down to testing,
										 		it proved more challenging than anticipated.

 *
 *
 */

/** An instance is a doubly linked list. */
public class DList<E> {

	/**
	 * Replace "-1" by the time you spent on A3 in hours.<br>
	 * Example: for 3 hours 15 minutes, use 3.25<br>
	 * Example: for 4 hours 30 minutes, use 4.50<br>
	 * Example: for 5 hours, use 5 or 5.0
	 */
	public static double timeSpent = 12;

	/** First node of linked list (null if size is 0) */
	private Node first;
	/** Last node of linked list (null if size is 0) */
	private Node last;
	/** Number of nodes in the linked list */
	private int size;

	/** Constructor: an empty linked list. */
	public DList() {
	}

	/**
	 * = the number of values in this list. <br>
	 * This function takes constant time.
	 */
	public int size() {
		return size;
	}

	/**
	 * First value in the list. <br>
	 * Throw a NoSuchElementException if list is empty.
	 */
	public E first() {
		if (size == 0)
			throw new NoSuchElementException();
		return first.val;
	}

	/**
	 * = the last value of the list. <br>
	 * Throw a NoSuchElementException if list is empty.
	 */
	public E last() {
		if (size == 0)
			throw new NoSuchElementException();
		return last.val;
	}

	/** = the first node of the list (null if the list is empty). */
	public Node firstNode() {
		return first;
	}

	/** = the last node of the list (null if the list is empty). */
	public Node lastNode() {
		return last;
	}

	/**
	 * = the value of node n of this list. This function takes constant time.<br>
	 * Precondition: n is a node of this list; it may not be null.
	 */
	public E value(Node n) {
		assert n != null;
		return n.val;
	}

	/**
	 * Return a representation of this list: its values, with adjacent ones <br>
	 * separated by ", ", "[" at the beginning, and "]" at the end. <br>
	 * Note: Exactly one blank separates a ',' from the next value.<br>
	 * Takes time proportional to the length of this list.<br>
	 * E.g. for the list containing 4 7 8 in that order, the result is "[4, 7, 8]".
	 * <br>
	 * E.g. for the list containing two empty strings, the result is "[, ]"
	 */
	@Override
	public String toString() {
		String res = "[";
		Node n = first;
		// invariant: res contains "[" followed by the String repr of values of nodes
		// before node n (all of them if n = null),
		// with ", " after each (except for the last value)
		while (n != null) {
			res = res + n.val;
			n = n.next;
			if (n != null)
				res = res + ", ";
		}

		return res + "]";
	}

	/**
	 * Return a representation of this list: its values in reverse, with adjacent
	 * <br>
	 * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
	 * Note: Exactly one blank separates a ',' from the next value.<br>
	 * Takes time proportional to the length of this list. <br>
	 * E.g. for the list containing 4 7 8 in that order, the result is "[8, 7, 4]".
	 * <br>
	 * E.g. for the list containing two empty strings, the result is "[, ]".
	 */
	public String toStringR() { // Note:
		// TODO 1. Look at toString to see how that was written.
		// Use the same scheme. Extreme case to watch out for:
		// E is String and values are the empty string.
		// You can't test this fully until ToDo 2, prepend, is written.
		String res = "[";
		Node n = last;
		// invariant: res contains "[" followed by the String repr of values of nodes
		// before node n (all of them if n = null),
		// with ", " after each (except for the last value)
		while (n != null) {
			res = res + n.val;
			n = n.prev;
			if (n != null)
				res = res + ", ";
		}

		return res + "]";
	}

	/**
	 * Add value v to the front of the list. <br>
	 * This operation takes constant time.
	 */
	public void prepend(E v) {
		// TODO 2. After writing this method, test this method and
		// method toStringR thoroughly before starting on the next
		// method. These two methods must be correct in order to be
		// able to write and test all the others.
		if (size == 0) {
			size = size + 1;
			DList<E>.Node f = new Node(null, v, null);
			first = f;
			last = first;

		} else {
			Node next = first;
			DList<E>.Node f = new Node(null, v, next);
			next.prev = f;
			first = f;
			size = size + 1;

		}
	}

	/**
	 * add value v to the end of the list. <br>
	 * This operation takes constant time.
	 */
	public void append(E v) {
		// TODO 3. This is the third method to write and test
		prepend(v);
		if (size > 1) {
			Node f = first;
			first = first.next;
			first.prev = null;
			f.prev = last;
			f.next = null;
			last = f;
			f.prev.next = f;
		}
	}

	/**
	 * Return node number h: If h is 0, return first node;<br>
	 * if h = 1, return second node, etc.<br>
	 * Precondition: 0 <= h < size of the list.
	 */
	public Node getNode(int h) {
		// TODO 4. This method should take time proportional to min(h, size-h).
		// For example, if h <= size/2, search from the beginning of the
		// list, otherwise search from the end of the list.

		assert 0 <= h && h < size;
		if (h >= 0 && h < size) {
			if (h <= size / 2) {
				Node target = first;
				for (int n = 0; n < h; n++)
					target = target.next();
				return target;

			}
			Node target = last;
			for (int n = size; n > h + 1;) {
				target = target.prev;
				return target;
			}

		}

		return null;
	}

	/**
	 * Remove node n from this list. <br>
	 * This operation must take constant time.<br>
	 * Precondition: n must be a node of this list; it may not be null.
	 */
	public void delete(Node n) {
		// TODO 5. Make sure this method takes constant time.
		assert n != null;
		if (size == 1) {
			first = null;
			last = null;
			size = size - 1;
		} else {
			if (n.equals(first) || n.equals(last)) {
				if (n.equals(first)) {

					n.next.prev = null;
					first = n.next;
					size = size - 1;
				}

				if (n.equals(last)) {
					n.prev.next = null;
					last = n.prev;
					size = size - 1;
				}
			} else {
				n.next.prev = n.prev;
				n.prev.next = n.next;
				size = size - 1;
			}
		}

	}

	/**
	 * Insert value v in a new node before node n.<br>
	 * This operation takes constant time.<br>
	 * Precondition: n must be a node of this list; it may not be null.
	 */
	public void insertBefore(E v, Node n) {
		// TODO 6. Make sure this method takes constant time.
		prepend(v);
		if (!n.equals(first.next)) {
			Node u = first;
			delete(u);
			size = size + 1;
			n.prev.next = u;
			u.prev = n.prev;
			n.prev = u;
			u.next = n;
		}

	}

	/*********************/

	/** An instance is a node of this list. */
	public class Node {
		private Node prev; // Previous node on list (null if this is first node)
		private E val; // The value of this element
		private Node next; // Next node on list. (null if this is last node)

		/**
		 * Constructor: an instance with previous node p (can be null), <br>
		 * value v, and next node n (can be null).
		 */
		Node(Node p, E v, Node n) {
			prev = p;
			val = v;
			next = n;
		}

		/**
		 * Return the node previous to this one (null if this is the first node of the
		 * list).
		 */
		public Node prev() {
			return prev;
		}

		/** Return the value of this node. */
		public E value() {
			return val;
		}

		/**
		 * Return the next node in this list (null if this is the last node of this
		 * list).
		 */
		public Node next() {
			return next;
		}
	}

}
