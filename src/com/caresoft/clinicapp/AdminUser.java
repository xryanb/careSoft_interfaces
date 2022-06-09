package com.caresoft.clinicapp;
import java.util.Date;
import java.util.ArrayList;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	
		private Integer employeeID;
	    private String role;
	    private ArrayList<String> securityIncidents;
	    
	    public AdminUser() {}
	    
	    public AdminUser(int id, String role) {
	    	super(id);
	    	this.role=role;
	    	this.securityIncidents= new ArrayList<String>();
	    }
	    
	    
	    public Integer getEmployeeID() {
			return employeeID;
		}

		public void setEmployeeID(Integer employeeID) {
			this.employeeID = employeeID;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public ArrayList<String> getSecurityIncidents() {
			return securityIncidents;
		}

		public void setSecurityIncidents(ArrayList<String> securityIncidents) {
			this.securityIncidents = securityIncidents;
		}

	@Override
	public boolean assignPin(int pin) {
		int length=String.valueOf(pin).length();
		if(length == 6) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(this.getId() == confirmedAuthID) {
			return true;
		}else {
			this.authIncident();
			return false;
			
		}
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		return this.getSecurityIncidents();
		
	}
	 public void newIncident(String notes) {
	        String report = String.format(
	            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
	            new Date(), this.id, notes
	        );
	        securityIncidents.add(report);
	    }
	    public void authIncident() {
	        String report = String.format(
	            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
	            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
	        );
	        securityIncidents.add(report);
	    }
}
