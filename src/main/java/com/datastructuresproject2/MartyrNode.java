package com.datastructuresproject2;

public class MartyrNode {
	// Attributes of Martyr
	private Object element;
	private MartyrNode next;

	// Constructor with parameters
	public MartyrNode(Object element) {
		this(element, null);
	}

	// Constructor with parameters
	public MartyrNode(Object element, MartyrNode next) {
		this.element = element;
		this.next = next;
	}

	// Getter method for retrieving the element
	public Object getElement() {
		return element;
	}

	// Setter method for setting the element
	public void setElement(Object element) {
		this.element = element;
	}

	// Getter method for retrieving the next
	public MartyrNode getNext() {
		return next;
	}

	// Setter method for setting the next
	public void setNext(MartyrNode next) {
		this.next = next;
	}

	// Override toString method to provide a meaningful string representation of the
	// MartyrNode object
	@Override
	public String toString() {
		return "SingleNode [element=" + element + ", next=" + next + "]";
	}
}
