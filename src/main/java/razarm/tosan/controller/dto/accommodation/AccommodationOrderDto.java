package razarm.tosan.controller.dto.accommodation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import razarm.tosan.controller.dto.BaseEntityDto;

import java.time.ZonedDateTime;
import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccommodationOrderDto extends BaseEntityDto {
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private  ZonedDateTime date;
    private  Integer discount;
    private  AccommodationDto accommodation;


    public AccommodationOrderDto() {}
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

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public void setAccommodation(AccommodationDto accommodation) {
        this.accommodation = accommodation;
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
