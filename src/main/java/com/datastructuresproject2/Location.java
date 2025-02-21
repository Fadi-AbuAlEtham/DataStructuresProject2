package com.datastructuresproject2;

public class Location {
	// Attributes of Location
	private String name;
	private BSTMartyrDate martyrTree;

	// Default constructor
	public Location() {
		martyrTree = new BSTMartyrDate();
	}

	// Constructor with parameters
	public Location(String name) {
		this.name = name;
		martyrTree = new BSTMartyrDate();
	}

	// Constructor with parameters
	public Location(String name, BSTMartyrDate martyrTree) {
		this.name = name;
		this.martyrTree = martyrTree;
	}

	// Getter method for retrieving the name
	public String getName() {
		return name;
	}

	// Setter method for setting the name
	public void setName(String name) {
		this.name = name;
	}

	// Getter method for retrieving the martyrTree
	public BSTMartyrDate getMartyrTree() {
		return martyrTree;
	}

	// Setter method for setting the martyrTree
	public void setMartyrTree(BSTMartyrDate martyrTree) {
		this.martyrTree = martyrTree;
	}

	// Override toString method to provide a meaningful string representation of the
	// Location object
	@Override
	public String toString() {
//		return name;
		return "Location [name=" + name + ", martyrList=" + martyrTree + "]";
	}

}
