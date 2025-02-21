package com.datastructuresproject2;

public class District {
	// Attributes of District
	private String name;
	private BSTLocation locationTree;

	// Default constructor
	public District() {
		locationTree = new BSTLocation();
	}

	// Constructor with parameters
	public District(String name) {
		this.name = name;
		locationTree = new BSTLocation();
	}

	// Constructor with parameters
	public District(String name, BSTLocation locationTree) {
		this.name = name;
		this.locationTree = locationTree;
	}

	// Getter method for retrieving the name
	public String getName() {
		return name;
	}

	// Setter method for setting the name
	public void setName(String name) {
		this.name = name;
	}

	// Getter method for retrieving the locationTree
	public BSTLocation getLocationTree() {
		return locationTree;
	}

	// Setter method for setting the locationTree
	public void setLocationTree(BSTLocation locationTree) {
		this.locationTree = locationTree;
	}

	// Override toString method to provide a meaningful string representation of the
	// District object
	@Override
	public String toString() {
		return "District [name=" + name + ", locationTree=" + locationTree + "]";
	}
}
