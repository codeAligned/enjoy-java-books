package endtoend.auctionsniper;

import auctionsniper.Main;
import auctionsniper.ui.MainWindow;

public class ApplicationRunner {

	public static final String SNIPER_ID = "sniper";
	public static final String SNIPER_PASSWORD = "sniper";
	public static final String XMPP_HOSTNAME = "csj4032-file.ipdisk.co.kr";
	private AuctionLogDriver logDriver = new AuctionLogDriver();
  	private AuctionSniperDriver driver;

	public void startBiddingIn(final FakeAuctionServer auction) throws InterruptedException {
		startSniper(auction);
	}

	public void showsSniperHasLostAuction() {
		driver.showsSniperStatus(MainWindow.STATUS_LOST);
	}

	public void stop() {
		if (driver != null) {
			driver.dispose();
		}
	}

	private void startSniper(FakeAuctionServer auction) {
		logDriver.clearLog();
		Thread thread = new Thread("Test Application") {
			@Override
			public void run() {
				try {
					Main.main(XMPP_HOSTNAME, SNIPER_ID, SNIPER_PASSWORD, auction.getItemId());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		thread.setDaemon(true);
		thread.start();
		driver = new AuctionSniperDriver(1000);
		driver.showsSniperStatus(MainWindow.STATUS_JOINING);
	}
}
