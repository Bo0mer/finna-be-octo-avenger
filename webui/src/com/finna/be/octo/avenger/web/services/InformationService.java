package com.finna.be.octo.avenger.web.services;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

@Startup
@Singleton
public class InformationService {

	private final MessageManager messageManager = new MessageManager();
	
	@Schedule(minute = "*/3", hour = "*", persistent = false)
	public void sendUpdateInformation() {
		try {
			messageManager.createAndSendMessages();
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
