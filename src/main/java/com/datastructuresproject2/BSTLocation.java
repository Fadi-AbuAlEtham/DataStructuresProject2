package com.datastructuresproject2;

import javafx.scene.control.Label;

public class BSTLocation {
	private BSTLocationNode root;
	private LinkedListStack stack = new LinkedListStack();

	public BSTLocation() {
		root = null;
	}

	/* Methods go here */

	public BSTLocationNode getRoot() {
		return root;
	}

	public void setRoot(BSTLocationNode root) {
		this.root = root;
	}

	public LinkedListStack getStack() {
		return stack;
	}

	public void setStack(LinkedListStack stack) {
		this.stack = stack;
	}

	// Check whether an element is in the tree
	public boolean contains(Location e) {
		return contains(e, root);
	}

	// Find an element in the tree
	public BSTLocationNode find(Location element) {
		return find(element, root);
	}

	// Insert an element into the tree
	public boolean insert(Location element, Label lbl) {
		root = insert(element, root);
		if (root != null) {
			lbl.setText("Location: " + element.getName() + " has been inserted successfully!");
			return true;
		} else {
			lbl.setText("Location: " + element.getName() + " has not been inserted!");
			return false;
		}
	}

	// Find the minimum element in the tree
	public BSTLocationNode findMin() {
		return findMin(root);
	}

	// Find the maximum element in the tree
	public BSTLocationNode findMax() {
		return findMax(root);
	}

	// Remove an element from the tree
	public void remove(String e, Label lbl) {
		root = remove(e, root, lbl);
	}

	// Check whether the element is in a tree or not
	private boolean contains(Location e, BSTLocationNode current) {
		if (current == null)
			return false; // Not found, empty tree.
		else if (e.getName().compareToIgnoreCase(((Location) current.getElement()).getName()) < 0) // if smaller than
																									// root.
			return contains(e, current.getLeft()); // Search left subtree
		else if (e.getName().compareToIgnoreCase(((Location) current.getElement()).getName()) < 0) // if larger than
																									// root.
			return contains(e, current.getRight()); // Search right subtree
		return true; // found .
	}

	// Returns the node contains the given element
	private BSTLocationNode find(Location element, BSTLocationNode current) {
		if (current == null)
			return null;
		if (element.getName().compareToIgnoreCase(((Location) current.getElement()).getName()) < 0)
			return find(element, current.getLeft());
		else if (element.getName().compareToIgnoreCase(((Location) current.getElement()).getName()) > 0)
			return find(element, current.getRight());
		else
			return current;
	}

	// Insert element function
	private BSTLocationNode insert(Location element, BSTLocationNode current) {
		if (current == null) {
			current = new BSTLocationNode(element); // create one node tree
			// Initialize the head of the locationTree to reference the martyrDateTree
			current.setHead(element.getMartyrTree());
		} else {
			if (element.getName().compareToIgnoreCase(((Location) current.getElement()).getName()) < 0)
				current.setLeft(insert(element, current.getLeft()));
			else
				current.setRight(insert(element, current.getRight()));
		}
		return current;

	}

	private BSTLocationNode findMin(BSTLocationNode current) {
		if (current == null)
			return null;
		else if (current.getLeft() == null)
			return current;
		else
			return findMin(current.getLeft()); // keep going to the left
	}

	private BSTLocationNode findMax(BSTLocationNode current) {
		if (current == null)
			return null;
		else if (current.getRight() == null)
			return current;
		else
			return findMax(current.getRight()); // keep going to the right
	}

	private BSTLocationNode remove(String e, BSTLocationNode current, Label lbl) {
		if (current == null) {
			if (root == null) {
				lbl.setVisible(true);
				lbl.setText("Error: the tree is empty");
			} else {
				lbl.setVisible(true);
				lbl.setText("Error: " + e + " has not been found");
			}
			return null; // Item not found,Empty tree
		}
		if (e.compareToIgnoreCase(((Location) current.getElement()).getName()) < 0)
			current.setLeft(remove(e, current.getLeft(), lbl));
		else if (e.compareToIgnoreCase(((Location) current.getElement()).getName()) > 0)
			current.setRight(remove(e, current.getRight(), lbl));
		else // found element to be deleted
		if (current.getLeft() != null && current.getRight() != null)// two children
		{
			/* Replace with smallest in right subtree */
			current.setElement(findMin(current.getRight()).getElement());
			current.setRight(remove((((Location) current.getElement()).getName()), current.getRight(), lbl));
			lbl.setVisible(true);
			lbl.setText(e + " has been deleted successfully");
		} else {// one or zero child
			current = (current.getLeft() != null) ? current.getLeft() : current.getRight();
			lbl.setVisible(true);
			lbl.setText(e + " has been deleted successfully");
		}
		return current;
	}

