package razarm.tosan.controller.dto.tour;

import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.repository.domain.tour.ActivityType;

import java.time.ZonedDateTime;

public class ActivityDto extends BaseEntityDto {
    private final String name;
    private final ActivityType type;
    private final ZonedDateTime startAt;
    private final ZonedDateTime endAt;


    public ActivityDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, ActivityType type, ZonedDateTime startAt, ZonedDateTime endAt) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.type = type;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public String getName() {
        return name;
    }

    public ActivityType getType() {
        return type;
    }

    public ZonedDateTime getStartAt() {
        return startAt;
    }

    public ZonedDateTime getEndAt() {
        return endAt;
    }


    public static final class ActivityDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private ActivityType type;
        private ZonedDateTime startAt;
        private ZonedDateTime endAt;

        private ActivityDtoBuilder() {
        }

        public static ActivityDtoBuilder anActivityDto() {
            return new ActivityDtoBuilder();
        }

        public ActivityDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public ActivityDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ActivityDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public ActivityDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public ActivityDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public ActivityDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ActivityDtoBuilder type(ActivityType type) {
            this.type = type;
            return this;
        }

        public ActivityDtoBuilder startAt(ZonedDateTime startAt) {
            this.startAt = startAt;
            return this;
        }

        public ActivityDtoBuilder endAt(ZonedDateTime endAt) {
            this.endAt = endAt;
            return this;
        }

        public ActivityDto build() {
            return new ActivityDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, startAt, endAt);
        }
    }
}
