package razarm.tosan.repository.domain;


import java.io.Serializable;
import java.time.Instant;


public abstract class BaseEntity implements Serializable {
    protected final String id;


    protected final Instant createdAt;
    protected final Instant modifiedAt;
    protected final String createdBy;
    protected final String modifiedBy;

    public abstract BaseEntity cloneWithId(String id);

    public BaseEntity(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy) {
        this.id = id;
        this.createdAt = createdAt  != null? createdAt : Instant.now();
        this.modifiedAt = modifiedAt != null? modifiedAt : Instant.now();
        this.createdBy = createdBy ;
        this.modifiedBy = modifiedBy;
    }

    public String getId() {
        return id;
    }



    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getModifiedAt() {
        return modifiedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }
}
