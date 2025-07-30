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
    boolean isAvailable(ArrayList<Bus> busList,ArrayList<Booking> bookList){
        int capVal = 0;
        Bus requestedBus = new Bus();
        for(Bus b : busList){
            if(b.getBno() == busNo){
                capVal = b.getCapacity();
                requestedBus = b;
            }
        }
        int count = 0;
        for(Booking user : bookList){
            if(user.busNo == busNo && user.date.equals(date)){
                count++;
            }
        }
        if(count<capVal){
            requestedBus.SetAvail(requestedBus.getAvail()-1);
            return true;
        }
        return false;
    }
}
