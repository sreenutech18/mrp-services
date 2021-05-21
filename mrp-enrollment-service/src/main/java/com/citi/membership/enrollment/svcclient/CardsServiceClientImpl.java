package com.citi.membership.enrollment.svcclient;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.citi.membership.enrollment.model.CardDetailsResp;

@Component
public class CardsServiceClientImpl implements CardsServiceClient {

	@Value("${service-url}")
	private String serviceUrl;
	
	@Value("${service-timeout}")
    private String serviceTimeout;
	
	@Autowired
	RestTemplate restTemplate; 
	
	@Override
	public CardDetailsResp getCardDetails(String cardNum) {
		
		
		CardDetailsResp svcResp = null;
		try {
			
			
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", "application/json");
			headers.set("clientId", "mrp");
			headers.set("requestId", UUID.randomUUID().toString().substring(0, 16));
			headers.set("msgTs", "24-05-2021");
									
			HttpEntity entity = new HttpEntity(headers);
			
			System.out.println("serviceUrl is :"+serviceUrl);
			
			System.out.println("restTemplate is :"+restTemplate);

			ResponseEntity<CardDetailsResp> response = restTemplate.exchange(serviceUrl, HttpMethod.GET, entity, CardDetailsResp.class);
			
			// Entity = Http Response codes + response body 
			
			System.out.println(" service response is :"+response);
				
			svcResp = response.getBody();
			
			
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return svcResp;
	}
	
	
	
}
