package razarm.tosan.controller.dto.tour;

import com.fasterxml.jackson.annotation.JsonInclude;
import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.controller.dto.auth.UserDto;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDto extends BaseEntityDto {
    private  ZonedDateTime date;
    private  String description;

    private  Set<TravelerDto> travelers;


    private  TourDto tour;

    private  UserDto user;

    public BookingDto() {}
    public BookingDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, ZonedDateTime date, String description, Set<TravelerDto> travelers, TourDto tour, UserDto user) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.date = date;
        this.description = description;
        this.travelers = travelers;
        this.tour = tour;
        this.user = user;
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

    public UserDto getUser() {
        return user;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTravelers(Set<TravelerDto> travelers) {
        this.travelers = travelers;
    }

    public void setTour(TourDto tour) {
        this.tour = tour;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public BookingDto cloneWithTour(TourDto tour) {
        return new BookingDto(id, createdAt, modifiedAt, createdBy, modifiedBy, date, description, travelers, tour, user);
    }

    public BookingDto cloneWithUser(UserDto user) {
        return new BookingDto(id, createdAt, modifiedAt, createdBy, modifiedBy, date, description, travelers, tour, user);
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
        private UserDto user;

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

        public BookingDtoBuilder user(UserDto user) {
            this.user = user;
            return this;
        }

        public BookingDto build() {
            return new BookingDto(id, createdAt, modifiedAt, createdBy, modifiedBy, date, description, travelers, tour, user);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BookingDto.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("createdAt=" + createdAt)
                .add("modifiedAt=" + modifiedAt)
                .add("createdBy='" + createdBy + "'")
                .add("modifiedBy='" + modifiedBy + "'")
                .add("date=" + date)
                .add("description='" + description + "'")
                .add("travelers=" + travelers)
                .add("tour=" + tour)
                .add("user=" + user)
                .toString();
    }
}

