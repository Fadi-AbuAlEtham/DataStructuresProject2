package com.datastructuresproject2;

public class BSTDistrictNode {
	private Object element;
	private BSTDistrictNode left;
	private BSTDistrictNode right;
	private BSTLocation head;
	

	public BSTDistrictNode(Object element) {
		this(element, null, null, null);
	}

	public BSTDistrictNode(Object element, BSTDistrictNode left, BSTDistrictNode right, BSTLocation head) {
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

	public BSTDistrictNode getLeft() {
		return left;
	}

	public void setLeft(BSTDistrictNode left) {
		this.left = left;
	}

	public BSTDistrictNode getRight() {
		return right;
	}

	public void setRight(BSTDistrictNode right) {
		this.right = right;
	}

	public BSTLocation getHead() {
		return head;
	}

	public void setHead(BSTLocation head) {
		this.head = head;
	}

	@Override
	public String toString() {
		return "BSTDistrictNode [element=" + element + ", left=" + left + ", right=" + right + ", head=" + head + "]";
	}
	
}