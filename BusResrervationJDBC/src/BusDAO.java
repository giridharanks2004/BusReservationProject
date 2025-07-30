import java.sql.*;
public class BusDAO {
    public void displayBusinfo() throws Exception{
        Connection con = DBConnect.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from bus");
        
        while (rs.next()){
            System.out.println("Bus no: "+rs.getInt(1));
            if(rs.getInt(1)==0){
                System.out.println("AC: No");
            }else{
                System.out.println("AC: Yes");
            }
            System.out.println("Capacity: "+rs.getInt(3));
            System.out.println("Available: "+rs.getInt(4)+"/"+rs.getInt(3)+" ");

            System.out.println("");
            
        }

        System.out.println("------------------------------------------------------------------------------");
    }
}
