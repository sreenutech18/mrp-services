package com.citi.membership.enrollment.svcclient;

import com.citi.membership.enrollment.model.CardDetailsResp;

public interface CardsServiceClient {
	
	
	CardDetailsResp getCardDetails(String cardNum);
	
        boolean getCardStatus(String cardnum);
	
	

}
