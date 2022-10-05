package StepDefinition;

import Entities.Booking;
import Steps.BookingSteps;
import Utilities.Hook;
import com.sun.istack.NotNull;
import io.appium.java_client.android.Activity;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.List;

import static org.assertj.core.api.Fail.fail;

public class BookingStepDefinition {
    @Steps
    BookingSteps bookingSteps;
    public static Booking booking;
    @Given("La aplicación de reservas se inicia")
    public void bookingAppStarts() throws Exception {
        Hook.init();
        bookingSteps.verifyHomePage();
    }

    @When("Se realiza la siguiente busqueda")
    public void searchingBooking(@NotNull DataTable table) throws Exception {

        List<List<Object>> rows = table.asLists(String.class);
        int count = 0;
        for (List<Object> columns : rows) {
            count++;
            if(count==2){
                booking = new Booking(columns.get(0).toString(),columns.get(1).toString(),
                        Integer.parseInt(columns.get(2).toString()), Integer.parseInt(columns.get(3).toString()),
                        Integer.parseInt(columns.get(4).toString()),Integer.parseInt(columns.get(5).toString()));

                bookingSteps.searchingBooking(booking);}
        }
    }

    @And("Se selecciona el segundo resultado de la busqueda")
    public void chooseSecondItem() throws Exception {
        bookingSteps.chooseSecondItem();
    }

    @And("Se selecciona la habitacion y se reserva la primera opcion")
    public void selectRoom() throws Exception {
        bookingSteps.selectRoom();
    }

    @Then("Se completa la información de la reserva")
    public void reserveRoom(@NotNull DataTable table) throws Exception {
        List<List<Object>> rows = table.asLists(String.class);
        int count = 0;
        for (List<Object> columns : rows) {
            count++;
            if(count==2){
                bookingSteps.reserveRoom(columns.get(0).toString(),columns.get(1).toString(),columns.get(2).toString(),
                        columns.get(3).toString(),columns.get(4).toString(),columns.get(5).toString(),
                        columns.get(6).toString(),columns.get(7).toString());
            }
        }
    }

    @And("Se obtiene el precio de la reserva")
    public void seObtieneElPrecioDeLaReserva() throws Exception {
        bookingSteps.getTotalPrices();
    }

    @And("Se verifica los datos de la reserva y se selecciona el ultimo paso")
    public void seVerificaLosDatosDeLaReservaYSeSeleccionaElUltimoPaso() throws Exception {
        seVerificaElCostoDeLaReserva();
    }

    @Then("Se elige la forma de pago tarjeta de credito")
    public void seEligeLaFormaDePagoTarjetaDeCredito() {
        if(!Hook.creditCardItNeeded.equals(""))
            bookingSteps.fillCreditCard();
    }

    @And("Se verifica el costo de la reserva")
    public void seVerificaElCostoDeLaReserva() throws Exception {
        bookingSteps.verifyTotalAmounts();
    }
}
