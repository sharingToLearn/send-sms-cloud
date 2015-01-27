package com.shahbaz.rest.api.sendsms.clients;

import com.shahbaz.rest.api.sendsms.api.AbstractSendSms;
import com.shahbaz.rest.api.sendsms.domain.SMS;
import com.shahbaz.rest.api.sendsms.utils.ApplicationProperties;

/**
 * Arsalan Resturant: Has separate SMS-API of its own so need the write custom implementation. 
 * @author Shahbaz.Khan
 *
 */
public class ArsalanSms extends AbstractSendSms {

	public static int ipipiPin = Integer.parseInt(ApplicationProperties
			.getProperty("arsalan.ipipiPin"));

	@Override
	public String sendSms(SMS sms) {
		loadProfile();
		System.out
				.println("****************** ARSALAN *************************");
		System.out.println(" SMS PROVIDER : IPIPI.COM");
		System.out.println("USERNAME : " + smsApiUsername);
		System.out.println("PHONE NUMBER : " + receiverMobileNumber);
		System.out.println("IPIPI-PIN : " + ipipiPin);
		return null;
	}

	@Override
	public void loadProfile() {
		smsApiUsername = ApplicationProperties.getProperty("arsalan.username");
		smsApiPassword = ApplicationProperties.getProperty("arsalan.password");
		receiverMobileNumber = ApplicationProperties
				.getProperty("arsalan.reciver.number");
	}
}
