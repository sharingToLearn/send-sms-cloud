package com.shahbaz.rest.api.sendsms.clients;

import com.shahbaz.rest.api.sendsms.api.AbstractSendSms;
import com.shahbaz.rest.api.sendsms.domain.SMS;
import com.shahbaz.rest.api.sendsms.utils.ApplicationProperties;

/**
 *  Uses SMS-LAN SMS api .So just loading the profile and calling the abstract
 * @author Shahbaz.Khan
 *
 */
public class ZamZamSms extends AbstractSendSms {

	@Override
	public String sendSms(SMS sms) {
		loadProfile();
		String response = super.sendSms(sms);
		return response;
	}

	@Override
	public void loadProfile() {
		smsApiUsername = ApplicationProperties.getProperty("zamzam.username");
		smsApiPassword = ApplicationProperties.getProperty("zamzam.password");
		receiverMobileNumber = ApplicationProperties
				.getProperty("zamzam.reciver.number");
	}

}
