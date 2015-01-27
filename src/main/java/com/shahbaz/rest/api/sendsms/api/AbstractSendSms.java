package com.shahbaz.rest.api.sendsms.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.shahbaz.rest.api.sendsms.domain.SMS;
import com.shahbaz.rest.api.sendsms.utils.ApplicationProperties;

/**
 * Provides default implementations of SMS interface
 * 
 * @author Shahbaz.Khan
 *
 */
public abstract class AbstractSendSms implements SendSmsService {

	public String smsApiUsername = ApplicationProperties
			.getProperty("username");

	public String smsApiPassword = ApplicationProperties
			.getProperty("password");

	public String receiverMobileNumber = ApplicationProperties
			.getProperty("reciver.number");

	public String sid = ApplicationProperties.getProperty("sid");

	public String fl = ApplicationProperties.getProperty("fl");

	public String sendSms(SMS sms) {

		System.out.println("****************** " + sms.getClient()
				+ " *************************");
		System.out.println(" SMS PROVIDER : SMS-LAN");
		System.out.println("USERNAME : " + smsApiUsername);
		System.out.println("PHONE NUMBER : " + receiverMobileNumber);

		String retval = "";
		String rsp = "";

		try {
			// Construct The Post Data
			String data = URLEncoder.encode("user", "UTF-8") + "="
					+ URLEncoder.encode(smsApiUsername, "UTF-8");
			data += "&" + URLEncoder.encode("password", "UTF-8") + "="
					+ URLEncoder.encode(smsApiPassword, "UTF-8");
			data += "&" + URLEncoder.encode("msisdn", "UTF-8") + "="
					+ URLEncoder.encode(receiverMobileNumber, "UTF-8");
			data += "&" + URLEncoder.encode("msg", "UTF-8") + "="
					+ URLEncoder.encode(sms.getMessage(), "UTF-8");
			data += "&" + URLEncoder.encode("sid", "UTF-8") + "="
					+ URLEncoder.encode(sid, "UTF-8");
			data += "&" + URLEncoder.encode("fl", "UTF-8") + "="
					+ URLEncoder.encode(fl, "UTF-8");

			// Push the HTTP Request
			URL url = new URL("http://smslane.com/vendorsms/pushsms.aspx");
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);

			OutputStreamWriter wr = new OutputStreamWriter(
					conn.getOutputStream());
			wr.write(data);
			wr.flush();

			// Read The Response
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				// Process line...
				retval += line;
			}
			wr.close();
			rd.close();

			System.out.println(retval);
			rsp = retval;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rsp;
	}

	public void loadProfile() {

	}

}
