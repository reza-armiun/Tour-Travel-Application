package razarm.tosan.controller.dto.tour;


import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.repository.domain.tour.TourCategory;
import razarm.tosan.repository.domain.tour.TourType;

import java.time.ZonedDateTime;
import java.util.Set;

public class TourDto extends BaseEntityDto {
    private final String name;
    private final TourType type;
    private final String guide;
    private  final String description;
    private final ZonedDateTime date;
    private final Set<TourCategory> categories;

    private final TourismManagerDto tourismManager;
    private final Set<SchedulePlanDto> schedulePlans;


    public TourDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, TourType type, String guide, String description, ZonedDateTime date, Set<TourCategory> categories, TourismManagerDto tourismManager, Set<SchedulePlanDto> schedulePlans) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.type = type;
        this.guide = guide;
        this.description = description;
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

    public ZonedDateTime getDate() {
        return date;
    }

    public Set<TourCategory> getCategories() {
        return categories;
    }

    public TourismManagerDto getTourismManager() {
        return tourismManager;
    }

    public Set<SchedulePlanDto> getSchedulePlans() {
        return schedulePlans;
    }


    public static final class TourDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private TourType type;
        private String guide;
        private String description;
        private ZonedDateTime date;
        private Set<TourCategory> categories;
        private TourismManagerDto tourismManager;
        private Set<SchedulePlanDto> schedulePlans;

        private TourDtoBuilder() {
        }

        public static TourDtoBuilder aTourDto() {
            return new TourDtoBuilder();
        }

        public TourDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public TourDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public TourDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public TourDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public TourDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public TourDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TourDtoBuilder type(TourType type) {
            this.type = type;
            return this;
        }

        public TourDtoBuilder guide(String guide) {
            this.guide = guide;
            return this;
        }

        public TourDtoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public TourDtoBuilder date(ZonedDateTime date) {
            this.date = date;
            return this;
        }

        public TourDtoBuilder categories(Set<TourCategory> categories) {
            this.categories = categories;
            return this;
        }

        public TourDtoBuilder tourismManager(TourismManagerDto tourismManager) {
            this.tourismManager = tourismManager;
            return this;
        }

        public TourDtoBuilder schedulePlans(Set<SchedulePlanDto> schedulePlans) {
            this.schedulePlans = schedulePlans;
            return this;
        }

        public TourDto build() {
            return new TourDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, guide, description, date, categories, tourismManager, schedulePlans);
        }
    }
}
