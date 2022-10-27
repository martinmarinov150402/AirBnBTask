package bg.sofia.uni.fmi.mjt.airbnb.accommodation;

import bg.sofia.uni.fmi.mjt.airbnb.accommodation.location.Location;

import java.time.Duration;
import java.time.LocalDateTime;

public class Apartment implements Bookable {
    private static int counter = 0;
    private String id;
    private Location loc;
    private double pricePerNight;
    private Stay stay;
    private int curStayIdx;

    public Apartment() {
        curStayIdx = 0;
        pricePerNight = 40.00;
    }
    public Apartment(Location location, double pricePerNight)
    {
        this.loc = location;
        this.pricePerNight = pricePerNight;
        curStayIdx = 0;
        StringBuilder test = new StringBuilder("APA-");
        test.append(counter);
        this.id = test.toString();
        counter++;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Location getLocation() {
        return loc;
    }

    @Override
    public boolean isBooked() {
        boolean flag = false;
        if(stay == null) return false;


        return true;
    }

    @Override
    public boolean book(LocalDateTime checkIn, LocalDateTime checkOut) {
        if(checkIn == null || checkOut == null) return false;
        if(isBooked() || checkIn.isAfter(checkOut) || checkIn.isEqual(checkOut)||checkIn.isBefore(LocalDateTime.now()))
        {
            return false;
        }
        else {
            stay = new Stay(checkIn, checkOut);
            return true;
        }



    }

    @Override
    public double getTotalPriceOfStay() {
        double priceAcum = 0.0;
        if(stay == null) return 0.0;
        if(stay.inPeriod(LocalDateTime.now()));
        {
            priceAcum += Duration.between(stay.getCheckIn(),stay.getCheckOut()).toDays() * pricePerNight;
        }
        return priceAcum;
    }

    @Override
    public double getPricePerNight() {
        if(this == null) return 0.0;
        return pricePerNight;
    }
}
