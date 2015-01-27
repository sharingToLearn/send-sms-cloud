package com.shahbaz.rest.api.sendsms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shahbaz.rest.api.sendsms.domain.SMS;
import com.shahbaz.rest.api.sendsms.utils.Client;

/**
 * This class mimics a rest layer which will be exposed to all the clients
 * 
 * @author Shahbaz.Khan
 *
 */

@RestController
public class RestLayer {

	@RequestMapping(value = "/sms/client/{client}/msg/{msg}",
			method = RequestMethod.GET)
	public ResponseEntity<String> sendSMSRest(@PathVariable String client, @PathVariable String msg) {

		String response =  sendSms(client, msg);
		if(response.contains("FAILED")){
			return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	public String sendSms(String client, String message) {

		/*
		 * Following the good old principle "Everything is an object" Though not
		 * required but it good to make the client SMS request in an object as
		 * the object going further can be converted to a JPA Entity and
		 * persisted by adding the required annotations
		 */
		SMS sms = SMS.setSMS(client, message);

		/*
		 * Client is an enum contains the list of Clients. Just trying to avoid
		 * messy if-else/switch statements.
		 */
		return Client.ListOfClients.valueOf(sms.getClient()).requestToSendSms(
				sms);

		// return false;

	}
}
