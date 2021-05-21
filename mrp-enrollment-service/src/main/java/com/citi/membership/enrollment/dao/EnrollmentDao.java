package com.citi.membership.enrollment.dao;

import com.citi.membership.enrollment.exception.BusinessException;
import com.citi.membership.enrollment.exception.SystemException;
import com.citi.membership.enrollment.model.EnrollmentDaoReq;
import com.citi.membership.enrollment.model.EnrollmentDaoRes;

public interface EnrollmentDao {
	
	public EnrollmentDaoRes createEnroll(EnrollmentDaoReq daoReq) throws BusinessException, SystemException;

}
