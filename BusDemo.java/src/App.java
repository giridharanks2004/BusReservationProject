import java.util.Scanner;
import java.util.ArrayList;
public class App {
    public static void main(String[] args){
        ArrayList<Bus> busList = new ArrayList<>();
        ArrayList<Booking> bookList = new ArrayList<>();
        busList.add(new Bus(1, false, 2));
        busList.add(new Bus(2, true, 30));
        busList.add(new Bus(3, true, 60));
        
        int UserOption = 1;
        Scanner inp = new Scanner(System.in);
        while(UserOption==1){
            for(Bus b : busList){
                b.displayBusinfo();
            }
            System.out.println("Enter 1 to book and 0 to exit:");
            UserOption = inp.nextInt();
            if(UserOption==1){
                Booking bookData = new Booking();
                if(bookData.isAvailable(busList, bookList)){
                    bookList.add(bookData);  
                    System.out.println("your booking is confirmed");   
                }
                else{
                    System.out.println("bus is not available please select a diffrent number or date to proceed");
                }
            }
        }
    }
}
