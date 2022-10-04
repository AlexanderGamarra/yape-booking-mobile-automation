package StepDefinition;

import Steps.BookingSteps;
import Utilities.Hook;
import io.appium.java_client.android.Activity;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.net.MalformedURLException;

public class BookingStepDefinition {
    @Steps
    BookingSteps bookingSteps;
    @Given("La aplicación de reservas se inicia")
    public void bookingAppStarts() throws MalformedURLException {
        Hook.init();
        //driver.startActivity(new Activity("com.booking", "startup.HomeActivity"));
    }
}
