package bg.sofia.uni.fmi.mjt.airbnb.filter;

import bg.sofia.uni.fmi.mjt.airbnb.accommodation.Bookable;

public class PriceCriterion implements Criterion{

    private double minPrice;
    private double maxPrice;

    public PriceCriterion(double minPrice, double maxPrice){
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }
    @Override
    public boolean check(Bookable bookable) {
        if(bookable.getPricePerNight() >= minPrice && bookable.getPricePerNight() <= maxPrice) {
            return true;
        }
        else {
            return false;
        }

    }
}
