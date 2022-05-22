package razarm.tosan.repository.data.auth;

import razarm.tosan.repository.data.BaseEntityData;
import razarm.tosan.repository.domain.tour.TourCategory;

import java.time.Instant;

public class InterestData extends BaseEntityData {

    private final String name;
    private final TourCategory tourCategory;


    public InterestData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, TourCategory tourCategory) {
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

    @Override
    public BaseEntityData cloneWithId(String id) {
        return new InterestData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, tourCategory);
    }


    public static final class InterestDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private TourCategory tourCategory;

        private InterestDataBuilder() {
        }

        public static InterestDataBuilder anInterestData() {
            return new InterestDataBuilder();
        }

        public InterestDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InterestDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public InterestDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public InterestDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public InterestDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public InterestDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public InterestDataBuilder tourCategory(TourCategory tourCategory) {
            this.tourCategory = tourCategory;
            return this;
        }

        public InterestData build() {
            return new InterestData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, tourCategory);
        }
    }
}
