package hotelBooking.model;

public class StandardRoom extends Room
{
    public StandardRoom(int i, int hId, int c, int p, String d, Boolean en)
    {
        super(i, hId, c, p, d, en);
    }
    public String getTypeName(){
        return "STANDARD";
    }
}
