package com.onlinepharmacy.exception;

public class NullObjectException extends RuntimeException {
	
	private String resourceName;
	
	public NullObjectException(String resourceName) {
		super(resourceName+" object is null" ); //Product not found with Id = 107
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
	

}
