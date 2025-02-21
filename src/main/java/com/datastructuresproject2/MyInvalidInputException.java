package com.datastructuresproject2;

public class MyInvalidInputException extends Exception{
	private String myErrorMessage = "";

	public MyInvalidInputException() {
		myErrorMessage = "ERROR!!! recheck the arguments and try again!";
	}
	
	public MyInvalidInputException(String myErrorMessage) {
		
		this.myErrorMessage = myErrorMessage;
	}

	@Override
	public String getMessage() {
		return myErrorMessage;
	}
	
}
