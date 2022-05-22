package razarm.tosan.controller.dto.tour;

import razarm.tosan.controller.dto.UserRequest;

import java.time.ZonedDateTime;

public  class BookingRequest extends UserRequest {
    protected final String tourName;
    protected final TravelerDto traveler;
    protected final ZonedDateTime date;
    protected final String description;


    public BookingRequest(String tourName, TravelerDto traveler, ZonedDateTime date, String description) {
        this.tourName = tourName;
        this.traveler = traveler;
        this.date = date;
        this.description = description;
    }

    public String getTourName() {
        return tourName;
    }

    public TravelerDto getTraveler() {
        return traveler;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
