import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<Taxi> taxis;
    int BookingId=1;
    BookingSystem(int taxiCount){
        taxis=new ArrayList<>();
        for(int i=1;i<=taxiCount;i++){
            taxis.add(new Taxi(i));
        }
    }
    private int CalculateCharges(char pickup,char drop){
        int dis=Math.abs(pickup-drop)*15;
        int amt=100;
        dis-=5;
        amt+=dis*10;
        return amt;
    }
    Taxi findTaxi(char pickup,int pickupTime){
        List<Taxi>freeTaxi=new ArrayList<>();
        for(Taxi t:taxis){
            if(t.isFree(pickup,pickupTime)){
                freeTaxi.add(t);
            }
        }
        if(freeTaxi.isEmpty()){
            return null;
        }
        int minDis=Integer.MAX_VALUE;
        for(Taxi t:freeTaxi){
            int dis=Math.abs(pickup-t.getCurrentSpot());
            minDis=Math.min(dis,minDis);
        }
        List<Taxi>closest=new ArrayList<>();
        for(Taxi t:freeTaxi){
            int dis=Math.abs(pickup-t.getCurrentSpot());
            if(dis==minDis){
                closest.add(t);
            }
        }
        Taxi selected=closest.get(0);
        for(Taxi t:closest){
            if(selected.getearnings()>t.getearnings()){
                selected=t;
            }
        }
        return selected;
    }
    void bookTaxi(Customer c){
        Taxi selected=findTaxi(c.getpickup(),c.getpickuptime());
        if(selected==null){
            System.out.println("No Taxi is Available");
            return;
        }
        int travelTime=Math.abs(c.getpickup()-c.getdrop());
        int dropTimes=c.getpickuptime()+travelTime;
        int cost=CalculateCharges(c.getpickup(),c.getdrop());
        Booking booking=new Booking(BookingId,dropTimes,cost,c);
        BookingId++;
        selected.assignBooking(booking);
        selected.setFreeTime(dropTimes);
        selected.setEarnings(cost+selected.getearnings());
        selected.setCurrentSpot(c.getdrop());
        System.out.println("Taxi-"+selected.getTaxiId()+" is allocated");
    }
    void displayTaxi(){
        System.out.println();
        System.out.println();
        for(Taxi t:taxis){
            System.out.println("Taxi-"+t.getTaxiId()+" Earnings: "+t.getearnings());
            System.out.println("Booking Id   Customer Id   From   To   Pickup Time   Drop Time   Charges");
            for(Booking b:t.getBooking()){
                System.out.println(b.getBookingId()+"   "+b.getCustomerId()+"   "+b.getPickUpPoint()+"   "+b.getDropPoint()+"   "+b.getPickupTime()+"   "+b.getDropTime()+"   "+b.getAmount());
            }
            System.out.println();
        }
    }
}
