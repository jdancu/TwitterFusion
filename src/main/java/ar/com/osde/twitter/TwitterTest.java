package ar.com.osde.twitter;

import java.io.IOException;
import java.util.Date;

import twitter4j.TwitterException;

import ar.com.osde.cep.CepEngine;
import ar.com.osde.model.TwitterEvent;

public class TwitterTest {

	/**
	 * @param args
	 */
	/*
	 * public static void main(String[] args) {
	 * 
	 * 
	 * 
	 * TwitterFactory tf = new TwitterFactory(cb.build()); Twitter twitter =
	 * tf.getInstance();
	 * 
	 * TwitterListener listener = new TwitterAdapter() {
	 * 
	 * @Override public void updatedStatus(Status status) {
	 * System.out.println("Successfully updated the status to [" +
	 * status.getText() + "]."); }
	 * 
	 * @Override public void onException(TwitterException e, int method) { if
	 * (method == TwitterMethods.UPDATE_STATUS) { e.printStackTrace(); } else {
	 * throw new AssertionError("Should not happen"); } } } // The factory
	 * instance is re-useable and thread safe. AsyncTwitterFactory factory = new
	 * AsyncTwitterFactory(listener); AsyncTwitter asyncTwitter =
	 * factory.getInstance(); asyncTwitter.updateStatus(args[0]); }
	 */

	public static void main(String[] args) throws TwitterException, IOException {

		Date timestamp = new Date();
		//TwitterEvent event = new TwitterEvent(timestamp,
		//		"Shakira es una genia", "jdancu", "Argentina");
		CepEngine engine = CepEngine.getInstance();
		//engine.addEvent(event);
		engine.stop();

	}

}
