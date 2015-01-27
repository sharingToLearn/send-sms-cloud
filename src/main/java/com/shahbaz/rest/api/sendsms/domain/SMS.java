package com.shahbaz.rest.api.sendsms.domain;

/**
 * This is a domain class, a template of SMS as send by mobile client. Can be
 * used for persist too for later :)
 * 
 * @author Shahbaz.Khan
 *
 */
public class SMS {

	/**
	 * The client who sent the request
	 */
	public String client;

	/**
	 * Message to be sent
	 */
	public String message;

	/**
	 * Private constructor for instantiating
	 * 
	 * @param client
	 * @param message
	 */
	private SMS(String client, String message) {
		this.client = client;
		this.message = message;
	}

	/**
	 * Factory method to get SMS object
	 * 
	 * @param client
	 * @param message
	 * @return
	 */
	public static SMS setSMS(String client, String message) {
		return new SMS(client, message);
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
