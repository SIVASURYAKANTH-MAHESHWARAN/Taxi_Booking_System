public class Booking {
    private int bookingid;
    private int droptime;
    private int amount;
    private Customer customer;
    Booking(int id,int dropTime,int amount,Customer customer){
        this.bookingid=id;
        this.droptime=dropTime;
        this.amount=amount;
        this.customer=customer;
    }
    public int getBookingId(){
        return bookingid;
    }
    public int getDropTime(){
        return droptime;
    }
    public int getAmount(){
        return amount;
    }
    public Customer getCustomer(){
        return customer;
    }
    public int getCustomerId(){
        return customer.getCustomerId();
    }
    public char getPickUpPoint(){
        return customer.getpickup();
    }
    public char getDropPoint(){
        return customer.getdrop();
    }
    public int getPickupTime(){
        return customer.getpickuptime();
    }
}
