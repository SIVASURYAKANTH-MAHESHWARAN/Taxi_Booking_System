public class Customer {
    private int customerid;
    private char pickup;
    private char drop;
    private int pickuptime;
    Customer(int customerid,char pickup,char drop,int pickuptime){
        this.customerid=customerid;
        this.pickup=pickup;
        this.drop=drop;
        this.pickuptime=pickuptime;
    }
    public int getCustomerId(){
        return customerid;
    }
    public char getpickup(){
        return pickup;

    }
    public char getdrop(){
        return drop;
    }
    public int getpickuptime(){
        return pickuptime;
    }
}
