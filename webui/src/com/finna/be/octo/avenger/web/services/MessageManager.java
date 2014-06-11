package com.finna.be.octo.avenger.web.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.finna.be.octo.avenger.core.db.dao.IUserDAO;
import com.finna.be.octo.avenger.core.db.dao.impl.UserDAO;
import com.finna.be.octo.avenger.core.db.model.DBUser;

public class MessageManager {
	
	private static final String MESSAGE_SUBJECT = "Task tracked information service update";
	
	private final IUserDAO userDAO = new UserDAO();
	
	public void createAndSendMessages() throws AddressException, MessagingException {
		final List<MimeMessage> messages = createMessages(getUsers());
		for (final MimeMessage message : messages) {
			Transport.send(message);
		}
	}

	private List<MimeMessage> createMessages(Collection<DBUser> users) throws AddressException, MessagingException {
		final Session session = getSession();
		final List<MimeMessage> messages = new ArrayList<MimeMessage>();
		for (final DBUser user : users) {
			messages.add(createMessage(user, session));
		}
		return messages;
	}

	private Session getSession() {
		final Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", "localhost");
		final Session session = Session.getDefaultInstance(properties);
		return session;
	}

	private MimeMessage createMessage(DBUser user, Session session) throws AddressException, MessagingException {
		final MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("infoservice@tasktracker"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
		message.setSubject(MESSAGE_SUBJECT);
		message.setText(generateMessageTextForUser(user));
		return message;
	}

	private String generateMessageTextForUser(DBUser user) {
		return "Hello, world!";
	}

	private Collection<DBUser> getUsers() {
		return userDAO.getUsers();
	}

	
}
