package bg.sofia.uni.fmi.mjt.airbnb.filter;

import bg.sofia.uni.fmi.mjt.airbnb.accommodation.Bookable;
import bg.sofia.uni.fmi.mjt.airbnb.accommodation.location.Location;

import java.time.LocalDateTime;

public class LocationCriterion implements Criterion{

    private Location a;
    private double maxDistance;

    public LocationCriterion(Location b, double maxDistance)
    {
        this.a = new Location(b);
        this.maxDistance = maxDistance;
    }
    @Override
    public boolean check(Bookable bookable) {
        if(bookable.getLocation().getDistance(a) <= maxDistance) {
            return true;
        }
        else {
            return false;
        }
    }
}
