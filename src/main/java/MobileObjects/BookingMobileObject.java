package MobileObjects;

import Entities.Booking;
import Utilities.Hook;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.internal.builders.IgnoredBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class BookingMobileObject {

    String closeRegistrationView = "//android.widget.ImageButton[@content-desc='Navigate up']";
    String startSavinToday = "com.booking:id/bui_empty_state_primary_action";

    String destinationHomeTextBox = "com.booking:id/facet_search_box_basic_field_label";
    String searchingDestinationTextBox = "com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content";
    String chooseFirstResult = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.ImageView[1]";

    String dateTime = "com.booking:id/facet_search_box_basic_field_label";
    String startDate ="//android.view.View[@content-desc='{date}']";
    String finalDate ="//android.view.View[@content-desc='{date}']";
    String selectDatesButton = "com.booking:id/facet_date_picker_confirm";

    String travelerInfo = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.widget.ScrollView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView";

    String plusRoomsButton = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.Button[2]";
    String plusAdultsButton = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.Button[2]";
    String plusChildrenButton = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup[3]/android.widget.LinearLayout/android.widget.Button[2]";

    String ageXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.NumberPicker/android.widget.Button[1]";
    String okButton = "android:id/button1";
    String applyButton = "com.booking:id/group_config_apply_button";
    String searchButton = "com.booking:id/facet_search_box_cta";
    String chooseSecondItemImg = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView";

    String selectRoom = "com.booking:id/select_room_cta";
    String reserveTheseOptions ="com.booking:id/recommended_block_reserve_button";
    String addMissingDetails = "";
    String reserveRoom ="com.booking:id/main_action";

    public void verifyHomePageLoads() throws InterruptedException {
        Hook.driver.findElement(By.xpath(closeRegistrationView)).click();
        sleep(10000);

        //Rewards & Wallet
        try {
            if(Hook.driver.findElement(By.id(startSavinToday)).isDisplayed()){
                Hook.driver.findElement(By.id(startSavinToday)).click();
                sleep(2000);
                Hook.driver.pressKey(new KeyEvent(AndroidKey.BACK));
                sleep(2000);
            }
        }catch (Exception ignore){};
    }

    public void enterDestination(String destination) throws Exception {
        try{
            Hook.driver.findElement(By.id(destinationHomeTextBox)).click();
            sleep(3000);
            Hook.driver.findElement(By.id(searchingDestinationTextBox)).click();
            Hook.driver.findElement(By.id(searchingDestinationTextBox)).sendKeys(destination);

            sleep(4000);
            Hook.driver.findElement(By.xpath(chooseFirstResult)).click();

        }catch (Exception e){throw new Exception("No se pudo ingresar el destino" + e.getMessage());};

    }

    public void searchingDate(String _startDate, String _finalDate) throws Exception {
        try {

            startDate = startDate.replace("{date}",_startDate);
            finalDate = finalDate.replace("{date}",_finalDate);
            sleep(2000);

            //Follow lines are comment because scroll is not working (I tried in other apps, and it works)
            TouchActions action = new TouchActions(Hook.driver);
            action.scroll(Hook.driver.findElement(By.id("com.booking:id/calendar_month_list")), 0, 400);
            action.perform();
                //Hook.driver.findElement(By.xpath(startDate)).click();
                //Hook.driver.findElement(By.xpath(finalDate)).click();

            sleep(2000);
            Hook.driver.findElement(By.id(selectDatesButton)).click();

        } catch (Exception e) {throw new Exception("No se pudo ingresar las fechas" + e.getMessage());}
    }

    public void enterPassengerInfo(Booking booking) throws Exception {
        try {
            sleep(4000);
            Hook.driver.findElement(By.xpath(travelerInfo)).click();
            for(int i=1;i<booking.getRooms();i++)
                Hook.driver.findElement(By.xpath(plusRoomsButton)).click();

            for(int i=2;i<booking.getRooms();i++)
                Hook.driver.findElement(By.xpath(plusAdultsButton)).click();

            for(int i=0;i<booking.getChildren();i++) {
                Hook.driver.findElement(By.xpath(plusChildrenButton)).click();
                Thread.sleep(3000);
                int times = 18 - booking.getAge();
                for(int j=0;j<times;j++) {
                    Hook.driver.findElement(By.xpath(ageXpath)).click();
                    Thread.sleep(3000);
                }
                Hook.driver.findElement(By.id(okButton)).click();
                Thread.sleep(2000);
                Hook.driver.findElement(By.id(applyButton)).click();
            }
        } catch (Exception e) {throw new Exception("No se pudo ingresar la información de los pasajeros" + e.getMessage());}
    }
    public void searchBooking() throws Exception {
        try {
            Thread.sleep(4000);
            Hook.driver.findElement(By.id(searchButton)).click();
        } catch (Exception e) {throw new Exception("No se encontro el boton buscar" + e.getMessage());}
    }

    public void chooseSecondItem() throws Exception {
        try {
            sleep(6000);
            Hook.driver.findElement(By.xpath(chooseSecondItemImg)).click();
        } catch (Exception e) {throw new Exception("No se encontro el boton buscar" + e.getMessage());}
    }

    public void selectRoom() throws Exception {
        try {
            sleep(2000);
            Hook.driver.findElement(By.id(selectRoom)).click();
            sleep(5000);
            try{
                if(!Hook.driver.findElement(By.id("com.booking:id/recommended_block_reserve_button")).isDisplayed()){
                    TouchActions action = new TouchActions(Hook.driver);
                    action.scroll(Hook.driver.findElement(By.id("com.booking:id/rooms_recycler_view")), 0, 100);
                    action.perform();
                    Hook.driver.findElement(By.id("com.booking:id/rooms_item_select_text_view")).click();
                    sleep(4000);
                }
            }catch (Exception ignored){};
            Hook.driver.findElement(By.id(reserveTheseOptions)).click();
            sleep(5000);
        } catch (Exception e) {throw new Exception("No se pudo seleccionar la habitación" + e.getMessage());}
    }
    public void getPrincipalPrice() throws Exception {
        try {
            Hook.principalPrice = Hook.driver.findElement(By.id("com.booking:id/recommended_block_item_price_view")).getText();
        } catch (Exception e) {throw new Exception("No se pudo reservar la habitación" + e.getMessage());}
    }

    public void getTaxes() throws Exception {
        try {
            Hook.taxesPrice = Hook.driver.findElement(By.id("com.booking:id/recommended_block_taxes_charges_view")).getText();
        } catch (Exception e) {throw new Exception("No se pudo reservar la habitación" + e.getMessage());}
    }
    public void reserveRoom(String name, String lastName, String mail, String country, String phoneNumber) throws Exception {
        try {

        } catch (Exception e) {throw new Exception("No se pudo reservar la habitación" + e.getMessage());}
    }

    public void verifyTotalAmounts() throws Exception {
        try {
            if(Hook.principalPrice.equals(Hook.driver.findElement(By.id("com.booking:id/recommended_block_item_price_view")).getText()))
                throw new Exception("El precio total no coincide");

            if(Hook.taxesPrice.equals(Hook.driver.findElement(By.id("com.booking:id/recommended_block_taxes_charges_view")).getText()))
                throw new Exception("El precio total no coincide");

        } catch (Exception e) {throw new Exception("No se pudo comparar los precios" + e.getMessage());}
    }
}
