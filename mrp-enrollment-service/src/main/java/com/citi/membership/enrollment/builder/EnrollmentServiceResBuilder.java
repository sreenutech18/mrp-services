package com.citi.membership.enrollment.builder;

import org.springframework.stereotype.Component;

import com.citi.membership.enrollment.model.EnrollmentDaoRes;
import com.citi.membership.enrollment.model.EnrollmentResponse;
import com.citi.membership.enrollment.model.StatusBlock;

@Component
public class EnrollmentServiceResBuilder {

	public EnrollmentResponse buildEnrollResp(EnrollmentDaoRes enrollmentDaoRes) {
		
		EnrollmentResponse enrollResp = new EnrollmentResponse();

		StatusBlock statusBlock = new StatusBlock();
		statusBlock.setRespCode(enrollmentDaoRes.getRespCode());
		statusBlock.setRespMsg(enrollmentDaoRes.getRespMsg());
		enrollResp.setStatusBlock(statusBlock);

		enrollResp.setStatusBlock(statusBlock);

		enrollResp.setEnrollStatus(enrollmentDaoRes.getEnrollStatus());
		enrollResp.setAcknNum(enrollmentDaoRes.getAcknNum());
		
		return enrollResp;
	}

}
