package bg.sofia.uni.fmi.mjt.airbnb.accommodation;

import java.time.LocalDateTime;

public class Stay {
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    public Stay(LocalDateTime checkIn, LocalDateTime checkOut)
    {
        this.checkIn = checkIn.minusDays(0);
        this.checkOut = checkOut.minusDays(0);
    }
    public boolean inPeriod(LocalDateTime time)
    {
        if(time.isAfter(checkIn) && time.isBefore(checkOut)) {
            return true;
        }
        else {
            return false;
        }
    }
    public LocalDateTime getCheckIn()
    {
        return checkIn.minusDays(0);
    }
    public LocalDateTime getCheckOut()
    {
        return checkOut.minusDays(0);
    }
}
