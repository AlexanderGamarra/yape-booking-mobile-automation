package Utilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Fail.fail;

public class Hook {

    public static AndroidDriver driver;
    public static String principalPrice = "";
    public static String taxesPrice = "";

    public static void init() throws MalformedURLException {
        try{
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/src/test/resources/apk/com.booking_v33.6.0.1-901292_Android-8.0.apk");
            desiredCapabilities.setCapability("appium:appPackage", "com.booking");
            desiredCapabilities.setCapability("appium:appActivity", "com.booking.startup.HomeActivity");

            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

        }catch (Exception e){
            fail("La aplicación no se pudo iniciar, verificar los capabilities y que el servidor de appium se encuentre disponible: \n"+
                    e.getMessage());
        }

    }
}
