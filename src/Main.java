//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//i have few points
public class Main {
    public static void main(String[] args) {
        Customer c1=new Customer(1,'A','B',9);
        Customer c2=new Customer(2,'B','D',9);
        Customer c3=new Customer(3,'B','C',12);
        BookingSystem TaxiBooking=new BookingSystem(4);
        TaxiBooking.bookTaxi(c1);
        TaxiBooking.bookTaxi(c2);
        TaxiBooking.bookTaxi(c3);
        TaxiBooking.displayTaxi();
    }
}
