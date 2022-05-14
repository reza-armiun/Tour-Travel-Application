package razarm.tosan.controller.dto.auth;

import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.repository.domain.tour.TourCategory;

import java.time.ZonedDateTime;

public class InterestDto extends BaseEntityDto {
    private final String name;
    private final TourCategory tourCategory;

    public InterestDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, TourCategory tourCategory) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.tourCategory = tourCategory;
    }

    public String getName() {
        return name;
    }

    public TourCategory getTourCategory() {
        return tourCategory;
    }

    public static final class InterestDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private TourCategory tourCategory;

        private InterestDtoBuilder() {
        }

        public static InterestDtoBuilder anInterestDto() {
            return new InterestDtoBuilder();
        }

        public InterestDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InterestDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public InterestDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public InterestDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public InterestDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public InterestDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public InterestDtoBuilder tourCategory(TourCategory tourCategory) {
            this.tourCategory = tourCategory;
            return this;
        }

        public InterestDto build() {
            return new InterestDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, tourCategory);
        }
    }
}
