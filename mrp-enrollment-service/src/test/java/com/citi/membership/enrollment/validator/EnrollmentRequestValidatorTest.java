package com.citi.membership.enrollment.validator;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.citi.membership.enrollment.exception.EnrollmentReqValidationExcep;
import com.citi.membership.enrollment.model.ClientInfo;
import com.citi.membership.enrollment.model.CustomerInfo;
import com.citi.membership.enrollment.model.EnrollmentRequest;

public class EnrollmentRequestValidatorTest {

	EnrollmentRequestValidator validator = null;
	EnrollmentRequest enrollmentReq = null;

	@Before
	public void setUp() throws Exception {
		validator = new EnrollmentRequestValidator();
		enrollmentReq = buildEnrollmentReq();
	}

	@Test
	public void testValidate_RequestObj_Null_Scenario() {

		try {

			validator.validate(null);

		} catch (EnrollmentReqValidationExcep e) {

			assertEquals("ens001", e.getRespCode());
			assertEquals("Request Object is null", e.getRespMsg());

		}
	}

	@Test
	public void testValidate_ClientObj_Null_Scenario() {

		try {
			enrollmentReq.setClientInfo(null);
			validator.validate(enrollmentReq);

		} catch (EnrollmentReqValidationExcep e) {

			assertEquals("ens001", e.getRespCode());

		}
	}

	@Test
	public void testValidate_CustomerObj_Null_Scenario() {

		try {
			enrollmentReq.setCustomerInfo(null);
			validator.validate(enrollmentReq);

		} catch (EnrollmentReqValidationExcep e) {

			assertEquals("ens001", e.getRespCode());

		}
	}

	@Test
	public void testValidate_ClientId_Null_Scenario() {

		try {

			enrollmentReq.getClientInfo().setClientId(null);

			validator.validate(enrollmentReq);

		} catch (EnrollmentReqValidationExcep e) {

			assertEquals("ens002", e.getRespCode());

		}

	}

	@Test
	public void testValidate_ClientId_Empty_Scenario() {

		try {

			enrollmentReq.getClientInfo().setClientId(" ");

			validator.validate(enrollmentReq);

		} catch (EnrollmentReqValidationExcep e) {

			assertEquals("ens002", e.getRespCode());

		}

	}

	@Test
	public void testValidate_ChannelId_Null_Scenario() {

		try {

			enrollmentReq.getClientInfo().setChannelId(null);

			validator.validate(enrollmentReq);

		} catch (EnrollmentReqValidationExcep e) {

			assertEquals("ens003", e.getRespCode());

		}

	}

	@Test
	public void testValidate_ChannelId_Empty_Scenario() {

		try {

			enrollmentReq.getClientInfo().setChannelId(" ");

			validator.validate(enrollmentReq);

		} catch (EnrollmentReqValidationExcep e) {

			assertEquals("ens003", e.getRespCode());

		}

	}

	@Test
	public void testValidate_CardNum_Null_Scenario() {

		try {

			enrollmentReq.getCustomerInfo().setCardNum(null);

			validator.validate(enrollmentReq);

		} catch (EnrollmentReqValidationExcep e) {

			assertEquals("ens004", e.getRespCode());

		}

	}
	
	@Test
	public void testValidate_CardNum_Empty_Scenario() {

		try {

			enrollmentReq.getCustomerInfo().setCardNum(" ");

			validator.validate(enrollmentReq);

		} catch (EnrollmentReqValidationExcep e) {

			assertEquals("ens004", e.getRespCode());

		}

	}

	@After
	public void tearDown() throws Exception {

		validator = null;
		enrollmentReq = null;
	}

	private EnrollmentRequest buildEnrollmentReq() {

		EnrollmentRequest enrollmentRequest = new EnrollmentRequest();

		ClientInfo clientInfo = new ClientInfo();

		clientInfo.setClientId("web");
		clientInfo.setChannelId("online");
		clientInfo.setReqId("abc123xyz");
		clientInfo.setMsgTs("27-04-2021");

		CustomerInfo customerInfo = new CustomerInfo();

		customerInfo.setCardNum("121212121");
		customerInfo.setCvv("123");
		customerInfo.setDob("24-03-1984");
		customerInfo.setEmailId("sreenu.sreenutech@gmail.com");
		customerInfo.setEnrollDate("01-01-2000");
		customerInfo.setExpDate("12-2022");
		customerInfo.setFirstName("sreenu");
		customerInfo.setLastName("tech");
		customerInfo.setMobNum("9966945339");
		customerInfo.setNameOnCard("sreenu");

		enrollmentRequest.setClientInfo(clientInfo);

		enrollmentRequest.setCustomerInfo(customerInfo);

		return enrollmentRequest;
	}

}
