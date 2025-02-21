package com.datastructuresproject2;

public class LocationNode {
	// Attributes of Martyr
	private Object element;
	private LocationNode next;
	private MartyrLinkedList head;

	// Constructor with parameters
	public LocationNode(Object element) {
		this(element, null, null);
	}

	// Constructor with parameters
	public LocationNode(Object element, LocationNode next, MartyrLinkedList head) {
		this.element = element;
		this.next = next;
		this.head = head;
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
	public LocationNode getNext() {
		return next;
	}

	// Setter method for setting the next
	public void setNext(LocationNode next) {
		this.next = next;
	}

	// Getter method for retrieving the head
	public MartyrLinkedList getHead() {
		return head;
	}

	// Setter method for setting the head
	public void setHead(MartyrLinkedList head) {
		this.head = head;
	}

	// Override toString method to provide a meaningful string representation of the
	// LocationNode object
	@Override
	public String toString() {
		return "SingleNode [element=" + element + ", next=" + next + ", head=" + head + "]";
	}
}
