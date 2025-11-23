import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private int taxiId;
    private char currentSpot;
    private int freeTime;
    private int earnings;
    private List<Booking> bookings;
    public Taxi(int id){
        this.taxiId=id;
        this.currentSpot='A';
        this.freeTime=0;
        this.earnings=0;
        bookings=new ArrayList<>();
    }
    public boolean isFree(char pickup,int pickupTime){
        int travelTime=Math.abs(pickup-currentSpot);
        if(freeTime + travelTime <=pickupTime){
            return true;
        }
        return false;
    }
    public void assignBooking(Booking b){
        bookings.add(b);
    }
    public int getTaxiId(){
        return taxiId;
    }
    public char getCurrentSpot(){
        return currentSpot;
    }
    public int freeTime(){
        return freeTime;
    }
    public int getearnings(){
        return earnings;
    }
    public List<Booking>getBooking(){
        return bookings;
    }
    public void setFreeTime(int freeTime){
        this.freeTime=freeTime;
    }
    public void setEarnings(int earnings){
        this.earnings=earnings;
    }
    public void setCurrentSpot(char currentSpot){
        this.currentSpot=currentSpot;
    }

}
