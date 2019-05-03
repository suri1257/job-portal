package com.intellect.jobportal.enums;

public enum OperationType {

	TEMPLATE_ALL("platform.template.retrive.all"),
	TEMPLATE_ID("platform.template.retrive.templateid"),
	TEMPLATE("platform.template.retrive.template"),
	REPORT_GENERATE("platform.report.generate.service"),
	DMS_DOWNLOAD("platform.document.download.service");
	
	
	private String type;
	
	private OperationType( String type ) {
		this.type = type;
	}
	
	public String gettype( ) {
		return this.type ;
	}
}
