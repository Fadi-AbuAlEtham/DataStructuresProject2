package com.datastructuresproject2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BSTDistrict {
	private BSTDistrictNode root;
	private LinkedListStack memoryStack = new LinkedListStack();

	public BSTDistrict() {
		root = null;
	}

	/* Methods go here */

	public BSTDistrictNode getRoot() {
		return root;
	}

	public void setRoot(BSTDistrictNode root) {
		this.root = root;
	}

	public LinkedListStack getMemoryStack() {
		return memoryStack;
	}

	public void setMemoryStack(LinkedListStack memoryStack) {
		this.memoryStack = memoryStack;
	}

	// Check whether an element is in the tree
	public boolean contains(District district) {
		return contains(district, root);
	}

	// Find an element in the tree
	public BSTDistrictNode find(District district) {
		return find(district, root);
	}

	// Insert an element into the tree
	public boolean insert(District district, Label lbl) {
		root = insert(district, root, lbl);
		if (root != null) {
			lbl.setText("District: " + district.getName() + " has been inserted successfully!");
			return true;
		} else {
			lbl.setText("District: " + district.getName() + " has not been inserted!");
			return false;
		}
	}

	// Find the minimum element in the tree
	public BSTDistrictNode findMin() {
		return findMin(root);
	}

	// Find the maximum element in the tree
	public BSTDistrictNode findMax() {
		return findMax(root);
	}

	// Remove an element from the tree
	public void remove(String e, Label lbl) {
		root = remove(e, root, lbl);
	}

	// Check whether the district is in a tree or not
	private boolean contains(District district, BSTDistrictNode current) {
		if (current == null)
			return false; // Not found, empty tree.
		else if (district.getName().compareToIgnoreCase(((District) current.getElement()).getName()) < 0) // if smaller
																											// than
																											// root.
			return contains(district, current.getLeft()); // Search left subtree
		else if (district.getName().compareToIgnoreCase(((District) current.getElement()).getName()) < 0) // if larger
																											// than
																											// root.
			return contains(district, current.getRight()); // Search right subtree
		return true; // found .
	}

	// Returns the node contains the given district
	private BSTDistrictNode find(District district, BSTDistrictNode current) {
		if (current == null)
			return null;
		if (district.getName().compareToIgnoreCase(((District) current.getElement()).getName()) < 0)
			return find(district, current.getLeft());
		else if (district.getName().compareToIgnoreCase(((District) current.getElement()).getName()) > 0)
			return find(district, current.getRight());
		else
			return current;
	}

	// Insert district function
	private BSTDistrictNode insert(District district, BSTDistrictNode current, Label lbl) {
		if (current == null) {
			current = new BSTDistrictNode(district);
			// Initialize the head of the districtTree to reference the locationTree
			current.setHead(district.getLocationTree());
			lbl.setText("District: " + district.getName() + " has been inserted successfully!");
		} else {
			if (district.getName().compareToIgnoreCase(((District) current.getElement()).getName()) < 0)
				current.setLeft(insert(district, current.getLeft(), lbl));
			else
				current.setRight(insert(district, current.getRight(), lbl));
		}
		return current;
	}

	BSTDistrictNode findMin(BSTDistrictNode current) {
		if (current == null)
			return null;
		else if (current.getLeft() == null)
			return current;
		else
			return findMin(current.getLeft()); // keep going to the left
	}

	private BSTDistrictNode findMax(BSTDistrictNode current) {
		if (current == null)
			return null;
		else if (current.getRight() == null)
			return current;
		else
			return findMax(current.getRight()); // keep going to the right
	}

	private BSTDistrictNode remove(String e, BSTDistrictNode current, Label lbl) {
		if (current == null) {
			if (root == null) {
				lbl.setText("Error: the tree is empty");
			} else
				lbl.setText("Error: " + e + " has not been found");

			return null; // Item not found,Empty tree
		}
		if (e.compareToIgnoreCase(((District) current.getElement()).getName()) < 0)
			current.setLeft(remove(e, current.getLeft(), lbl));
		else if (e.compareToIgnoreCase(((District) current.getElement()).getName()) > 0)
			current.setRight(remove(e, current.getRight(), lbl));
		else // found element to be deleted
		if (current.getLeft() != null && current.getRight() != null)// two children
		{
			/* Replace with smallest in right subtree */
			current.setElement(findMin(current.getRight()).getElement());
			current.setRight(remove((((District) current.getElement()).getName()), current.getRight(), lbl));
			lbl.setText(e + " has been deleted successfully");
		} else {// one or zero child
			current = (current.getLeft() != null) ? current.getLeft() : current.getRight();
			lbl.setText(e + " has been deleted successfully");
		}

		return current;
	}

	// Method that renames the district
	public boolean renameDistrict(String oldName, String newName, Label lbl) {
		// Check if oldName or newName are empty
		if (oldName.isEmpty()) {
			lbl.setText("Enter the district name that you want to rename first!");
			return false;
		} else if (newName.isEmpty()) {
			lbl.setText("Enter the new district name for '" + oldName + "'.");
			return false;
		}

		// Find the old district node
		BSTDistrictNode oldDistrictNode = find(new District(oldName));
		// Create a reference to the old district node
		BSTDistrictNode newDistrictNode = oldDistrictNode;

		// Check if the new name already exists
		if (find(new District(newName)) != null) {
			lbl.setText("Error! Can't rename this district because the new name already exists!");
			return false;
		}

		// Check if the old district node exists
		if (oldDistrictNode != null) {
			// Remove the old district node from the list
			remove(oldName, lbl);
			// Set the name of the district to the new name
			((District) newDistrictNode.getElement()).setName(newName);
			// Insert the renamed district node sorted into the list
			insert(((District) newDistrictNode.getElement()), lbl);
			// Display success message
			lbl.setText(oldName + " district has been renamed to " + newName);
			return true;
		} else {
			lbl.setText(oldName + " district doesn't exist!");
			return false;
		}
	}

	// Method that renames the location
	public void renameLocation(String district, String oldName, String newName, Label lbl) {
		// Check if district, oldName, or newName are empty
		if (district.isEmpty()) {
			lbl.setText("Enter the district name first!");
			return;
		} else if (oldName.isEmpty()) {
			lbl.setText("Enter the location name that you want to rename first!");
			return;
		} else if (newName.isEmpty()) {
			lbl.setText("Enter the new location name for '" + oldName + "'.");
			return;
		}

		// Find the district node
		BSTDistrictNode districtNode = find(new District(district));

		// Check if the district node exists
		if (districtNode == null) {
			lbl.setText("Error! This district doesn't exist!");
			return;
		}

		// Get the location list of the district
		BSTLocation locationList = districtNode.getHead();

		// Check if the new name already exists in the location list
		if (locationList.find(new Location(newName)) != null) {
			lbl.setText("Error! Can't rename this location because the new name already exists!");
			return;
		}

		// Find the old location node
		BSTLocationNode oldLocationNode = locationList.find(new Location(oldName));
		// Create a reference to the old location node
		BSTLocationNode newLocationNode = oldLocationNode;

		// Check if the old location node exists
		if (oldLocationNode != null) {
			// Remove the old location node from the list
			locationList.remove(oldName, lbl);
			// Set the name of the location to the new name
			((Location) newLocationNode.getElement()).setName(newName);
			// Insert the renamed location node sorted into the list
			locationList.insert((Location) newLocationNode.getElement(), lbl);
			// Display success message
			lbl.setText(oldName + " has been updated successfully to " + newName + ".");
		} else {
			lbl.setText(oldName + " location doesn't exist!");
		}
	}

	// Method that deletes a location
	public void deleteLocation(String district, String location, Label lbl) {
		BSTDistrictNode disNode = find(new District(district));

		// Check if the district exist or not
		if (disNode == null) {
			lbl.setVisible(true);
			lbl.setText(district + " district doesn't exist!");
			return;
		}

		// Check the existence of the location
		BSTLocation locationList = disNode.getHead();
		BSTLocationNode locationNodeIndex = locationList.find(new Location(location));

		if (locationNodeIndex == null) {
			lbl.setVisible(true);
			lbl.setText(location + " location doesn't exist!");
			return;
		}

		// Notify the user whether the delete was successful or failed
		locationList.remove(((Location) locationNodeIndex.getElement()).getName(), lbl);

	}

	// Method to update a martyr's information
	public void updateMartyr(BSTDistrictNode districtNode, MartyrLinkedList martyrList, String oldMart, Martyr newMart,
			TextArea txtArea, Label lbl) {
		// Check if district, location, oldMart, or newMart are empty
		if (oldMart.isEmpty()) {
			lbl.setVisible(true);
			lbl.setText("Enter the martyr details that you want to update first!");
			return;
		} else if (newMart == null) {
			lbl.setVisible(true);
			lbl.setText("Enter the new martyr details for " + oldMart + ".");
			return;
		}

		// Check if the old martyr exists in the specified location
		int oldLocIndex = martyrList.findByName(oldMart);
		if (oldLocIndex == -1) {
			lbl.setVisible(true);
			lbl.setText("The old martyr does not exist in the specified location.");
			return;
		}

		Martyr mart = (Martyr) martyrList.get(oldLocIndex);

		if (!mart.getName().equals(newMart.getName()) || mart.getAge() != newMart.getAge()
				|| mart.getGender() != newMart.getGender()) {
			// Remove the old martyr from the specified location
			newMart.setDistrict(mart.getDistrict());
			newMart.setDate(mart.getDate());
			newMart.setLocation(mart.getLocation());
			martyrList.remove(oldLocIndex);
			MartyrNode martyrNode = new MartyrNode(newMart);
			// Get the reference to the martyrList of the location
			lbl.setVisible(true);
			martyrList.insertMartyrSorted(martyrNode, txtArea, lbl);
			lbl.setText("Martyr updated successfully.");
		} else
			lbl.setText("You didn't update any information!");

	}

	// Method that searches for martyrs by part of the name
	public void searchMartyrByName(String district, String location, String date, String name,
			TableView<Martyr> tableView, Label lbl) {
		if (!name.isEmpty()) {
			// Search for martyrs by part of the name within the specified location
			MartyrLinkedList martyrList = searchMartyrByName(name, lbl);
			martyrList.searchMartyr(name, tableView, lbl);
		}

//		if (!district.isEmpty() && !location.isEmpty() && !date.isEmpty() && !name.isEmpty()) {
//			// Find the specified district node
//			BSTDistrictNode districtNode = find(new District(district));
//			if (districtNode == null) {
//				// Handle the case when the district is not found
//				lbl.setVisible(true);
//				tableView.setVisible(false);
//				lbl.setText("This district doesn't exist!");
//				return;
//			}
//
//			// Get the location list of the specified district
//			BSTLocation locationTree = districtNode.getHead();
//
//			// Find the specified location node
//			BSTLocationNode locationNode = locationTree.find(new Location(location));
//			if (locationNode == null) {
//				// Handle the case when the location is not found
//				lbl.setVisible(true);
//				tableView.setVisible(false);
//				lbl.setText("This location doesn't exist in this district!");
//				return;
//			}
//
//			// Get the location list of the specified district
//			BSTMartyrDate dateTree = locationNode.getHead();
//
//			// Find the specified location node
//			BSTMartyrDateNode martDateNode = dateTree.find(new MartyrDate(date));
//			if (martDateNode == null) {
//				// Handle the case when the location is not found
//				lbl.setVisible(true);
//				tableView.setVisible(false);
//				lbl.setText("This date doesn't exist in this district and location!");
//				return;
//			}
//
//			// Get the martyr list of the specified location
//			MartyrLinkedList martyrList = martDateNode.getHead();
//
//			// Search for martyrs by part of the name within the specified location
//			martyrList.searchMartyr(name, tableView, lbl);
//		}
//		// If the user doesn't know the district but knows the location
//		else if (district.isEmpty() && !location.isEmpty() && !date.isEmpty() && !name.isEmpty()) {
//			// Find the specified location node across all districts
//			BSTLocationNode locationNode = findLocationAcrossAllDistricts(location, root);
//			if (locationNode == null) {
//				// Handle the case when the location is not found
//				lbl.setVisible(true);
//				tableView.setVisible(false);
//				lbl.setText("This location doesn't exist in any district!");
//				return;
//			}
//
//			// Get the martyr list of the specified location
//			BSTMartyrDate martyrDateTree = locationNode.getHead();
//
//			// Find the specified location node
//			BSTMartyrDateNode martDateNode = martyrDateTree.find(new MartyrDate(date));
//			if (martDateNode == null) {
//				// Handle the case when the location is not found
//				lbl.setVisible(true);
//				tableView.setVisible(false);
//				lbl.setText("This date doesn't exist in this location!");
//				return;
//			}
//
//			// Get the martyr list of the specified location
//			MartyrLinkedList martyrList = martDateNode.getHead();
//
//			// Search for martyrs by part of the name within the specified location
//			martyrList.searchMartyr(name, tableView, lbl);
//		}
		//
//		else if (district.isEmpty() && !location.isEmpty() && !date.isEmpty() && !name.isEmpty()) {
//			// Find the specified location node across all districts
//			BSTLocationNode locationNode = findLocationAcrossAllDistricts(location, root);
//			if (locationNode == null) {
//				// Handle the case when the location is not found
//				lbl.setVisible(true);
//				tableView.setVisible(false);
//				lbl.setText("This location doesn't exist in any district!");
//				return;
//			}
//
//			// Get the martyr list of the specified location
//			BSTMartyrDate martyrDateTree = locationNode.getHead();
//
//			// Find the specified location node
//			BSTMartyrDateNode martDateNode = martyrDateTree.find(new MartyrDate(date));
//			if (martDateNode == null) {
//				// Handle the case when the location is not found
//				lbl.setVisible(true);
//				tableView.setVisible(false);
//				lbl.setText("This date doesn't exist in this location!");
//				return;
//			}
//
//			// Get the martyr list of the specified location
//			MartyrLinkedList martyrList = martDateNode.getHead();
//
//			// Search for martyrs by part of the name within the specified location
//			martyrList.searchMartyr(name, tableView, lbl);
//		}
	}

	// Method to insert the locations for the chosen district to the ComboBox
	public void insertLocationsToComboBox(String district, ComboBox<String> comboBox, Label lbl) {
		BSTDistrictNode currentDistrict = find(new District(district));

		if (currentDistrict == null) {
			lbl.setVisible(true);
			lbl.setText("This district doesn't exist!");
			return;
		}

		// Clear the ComboBox before adding locations
		comboBox.getItems().clear();

		// Start with the root of the location tree of the current district
		BSTLocationNode currentLocation = currentDistrict.getHead().getRoot();
		LinkedListStack stack = new LinkedListStack();

		while (currentLocation != null || !stack.isEmpty()) {
			while (currentLocation != null) {
				stack.push(currentLocation);
				currentLocation = currentLocation.getLeft();
			}

			currentLocation = (BSTLocationNode) stack.pop();
			comboBox.getItems().add(((Location) currentLocation.getElement()).getName());

			currentLocation = currentLocation.getRight();
		}
	}

	public MartyrLinkedList searchMartyrByName(String partialName, Label lbl) {
		if (root == null) {
			lbl.setText("Error: The tree is empty");
			return null;
		}

		MartyrLinkedList resultList = new MartyrLinkedList();
		searchMartyrByNameHelper(root, partialName.toLowerCase(), resultList);

		if (resultList.isEmpty()) {
			lbl.setText("No matching names were found!");
		} else {
			lbl.setText("");
		}
		return resultList;
	}

	private void searchMartyrByNameHelper(BSTDistrictNode currentDistrict, String partialName,
			MartyrLinkedList resultList) {
		if (currentDistrict != null) {
			// Iterate over locations in the current district
			BSTLocation locationTree = currentDistrict.getHead();
			if (locationTree != null) {
				searchMartyrByNameInLocation(locationTree.getRoot(), partialName, resultList);
			}

			searchMartyrByNameHelper(currentDistrict.getLeft(), partialName, resultList);
			searchMartyrByNameHelper(currentDistrict.getRight(), partialName, resultList);
		}
	}

	private void searchMartyrByNameInLocation(BSTLocationNode currentLocation, String partialName,
			MartyrLinkedList resultList) {
		if (currentLocation != null) {
			// Iterate over martyr dates in the current location
			BSTMartyrDate datesTree = currentLocation.getHead();
			if (datesTree != null) {
				searchMartyrByNameInMartyrDates(datesTree.getRoot(), partialName, resultList);
			}

			searchMartyrByNameInLocation(currentLocation.getLeft(), partialName, resultList);
			searchMartyrByNameInLocation(currentLocation.getRight(), partialName, resultList);
		}
	}

	private void searchMartyrByNameInMartyrDates(BSTMartyrDateNode currentDate, String partialName,
			MartyrLinkedList resultList) {
		if (currentDate != null) {
			// Iterate over martyrs in the current date
			MartyrLinkedList martyrList = currentDate.getHead();
			if (martyrList != null && !martyrList.isEmpty()) {
				MartyrNode currentMartyr = martyrList.getFront();
				while (currentMartyr != null) {
					Martyr m = (Martyr) currentMartyr.getElement();
					if (m.getName().toLowerCase().contains(partialName)) {
						resultList.addSorted(m);
					}
					currentMartyr = currentMartyr.getNext();
				}
			}

			searchMartyrByNameInMartyrDates(currentDate.getLeft(), partialName, resultList);
			searchMartyrByNameInMartyrDates(currentDate.getRight(), partialName, resultList);
		}
	}

	// Method that write the martyrs info on the required textFileds
	public void returnMartyr(MartyrLinkedList martyrList, String name, TextField txtMartName, TextField txtMartDate,
			TextField txtMartAge, TextField txtMartLoc, TextField txtMartDis, RadioButton rbMale, RadioButton rbFemale,
			RadioButton rbUnknown) {
		// returns the target martyr by name
		Martyr mart = (Martyr) martyrList.get(martyrList.findByName(name));
		if (mart != null) {
			// Write the martyr's info on the target textFileds
			txtMartName.setText(mart.getName());

			// If the age of the martyr was -1 that means that it's empty
			if (mart.getAge() == -1)
				txtMartAge.setText("");
			else
				txtMartAge.setText(mart.getAge() + "");

			// set the radioButtons according to the gender
			if (mart.getGender() == 'M' || mart.getGender() == 'm') {
				rbMale.setSelected(true);
			} else if (mart.getGender() == 'F' || mart.getGender() == 'f') {
				rbFemale.setSelected(true);
			} else if (mart.getGender() == 'N' || mart.getGender() == 'n')
				rbUnknown.setSelected(true);
		}

	}

	public boolean searchMartyr(Martyr newMart, Label lbl) {
		if (root == null) {
			lbl.setText("Error: The tree is empty");
			return false;
		}

		return searchMartyrHelper(root, newMart, lbl);
	}

	private boolean searchMartyrHelper(BSTDistrictNode currentDistrict, Martyr newMart, Label lbl) {
		if (currentDistrict != null) {
			// Iterate over locations in the current district
			BSTLocation locationTree = currentDistrict.getHead();
			if (locationTree != null) {
				searchMartyrInLocation(locationTree.getRoot(), newMart, lbl);
			}
			return searchMartyrHelper(currentDistrict.getLeft(), newMart, lbl)
					|| searchMartyrHelper(currentDistrict.getRight(), newMart, lbl);
		}
		return false;
	}

	private boolean searchMartyrInLocation(BSTLocationNode currentLocation, Martyr newMart, Label lbl) {
		if (currentLocation != null) {
			// Iterate over martyr dates in the current location
			BSTMartyrDate datesTree = currentLocation.getHead();
			if (datesTree != null) {
				searchMartyrInMartyrDates(datesTree.getRoot(), newMart, lbl);
			}
			searchMartyrInLocation(currentLocation.getLeft(), newMart, lbl);
			searchMartyrInLocation(currentLocation.getRight(), newMart, lbl);
		}
		return false;
	}

	private boolean searchMartyrInMartyrDates(BSTMartyrDateNode currentDate, Martyr newMart, Label lbl) {
		if (currentDate != null) {
			// Iterate over martyrs in the current date
			MartyrLinkedList martyrList = currentDate.getHead();
			if (martyrList != null && !martyrList.isEmpty()) {
				MartyrNode currentMartyr = martyrList.getFront();
				while (currentMartyr != null) {
					Martyr m = (Martyr) currentMartyr.getElement();
					Martyr m1 = newMart;
					if (m.getName().equalsIgnoreCase(m1.getName()) && m.getGender() == (m1.getGender())
							&& m.getAge() == (m1.getAge())) {
						if (!m.getName().equals("Name unknown to B'Tselem")) {
							// If the martyr exists
							lbl.setText("This martyr exists in this or different location");
							return true;
						}
					}
					currentMartyr = currentMartyr.getNext();
				}
			}
			searchMartyrInMartyrDates(currentDate.getLeft(), newMart, lbl);
			searchMartyrInMartyrDates(currentDate.getRight(), newMart, lbl);
		}
		return false;
	}

	// Method to navigate through districts in an in-order traversal
	public void inOrderTraversal(BSTDistrictNode root) {
		if (root != null) {
			// Traverse left subtree
			inOrderTraversal(root.getLeft());

			// Push current district to the stack
			memoryStack.push(((District) root.getElement()).getName());

			// Traverse right subtree
			inOrderTraversal(root.getRight());
		}
	}

	// Method that returns the number of martyrs
	public int martyrCountInLocations(String district) {
		BSTDistrictNode disNode = find(new District(district));

		if (disNode == null) {
			System.out.println("Error district is null");
			return 0;
		}

		BSTLocation locationTree = disNode.getHead();

		return countMartyrsInLocations(locationTree.getRoot());
	}

	private int countMartyrsInLocations(BSTLocationNode locationNode) {
		int count = 0;
		if (locationNode != null) {
			BSTMartyrDate dateTree = locationNode.getHead();
			count += countMartyrsInDate(dateTree.getRoot());
			// Traverse left subtree
			count += countMartyrsInLocations(locationNode.getLeft());
			// Traverse right subtree
			count += countMartyrsInLocations(locationNode.getRight());
		}
		return count;
	}

	private int countMartyrsInDate(BSTMartyrDateNode dateNode) {
		int count = 0;
		if (dateNode != null) {
			MartyrLinkedList martyrList = dateNode.getHead();
			count += martyrList.getTotalMartyr();
			// Traverse left subtree
			count += countMartyrsInDate(dateNode.getLeft());
			// Traverse right subtree
			count += countMartyrsInDate(dateNode.getRight());
		}
		return count;
	}

	// Method that shows the location inside the district with the number of martyrs
	// for each location
	public void btLoadDisNavigation(BSTDistrictNode disNode, TextArea txtArea) {
		String locName;
		int totalMartyr = 0;

		if (disNode == null)
			return;

		BSTLocation locationTree = disNode.getHead();

		// sort the locations of the district in a stack
		locationTree.inOrderTraversal(locationTree.getRoot());

		// Get the sorted stack
		LinkedListStack stackLoc = locationTree.getStack();
		LinkedListStack reversedStackLoc = new LinkedListStack();

		// Reverse the current stack to have the correct order of locations
		while (!stackLoc.isEmpty()) {
			reversedStackLoc.push(stackLoc.pop());
		}

		txtArea.setText("");
		// Traverse the locations
		while (!reversedStackLoc.isEmpty()) {
			BSTLocationNode locNode = (BSTLocationNode) reversedStackLoc.pop();

			if (locNode == null)
				return;

			locName = ((Location) (locNode).getElement()).getName();

			BSTMartyrDate dateTree = locNode.getHead();

			// traverse the dates in the location
			dateTree.inOrderTraversal(dateTree.getRoot());

			LinkedListStack stackDate = dateTree.getMemoryStack();
			LinkedListStack reversedStackDate = new LinkedListStack();

			// Reverse the current stack to have the correct order of dates
			while (!stackDate.isEmpty()) {
				reversedStackDate.push(stackDate.pop());
			}

			// reset the counter
			totalMartyr = 0;

			// Traverse the dates
			while (!reversedStackDate.isEmpty()) {
				String date = (String) reversedStackDate.pop();

				BSTMartyrDateNode dateNode = dateTree.find(new MartyrDate(date));

				if (dateNode == null) {
					return;
				}

				MartyrLinkedList martyrList = dateNode.getHead();

				// increment the counter
				totalMartyr += martyrList.size();
			}
			txtArea.appendText("Location Name: " + locName + " ----> Total Martyrs: " + totalMartyr + "\n\n");
		}

	}

	// Method that shows the dates inside the location with the number of martyrs
	// for each date
	public void btLoadLocNavigation(BSTLocationNode locNode, TextArea txtArea) {
		String date = null;
		int totalMartyr = 0;

		txtArea.setText("");

		if (locNode == null)
			return;

		BSTMartyrDate dateTree = locNode.getHead();

		// sort all the dates in a stack
		dateTree.inOrderTraversal(dateTree.getRoot());

		// Get the sorted dates from the stack
		LinkedListStack stackDate = dateTree.getMemoryStack();
		LinkedListStack reversedStackDate = new LinkedListStack();

		// Reverse the current stack to have the correct order of dates
		while (!stackDate.isEmpty()) {
			reversedStackDate.push(stackDate.pop());
		}

		// traverse all the dates
		while (!reversedStackDate.isEmpty()) {
			totalMartyr = 0;
			date = (String) reversedStackDate.pop();

			BSTMartyrDateNode dateNode = dateTree.find(new MartyrDate(date));

			if (dateNode == null) {
				return;
			}

			MartyrLinkedList martyrList = dateNode.getHead();

			// Increment the counter
			totalMartyr += martyrList.size();

			txtArea.appendText("Date: " + date + " ----> Total Martyrs: " + totalMartyr + "\n\n");
		}

	}

	// Method to write martyrs to a file
	public boolean writeOnFile(String fileName) {
		try (PrintWriter writer = new PrintWriter(new File(fileName))) {
			writer.println("Name,Date,Age,location,District,Gender");
			// Traverse the district tree
			inOrderTraversal(root, writer);
			// File writing successful
			return true;
		} catch (IOException e) {
			// File writing failed
			System.out.println("Error writing to file: " + e.getMessage());
			return false;
		}
	}

	// Recursive method to traverse the district tree and write martyrs to the file
	private void inOrderTraversal(BSTDistrictNode node, PrintWriter writer) {
		if (node != null) {
			// Traverse left subtree
			inOrderTraversal(node.getLeft(), writer);

			// Traverse the locations in this district
			BSTLocation locationTree = node.getHead();
			inOrderTraversalLocations(locationTree.getRoot(), writer);

			// Traverse right subtree
			inOrderTraversal(node.getRight(), writer);
		}
	}

	// Recursive method to traverse the location tree and write martyrs to the file
	private void inOrderTraversalLocations(BSTLocationNode node, PrintWriter writer) {
		if (node != null) {
			// Traverse left subtree
			inOrderTraversalLocations(node.getLeft(), writer);

			// Traverse the martyr date tree for this location
			BSTMartyrDate martyrDateTree = node.getHead();
			inOrderTraversalMartyrs(martyrDateTree.getRoot(), writer);

			// Traverse right subtree
			inOrderTraversalLocations(node.getRight(), writer);
		}
	}

	// Recursive method to traverse the martyr date tree and write martyrs to the
	// file
	private void inOrderTraversalMartyrs(BSTMartyrDateNode node, PrintWriter writer) {
		if (node != null) {
			// Traverse left subtree
			inOrderTraversalMartyrs(node.getLeft(), writer);

			// Write the martyrs in this list
			MartyrNode martyrNode = node.getHead().getFront();

			// Traverse martyrs
			while (martyrNode != null) {
				Martyr martyr = (Martyr) martyrNode.getElement();
				writer.println(martyr.getName() + "," + martyr.getDate() + "," + martyr.getAge() + ","
						+ martyr.getLocation() + "," + martyr.getDistrict() + "," + martyr.getGender());
				martyrNode = martyrNode.getNext();
			}

			// Traverse right subtree
			inOrderTraversalMartyrs(node.getRight(), writer);
		}
	}

}