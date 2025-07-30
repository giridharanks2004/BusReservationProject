import java.sql.*;
public class BusDAO {
    public void displayBusinfo() throws Exception{
        Connection con = DBConnect.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from bus");
        System.out.println(" ");   
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
        con.close();
        System.out.println("------------------------------------------------------------------------------");
    }
    public int getCapacity(int busid) throws Exception{
        Connection con = DBConnect.getConnection();
        PreparedStatement st = con.prepareStatement("select capacity from bus where bus_id = ?");
        st.setInt(1, busid);
        ResultSet rs = st.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public int getAvail(int busid) throws Exception{
        Connection con = DBConnect.getConnection();
        PreparedStatement st = con.prepareStatement("select avail from bus where bus_id = ?");
        st.setInt(1, busid);
        ResultSet rs = st.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    public boolean setAvail(int busid,int val) throws Exception{
        Connection con = DBConnect.getConnection();
        con.setAutoCommit(false);
        PreparedStatement st = con.prepareStatement("update bus set avail = ? where bus_id = ?");
        st.setInt(1, val);
        st.setInt(2, busid);
        int rows = st.executeUpdate();
        if(rows>0){
            con.commit();
            return true;
        }
        con.rollback();
        return false;
    }
}
