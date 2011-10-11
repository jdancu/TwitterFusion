package ar.com.osde.twitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.osde.cep.CepEngine;
import ar.com.osde.model.TwitterEvent;

import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.UserMentionEntity;

public class CepListener implements StatusListener {

	public void onException(Exception arg0) {
		// TODO Auto-generated method stub

	}

	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO Auto-generated method stub

	}

	public void onScrubGeo(long arg0, long arg1) {
		// TODO Auto-generated method stub

	}

	public void onStatus(Status status) {

		String username = status.getUser().getScreenName();
		String userLocale = status.getUser().getLocation();
		String message = status.getText();
		Date timestamp = status.getCreatedAt();
		UserMentionEntity[] userMentions = status.getUserMentionEntities();

		List<String> userMentionList = new ArrayList<String>();

		for (int i = 0; i < userMentions.length; i++) {
			UserMentionEntity e = userMentions[i];
			userMentionList.add(e.getScreenName());
		}

		TwitterEvent event = new TwitterEvent(
				timestamp, message, username, userLocale, userMentionList);

		// System.out.println(message + "---------" );

		CepEngine.getInstance().addEvent(event);

	}

	public void onTrackLimitationNotice(int arg0) {
		// TODO Auto-generated method stub

	}

}
