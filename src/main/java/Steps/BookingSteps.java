package Steps;

import Entities.Booking;
import MobileObjects.BookingMobileObject;

public class BookingSteps {

    BookingMobileObject bookingMobileObject;

    public BookingSteps(){
        bookingMobileObject = new BookingMobileObject();}
    public void verifyHomePage() throws Exception {
        try{
            bookingMobileObject.verifyHomePageLoads();
        }catch (Exception e){throw new Exception("No se pudo ingresar al homepage, no se pudo identificar mobile elements");}

    }

    public void searchingBooking(Booking booking) throws Exception {
        //Sending destination
        bookingMobileObject.enterDestination(booking.getDestination());
        bookingMobileObject.searchingDate(booking.getDates()[0],booking.getDates()[1]);
        bookingMobileObject.enterPassengerInfo(booking);
        bookingMobileObject.searchBooking();
    }

    public void chooseSecondItem() throws Exception {
        bookingMobileObject.chooseSecondItem();
    }

    public void selectRoom() throws Exception {
        bookingMobileObject.selectRoom();
    }
    public void getTotalPrices() throws Exception {
        bookingMobileObject.getPrincipalPrice();
        bookingMobileObject.getTaxes();
    }
    public void reserveRoom(String name, String lastName, String mail,String address,String zipCode,String city, String country, String phoneNumber ) throws Exception {
        bookingMobileObject.reserveRoom(name,lastName,mail,address,zipCode,city,country,phoneNumber);
    }

    public void verifyTotalAmounts() throws Exception {
        bookingMobileObject.verifyTotalAmounts();
    }

    public void fillCreditCard(String PAM, String name, String exp) {
        bookingMobileObject.fillCreditCard(PAM,name,exp);
    }
}

