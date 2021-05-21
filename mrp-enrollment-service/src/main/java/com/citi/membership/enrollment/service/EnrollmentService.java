package com.citi.membership.enrollment.service;

import com.citi.membership.enrollment.exception.BusinessException;
import com.citi.membership.enrollment.exception.SystemException;
import com.citi.membership.enrollment.model.EnrollmentRequest;
import com.citi.membership.enrollment.model.EnrollmentResponse;

public interface EnrollmentService {
	
	
	public EnrollmentResponse   createEnroll(EnrollmentRequest enrollmentReq) throws BusinessException, SystemException;

}
