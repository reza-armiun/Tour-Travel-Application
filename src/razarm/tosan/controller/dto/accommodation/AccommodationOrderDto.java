package razarm.tosan.controller.dto.accommodation;

import razarm.tosan.controller.dto.BaseEntityDto;

import java.time.ZonedDateTime;
import java.util.StringJoiner;

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


    public AccommodationOrderDto cloneWithDiscount(Integer discount) {
        return new AccommodationOrderDto(id, createdAt, modifiedAt, createdBy, modifiedBy, date, discount, accommodation);
    }

    public static final class AccommodationOrderDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private ZonedDateTime date;
        private Integer discount;
        private AccommodationDto accommodation;

        private AccommodationOrderDtoBuilder() {
        }

        public static AccommodationOrderDtoBuilder anAccommodationOrderDto() {
            return new AccommodationOrderDtoBuilder();
        }

        public AccommodationOrderDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public AccommodationOrderDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccommodationOrderDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public AccommodationOrderDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AccommodationOrderDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public AccommodationOrderDtoBuilder date(ZonedDateTime date) {
            this.date = date;
            return this;
        }

        public AccommodationOrderDtoBuilder discount(Integer discount) {
            this.discount = discount;
            return this;
        }

        public AccommodationOrderDtoBuilder accommodation(AccommodationDto accommodation) {
            this.accommodation = accommodation;
            return this;
        }

        public AccommodationOrderDto build() {
            return new AccommodationOrderDto(id, createdAt, modifiedAt, createdBy, modifiedBy, date, discount, accommodation);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AccommodationOrderDto.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("createdAt=" + createdAt)
                .add("modifiedAt=" + modifiedAt)
                .add("createdBy='" + createdBy + "'")
                .add("modifiedBy='" + modifiedBy + "'")
                .add("date=" + date)
                .add("discount=" + discount)
                .add("accommodation=" + accommodation)
                .toString();
    }
}