import java.sql.*;
import java.util.Date;
public class BookingDAO {
    public int getCount(int busNo,Date buDate) throws Exception{
        Connection con = DBConnect.getConnection();
        PreparedStatement st = con.prepareStatement("select count(p_name) from booking where bus_id = ? and travel_date = ?");
        java.sql.Date sqlDate = new java.sql.Date(buDate.getTime());
        st.setInt(1, busNo);
        st.setDate(2, sqlDate);
        ResultSet rs = st.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    public String TicketConfirmation(int busid,String Passenger_name,Date bDate) throws Exception{
        Connection con = DBConnect.getConnection();
        con.setAutoCommit(false);
        PreparedStatement st = con.prepareStatement("insert into booking(p_name,bus_id,travel_date) values (?,?,?)");
        st.setString(1,Passenger_name);
        st.setInt(2, busid);
        java.sql.Date sqlDate = new java.sql.Date(bDate.getTime());
        st.setDate(3, sqlDate);
        int rows = st.executeUpdate();
        if(rows>0){
            con.commit();
            PreparedStatement chkst = con.prepareStatement("select status from booking where p_name = ? and bus_id =?");
            chkst.setString(1, Passenger_name);
            chkst.setInt(2, busid);
            ResultSet rs = chkst.executeQuery();
            rs.next();
            String status = rs.getString(1);
            return status;
        }
            
        return "booking failed";
    }
}
