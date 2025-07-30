import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception{     
        int UserOption = 1;
        Scanner inp = new Scanner(System.in);
        while(UserOption==1){
            BusDAO busdetails = new BusDAO();
            busdetails.displayBusinfo();
            System.out.println("Enter 1 to book and 0 to exit:");
            UserOption = inp.nextInt();
            if(UserOption==1){
                Booking bookData = new Booking();
                if(bookData.isAvailable()){  
                    
                    bookData.confirmBooking();
                    System.out.println(" ");
                    System.out.println(" ");
                }
                else{
                    System.out.print(" ");
                    System.out.println("bus is not available please select a diffrent number or date to proceed");
                }
            }
        }
    }
}
