package gamecenterguest;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import gameCenter.GameCenterServerInterface;
import gamecenterserver.GameCenter;

public class Activator implements BundleActivator {
	private ServiceTracker gameCenterTracker;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("\n[*] Launching Game Center Guest...");
		gameCenterTracker = new ServiceTracker(context, GameCenter.class.getName(), null);
		gameCenterTracker.open();
		GameCenterServerInterface gameCenter = (GameCenterServerInterface) gameCenterTracker.getService();

		if (gameCenter == null) {
			System.out.println("[-] Couldn't find Game Center Server.");
			System.out.println("[-] Couldn't call the server");
		} else {
			gameCenter.runServer();
			System.out.println("[+] Server is running...");
			System.out.println("[*] Welcome to the best Game Center ever!");
		}

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("[*] Game Center Guest has stopped.");
	}
}
