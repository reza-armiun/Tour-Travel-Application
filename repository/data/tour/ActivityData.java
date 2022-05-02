package razarm.tosan.repository.data.tour;

import razarm.tosan.repository.data.BaseEntityData;
import razarm.tosan.repository.domain.tour.ActivityType;

import java.time.Instant;

public class ActivityData extends BaseEntityData {
    private final String name;
    private final ActivityType type;
    private final Instant startAt;
    private final Instant endAt;

    public ActivityData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, ActivityType type, Instant startAt, Instant endAt) {
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

    public Instant getStartAt() {
        return startAt;
    }

    public Instant getEndAt() {
        return endAt;
    }

    @Override
    public BaseEntityData cloneWithId(String id) {
        return new ActivityData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, startAt, endAt);
    }


    public static final class ActivityDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private ActivityType type;
        private Instant startAt;
        private Instant endAt;

        private ActivityDataBuilder() {
        }

        public static ActivityDataBuilder anActivityData() {
            return new ActivityDataBuilder();
        }

        public ActivityDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public ActivityDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ActivityDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public ActivityDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public ActivityDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public ActivityDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ActivityDataBuilder type(ActivityType type) {
            this.type = type;
            return this;
        }

        public ActivityDataBuilder startAt(Instant startAt) {
            this.startAt = startAt;
            return this;
        }

        public ActivityDataBuilder endAt(Instant endAt) {
            this.endAt = endAt;
            return this;
        }

        public ActivityData build() {
            return new ActivityData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, startAt, endAt);
        }
    }
}
