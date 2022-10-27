package bg.sofia.uni.fmi.mjt.airbnb;

import bg.sofia.uni.fmi.mjt.airbnb.accommodation.Bookable;
import bg.sofia.uni.fmi.mjt.airbnb.filter.Criterion;

public class Airbnb implements AirbnbAPI {
    Bookable[] accomodations;

    Airbnb(Bookable[] accommodations) {
        this.accomodations = accommodations.clone();
    }

    @Override
    public Bookable findAccommodationById(String id) {
        Bookable result = null;
        for (Bookable i : accomodations) {

            if (id != null && i.getId().compareTo(id) == 0) {
                result = i;
            }
        }
        return result;
    }

    @Override
    public double estimateTotalRevenue() {
        double total = 0;
        for (Bookable i : accomodations) {
            total += i.getTotalPriceOfStay();
        }
        return total;
    }

    @Override
    public long countBookings() {
        long result = 0;
        for (Bookable i : accomodations) {
            if(i.isBooked()){
                result += 1;
            }

        }
        return result;
    }

    @Override
    public Bookable[] filterAccommodations(Criterion... criteria) {
        Bookable[] result = new Bookable[accomodations.length];
        int idx = 0;
        for (Bookable i : accomodations) {
            boolean flag = true;
            for (Criterion crit : criteria) {
                flag = flag && crit.check(i);
            }
            if (flag) {
                result[idx++] = i;
            }
        }
        Bookable[] result2 = new Bookable[idx];
        for(int i = 0; i < idx; i++)
        {
            result2[i] = result[i];
        }
        return result2.clone();
    }


}
