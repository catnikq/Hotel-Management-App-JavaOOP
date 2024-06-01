package io.catnikq.hotel_app;

import java.util.List;

public class RoomService extends Service {
    private List<String> amenities;
    
    //Constructor

    public RoomService(List<String> amenities) {
        this.amenities = amenities;
    }
    
    //Getters and Setters
    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }
    
    
}
