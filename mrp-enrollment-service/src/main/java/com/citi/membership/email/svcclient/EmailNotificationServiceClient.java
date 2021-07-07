package com.citi.membership.email.svcclient;

public interface EmailNotificationServiceClient {
	
	String sendEmail(String fromEmail, String toEamil, String body);
		
		
	

}
