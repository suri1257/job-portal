package com.intellect.jobportal.enums;

public enum DocumentType {

	ID("id"),PATH("path"), DOCUMENTID("documentId");
	
	
	private String type;
	
	private DocumentType( String type ) {
		this.type = type;
	}
	
	public String gettype( ) {
		return this.type ;
	}
}
