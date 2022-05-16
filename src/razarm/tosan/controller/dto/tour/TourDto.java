package razarm.tosan.controller.dto.tour;


import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.repository.domain.tour.TourCategory;
import razarm.tosan.repository.domain.tour.TourType;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.Set;

public class TourDto extends BaseEntityDto {
    private  String name;
    private  TourType type;
    private  String guide;
    private   String description;
    private  String imgUrl;
    private  Float rating;
    private BigInteger price;
    private  ZonedDateTime date;
    private  Set<TourCategory> categories;

    private  TourismManagerDto tourismManager;
    private  Set<SchedulePlanDto> schedulePlans;

    public TourDto() { }



    public TourDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, TourType type, String guide, String description, String imgUrl, Float rating, BigInteger price, ZonedDateTime date, Set<TourCategory> categories, TourismManagerDto tourismManager, Set<SchedulePlanDto> schedulePlans) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.type = type;
        this.guide = guide;
        this.description = description;
        this.imgUrl = imgUrl;
        this.rating = rating;
        this.price = price;
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

    public String getRating() {
        return String.format("%.1f", !Float.isNaN(rating) ? rating : 0.00); // TODO
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

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(TourType type) {
        this.type = type;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public void setCategories(Set<TourCategory> categories) {
        this.categories = categories;
    }

    public void setTourismManager(TourismManagerDto tourismManager) {
        this.tourismManager = tourismManager;
    }

    public void setSchedulePlans(Set<SchedulePlanDto> schedulePlans) {
        this.schedulePlans = schedulePlans;
    }

    public TourDto cloneWithRating(Float rating) {
        return new TourDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, guide, description, imgUrl, rating, price, date, categories, tourismManager, schedulePlans);
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TourDto{");
        sb.append("id='").append(id).append('\'');
        sb.append(", createdAt=").append(createdAt);
        sb.append(", modifiedAt=").append(modifiedAt);
        sb.append(", createdBy='").append(createdBy).append('\'');
        sb.append(", modifiedBy='").append(modifiedBy).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", type=").append(type);
        sb.append(", guide='").append(guide).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", imgUrl='").append(imgUrl).append('\'');
        sb.append(", rating=").append(getRating());
        sb.append(", date=").append(date);
        sb.append(", categories=").append(categories);
        sb.append(", tourismManager=").append(tourismManager);
        sb.append(", schedulePlans=").append(schedulePlans);
        sb.append('}');
        return sb.toString();
    }


    public static final class TourDtoBuilder {
        protected  String id;
        protected ZonedDateTime createdAt;
        protected  ZonedDateTime modifiedAt;
        protected  String createdBy;
        protected  String modifiedBy;
        private  String name;
        private TourType type;
        private  String guide;
        private   String description;
        private  String imgUrl;
        private  Float rating;
        private BigInteger price;
        private  ZonedDateTime date;
        private Set<TourCategory> categories;
        private TourismManagerDto tourismManager;
        private  Set<SchedulePlanDto> schedulePlans;

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

        public TourDtoBuilder imgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
            return this;
        }

        public TourDtoBuilder rating(Float rating) {
            this.rating = rating;
            return this;
        }

        public TourDtoBuilder price(BigInteger price) {
            this.price = price;
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
            return new TourDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, guide, description, imgUrl, rating, price, date, categories, tourismManager, schedulePlans);
        }
    }
}
