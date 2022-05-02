package razarm.tosan.controller.dto.tour;

import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.utility.AppCollections;

import java.time.ZonedDateTime;
import java.util.Set;

public class BookingDto extends BaseEntityDto {
    private final ZonedDateTime date;
    private final String description;

    private final Set<TravelerDto> travelers;
    private final TourDto tour;

    public BookingDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, ZonedDateTime date, String description, Set<TravelerDto> travelers, TourDto tour) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.date = date;
        this.description = description;
        this.travelers = AppCollections.unmodifiableSet(travelers);
        this.tour = tour;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Set<TravelerDto> getTravelers() {
        return travelers;
    }

    public TourDto getTour() {
        return tour;
    }


    public static final class BookingDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private ZonedDateTime date;
        private String description;
        private Set<TravelerDto> travelers;
        private TourDto tour;

        private BookingDtoBuilder() {
        }

        public static BookingDtoBuilder aBookingDto() {
            return new BookingDtoBuilder();
        }

        public BookingDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public BookingDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public BookingDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public BookingDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public BookingDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public BookingDtoBuilder date(ZonedDateTime date) {
            this.date = date;
            return this;
        }

        public BookingDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public BookingDtoBuilder travelers(Set<TravelerDto> travelers) {
            this.travelers = travelers;
            return this;
        }

        public BookingDtoBuilder tour(TourDto tour) {
            this.tour = tour;
            return this;
        }

        public BookingDto build() {
            return new BookingDto(id, createdAt, modifiedAt, createdBy, modifiedBy, date, description, travelers, tour);
        }
    }
}
