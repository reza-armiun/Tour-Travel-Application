package razarm.tosan.repository.data;

import razarm.tosan.repository.inMemoryImpl.IdGenerator;

import java.io.Serializable;
import java.time.Instant;

public abstract class BaseEntityData implements Serializable {
    protected final String id;


    protected final Instant createdAt;
    protected final Instant modifiedAt;
    protected final String createdBy;
    protected final String modifiedBy;


    public abstract BaseEntityData cloneWithId(String id);

    public BaseEntityData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy) {
        if(id == null) this.id = IdGenerator.generateId();
        else this.id = id;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.createdBy = createdBy;
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
