package bg.sofia.uni.fmi.mjt.airbnb.accommodation.location;

public class Location {
    private double x, y;
    public Location(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public Location(Location loc)
    {
        this.x = loc.x;
        this.y = loc.y;
    }
    public double getDistance(double x, double y){
        return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
    }
    public double getDistance(Location a){
        return Math.sqrt((this.x - a.x) * (this.x - a.x) + (this.y - a.y) * (this.y - a.y));
    }

}
