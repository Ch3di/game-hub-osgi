package gamecenterserver;

import java.util.Dictionary;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceRegistration;

import gameCenter.GameCenterServerInterface;

public class GameCenter implements BundleActivator, ServiceListener, GameCenterServerInterface {

	private static BundleContext leContext;
	private ServiceRegistration registration;
	
	static BundleContext getContext() {
		return leContext;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("\n[*] Registering Game Center Service...");
		context.addServiceListener(this);
		Properties props = new Properties();
		props.put("Language", "English");
		registration = context.registerService(this.getClass().getName(), new GameCenter(),
				(Dictionary) props);
		System.out.println("[+] Game Center Service has been registered.");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		registration.unregister();
		System.out.println("\n[-] Game Center Service has stopped.");
		System.out.println("[-] Game Center Service has been removed.");
	}


	@Override
	public void serviceChanged(ServiceEvent event) {
		String[] objectClass = (String[]) event.getServiceReference().getProperty("objectClass");
		String src = event.getServiceReference().getBundle().getSymbolicName();
		if (((src.toUpperCase()).equals("Snake".toUpperCase()))
				|| ((src.toUpperCase()).equals("Sokoban".toUpperCase())) || ((src.toUpperCase()).equals("Tetris".toUpperCase()))) {
			System.out.print("Event>> Source Bundle  : " + src + ", has been detected from Game Center Service: ");
			if (event.getType() == ServiceEvent.REGISTERED) {
				System.out.println(" [*] Type of the service is " + objectClass[0] + "registered.");
			} else if (event.getType() == ServiceEvent.UNREGISTERING) {
				System.out.println(" [*] Type of the service is " + objectClass[0] + "removed.");
			} else if (event.getType() == ServiceEvent.MODIFIED) {
				System.out.println(" [*] Type of the service is " + objectClass[0] + " modified.");
			}
		}
	}

	@Override
	public void runServer() {
		GameCenterMenu.main(null);
		
	}

}
