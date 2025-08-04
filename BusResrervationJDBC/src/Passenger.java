import java.util.*;
import java.util.*;
public class Passenger {
    String Username;
    String Password;
    Passenger() throws Exception{
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter Username:");
        this.Username = inp.nextLine();
        System.out.println("Enter Password:");
        this.Password = inp.nextLine();
    }
    public boolean checkUser()throws Exception{
        PassengerDAO Pacess = new PassengerDAO();
        return Pacess.authUser(Username,Password);
    }
}