	// Method to traverse the location tree in order and push locations into a stack
	public void inOrderTraversal(BSTLocationNode root) {
		if (root != null) {
			inOrderTraversal(root.getLeft()); // Traverse left subtree
			stack.push(root); // Push current location to the stack
			inOrderTraversal(root.getRight()); // Traverse right subtree
		}
	}

	// Method that finds the next location of a district using level-by-level
	// traversal
	public BSTLocationNode getNextLocationInDistrict(BSTLocationNode root, BSTLocationNode currentLocation) {
		// Check if the root or currentLocation is null
		if (root == null || currentLocation == null)
			return null;

		// Initialize a queue for level-by-level traversal
		LinkedListQueue queue = new LinkedListQueue();
		queue.enQueue(root);

		boolean found = false;
		while (!queue.isEmpty()) {
			BSTLocationNode node = (BSTLocationNode) queue.deQueue();

			// Check if the current node is the next location
			if (found)
				return node;

			// Mark found as true if currentLocation is found in the tree
			if (node == currentLocation)
				found = true;

			// Enqueue the left and right children if they exist
			if (node.getLeft() != null)
				queue.enQueue(node.getLeft());
			if (node.getRight() != null)
				queue.enQueue(node.getRight());
		}

		// Return null if the next location is not found
		return null;
	}

	// Method that finds the previous location of a district using level-by-level
	// traversal
	public BSTLocationNode getPrevLocationInDistrict(BSTLocationNode root, BSTLocationNode currentLocation) {
		// Check if the root or currentLocation is null
		if (root == null || currentLocation == null)
			return null;

		// Initialize a queue for level-by-level traversal
		LinkedListQueue queue = new LinkedListQueue();
		queue.enQueue(root);

		BSTLocationNode prev = null;
		while (!queue.isEmpty()) {
			int size = queue.size();

			// Traverse each level of the tree
			for (int i = 0; i < size; i++) {
				BSTLocationNode node = (BSTLocationNode) queue.deQueue();

				// Check if the current node is the previous location
				if (node == currentLocation) {
					// Return the previous location if it exists
					if (prev != null)
						return prev;
					else
						return null; // The currentLocation is the first node, no previous node
				}

				// Enqueue the left and right children if they exist
				if (node.getLeft() != null)
					queue.enQueue(node.getLeft());
				if (node.getRight() != null)
					queue.enQueue(node.getRight());

				// Update prev to the current node
				prev = node;
			}
		}

		// Return null if the previous location is not found
		return null;
	}

	// Method that returns the date with the maximum number of martyrs
	public String findDateWithMaxMartyrs(BSTLocationNode locationNode) {
		String maxDate = null;
		int maxCount = 0;

		if (locationNode != null) {
			BSTMartyrDateNode root = locationNode.getHead().getRoot();

			LinkedListStack dateStack = new LinkedListStack();
			BSTMartyrDateNode current = root;

			// Perform in-order traversal using a stack
			while (current != null || !dateStack.isEmpty()) {
				while (current != null) {
					dateStack.push(current);
					current = current.getLeft();
				}

				current = (BSTMartyrDateNode) dateStack.pop();
				String date = ((MartyrDate) current.getElement()).getDate();

				// Get the reference to the martyr linked list
				MartyrLinkedList martyrList = current.getHead();
				int count = 0;

				count = martyrList.size();

				if (count > maxCount) {
					maxCount = count;
					maxDate = date;
				}

				current = current.getRight();
			}
		}

		return maxDate;
	}

	// Method that finds the latest date which is the minimum date in the root
	public String findEarliestDateWithMartyrs(BSTLocationNode root) {
		if (root == null) {
			return null;
		}

		BSTMartyrDate dateTree = root.getHead();

		String earliestDate = ((MartyrDate) dateTree.findMin().getElement()).getDate();

		return earliestDate;
	}

	// Method that finds the latest date which is the maximum date in the root
	public String findLatestDateWithMartyrs(BSTLocationNode root) {
		if (root == null) {
			return null;
		}

		BSTMartyrDate dateTree = root.getHead();

		String LatestDate = ((MartyrDate) dateTree.findMax().getElement()).getDate();

		return LatestDate;
	}
}