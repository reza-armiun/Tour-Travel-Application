package razarm.tosan.repository.domain.tour;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.Costable;
import razarm.tosan.repository.domain.Timeable;

import java.time.Instant;

public abstract class Activity extends BaseEntity
        implements Timeable, Costable {
    private final String name;
    private final ActivityType type;
    private final Instant startAt;
    private final Instant endAt;

    abstract void perform();


    private final SchedulePlan schedulePlan;

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



}
