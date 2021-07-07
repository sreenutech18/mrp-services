package com.citi.membership.email.svcclient;

import org.springframework.stereotype.Component;

@Component
public class EmailNotificationServiceClientImpl implements EmailNotificationServiceClient {

	@Override
	public String sendEmail(String fromEmail, String toEamil, String body) {
		
		//invoke th email service
		//TODO : if any email service fails then ignore those errors.
		//but we should track how many notifications got failed
		
		
		return null;
	}
	
	

}
