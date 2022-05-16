package razarm.tosan.repository.domain.tour;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.Costable;
import razarm.tosan.repository.domain.Timeable;

import java.math.BigInteger;
import java.time.Instant;

public  class Activity extends BaseEntity
        implements Timeable, Costable {
    protected final String name;
    protected final ActivityType type;
    protected final Instant startAt;
    protected final Instant endAt;

//    abstract void perform();


    protected final SchedulePlan schedulePlan;

    public Activity(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, ActivityType type, Instant startAt, Instant endAt, SchedulePlan schedulePlan) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.type = type;
        this.startAt = startAt;
        this.endAt = endAt;
        this.schedulePlan = schedulePlan;
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

    public SchedulePlan getSchedulePlan() {
        return schedulePlan;
    }


    @Override
    public BaseEntity cloneWithId(String id) {
        return null;
    }

    @Override
    public BigInteger calculatePrice() {
        return null;
    }

    @Override
    public Long estimateTime() {
        return null;
    }


    public static final class ActivityBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        protected String name;
        protected ActivityType type;
        protected Instant startAt;
        protected Instant endAt;
        protected SchedulePlan schedulePlan;

        private ActivityBuilder() {
        }

        public static ActivityBuilder anActivity() {
            return new ActivityBuilder();
        }

        public ActivityBuilder id(String id) {
            this.id = id;
            return this;
        }

        public ActivityBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ActivityBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public ActivityBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public ActivityBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public ActivityBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ActivityBuilder type(ActivityType type) {
            this.type = type;
            return this;
        }

        public ActivityBuilder startAt(Instant startAt) {
            this.startAt = startAt;
            return this;
        }

        public ActivityBuilder endAt(Instant endAt) {
            this.endAt = endAt;
            return this;
        }

        public ActivityBuilder schedulePlan(SchedulePlan schedulePlan) {
            this.schedulePlan = schedulePlan;
            return this;
        }

        public Activity build() {
            return new Activity(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, startAt, endAt, schedulePlan);
        }
    }
}
