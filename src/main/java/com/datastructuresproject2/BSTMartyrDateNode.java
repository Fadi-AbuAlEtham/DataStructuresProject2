package com.datastructuresproject2;

public class BSTMartyrDateNode {
	private Object element;
	private BSTMartyrDateNode left;
	private BSTMartyrDateNode right;
	private MartyrLinkedList head;
	

	public BSTMartyrDateNode(Object element) {
		this(element, null, null, null);
	}

	public BSTMartyrDateNode(Object element, BSTMartyrDateNode left, BSTMartyrDateNode right, MartyrLinkedList head) {
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

	public BSTMartyrDateNode getLeft() {
		return left;
	}

	public void setLeft(BSTMartyrDateNode left) {
		this.left = left;
	}

	public BSTMartyrDateNode getRight() {
		return right;
	}

	public void setRight(BSTMartyrDateNode right) {
		this.right = right;
	}

	public MartyrLinkedList getHead() {
		return head;
	}

	public void setHead(MartyrLinkedList head) {
		this.head = head;
	}

	@Override
	public String toString() {
		return "BSTMartyrDateNode [element=" + element + ", left=" + left + ", right=" + right + ", head=" + head + "]";
	}
}
