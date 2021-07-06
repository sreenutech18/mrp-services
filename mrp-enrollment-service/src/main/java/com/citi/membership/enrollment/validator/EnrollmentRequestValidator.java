package com.citi.membership.enrollment.validator;

import org.springframework.stereotype.Component;

import com.citi.membership.enrollment.exception.EnrollmentReqValidationExcep;
import com.citi.membership.enrollment.model.ClientInfo;
import com.citi.membership.enrollment.model.CustomerInfo;
import com.citi.membership.enrollment.model.EnrollmentRequest;
import com.citi.membership.enrollment.util.EnrollmentConstant;

@Component
public class EnrollmentRequestValidator {

	public void validate(final EnrollmentRequest enrollmentReq) throws EnrollmentReqValidationExcep {
		
		// TODO : Validate the request. If any one of the element is invalid then send exception
		// Need to handle user defined exception.
		
		if( enrollmentReq == null || enrollmentReq.getClientInfo() == null || enrollmentReq.getCustomerInfo() == null ) {
			
			throw new EnrollmentReqValidationExcep(EnrollmentConstant.ENS001, EnrollmentConstant.ENS001_DESC);
		}
		
		final ClientInfo clientInfo  = enrollmentReq.getClientInfo();
		
		//client id null or empty scenarios
		
		if( clientInfo.getClientId() == null || " ".equals(clientInfo.getClientId())) {
			
			throw new EnrollmentReqValidationExcep("ens002", "Invalid Client Id");
		}
		
		//channel id null or empty scenarios
		
		if( clientInfo.getChannelId() == null || " ".equals(clientInfo.getChannelId())) {
			
			throw new EnrollmentReqValidationExcep("ens003", "Invalid Client Id");
		}
		
	
		final CustomerInfo customerInfo = enrollmentReq.getCustomerInfo();
	
		//cardnumber is null or empty scenarios
		if( customerInfo.getCardNum() == null || " ".equals(customerInfo.getCardNum())) {
			throw new EnrollmentReqValidationExcep("ens004", "Invalid Card number ");
		}
		
		if( customerInfo.getCvv == null || " ".equals(customerInfo.getCvv)) {
			throw new EnrollmentReqValidationExcep("ens004", "Invalid Cvv number ");
		}
		
		
	}

}
