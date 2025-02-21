package com.datastructuresproject2;

import javafx.scene.control.Label;

public class BSTMartyrDate {
	private BSTMartyrDateNode root;
	private LinkedListStack memoryStack = new LinkedListStack();
	private LinkedListStack memoryStack2 = new LinkedListStack();

	public BSTMartyrDate() {
		root = null;
	}

	/* Methods go here */

	public BSTMartyrDateNode getRoot() {
		return root;
	}

	public void setRoot(BSTMartyrDateNode root) {
		this.root = root;
	}

	public LinkedListStack getMemoryStack() {
		return memoryStack;
	}

	public void setMemoryStack(LinkedListStack memoryStack) {
		this.memoryStack = memoryStack;
	}

	public LinkedListStack getMemoryStack2() {
		return memoryStack2;
	}

	public void setMemoryStack2(LinkedListStack memoryStack2) {
		this.memoryStack2 = memoryStack2;
	}

	// Check whether an element is in the tree
	public boolean contains(MartyrDate e) {
		return contains(e, root);
	}

	// Find an element in the tree
	public BSTMartyrDateNode find(MartyrDate element) {
		return find(element, root);
	}

	// Insert an element into the tree
	public boolean insert(MartyrDate element, Label lbl) {
		root = insert(element, root);
		if (root != null) {
			lbl.setText("Date: " + element + " has been inserted successfully!");
			return true;
		} else {
			lbl.setText("Date: " + element + " has not been inserted!");
			return false;
		}
	}

	// Find the minimum element in the tree
	public BSTMartyrDateNode findMin() {
		return findMin(root);
	}

	// Find the maximum element in the tree
	public BSTMartyrDateNode findMax() {
		return findMax(root);
	}

	// Remove an element from the tree
	public void remove(MartyrDate e) {
		root = remove(e, root);
	}

	// Check whether the element is in a tree or not
	private boolean contains(MartyrDate e, BSTMartyrDateNode current) {
		if (current == null)
			return false; // Not found, empty tree.
		else if (e.compareTo(((MartyrDate) current.getElement())) < 0) // if smaller than
																		// root.
			return contains(e, current.getLeft()); // Search left subtree
		else if (e.getDate().compareTo(((MartyrDate) current.getElement()).getDate()) < 0) // if larger than
																							// root.
			return contains(e, current.getRight()); // Search right subtree
		return true; // found .
	}

	// Returns the node contains the given element
	private BSTMartyrDateNode find(MartyrDate element, BSTMartyrDateNode current) {
		if (current == null)
			return null;
		if (element.compareTo(((MartyrDate) current.getElement())) < 0)
			return find(element, current.getLeft());
		else if (element.compareTo(((MartyrDate) current.getElement())) > 0)
			return find(element, current.getRight());
		else
			return current;
	}

	// Insert element function
	private BSTMartyrDateNode insert(MartyrDate element, BSTMartyrDateNode current) {
		if (current == null) {
			current = new BSTMartyrDateNode(element); // create one node tree
			// Initialize the head of the martyrDateTree to reference the martyrList
			current.setHead(element.getMartyrList());
		} else {
			if (element.compareTo(((MartyrDate) current.getElement())) < 0)
				current.setLeft(insert(element, current.getLeft()));
			else
				current.setRight(insert(element, current.getRight()));
		}
		return current;

	}

	private BSTMartyrDateNode findMin(BSTMartyrDateNode current) {
		if (current == null)
			return null;
		else if (current.getLeft() == null)
			return current;
		else
			return findMin(current.getLeft()); // keep going to the left
	}

	private BSTMartyrDateNode findMax(BSTMartyrDateNode current) {
		if (current == null)
			return null;
		else if (current.getRight() == null)
			return current;
		else
			return findMax(current.getRight()); // keep going to the right
	}

	private BSTMartyrDateNode remove(MartyrDate e, BSTMartyrDateNode current) {
		if (current == null)
			return null; // Item not found,Empty tree
		if (e.compareTo(((MartyrDate) current.getElement())) < 0)
			current.setLeft(remove(e, current.getLeft()));
		else if (e.compareTo(((MartyrDate) current.getElement())) > 0)
			current.setRight(remove(e, current.getRight()));
		else // found element to be deleted
		if (current.getLeft() != null && current.getRight() != null)// two children
		{
			/* Replace with smallest in right subtree */
			current.setElement(findMin(current.getRight()).getElement());
			current.setRight(remove((((MartyrDate) current.getElement())), current.getRight()));
		} else// one or zero child
			current = (current.getLeft() != null) ? current.getLeft() : current.getRight();
		return current;
	}

	// Method to navigate through districts in an in-order traversal
	public void inOrderTraversal(BSTMartyrDateNode root) {
		if (root != null) {
			inOrderTraversal(root.getLeft()); // Traverse left subtree

			// Process the current district
			memoryStack.push(((MartyrDate) root.getElement()).getDate()); // Push current district to the stack

			inOrderTraversal(root.getRight()); // Traverse right subtree
		}
	}

	// Method to navigate through districts in an in-order traversal
	public void inOrderTraversal2(BSTMartyrDateNode root) {
		if (root != null) {
			inOrderTraversal2(root.getLeft()); // Traverse left subtree

			// Push current node to the stack
			memoryStack2.push(root);

			inOrderTraversal2(root.getRight()); // Traverse right subtree
		}
	}
}