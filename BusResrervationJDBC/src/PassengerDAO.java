import java.sql.*;
import java.util.Scanner;
public class PassengerDAO {
    public boolean authUser(String uid,String Pass) throws Exception{
        Connection con = DBConnect.getConnection();
        PreparedStatement st = con.prepareStatement("select * from UserAuth where userid = ?");
        st.setString(1, uid);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
             if(uid.equals(rs.getString(1)) && Pass.equals(rs.getString(2))){
                System.out.println("logged in");
                return true;
             }
             else{
                System.out.println("check username or password and re enter");
                return false;
             }
        }
        else{
            System.out.println("Do you want to create a new account (y/n)");
            Scanner inp = new Scanner(System.in);
            String ch = inp.next();
            if(ch.equals("y")|| ch.equals("Y")){
                return createUser();
            }
            return false;
        }
    }
    public boolean authUser(String uid) throws Exception{
        Connection con = DBConnect.getConnection();
        PreparedStatement st = con.prepareStatement("select userid from UserAuth where userid = ?");
        st.setString(1, uid);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            return true;
        }
        return false;
    }
    public boolean createUser() throws Exception{
        boolean auth = true;
        Scanner inp = new Scanner(System.in);
        String check,uid,pass;
        System.out.println("enter username:");
        uid = inp.nextLine();
        while(auth){
            auth = authUser(uid);
            if(auth){
                System.out.println("username already taken!");
                check = inp.nextLine();
            }
            uid = check;
        }

        System.out.println("enter password:");
        pass = inp.nextLine();
        Connection con = DBConnect.getConnection();
        con.setAutoCommit(false);
        PreparedStatement st = con.prepareStatement("insert into UserAuth values (?,?)");
        st.setString(1, uid);
        st.setString(2, pass);
        int rows = st.executeUpdate();
        if(rows>0){
            con.commit();
            return true;
        }
        con.rollback();
        return false;
    }
}
