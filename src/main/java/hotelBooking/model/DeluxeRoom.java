package hotelBooking.model;

public class DeluxeRoom extends Room{
    public DeluxeRoom(int i, int hId, int c, int p, String d, Boolean en)
    {
        super(i, hId, c, p, d, en);
    }
    public String getTypeName(){
        return "DELUXE";
    }
}
