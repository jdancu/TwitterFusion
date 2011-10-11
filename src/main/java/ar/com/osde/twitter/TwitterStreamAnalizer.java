package ar.com.osde.twitter;

import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterStreamAnalizer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("DrDJ37k4KtiVH0jkgd3YWQ")
				.setOAuthConsumerSecret(
						"1DtNYFMMPOZoLsMYfbreeF00wQ3dbXuKNTfSmYl8")
				.setOAuthAccessToken(
						"81178597-FrOSsWdWnEUZAwJS9vQNDe2r9N1JiD4WMcVqWZHhz")
				.setOAuthAccessTokenSecret(
						"38TAhMn7Mad4clsJOHN0PIsXYoSB3UVgvYeuzV8");
		// .setHttpProxyHost("10.100.0.47")
		// .setHttpProxyPassword("internet").setHttpProxyPort(3128)
		// .setHttpProxyUser("MT26548596");

		
		TwitterStreamFactory tf = new TwitterStreamFactory(cb.build());
		TwitterStream twitterStream = tf.getInstance();

		twitterStream.addListener(new CepListener());
		// sample() method internally creates a thread which manipulates
		// TwitterStream and calls these adequate listener methods continuously.
		twitterStream.sample();
	}

}
