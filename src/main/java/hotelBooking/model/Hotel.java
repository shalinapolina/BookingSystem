package hotelBooking.model;

public class Hotel {
    private int id;
    private String title;
    private String description;
    public Hotel(int i, String t, String d)
    {
        id = i;
        title = t;
        description = d;
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public String toString()
    {
        return id + ": " + title + " - " + description;
    }
}
