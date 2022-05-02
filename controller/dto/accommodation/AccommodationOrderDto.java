package razarm.tosan.controller.dto.accommodation;

import razarm.tosan.controller.dto.BaseEntityDto;

import java.time.ZonedDateTime;

public class AccommodationOrderDto extends BaseEntityDto {
    private final ZonedDateTime date;
    private final Integer discount;
    private final AccommodationDto accommodation;

    public AccommodationOrderDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, ZonedDateTime date, Integer discount, AccommodationDto accommodation) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.date = date;
        this.discount = discount;
        this.accommodation = accommodation;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public Integer getDiscount() {
        return discount;
    }

    public AccommodationDto getAccommodation() {
        return accommodation;
    }
}
