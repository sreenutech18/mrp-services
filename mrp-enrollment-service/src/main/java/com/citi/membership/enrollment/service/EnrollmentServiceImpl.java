package com.citi.membership.enrollment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.citi.membership.enrollment.builder.EnrollmentServiceReqBuilder;
import com.citi.membership.enrollment.builder.EnrollmentServiceResBuilder;
import com.citi.membership.enrollment.dao.EnrollmentDao;
import com.citi.membership.enrollment.exception.BusinessException;
import com.citi.membership.enrollment.exception.SystemException;
import com.citi.membership.enrollment.model.CardDetails;
import com.citi.membership.enrollment.model.CardDetailsResp;
import com.citi.membership.enrollment.model.EnrollmentDaoReq;
import com.citi.membership.enrollment.model.EnrollmentDaoRes;
import com.citi.membership.enrollment.model.EnrollmentRequest;
import com.citi.membership.enrollment.model.EnrollmentResponse;
import com.citi.membership.enrollment.svcclient.CardsServiceClient;

@Component
public class EnrollmentServiceImpl implements EnrollmentService {
	
	@Autowired
	CardsServiceClient cardsServiceClient;
	
	@Autowired
	@Qualifier("enrollmentSpringDaoImpl")
	EnrollmentDao enrollmentDao;
	
	@Autowired
	EnrollmentServiceReqBuilder enrollmentServiceReqBuilder;
	
	@Autowired
	EnrollmentServiceResBuilder enrollmentServiceResBuilder;
	

	public EnrollmentResponse createEnroll(EnrollmentRequest enrollmentReq) throws BusinessException, SystemException {

		// 1. Get the enrollment Request from controller

		// 2. prepare the request for serivce client

		// 3. call the service client
		CardDetailsResp cardDetailsResp = cardsServiceClient.getCardDetails(enrollmentReq.getCustomerInfo().getCardNum());

		if (cardDetailsResp != null) {

			List<CardDetails> cardDetailsList = cardDetailsResp.getCardDetails();

			for (CardDetails cardDetails : cardDetailsList) {

				String card13digit = cardDetails.getCardNum().substring(13, 15);

				if (!"pa".equals(cardDetails.getProductType()) || !"active".equals(cardDetails.getStatus())
						|| !cardDetails.isPrimary()) {

					// Todo : handle user defined exception - You are not eligble for this
					// enrollments

				}

			}

		}

		// 2. Prepare the request for dao with the help of controller request

		
		EnrollmentDaoReq enrollmentDaoReq = enrollmentServiceReqBuilder.buildDAORequest(enrollmentReq);
		
		// 3. call dao and get the dao response

		EnrollmentDaoRes enrollmentDaoRes = enrollmentDao.createEnroll(enrollmentDaoReq);

		// 4. prepare the service response with the help of dao
		
		EnrollmentResponse enrollmentResponse = enrollmentServiceResBuilder.buildEnrollResp(enrollmentDaoRes); 

		
		 return enrollmentResponse;
	}

}
