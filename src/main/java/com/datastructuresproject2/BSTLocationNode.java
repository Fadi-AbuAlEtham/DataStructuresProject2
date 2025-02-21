package com.datastructuresproject2;

public class BSTLocationNode {
	private Object element;
	private BSTLocationNode left;
	private BSTLocationNode right;
	private BSTMartyrDate head;
	

	public BSTLocationNode(Object element) {
		this(element, null, null, null);
	}

	public BSTLocationNode(Object element, BSTLocationNode left, BSTLocationNode right, BSTMartyrDate head) {
		this.element = element;
		this.left = left;
		this.right = right;
		this.head = head;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public BSTLocationNode getLeft() {
		return left;
	}

	public void setLeft(BSTLocationNode left) {
		this.left = left;
	}

	public BSTLocationNode getRight() {
		return right;
	}

	public void setRight(BSTLocationNode right) {
		this.right = right;
	}

	public BSTMartyrDate getHead() {
		return head;
	}

	public void setHead(BSTMartyrDate head) {
		this.head = head;
	}

	@Override
	public String toString() {
		return "BSTDistrictNode [element=" + element + ", left=" + left + ", right=" + right + ", head=" + head + "]";
	}
}
