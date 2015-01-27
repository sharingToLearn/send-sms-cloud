package com.shahbaz.rest.api.sendsms.clients;

import com.shahbaz.rest.api.sendsms.api.AbstractSendSms;
import com.shahbaz.rest.api.sendsms.domain.SMS;
import com.shahbaz.rest.api.sendsms.utils.ApplicationProperties;

/*
 * This is a Dummy Client for testing purpose
 */

public class DummySms extends AbstractSendSms{
	
	@Override
	public String sendSms(SMS sms) {
		loadProfile();
		String response = super.sendSms(sms);
		return response;
	}

	@Override
	public void loadProfile() {
		smsApiUsername = ApplicationProperties.getProperty("dummy.username");
		smsApiPassword = ApplicationProperties.getProperty("dummy.password");
		receiverMobileNumber = ApplicationProperties
				.getProperty("dummy.reciver.number");
	}
	

}
