package com.shahbaz.rest.api.sendsms.api;

import com.shahbaz.rest.api.sendsms.domain.SMS;

/**
 * 
 * @author Shahbaz.Khan Interface to Send SMS
 */
public interface SendSmsService {

	public void loadProfile();

	public String sendSms(SMS sms);
}
