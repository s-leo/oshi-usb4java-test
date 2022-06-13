package eu.winwinit.kura.test;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import oshi.SystemInfo;

@Component(immediate = true)
public class OshiTestService {

    @Activate
    public void activate() {
        System.out.println("OshiTestService - ACTIVATING");
        Thread t = new Thread(() -> {
            System.out.println("OshiTestService - SLEEP START");
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                System.out.println("OshiTestService - SLEEP END");
                Thread.currentThread().interrupt();
            }
            System.out.println("OshiTestService - SLEEP END");
            new SystemInfo().getHardware().getDiskStores();
        });
        t.start();
        System.out.println("OshiTestService - ACTIVATED");
    }

    @Deactivate
    public void deactivate() {
        System.out.println("OshiTestService - DEACTIVATED");
    }

}
