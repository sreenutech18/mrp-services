package com.citi.membership.enrollment.model;

import lombok.Data;

@Data
public class CustomerInfo {
	
	private String cardNum;
	private String cvv;
	private String expDate;
	private String nameOnCard;
	private String firstName;
	private String lastName;
	private String dob;
	private String emailId;
	private String mobNum;
	private String enrollDate;

}
