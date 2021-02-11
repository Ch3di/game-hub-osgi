package tetris;

import java.util.Dictionary;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {
	private ServiceRegistration registration;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("[*] Registring Tetris Game Service...");
		Properties props = new Properties();
		props.put("Language", "English");
		registration = context.registerService(TetrisGame.class.getName(), new TetrisGame(),
				(Dictionary) props);
		System.out.println("[+] Tetris Game Service has been registred.");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		registration.unregister();
		System.out.println("[-] Tetris Game Service has been removed.");
		System.out.println("[*] Tetris Game has stopped.");
	}
}