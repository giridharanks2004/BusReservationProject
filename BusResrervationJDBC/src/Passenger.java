import java.util.*;
import java.util.*;
public class Passenger {
    String Username;
    String Password;
    Passenger() throws Exception{
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter Username:");
        this.Username = inp.nextLine();
        PassengerDAO Pacess = new PassengerDAO();
        if(Pacess.authUser(Username,Password)){
            System.out.println("Enter Password:");
            this.Password = inp.nextLine();
        }
    }
}
