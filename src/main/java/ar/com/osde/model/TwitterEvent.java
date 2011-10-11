package ar.com.osde.model;

import java.util.Date;
import java.util.List;

public final class TwitterEvent extends Event {

	private Date timestamp;
	private String message;
	private String senderUserName;
	private String userLocale;
	private List<String> userMentions;
	
	
	public TwitterEvent(Date timestamp, String message, String username,
			String userLocale, List<String> userMentions) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.senderUserName = username;
		this.userLocale = userLocale;
		this.userMentions = userMentions;		
	}


	public Date getTimestamp() {
		return timestamp;
	}


	public String getMessage() {
		return message;
	}


	public String getSenderUsername() {
		return senderUserName;
	}


	public String getUserLocale() {
		return userLocale;
	}


	public List<String> getUserMentions() {
		return userMentions;
	}


	public void setUserMentions(List<String> userMentions) {
		this.userMentions = userMentions;
	}

	

	

}
