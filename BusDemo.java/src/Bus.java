public class Bus {
    private int Bus_no;
    private boolean Ac;
    private int Capacity;
    private int Available;
    Bus(){}
    Bus(int b_no,boolean ac,int cap){
        this.Bus_no = b_no;
        this.Ac = ac;
        this.Capacity = cap;
        this.Available = cap;
    }
    int getCapacity(){
        return Capacity;
    }
    boolean getAC(){
        return Ac;
    }
    int getBno(){
        return Bus_no;
    }
    int getAvail(){
        return Available;
    }
    void SetAvail(int val){
        Available = val;
    }
    void SetCap(int val){
        Capacity = val;
    }
    void SetAc(boolean val){
        Ac = val;
    }
    void displayBusinfo(){
        System.out.println("Bus number: "+Bus_no);
        if(Ac){
            System.out.println("Ac: Yes");
        }else{
            System.out.println("Ac: No");
        }
        System.out.println("Seating Capacity: "+Capacity);
        System.out.print("Seats Available: "+Available+"/"+Capacity);
        System.out.println(" ");
        System.out.println(" ");
    }
}
