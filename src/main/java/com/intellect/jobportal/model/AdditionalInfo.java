package com.intellect.jobportal.model;

import java.util.List;

public class AdditionalInfo {

		private String summary;
		private List<Organization> organizations;
		private String hobbies;
		private String areasOfInterst;
		private String currentPackage;
		private String previousPackage;
		private List<String> techExpertise;
		public String getSummary() {
			return summary;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
		public String getHobbies() {
			return hobbies;
		}
		public void setHobbies(String hobbies) {
			this.hobbies = hobbies;
		}
		public String getAreasOfInterst() {
			return areasOfInterst;
		}
		public void setAreasOfInterst(String areasOfInterst) {
			this.areasOfInterst = areasOfInterst;
		}
		public String getCurrentPackage() {
			return currentPackage;
		}
		public void setCurrentPackage(String currentPackage) {
			this.currentPackage = currentPackage;
		}
		public String getPreviousPackage() {
			return previousPackage;
		}
		public void setPreviousPackage(String previousPackage) {
			this.previousPackage = previousPackage;
		}
		public List<Organization> getOrganizations() {
			return organizations;
		}
		public void setOrganizations(List<Organization> organizations) {
			this.organizations = organizations;
		}
		public List<String> getTechExpertise() {
			return techExpertise;
		}
		public void setTechExpertise(List<String> techExpertise) {
			this.techExpertise = techExpertise;
		}
		
}
