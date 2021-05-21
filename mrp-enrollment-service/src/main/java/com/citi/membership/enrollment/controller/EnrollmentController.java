package com.citi.membership.enrollment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.citi.membership.enrollment.exception.BusinessException;
import com.citi.membership.enrollment.exception.EnrollmentReqValidationExcep;
import com.citi.membership.enrollment.exception.SystemException;
import com.citi.membership.enrollment.model.EnrollmentRequest;
import com.citi.membership.enrollment.model.EnrollmentResponse;
import com.citi.membership.enrollment.service.EnrollmentService;
import com.citi.membership.enrollment.validator.EnrollmentRequestValidator;

@RestController
@RequestMapping(value="/customer")
public class EnrollmentController {
	
	@Autowired
	EnrollmentRequestValidator validator;
	
	@Autowired
	EnrollmentService enrollmentService;
	
	@RequestMapping(value="/enrollment", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	@ResponseBody
	public EnrollmentResponse createEnroll(@RequestBody EnrollmentRequest enrollmentReq) throws EnrollmentReqValidationExcep, BusinessException, SystemException {
		
		//1. Get the request from consumers/clients
		//2. Validate the request
		validator.validate(enrollmentReq);
		
		//3. Prepare the request for service
		
		//4. call service and get the response
		final EnrollmentResponse enrollementResp = enrollmentService.createEnroll(enrollmentReq);
		
		//5. Prepare the controller resp
		
		return enrollementResp;
	}
	
	@RequestMapping(value="/healh" , method=RequestMethod.GET)
	
	public String healthCheck() {
		
		return "Service UP and Running";
	}
	
	

}
