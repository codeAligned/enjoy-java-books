package test.auctionsniper.xmpp;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.packet.Message;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class AuctionMessageTranslatorTest {

	private static final String SNIPER_ID = "genius";
	private static final Chat UNUSERD_CHAT = null;

	private final Mockery context = new Mockery();

	@Test
	public void notifiesAuctionClosedWhenCloseMessageReceived() {
		context.checking(new Expectations() {
		});

		Message message = new Message();
		message.setBody("SOLVersion: 1.1; Event: CLOSE;");
	}

	private Message message(String body) {
		Message message = new Message();
		message.setBody(body);
		return message;
	}
}
