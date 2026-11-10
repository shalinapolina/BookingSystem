package hotelBooking.model;

abstract public class Room {
    private int id;
    private int hotelId;
    private int capacity;
    private int pricePerNight;
    private String description;
    private boolean enabled;
    public Room(int i, int hId, int c, int p, String d, boolean en)
    {
        id = i;
        hotelId = hId;
        capacity = c;
        pricePerNight = p;
        description = d;
        enabled = en;
    }
    public int getId(){
        return id;
    }
    public int getHotelId(){
        return hotelId;
    }
    public int getCapacity(){
        return capacity;
    }
    public int getPricePerNight(){
        return pricePerNight;
    }
    public String getDescription(){
        return description;
    }
    public Boolean getIsEnabled(){
        return enabled;
    }
    abstract public String getTypeName();
    public String toString()
    {
        return getTypeName();
    }
}