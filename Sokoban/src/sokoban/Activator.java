package sokoban;

import java.util.Dictionary;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	private ServiceRegistration registration;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Registering Sokoban Game Service...");
		Properties props = new Properties();
		props.put("Language", "English");
		registration = context.registerService(SokobanGame.class.getName(), new SokobanGame(),
				(Dictionary) props);
		System.out.println("[+] Sokoban Game Service has been registred.");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		registration.unregister();
		System.out.println("[-] Sokoban Game Service has been removed.");
		System.out.println("[*] Sokoban Game has stopped.");
	}
}