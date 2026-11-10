package hotelBooking.model;

public class Suite extends Room{
    public Suite(int i, int hId, int c, int p, String d, Boolean en)
    {
        super(i, hId, c, p, d, en);
    }
    public String getTypeName(){
        return "SUITE";
    }
}
