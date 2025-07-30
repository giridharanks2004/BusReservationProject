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
        System.out.println("enter date (dd-mm-yyyy):");
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
        int capVal=bus.getCapacity(busNo);
        int count=0;
        if(count<capVal){
            return true;
        }
        return false;
    }
}
