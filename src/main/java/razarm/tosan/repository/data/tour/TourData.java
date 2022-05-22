package razarm.tosan.repository.data.tour;

import razarm.tosan.repository.data.BaseEntityData;
import razarm.tosan.repository.domain.tour.TourCategory;
import razarm.tosan.repository.domain.tour.TourType;

import java.time.Instant;
import java.util.Set;

public class TourData extends BaseEntityData {

    protected final String name;
    protected final TourType type;
    protected final String guide;
    protected final String description;
    protected final String imgUrl;
    protected final Integer tourRateId;
    protected final Instant date;
    protected final Set<TourCategory> categories;
    protected final TourismManagerData tourismManager;
    protected final Set<SchedulePlanData> schedulePlans;


    public TourData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, TourType type, String guide, String description, String imgUrl, Integer tourRateId, Instant date, Set<TourCategory> categories, TourismManagerData tourismManager, Set<SchedulePlanData> schedulePlans) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.type = type;
        this.guide = guide;
        this.description = description;
        this.imgUrl = imgUrl;
        this.tourRateId = tourRateId;
        this.date = date;
        this.categories = categories;
        this.tourismManager = tourismManager;
        this.schedulePlans = schedulePlans;
    }

    public String getName() {
        return name;
    }

    public TourType getType() {
        return type;
    }

    public String getGuide() {
        return guide;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Integer getTourRateId() {
        return tourRateId;
    }

    public Instant getDate() {
        return date;
    }

    public Set<TourCategory> getCategories() {
        return categories;
    }

    public TourismManagerData getTourismManager() {
        return tourismManager;
    }

    public Set<SchedulePlanData> getSchedulePlans() {
        return schedulePlans;
    }

    @Override
    public TourData cloneWithId(String id) {
        return new TourData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, guide, description, imgUrl, tourRateId, date, categories, tourismManager, schedulePlans);
    }

    public TourData cloneWith(Set<SchedulePlanData> schedulePlans) {
        return new TourData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, guide, description, imgUrl, tourRateId, date, categories, tourismManager, schedulePlans);
    }


    public static final class TourDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        protected String name;
        protected TourType type;
        protected String guide;
        protected String description;
        protected String imgUrl;
        protected Integer tourRateId;
        protected Instant date;
        protected Set<TourCategory> categories;
        protected TourismManagerData tourismManager;
        protected Set<SchedulePlanData> schedulePlans;

        private TourDataBuilder() {
        }

        public static TourDataBuilder aTourData() {
            return new TourDataBuilder();
        }

        public TourDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public TourDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public TourDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public TourDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public TourDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public TourDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TourDataBuilder type(TourType type) {
            this.type = type;
            return this;
        }

        public TourDataBuilder guide(String guide) {
            this.guide = guide;
            return this;
        }

        public TourDataBuilder description(String description) {
            this.description = description;
            return this;
        }

        public TourDataBuilder imgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
            return this;
        }

        public TourDataBuilder tourRateId(Integer tourRateId) {
            this.tourRateId = tourRateId;
            return this;
        }

        public TourDataBuilder date(Instant date) {
            this.date = date;
            return this;
        }

        public TourDataBuilder categories(Set<TourCategory> categories) {
            this.categories = categories;
            return this;
        }

        public TourDataBuilder tourismManager(TourismManagerData tourismManager) {
            this.tourismManager = tourismManager;
            return this;
        }

        public TourDataBuilder schedulePlans(Set<SchedulePlanData> schedulePlans) {
            this.schedulePlans = schedulePlans;
            return this;
        }

        public TourData build() {
            return new TourData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, guide, description, imgUrl, tourRateId, date, categories, tourismManager, schedulePlans);
        }
    }
}