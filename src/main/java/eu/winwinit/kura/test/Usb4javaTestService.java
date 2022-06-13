package eu.winwinit.kura.test;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import javax.usb.UsbException;
import javax.usb.UsbHostManager;

@Component(immediate = true)
public class Usb4javaTestService {

    @Activate
    public void activate() {
        System.out.println("Usb4javaTestService - ACTIVATING");
        try {
            UsbHostManager.getUsbServices();
        } catch (UsbException e) {
            System.out.println("Error while trying to obtain usb services");
            e.printStackTrace();
        }
        System.out.println("Usb4javaTestService - ACTIVATED");
    }

    @Deactivate
    public void deactivate() {
        System.out.println("Usb4javaTestService - DEACTIVATED");
    }
    
}
