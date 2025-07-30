import java.util.*;
import java.text.SimpleDateFormat;
public class Booking {
    String Passenger_name;
    int busNo;
    Date date;
    Booking(){
        System.out.println("enter passenger name:");
        Scanner inp = new Scanner(System.in);
        this.Passenger_name = inp.nextLine();
        System.out.println("enter bus no:");
        this.busNo = inp.nextInt();
        System.out.println("enter date (dd-mm-yyy):");
        String bdate = inp.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.date = dateFormat.parse(bdate);   
        } catch (Exception e) {
            System.out.println("enter the date properly");
        }
    }
    boolean isAvailable() throws Exception{
        BusDAO bus = new BusDAO();
        BookingDAO book = new BookingDAO();
        int capVal = bus.getCapacity(busNo);
        int count =  book.getCount(busNo,date);  
        if(count<capVal){
            return true;
        }
        return false;
    }
    void confirmBooking() throws Exception{
        BookingDAO book = new BookingDAO();
        String ConfirmationStatus = book.TicketConfirmation(busNo,Passenger_name,date);
        BusDAO bus = new BusDAO();
        if(bus.setAvail(busNo,bus.getAvail(busNo)-1)){
            System.out.println(" ");
            System.out.println("Booking Status: "+ConfirmationStatus);
            System.out.println(" ");
        }
        else{
            System.out.println(" ");
            System.out.println("error please try again");
            System.out.println(" ");
        }
        
        
    }
}
