package com.shahbaz.rest.api.sendsms.utils;

import com.shahbaz.rest.api.sendsms.clients.ArsalanSms;
import com.shahbaz.rest.api.sendsms.clients.DummySms;
import com.shahbaz.rest.api.sendsms.clients.SirajSms;
import com.shahbaz.rest.api.sendsms.clients.VeryPoorResturant;
import com.shahbaz.rest.api.sendsms.clients.ZamZamSms;
import com.shahbaz.rest.api.sendsms.domain.SMS;

public class Client {

	public enum ListOfClients {
		ZAMZAM {

			@Override
			public String requestToSendSms(SMS sms) {
				return new ZamZamSms().sendSms(sms);
			}

		},
		ARSALAN {

			@Override
			public String requestToSendSms(SMS sms) {
				return new ArsalanSms().sendSms(sms);
			}

		},
		SIRAJ {

			@Override
			public String requestToSendSms(SMS sms) {
				return new SirajSms().sendSms(sms);
			}

		},VERYPOOR {

			@Override
			public String requestToSendSms(SMS sms) {
				return new VeryPoorResturant().sendSms(sms);
			}

		}, DUMMY {
			
			@Override
			public String requestToSendSms(SMS sms) {
				return new DummySms().sendSms(sms);
			}
		}
		;

		public abstract String requestToSendSms(SMS sms);
	}
}
